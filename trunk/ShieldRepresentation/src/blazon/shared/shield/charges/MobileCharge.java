package blazon.shared.shield.charges;

public class MobileCharge extends GeometricCharge {

	private static final long serialVersionUID = -5079719407441394224L;

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("MobileCharge{tincture=");
		sb.append(tincture).append(":name=").append(name).append("}");
		return sb.toString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof MobileCharge))
			return false;
		MobileCharge other = (MobileCharge) obj;
		boolean nameMatch = name.equals(other.name);
		boolean tinctureMatch = tincture.equals(other.tincture);
		return nameMatch && tinctureMatch;
	}
}
