package blazon.server;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import blazon.client.ui.widget.LabelledTextBox;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.Link;

@Entity
public class PersistedCharge {
	
	public PersistedCharge(final String charge, final String attitude, final String attitudeModifier, final String tincture, final List<LabelledTextBox> bodyPartTextBoxes, final int numberOfLabels, final String imageSource) {
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
		if (numberOfLabels != 0 || numberOfLabels != 2) {
			throw new IllegalArgumentException("Can not create a charge to be stored in the database as there should pairs of text boxes, 1 for the body part, 1 for the tincture of the body part.");
		}
		this.charge = charge;
		this.attitude = attitude;
		this.attitudeModifier = attitudeModifier;
		this.tincture = tincture;
		this.imageSource = new Link(imageSource);
		this.dateOfSourceAccess = new Date();
		
		Set<String> bodyPartsSet = new HashSet<String>();
		StringBuilder sb = new StringBuilder(charge).append(" ").append(attitude).append(" ").append(attitudeModifier).append(" ").append(tincture);
		if (bodyPartsWithTincture != null) {
			for (int i = 0; i < bodyPartTextBoxes.size(); i += 2) {
				LabelledTextBox bodyPart = bodyPartTextBoxes.get(i);
				LabelledTextBox bodyPartTincture = bodyPartTextBoxes.get(i + 1);
				String bodyPartText = bodyPart.getEnteredText();
				String bodyPartTinctureText = bodyPartTincture.getEnteredText();
				bodyPartsSet.add(bodyPartText + ":" + bodyPartTinctureText);
				sb.append(bodyPartText).append(" ").append(bodyPartTinctureText);
			}
		}
		this.bodyPartsWithTincture = bodyPartsSet;
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
	
	private Set<String> bodyPartsWithTincture = null;

	public String getImageSource() {
		return imageSource.getValue();
	}

}
