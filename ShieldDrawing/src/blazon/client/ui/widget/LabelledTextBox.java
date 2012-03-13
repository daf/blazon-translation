package blazon.client.ui.widget;

import java.io.Serializable;

import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.TextBox;

public class LabelledTextBox extends Composite implements Serializable {

	private static final long serialVersionUID = -1233299501466346093L;
	private TextBox textBox;
	private Label label;
	
	public LabelledTextBox() {}
	
	public LabelledTextBox(String labelText, String labelCssClass, String textBoxCssClass, String panelCssClass) {
		textBox = new TextBox();
		textBox.setStyleName(textBoxCssClass);
		label = new Label(labelText);
		label.setStyleName(labelCssClass);
		Panel panel = new FlowPanel();
		panel.setStyleName(panelCssClass);
		panel.add(label);
		panel.add(textBox);
		initWidget(panel);
	}
	
	public String getLabelText() {
		return label.getText();
	}

	public String getEnteredText() {
		return textBox.getValue();
	}

	public void clearEnteredText() {
		textBox.setText("");
	}
	
	public void setFocus() {
		textBox.setFocus(true);
	}

	public void addDefaultButton(final Button button) {
		textBox.addKeyPressHandler(new KeyPressHandler() {
			
			@Override
			public void onKeyPress(KeyPressEvent event) {
				if (event.getCharCode() == KeyCodes.KEY_ENTER) {
					button.click();
				}
			}
		});
	}
}
