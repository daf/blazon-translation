package blazon.client.ui.widget;

import java.io.Serializable;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;

public class LabelledTextBox extends Composite implements Serializable {

	private static final long serialVersionUID = -1233299501466346093L;
	private TextBox textBox;
	private Label label;
	
	public LabelledTextBox() {}
	
	public LabelledTextBox(String labelText) {
		textBox = new TextBox();
		textBox.setStyleName("appTextBox");
		label = new Label(labelText);
		label.setStyleName("appTextBoxLabel");
		HorizontalPanel panel = new HorizontalPanel();
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
	
}
