package blazon.shared.shield.charges;

import java.io.Serializable;

public class Subordinary extends GeometricCharge implements Serializable {


	private static final long serialVersionUID = 6967031401603144916L;

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Subordinary{tincture=");
		sb.append(tincture).append(":name=").append(name).append("}");
		return sb.toString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Subordinary))
			return false;
		Subordinary other = (Subordinary) obj;
		boolean nameMatch = name.equals(other.name);
		boolean tinctureMatch = tincture.equals(other.tincture);
		return nameMatch && tinctureMatch;
	}
}