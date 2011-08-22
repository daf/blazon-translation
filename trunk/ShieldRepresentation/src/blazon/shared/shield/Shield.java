package blazon.shared.shield;

import java.util.List;

import blazon.shared.shield.diagnostic.ShieldDiagnostic;

public interface Shield {
	List<ShieldDiagnostic> getShieldDiagnostics();
	void addDiagnostics(List<ShieldDiagnostic> diagnostics);
}
