package blazon.client.ui;

import java.util.List;

import blazon.shared.shield.diagnostic.ShieldDiagnostic;

import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.RootPanel;

public class DiagnosticDisplayer {
	
	private static DiagnosticDisplayer instance;
	private Panel diagPanel = RootPanel.get("diagnosticsPanel");
	private FlexTable diagTable = new FlexTable();
	private int diagRecords = 0;
	
	private DiagnosticDisplayer() { 
		diagPanel.getElement().appendChild(diagTable.getElement());
	}
	
	public static synchronized DiagnosticDisplayer getInstance() {
		if (instance == null) {
			instance = new DiagnosticDisplayer();
		}
		return instance;
	}

	public void displayDiagnostics(List<ShieldDiagnostic> shieldDiagnostics) {
		if (shieldDiagnostics != null && !shieldDiagnostics.isEmpty()) {
			if (diagRecords == 0) {
				diagTable.setText(0, 0, "Severity Level");
				diagTable.setText(0, 1, "Information");
			}
			int row = diagRecords;
			diagRecords += shieldDiagnostics.size();
			while (row < diagRecords) {
				ShieldDiagnostic diag = shieldDiagnostics.get(row++);
				diagTable.setText(row, 0, diag.getSeverity().toString());
				diagTable.setText(row, 1, diag.getMessage());
			}
		}
	}

	public void displayThrowable(Throwable caught) {
		if (caught != null) {
			FlexTable diagTable = new FlexTable();
			if (diagRecords == 0) {
				diagTable.setText(0, 0, "Severity Level");
				diagTable.setText(0, 1, "Information");
			}
			diagTable.setText(diagRecords, 0, "Throwable");
			diagTable.setText(1, 0, caught.toString());
		}
	}
	
	public void clearPanel() {
		diagRecords = 0;
		diagTable.removeAllRows();
	}
}