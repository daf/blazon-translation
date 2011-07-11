package blazon.server;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.TokenStream;

import blazon.client.ShieldDrawingService;
import blazon.server.grammar.ANTLRNoCaseStringStream;
import blazon.server.grammar.BlazonLexer;
import blazon.server.grammar.BlazonParser;
import blazon.shared.shield.Shield;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server side implementation of the RPC service.
 */
public class ShieldDrawingServiceImpl extends RemoteServiceServlet implements
		ShieldDrawingService {
	private static Logger logger = Logger.getLogger("");
	private static final long serialVersionUID = -1112781771348351096L;

	@Override
	public Shield createShieldRepresentation(String blazon) throws IllegalArgumentException {
		CharStream input = new ANTLRNoCaseStringStream(blazon);
        BlazonLexer lexer = new BlazonLexer(input);
        TokenStream tokenStream = new CommonTokenStream(lexer);
        BlazonParser parser = new BlazonParser(tokenStream);
        Shield shield;
        try {
            shield = parser.shield();
        } catch (Exception e) {
        	logger.log(Level.SEVERE, "Grammar was unable to match given Blazon", e);
            return null;
        }
        return shield;
	}

}
