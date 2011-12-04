package blazon.server.drawing;

import java.util.ArrayList;
import java.util.List;

import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;

import blazon.client.drawing.BlazonParsingService;
import blazon.server.grammar.ANTLRNoCaseStringStream;
import blazon.server.grammar.BlazonLexer;
import blazon.server.grammar.BlazonParser;
import blazon.shared.shield.InvalidShield;
import blazon.shared.shield.Shield;
import blazon.shared.shield.diagnostic.ShieldDiagnostic;

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
		List<ShieldDiagnostic> diags = new ArrayList<ShieldDiagnostic>();
        BlazonLexer lexer = new BlazonLexer(input, diags);
        TokenStream tokenStream = new CommonTokenStream(lexer);
        BlazonParser parser = new BlazonParser(tokenStream, diags);
        Shield shield;
        try {
        	shield = parser.shield();
        } catch (RecognitionException re) {
        	return InvalidShield.build();
        }
        return shield;
	}

}
