package blazon.shared.shield;

import java.util.List;

import blazon.shared.shield.charges.GeometricCharge;
import blazon.shared.shield.diagnostic.ShieldDiagnostic;

public class InvalidShield extends AbstractShield {

	private static final long serialVersionUID = -5920462606297751154L;

	private InvalidShield() {}
	
	public static Shield build() {
		return new InvalidShield();
	}
	
	public static Shield build(List<ShieldDiagnostic> diagnostics) {
		InvalidShield shield = new InvalidShield();
		shield.addDiagnostics(diagnostics);
		shield.blazon = "ERROR - Invalid Blazon";
		return shield;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("InvalidShield{diagnostics=").append(getShieldDiagnostics());
		return sb.append("}").toString();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof InvalidShield)) {
			return false;
		}
		InvalidShield other = (InvalidShield)obj;
		List<ShieldDiagnostic> myDiagnostics = getShieldDiagnostics();
		List<ShieldDiagnostic> otherDiagnostics = other.getShieldDiagnostics();
		if (myDiagnostics == null && otherDiagnostics == null) {
			return true;
		} else if (myDiagnostics == null || otherDiagnostics == null) {
			return false;
		} else {
			return myDiagnostics.equals(other.getShieldDiagnostics());
		}
	}
	
	@Override
	public int hashCode() {
		int result = 17;
		result = 31 * result + (getShieldDiagnostics() == null ? 0 : getShieldDiagnostics().hashCode());
		return result;
	}

	@Override
	public Field getField() {
		throw new UnsupportedOperationException("An InvalidShield object does not have a field.");
	}

	@Override
	public void addCharges(List<GeometricCharge> charges) {
		throw new UnsupportedOperationException("An InvalidShield object does not have charges.");
	}

	@Override
	public List<GeometricCharge> getCharges() {
		throw new UnsupportedOperationException("An InvalidShield object does not have charges.");
	}
}
