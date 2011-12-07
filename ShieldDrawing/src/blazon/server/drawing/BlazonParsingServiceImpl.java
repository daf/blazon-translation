package blazon.server.drawing;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;

import blazon.client.drawing.BlazonParsingService;
import blazon.server.PersistedCharge;
import blazon.server.chargeadding.EMF;
import blazon.server.grammar.ANTLRNoCaseStringStream;
import blazon.server.grammar.BlazonLexer;
import blazon.server.grammar.BlazonParser;
import blazon.shared.shield.InvalidShield;
import blazon.shared.shield.Shield;
import blazon.shared.shield.charges.Charge;
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
        	List<Charge> charges = shield.getCharges();
        	for (Charge charge : charges) {
        		if (!charge.hasSource()) {
            		String lion = "lion";
            		String rampant = "rampant";
            		String or = "or";
        			EntityManager entityManager = EMF.getInstance().createEntityManager();
            		Query q = entityManager.createQuery("SELECT FROM " + PersistedCharge.class.getName() + " c WHERE c.charge = '" + lion + "' AND c.attitude = '" + rampant + "' AND c.tincture = '" + or + "'");
            		List<PersistedCharge> resultList = q.getResultList();
            		charge.setSource(resultList.get(0).getImageSource());
            		entityManager.close();
        		}
        	}
    		//TODO refactor image retrieval

    		
    		
        } catch (RecognitionException re) {
        	return InvalidShield.build();
        }
        return shield;
	}

}
