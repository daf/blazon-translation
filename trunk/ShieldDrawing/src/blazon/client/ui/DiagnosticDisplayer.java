package blazon.client.ui;

import java.util.List;

import blazon.shared.shield.diagnostic.ShieldDiagnostic;

import com.google.gwt.user.client.ui.FlexTable;

public class DiagnosticDisplayer {
	
	
	public DiagnosticDisplayer() {}
	
	public FlexTable displayDiagnostics(List<ShieldDiagnostic> shieldDiagnostics) {
		if (shieldDiagnostics != null && !shieldDiagnostics.isEmpty()) {
			FlexTable diagTable = new FlexTable();
			addHeader(diagTable);
			for (int row = 1; row <= shieldDiagnostics.size(); row++) {
				ShieldDiagnostic diag = shieldDiagnostics.get(row-1);
				diagTable.setText(row, 0, diag.getSeverity().toString());
				diagTable.setText(row, 1, diag.getMessage());
				diagTable.getCellFormatter().addStyleName(row, 0, "diagData");
				diagTable.getCellFormatter().addStyleName(row, 1, "diagData");
			}
			return diagTable;
		}
		return null;
	}

	public FlexTable displayThrowable(Throwable caught) {
		if (caught != null) {
			FlexTable diagTable = new FlexTable();
			addHeader(diagTable);
			diagTable.setText(1, 0, "Throwable");
			StringBuilder sb = new StringBuilder(caught.getClass().getName());
			sb.append(": ").append(caught.getMessage());
			for (StackTraceElement ste : caught.getStackTrace())
				sb.append("\n").append(ste.toString());
			diagTable.setText(1, 1, sb.toString());
			diagTable.getCellFormatter().addStyleName(1, 0, "diagData");
			diagTable.getCellFormatter().addStyleName(1, 1, "diagData");
			return diagTable;
		}
		return null;
	}
	
	private void addHeader(FlexTable diagTable) {
		diagTable.setText(0, 0, "Severity Level");
		diagTable.setText(0, 1, "Information");
		diagTable.getCellFormatter().addStyleName(0, 0, "diagHeader");
		diagTable.getCellFormatter().addStyleName(0, 1, "diagHeader");
	}
}