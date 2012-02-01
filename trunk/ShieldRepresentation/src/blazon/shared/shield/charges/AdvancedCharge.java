package blazon.shared.shield.charges;

import java.io.Serializable;

import blazon.shared.shield.tinctures.Tincture;
//LATER could use proxy pattern with persisted charge
public class AdvancedCharge implements Charge, Serializable {
	
	private static final long serialVersionUID = -6533905684774401769L;
	
	private String name;
	private String attitude;
	private String attitudeModifier;
	private Tincture tincture;
	private String imageSource;
	
	public static AdvancedCharge build(final String name, final String attitude, final String attitudeModifier, final Tincture tincture) {
		AdvancedCharge ac = new AdvancedCharge();
		ac.name = name;
		ac.attitude = attitude;
		ac.attitudeModifier = attitudeModifier;
		ac.tincture = tincture;
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

	public String getTextDescription() { // TODO add body parts etc
		return "'" + name + " " + attitude + " " + tincture.getName() + "'";
	}

}
