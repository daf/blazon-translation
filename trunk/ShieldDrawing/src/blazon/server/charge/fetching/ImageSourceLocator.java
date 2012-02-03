package blazon.server.charge.fetching;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import blazon.server.PersistedCharge;
import blazon.server.charge.adding.EMF;
import blazon.shared.charge.fetching.NoImageForAdvancedChargeException;
import blazon.shared.shield.Shield;
import blazon.shared.shield.charges.AdvancedCharge;
import blazon.shared.shield.charges.Charge;

public class ImageSourceLocator {

	private final Shield shield;

	public ImageSourceLocator(Shield shield) {
		this.shield = shield;
	}

	public Shield locateChargeSources() throws NoImageForAdvancedChargeException {
		EntityManager entityManager = EMF.getInstance().createEntityManager();
		try {
	    	List<Charge> charges = shield.getCharges();
			for (Charge charge : charges ) {
	    		if (!charge.hasSource()) {
	    			AdvancedCharge advCharge = (AdvancedCharge) charge;
	    			Query q = buildQuery(advCharge, entityManager);
	        		System.out.println(q);
	    			List<PersistedCharge> resultList = q.getResultList();
	        		if (resultList.isEmpty()) {
	        			//TODO deal with removing some of the body parts
	        			throw new NoImageForAdvancedChargeException(advCharge);
	        		}
	        		else if (resultList.size() == 1) {
	        			advCharge.setSource(resultList.get(0).getImageSource());
	        		}
	        		else {
	        			//TODO throw some exception
	        		}
	    		}
	    	}
	    	return shield;
		} finally {
			entityManager.close();
		}
	}

	private Query buildQuery(AdvancedCharge charge, EntityManager entityManager) {
		StringBuilder sb = new StringBuilder("SELECT FROM ");
		sb.append(PersistedCharge.class.getName()).append(" c ");
		sb.append("WHERE c.charge = '").append(charge.getName()).append("' ");
		sb.append("AND c.attitude = '").append(charge.getAttitude()).append("' ");;
		sb.append("AND c.tincture = '").append(charge.getTincture().getName()).append("'");
		return entityManager.createQuery(sb.toString());
		//TODO add body part searching
	}
}
