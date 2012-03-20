package blazon.shared.shield.charges;

import java.io.Serializable;

public class Ordinary extends GeometricCharge implements Serializable {

	private static final long serialVersionUID = -4970206075746766696L;

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Ordinary{tincture=");
		sb.append(tincture).append(":name=").append(name).append("}");
		return sb.toString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Ordinary))
			return false;
		Ordinary other = (Ordinary) obj;
		boolean nameMatch = name.equals(other.name);
		boolean tinctureMatch = tincture.equals(other.tincture);
		return nameMatch && tinctureMatch;
	}
}
