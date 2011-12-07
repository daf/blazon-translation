package blazon.server.chargeadding;

import java.util.Map;

import javax.persistence.EntityManager;

import com.google.appengine.api.datastore.Blob;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import blazon.client.chargeadding.ChargeAddingService;
import blazon.server.PersistedCharge;

public class ChargeAddingServiceImpl extends RemoteServiceServlet implements ChargeAddingService {

	private static final long serialVersionUID = -8716005130771464895L;

	@Override
	public void addChargeToDatastore(String chargeName, String attitude, String attitudeModifier, String tincture, Map<String, String> bodyPartTexts, String imageLocation) {
		Blob imageData = new ImageToBlobConverter().getImageDataFromUrlLocation(imageLocation);
		PersistedCharge charge = new PersistedCharge(chargeName, attitude, attitudeModifier, tincture, bodyPartTexts, imageData, imageLocation);
		EntityManager entityManager = EMF.getInstance().createEntityManager();
		entityManager.persist(charge);
		entityManager.close();
	}
}
