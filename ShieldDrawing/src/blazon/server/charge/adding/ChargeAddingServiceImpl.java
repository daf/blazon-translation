package blazon.server.charge.adding;

import java.util.SortedSet;

import javax.persistence.EntityManager;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import blazon.client.charge.adding.ChargeAddingService;
import blazon.server.charge.PersistedCharge;

public class ChargeAddingServiceImpl extends RemoteServiceServlet implements ChargeAddingService {

	private static final long serialVersionUID = -8716005130771464895L;

	@Override
	public void addChargeToDatastore(String chargeType, String attitude, String attMod, String tincture, String imageLocation, SortedSet<String> bodyPartSet) throws IllegalArgumentException {
		if (chargeType == null || chargeType.isEmpty() || attitude == null || attitude.isEmpty() || tincture == null || tincture.isEmpty() || imageLocation == null || imageLocation.isEmpty()) {
			throw new IllegalArgumentException("Can not add charge to datastore if compulsory value is null");
		}
		PersistedCharge charge = new PersistedCharge(chargeType, attitude, attMod, tincture, bodyPartSet, imageLocation);
		EntityManager entityManager = EMF.getInstance().createEntityManager();
		entityManager.persist(charge);
		entityManager.close();
	}
}
