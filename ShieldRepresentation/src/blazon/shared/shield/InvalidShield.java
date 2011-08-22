package blazon.shared.shield;

import java.util.ArrayList;
import java.util.List;

import blazon.shared.shield.diagnostic.ShieldDiagnostic;

public class InvalidShield extends AbstractShield {

	private static final long serialVersionUID = -5920462606297751154L;

	private InvalidShield() {}
	
	public static Shield build() {
		return new InvalidShield();
	}
	
	public static Shield build(List<ShieldDiagnostic> diagnostics) {
		InvalidShield shield = new InvalidShield();
		shield.diagnostics = new ArrayList<ShieldDiagnostic>(diagnostics);
		return shield;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("InvalidShield{diagnostics=").append(diagnostics);
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
		return diagnostics.equals(other.diagnostics);
	}
	
	@Override
	public int hashCode() {
		int result = 17;
		result = 31 * result + (diagnostics == null ? 0 : diagnostics.hashCode());
		return result;
	}
}
