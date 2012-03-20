package blazon.shared.shield;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import blazon.shared.shield.diagnostic.ShieldDiagnostic;

public abstract class AbstractShield implements Shield, Serializable {

	private static final long serialVersionUID = 6055643270596134156L;

	private List<ShieldDiagnostic> diagnostics = new ArrayList<ShieldDiagnostic>();
	protected String blazon;
	
	public List<ShieldDiagnostic> getShieldDiagnostics() {
		return diagnostics;
	}
	
	public void addDiagnostics(List<ShieldDiagnostic> diagnostics) {
		if (diagnostics == null || diagnostics.size() == 0) {
			return;
		} else {
			this.diagnostics.addAll(diagnostics);
		}
	}
	
	public void addDiagnostic(ShieldDiagnostic diagnostic) {
		this.diagnostics.add(diagnostic);
	}
	
	public final String getBlazon() {
		return blazon;
	}

	public abstract Field getField();
}
