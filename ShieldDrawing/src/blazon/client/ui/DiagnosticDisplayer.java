package blazon.client.ui;

import java.util.List;

import blazon.shared.shield.diagnostic.ShieldDiagnostic;

import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.RootPanel;

public class DiagnosticDisplayer {

	public void displayDiagnostics(List<ShieldDiagnostic> shieldDiagnostics) {
		Panel diagPanel = RootPanel.get("diagnosticsPanel");
		FlexTable diagTable = new FlexTable();
		if (shieldDiagnostics != null && !shieldDiagnostics.isEmpty()) {
			diagTable.setText(0, 0, "Severity Level");
			diagTable.setText(0, 1, "Information");
			for (int i = 0; i < shieldDiagnostics.size(); i++) {
				ShieldDiagnostic diag = shieldDiagnostics.get(i);
				diagTable.setText(i + 1, 0, diag.getSeverity().toString());
				diagTable.setText(i + 1, 1, diag.getMessage());
			}
		}
		removeOldElementAndAddNew(diagPanel.getElement(), diagTable.getElement());
	}

	public void displayThrowable(Throwable caught) {
		Panel diagPanel = RootPanel.get("diagnosticsPanel");
		FlexTable diagTable = new FlexTable();
		if (caught != null) {
			diagTable.setText(0, 0, "Throwable Caught");
			diagTable.setText(1, 0, caught.toString());
		}
		removeOldElementAndAddNew(diagPanel.getElement(), diagTable.getElement());
	}
	
	private void removeOldElementAndAddNew(Element parent, Element newChild) {
		if (parent.getChildCount() != 0) {
			parent.removeChild(parent.getChild(0));
		}
		parent.appendChild(newChild);
	}
}