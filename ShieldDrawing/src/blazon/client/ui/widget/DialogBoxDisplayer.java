package blazon.client.ui.widget;

import java.util.List;

import blazon.shared.shield.diagnostic.ShieldDiagnostic;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.VerticalPanel;

// code taken from http://stackoverflow.com/questions/5051643/messagebox-in-gwt
public class DialogBoxDisplayer {
	
	private final DialogBox box;

	
	public DialogBoxDisplayer(final String header, final String content) {
		this(header, content, null, null);
	}
	
	public DialogBoxDisplayer(final String header, final String content, Throwable caught) {
		this(header, content, caught, null);
	}

	public DialogBoxDisplayer(String header, String content, List<ShieldDiagnostic> diags) {
		this(header, content, null, diags);
	}
	
	public DialogBoxDisplayer(final String header, final String content, Throwable caught, List<ShieldDiagnostic> diags) {
		box = new DialogBox();
        final VerticalPanel panel = new VerticalPanel();
        panel.addStyleName("dialogPanel");
        box.setText(header);
        Label message = new HTML(content);
        message.addStyleName("message");
		panel.add(message);
		addDetailsToDialogBox(caught, diags, panel);
        final Button button = new Button("Close");
        button.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(final ClickEvent event) {
                box.hide();
            }
        });
        // few empty labels to make widget larger
        panel.add(createEmptyLabel());
        button.setWidth("90px");
        button.setHeight("25px");
        button.addStyleName("dialogButton");
        panel.add(button);
        panel.add(createEmptyLabel());
        panel.setCellHorizontalAlignment(button, HasAlignment.ALIGN_CENTER);
        box.add(panel);
	}

	private void addDetailsToDialogBox(Throwable caught, List<ShieldDiagnostic> diags, final VerticalPanel panel) {
		if ((diags == null || diags.isEmpty()) && caught == null) {
			return;
		}
        panel.add(createEmptyLabel());
		final Label showDetailsLink = new Label("Show Details");
		showDetailsLink.addStyleName("showDetailsLink");
		panel.add(showDetailsLink);
		final Panel detailsPanel = new FlowPanel();
		if (diags != null && !diags.isEmpty()) {
			detailsPanel.add(displayDiagnostics(diags));
		} else if (caught != null) {
			detailsPanel.add(displayThrowable(caught));
		}
        detailsPanel.setVisible(false);
        panel.add(detailsPanel);
		showDetailsLink.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				//change text to show/hide
				if (detailsPanel.isVisible()) {
					showDetailsLink.setText("Show Details");
				} else {
					showDetailsLink.setText("Hide Details");
				}
				detailsPanel.setVisible(!detailsPanel.isVisible());
			}
		});
	}

	private FlexTable displayDiagnostics(List<ShieldDiagnostic> shieldDiagnostics) {
		if (shieldDiagnostics != null && !shieldDiagnostics.isEmpty()) {
			FlexTable diagTable = new FlexTable();
			for (int row = 0; row < shieldDiagnostics.size(); row++) {
				ShieldDiagnostic diag = shieldDiagnostics.get(row);
				diagTable.setText(row, 0, diag.getSeverity().toString());
				diagTable.setText(row, 1, diag.getMessage());
				diagTable.getCellFormatter().addStyleName(row, 0, "diagData");
				diagTable.getCellFormatter().addStyleName(row, 1, "diagData");
			}
			return diagTable;
		}
		return null;
	}

	private FlexTable displayThrowable(Throwable caught) {
		if (caught != null) {
			FlexTable diagTable = new FlexTable();
			String message = caught.getClass().getName();
			message += ": " + caught.getMessage();
			diagTable.setText(0, 0, message);
			diagTable.getCellFormatter().addStyleName(0, 0, "diagData");
			return diagTable;
		}
		return null;
	}
	
	public void displayDialogBox() {
        box.center();
    }

	private Label createEmptyLabel() {
		Label emptyLabel = new Label("");
        emptyLabel.setSize("auto","15px");
		return emptyLabel;
	}
}
