package blazon.server.charge.fetching;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import blazon.client.charge.fetching.ChargeFetchingService;
import blazon.shared.charge.fetching.NoImageForAdvancedChargeException;
import blazon.shared.shield.Shield;

public class ChargeFetchingServiceImpl extends RemoteServiceServlet implements ChargeFetchingService {

	private static final long serialVersionUID = 380031744539198592L;

	@Override
	public Shield fetchImagesForCharges(Shield shield) throws NoImageForAdvancedChargeException {
		ImageSourceLocator locator = new ImageSourceLocator(shield);
		Shield shieldWithLocations = locator.locateChargeSources();
		return shieldWithLocations;
	}
}
