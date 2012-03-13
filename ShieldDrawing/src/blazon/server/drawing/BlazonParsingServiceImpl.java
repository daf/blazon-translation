package blazon.server.drawing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

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
import blazon.shared.shield.charges.Charge;
import blazon.shared.shield.charges.GeometricCharge;
import blazon.shared.shield.charges.GeometricChargeNames;
import blazon.shared.shield.diagnostic.ShieldDiagnostic;
import blazon.shared.shield.diagnostic.ShieldDiagnostic.LogLevel;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server side implementation of the RPC service.
 */
public class BlazonParsingServiceImpl extends RemoteServiceServlet implements BlazonParsingService {
	private static final long serialVersionUID = -1112781771348351096L;

	private final Logger logger = Logger.getLogger("blazon");

	
	@Override
	public Shield createShieldRepresentation(String blazon) throws IllegalArgumentException {
		logger.info("BlazonParsingServiceImpl called with parameter: '" + blazon + "'");
		if (blazon == null || blazon.trim().isEmpty()) {
			throw new IllegalArgumentException("Can not draw shield for empty or null Blazon");
		}
		blazon = blazon.trim().toLowerCase();
		CharStream input = new ANTLRNoCaseStringStream(blazon);
		List<ShieldDiagnostic> diags = new ArrayList<ShieldDiagnostic>();
		BlazonLexer lexer = new BlazonLexer(input, diags);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		BlazonParser parser = new BlazonParser(tokenStream, diags);
		try {
			Shield shield = parser.shield();
			checkForMultipleOrdinaries(shield);
			return shield;
		} catch (RecognitionException re) {
			return InvalidShield.build();
		}
	}
	
	private void checkForMultipleOrdinaries(Shield shield) {
		if (shield.getCharges() == null) {
			return;
		}
		Set<GeometricChargeNames> ordinariesInUse = new HashSet<GeometricChargeNames>();
		for (Charge charge: shield.getCharges()) {
			if (charge instanceof GeometricCharge) {
				GeometricCharge geoCharge = (GeometricCharge) charge;
				GeometricChargeNames typeOfCharge = geoCharge.getType();
				if (typeOfCharge.isOrdinary()) {
					if (!ordinariesInUse.add(typeOfCharge)) {
						shield.addDiagnostic(ShieldDiagnostic.build(LogLevel.ERROR, "You can not have multiple '" + typeOfCharge + "'s as it is an ordinary."));
					}
				}
			}
		}
	}
}
