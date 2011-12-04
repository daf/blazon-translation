package blazon.server.chargeadding;

import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.google.appengine.api.datastore.Blob;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;


@Entity
public class Charge {
	
	public Charge(final String charge, final String attitude, final String attitudeModifier, final String tincture, final Map<String, String> bodyPartsWithTincture,  final Blob imageData, final String imageSource) {
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
		if (imageData == null) {
			throw new IllegalArgumentException("Can not create a charge to be stored in the database with null image data");
		}
		if (imageSource == null) {
			throw new IllegalArgumentException("Can not create a charge to be stored in the database with a null image source");
		}
		this.charge = charge;
		this.attitude = attitude;
		this.attitudeModifier = attitudeModifier;
		this.tincture = tincture;
		this.imageData = imageData;
		this.imageSource = imageSource;
		this.dateOfSourceAccess = new Date();
		
		Set<String> bodyPartsSet = new HashSet<String>();
		StringBuilder sb = new StringBuilder(charge).append(" ").append(attitude).append(" ").append(attitudeModifier).append(" ").append(tincture);
		if (bodyPartsWithTincture != null) {
			for (Map.Entry<String, String> entry : bodyPartsWithTincture.entrySet()) {
				String bodyPart = entry.getKey();
				String bodyPartTincture = entry.getValue();
				bodyPartsSet.add(bodyPart + ":" + bodyPartTincture);
				sb.append(bodyPart).append(" ").append(bodyPartTincture);
			}
		}
		this.bodyPartsWithTincture = bodyPartsSet;
		this.key = KeyFactory.createKey(Charge.class.getSimpleName(), sb.toString());
	}
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Key key;
	
	private String charge;
	
	private String attitude;
	
	private String attitudeModifier;
	
	private String tincture;

	private Blob imageData;
	
	private String imageSource;
	
	private Date dateOfSourceAccess;
	
	private Set<String> bodyPartsWithTincture;

	Blob getImageData() {
		return imageData;
	}

	Key getKey() {
		return key;
	}

	String getCharge() {
		return charge;
	}

	String getAttitude() {
		return attitude;
	}

	Set<String> getBodyPartsWithTincture() {
		return bodyPartsWithTincture;
	}

	Date getDateOfSourceAccess() {
		return dateOfSourceAccess;
	}

	String getImageSource() {
		return imageSource;
	}

	String getTincture() {
		return tincture;
	}

	String getAttitudeModifier() {
		return attitudeModifier;
	}

}
