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
	
	private DiagnosticDisplayer() {}
	
	public static synchronized DiagnosticDisplayer getInstance() {
		if (instance == null) {
			instance = new DiagnosticDisplayer();
		}
		return instance;
	}

	public void displayDiagnostics(List<ShieldDiagnostic> shieldDiagnostics) {
		if (shieldDiagnostics != null && !shieldDiagnostics.isEmpty()) {
			makeVisible();
			addHeader();
			int row = diagRecords;
			diagRecords += shieldDiagnostics.size();
			while (row < diagRecords) {
				ShieldDiagnostic diag = shieldDiagnostics.get(row++);
				diagTable.setText(row, 0, diag.getSeverity().toString());
				diagTable.setText(row, 1, diag.getMessage());
				diagTable.getCellFormatter().addStyleName(row, 0, "diagData");
				diagTable.getCellFormatter().addStyleName(row, 1, "diagData");
			}
		}
	}

	public void displayThrowable(Throwable caught) {
		if (caught != null) {
			makeVisible();
			addHeader();
			diagTable.setText(diagRecords, 0, "Throwable");
			diagTable.setText(1, 0, caught.toString());
			diagTable.getCellFormatter().addStyleName(1, 0, "diagData");
			diagTable.getCellFormatter().addStyleName(1, 1, "diagData");
		}
	}
	
	private void addHeader() {
		if (diagRecords == 0) {
			diagTable.setText(0, 0, "Severity Level");
			diagTable.setText(0, 1, "Information");
			diagTable.getCellFormatter().addStyleName(0, 0, "diagHeader");
			diagTable.getCellFormatter().addStyleName(0, 1, "diagHeader");
		}
	}
	
	public void clearPanel() {
		if (diagRecords > 0) {
			makeInvisible();
			diagRecords = 0;
			diagTable.removeAllRows();
		}
	}
	
	private void makeVisible() {
		diagPanel.setStyleName("diagPanel");
		diagPanel.getElement().appendChild(diagTable.getElement());
		diagTable.setStyleName("diagTable");
	}
	
	private void makeInvisible() {
		diagPanel.removeStyleName("diagPanel");
		diagPanel.getElement().removeChild(diagTable.getElement());
		diagTable.removeStyleName("diagTable");
	}
}