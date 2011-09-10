package blazon.shared.shield;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import blazon.shared.shield.diagnostic.ShieldDiagnostic;

public abstract class AbstractShield implements Shield, Serializable {

	private static final long serialVersionUID = 6055643270596134156L;

	private List<ShieldDiagnostic> diagnostics;
	protected String blazon;
	
	public List<ShieldDiagnostic> getShieldDiagnostics() {
		return diagnostics;
	}
	
	public void addDiagnostics(List<ShieldDiagnostic> diagnostics) {
		if (diagnostics == null || diagnostics.size() == 0) {
			return;
		} else {
			if (this.diagnostics == null) {
				this.diagnostics = new ArrayList<ShieldDiagnostic>(diagnostics);
			} else {
				this.diagnostics.addAll(diagnostics);
			}
		}
		
	}
	
	public final String getBlazon() {
		return blazon;
	}
}
