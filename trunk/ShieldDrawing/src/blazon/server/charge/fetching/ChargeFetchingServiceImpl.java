package blazon.server.charge.fetching;

import java.util.logging.Logger;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import blazon.client.charge.fetching.ChargeFetchingService;
import blazon.shared.charge.fetching.NoImageForAdvancedChargeException;
import blazon.shared.shield.Shield;

public class ChargeFetchingServiceImpl extends RemoteServiceServlet implements ChargeFetchingService {

	private static final long serialVersionUID = 380031744539198592L;

	private final Logger logger = Logger.getLogger("blazon");
	
	@Override
	public Shield fetchImagesForCharges(Shield shield) throws NoImageForAdvancedChargeException {
		logger.info("ChargeFetchingServiceImpl called");
		ImageSourceLocator locator = new ImageSourceLocator(shield);
		Shield shieldWithLocations = locator.locateChargeSources();
		return shieldWithLocations;
	}
}
