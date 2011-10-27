package blazon.shared.shield;

import java.util.List;

import blazon.shared.shield.charges.GeometricCharge;
import blazon.shared.shield.diagnostic.ShieldDiagnostic;

public interface Shield {
	List<ShieldDiagnostic> getShieldDiagnostics();
	void addDiagnostics(List<ShieldDiagnostic> diagnostics);
	String getBlazon();
	ShieldLayer getField();
	void addCharges(List<GeometricCharge> charges);
	List<GeometricCharge> getCharges();
}
