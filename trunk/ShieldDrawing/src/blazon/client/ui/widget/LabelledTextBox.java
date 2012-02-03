package blazon.client.ui.widget;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;

public class LabelledTextBox extends Composite {

	private TextBox textBox;
	private Label label;
	
	public LabelledTextBox(String labelText) {
		textBox = new TextBox();
		label = new Label(labelText);
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
