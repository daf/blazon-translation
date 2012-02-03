package blazon.shared.shield.charges;

import java.io.Serializable;
import java.util.Map;

import blazon.shared.shield.tinctures.Tincture;
//LATER could use proxy pattern with persisted charge
public class AdvancedCharge implements Charge, Serializable {
	
	private static final long serialVersionUID = -6533905684774401769L;
	
	private String name;
	private String attitude;
	private String attitudeModifier;
	private Tincture tincture;
	private String imageSource;
	private Map<String, Tincture> bodyParts;
	
	public static AdvancedCharge build(final String name, final String attitude, final String attitudeModifier, final Tincture tincture, final Map<String, Tincture> bodyParts) {
		AdvancedCharge ac = new AdvancedCharge();
		ac.name = name;
		ac.attitude = attitude;
		ac.attitudeModifier = attitudeModifier;
		ac.tincture = tincture;
		ac.bodyParts = bodyParts;
		ac.imageSource = null;
		return ac;
	}

	@Override
	public boolean hasSource() {
		return imageSource != null;
	}

	public String getName() {
		return name;
	}

	public String getAttitude() {
		return attitude;
	}

	public String getAttitudeModifier() {
		return attitudeModifier;
	}

	public Tincture getTincture() {
		return tincture;
	}

	@Override
	public boolean setSource(String source) {
		if (hasSource()) {
			return false;
		}
		imageSource = source;
		return true;
	}

	public String getSource() {
		return imageSource;
	}

	public String getTextDescription() {
		StringBuilder sb = new StringBuilder();
		sb.append("'").append(name).append(" ").append(attitude);
		sb.append(" ").append(tincture.getName()).append(" ");
		for (Map.Entry<String, Tincture> bodyPart : bodyParts.entrySet()) {
			sb.append(bodyPart.getKey()).append(" ").append(bodyPart.getValue().getName()).append(" ");
		}
		return sb.append("'").toString();
	}

	public Map<String, Tincture> getSpecifiedBodyParts() {
		return bodyParts;
	}

}
