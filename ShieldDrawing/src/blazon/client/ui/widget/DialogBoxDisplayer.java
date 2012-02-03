package blazon.client.ui.widget;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HasAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

// code taken from http://stackoverflow.com/questions/5051643/messagebox-in-gwt
public class DialogBoxDisplayer {
	
	private final String header;
	private final String content;

	public DialogBoxDisplayer(final String header, final String content) {
		this.header = header;
		this.content = content;
	}

	public void displayDialogBox() {
		DialogBox box = createDialogBox();
        box.center();
    }

	private DialogBox createDialogBox() {
        final DialogBox box = new DialogBox();
        final VerticalPanel panel = new VerticalPanel();
        box.setText(header);
        panel.add(new Label(content));
        final Button button = new Button("Close");
        button.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(final ClickEvent event) {
                box.hide();
            }
        });
        // few empty labels to make widget larger
        final Label emptyLabel = new Label("");
        emptyLabel.setSize("auto","25px");
        panel.add(emptyLabel);
        panel.add(emptyLabel);
        button.setWidth("90px");
        panel.add(button);
        panel.setCellHorizontalAlignment(button, HasAlignment.ALIGN_CENTER);
        box.add(panel);
        return box;
    }
}
