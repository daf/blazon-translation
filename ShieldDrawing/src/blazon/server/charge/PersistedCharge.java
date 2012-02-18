package blazon.server.charge;

import java.util.Date;
import java.util.SortedSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.Link;

@Entity
public class PersistedCharge {
	
	public PersistedCharge(final String charge, final String attitude, final String attitudeModifier, final String tincture, final SortedSet<String> bodyPartsSet, final String imageSource) {
		if (charge == null) {
			throw new IllegalArgumentException("Can not create a charge to be stored in the database with a null charge name.");
		}
		if (attitude == null) {
			throw new IllegalArgumentException("Can not create a charge to be stored in the database with a null attitude");
		}
		if (attitudeModifier == null) {
			throw new IllegalArgumentException("Can not create a charge to be stored in the database with a null attitude modifier");
		}
		if (tincture == null) {
			throw new IllegalArgumentException("Can not create a charge to be stored in the database with a null tincture");
		} 
		if (imageSource == null) {
			throw new IllegalArgumentException("Can not create a charge to be stored in the database with a null image source");
		}
		this.charge = charge;
		this.attitude = attitude;
		this.attitudeModifier = attitudeModifier;
		this.tincture = tincture;
		this.imageSource = new Link(imageSource);
		this.dateOfSourceAccess = new Date();
		this.bodyPartsWithTincture = bodyPartsSet;
		StringBuilder sb = new StringBuilder(charge).append(" ").append(attitude).append(" ").append(attitudeModifier).append(" ").append(tincture);
		sb.append(" ").append(bodyPartsSet);
		this.key = KeyFactory.createKey(PersistedCharge.class.getSimpleName(), sb.toString());
	}
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Key key;
	
	private String charge;
	
	private String attitude;
	
	private String attitudeModifier;
	
	private String tincture;

	private Link imageSource;
	
	private Date dateOfSourceAccess;
	
	private SortedSet<String> bodyPartsWithTincture;

	public String getImageSource() {
		return imageSource.getValue();
	}

	public SortedSet<String> getSpecifiedBodyParts() { // must have ordered set for searching in datastore
		return bodyPartsWithTincture;
	}

}
