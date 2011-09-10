package blazon.server;

import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;

import blazon.client.BlazonParsingService;
import blazon.server.grammar.ANTLRNoCaseStringStream;
import blazon.server.grammar.BlazonLexer;
import blazon.server.grammar.BlazonParser;
import blazon.shared.shield.InvalidShield;
import blazon.shared.shield.Shield;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server side implementation of the RPC service.
 */
public class BlazonParsingServiceImpl extends RemoteServiceServlet implements
		BlazonParsingService {
	private static final long serialVersionUID = -1112781771348351096L;

	@Override
	public Shield createShieldRepresentation(String blazon) {
		CharStream input = new ANTLRNoCaseStringStream(blazon);
        BlazonLexer lexer = new BlazonLexer(input);
        TokenStream tokenStream = new CommonTokenStream(lexer);
        BlazonParser parser = new BlazonParser(tokenStream);
        Shield shield;
        try {
        	shield = parser.shield();
        } catch (RecognitionException re) {
        	return InvalidShield.build();
        }
        return shield;
	}

}