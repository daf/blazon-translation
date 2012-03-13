package blazon.server.charge.fetching;

import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import blazon.server.charge.PersistedCharge;
import blazon.server.charge.adding.EMF;
import blazon.shared.charge.fetching.NoImageForAdvancedChargeException;
import blazon.shared.shield.Shield;
import blazon.shared.shield.charges.AdvancedCharge;
import blazon.shared.shield.charges.Charge;
import blazon.shared.shield.tinctures.Tincture;

public class ImageSourceLocator {

	private final Shield shield;
	private Logger logger = Logger.getLogger("blazon");

	public ImageSourceLocator(Shield shield) {
		this.shield = shield;
	}

	public Shield locateChargeSources() throws NoImageForAdvancedChargeException {
		EntityManager entityManager = EMF.getInstance().createEntityManager();
		try {
	    	List<Charge> charges = shield.getCharges();
	    	if (charges == null || charges.isEmpty()) {
	    		return shield;
	    	}
	    	logger.info("ImageSourceLocator.locateChargeSources called. Shield has " + charges.size() + " charge(s).");

			for (Charge charge : charges) {
	    		if (!charge.hasSource()) {
	    			AdvancedCharge advCharge = (AdvancedCharge) charge;
	    			Query q = buildQuery(advCharge, entityManager);
	    			List<PersistedCharge> resultList = q.getResultList();
	        		if (resultList.isEmpty()) {
	        			throw new NoImageForAdvancedChargeException(advCharge);
	        		}
	        		else if (resultList.size() == 1) {
	        			logger.info("AdvancedCharge.setSource called with '" + resultList.get(0).getImageSource() + "' as parameter." );
	        			advCharge.setSource(resultList.get(0).getImageSource());
	        		}
	        		else {
	        			final int numberOfRequestedBodyParts = (advCharge.getSpecifiedBodyParts() == null) ? 0 : advCharge.getSpecifiedBodyParts().size();
	        			PersistedCharge persistedChargeWithFewestExtraBodyParts = null;
	        			int minimumNumberOfExtraBodyParts = numberOfRequestedBodyParts + 1; // guaranteed to be more than requested so source will be set.
	        			for (PersistedCharge persistedCharge : resultList) {
	        				int numberOfSpecifiedBodyPartsOfPersitedCharge = persistedCharge.getSpecifiedBodyParts().size();
	        				int differenceInNumberOfSpecifiedBodyParts = numberOfSpecifiedBodyPartsOfPersitedCharge - numberOfRequestedBodyParts;

	        				if (differenceInNumberOfSpecifiedBodyParts == 0) {
	        					persistedChargeWithFewestExtraBodyParts = persistedCharge;
								break;
							} else if (minimumNumberOfExtraBodyParts >= differenceInNumberOfSpecifiedBodyParts) {
								minimumNumberOfExtraBodyParts = differenceInNumberOfSpecifiedBodyParts;
								persistedChargeWithFewestExtraBodyParts = persistedCharge; 
	        				}
						}
	        			logger.info("AdvancedCharge.setSource called with '" + persistedChargeWithFewestExtraBodyParts.getImageSource() + "' as paramter." );
	        			advCharge.setSource(persistedChargeWithFewestExtraBodyParts.getImageSource());
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
		sb.append("AND c.attitude = '").append(charge.getAttitude()).append("' ");
		if (charge.getAttitudeModifier() != null && !charge.getAttitudeModifier().isEmpty()) {
			sb.append("AND c.attitudeModifier = '").append(charge.getAttitudeModifier()).append("' ");
		}
		sb.append("AND c.tincture = '").append(charge.getTincture().getName()).append("'");
		Map<String, Tincture> specifiedBodyParts = charge.getSpecifiedBodyParts();
		SortedSet<String> bodyPartSet = new TreeSet<String>();
		if (specifiedBodyParts != null && !specifiedBodyParts.isEmpty()) {
			for (Map.Entry<String, Tincture> bodyPart : specifiedBodyParts.entrySet()) {
				bodyPartSet.add(bodyPart.getKey() + ":" + bodyPart.getValue().getName());
			}
			sb.append(" AND c.bodyPartsWithTincture IN (:bodyParts)");
		}
		Query q = entityManager.createQuery(sb.toString());
		q.setParameter("bodyParts", bodyPartSet);
		return q;
	}
}
