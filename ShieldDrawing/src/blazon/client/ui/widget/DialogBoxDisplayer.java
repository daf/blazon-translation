package blazon.client.ui.widget;

import java.util.List;

import blazon.client.ui.DiagnosticDisplayer;
import blazon.shared.shield.diagnostic.ShieldDiagnostic;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HasAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.VerticalPanel;

// code taken from http://stackoverflow.com/questions/5051643/messagebox-in-gwt
public class DialogBoxDisplayer {
	
	private final String header;
	private final String content;
	private final Throwable caught;
	private final List<ShieldDiagnostic> diags;

	public DialogBoxDisplayer(final String header, final String content, Throwable caught, List<ShieldDiagnostic> diags) {
		this.header = header;
		this.content = content;
		this.caught = caught;
		this.diags = diags;
	}
	
	public DialogBoxDisplayer(final String header, final String content) {
		this(header, content, null, null);
	}
	
	public DialogBoxDisplayer(final String header, final String content, Throwable caught) {
		this(header, content, caught, null);
	}

	public DialogBoxDisplayer(String header, String content,
			List<ShieldDiagnostic> diags) {
		this(header, content, null, diags);
	}

	public void displayDialogBox() {
		DialogBox box = createDialogBox();
        box.center();
    }

	private DialogBox createDialogBox() {
        final DialogBox box = new DialogBox();
        final VerticalPanel panel = new VerticalPanel();
        panel.addStyleName("dialogPanel");
        box.setText(header);
        Label message = new Label(content);
        message.addStyleName("message");
		panel.add(message);
        final Button button = new Button("Close");
        button.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(final ClickEvent event) {
                box.hide();
            }
        });
        // few empty labels to make widget larger
        Label emptyLabel = createEmptyLabel();
        Label emptyLabel2 = createEmptyLabel();
        panel.add(emptyLabel);
        button.setWidth("90px");
        button.setHeight("25px");
        button.addStyleName("dialogButton");
        panel.add(button);
        panel.add(emptyLabel2);

        panel.setCellHorizontalAlignment(button, HasAlignment.ALIGN_CENTER);
        panel.add(addDiagnostics(diags, caught));
        box.add(panel);
        return box;
    }

	private Label createEmptyLabel() {
		Label emptyLabel = new Label("");
        emptyLabel.setSize("auto","15px");
		return emptyLabel;
	}

	private Panel addDiagnostics(List<ShieldDiagnostic> diags, Throwable caught) {
		DiagnosticDisplayer diagDisplayer = new DiagnosticDisplayer();
		Panel panel = new FlowPanel();
		if (diags != null && !diags.isEmpty()) {
			panel.add(diagDisplayer.displayDiagnostics(diags));
		} else if (caught != null) {
			panel.add(diagDisplayer.displayThrowable(caught));
		}
		return panel;
	}
}
