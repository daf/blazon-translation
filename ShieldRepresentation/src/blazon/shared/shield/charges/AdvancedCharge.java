package blazon.shared.shield.charges;

import java.io.Serializable;

import blazon.shared.shield.tinctures.Tincture;

public class AdvancedCharge implements Charge, Serializable {
	
	private static final long serialVersionUID = -6533905684774401769L;
	
	private final String name;
	private final String attitude;
	private final String attitudeModifier;
	private final Tincture tincture;
	private String imageSource;
	
	public AdvancedCharge(final String name, final String attitude, final String attitudeModifier, final Tincture tincture) {
		this.name = name;
		this.attitude = attitude;
		this.attitudeModifier = attitudeModifier;
		this.tincture = tincture;
		this.imageSource = null;
	}
	
	public void setImageSource(final String imageSource) {
		if (this.imageSource == null) {
			this.imageSource = imageSource;
		}
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

}
