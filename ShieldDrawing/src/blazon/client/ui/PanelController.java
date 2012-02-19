package blazon.client.ui;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import blazon.client.ui.widget.LabelledTextBox;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Panel;

public class PanelController implements Serializable {
	
	private static final long serialVersionUID = 5926214964504846687L;
	public Map<String, LabelledTextBox> textBoxMap;
	protected Panel panel;
	
	PanelController() {}
	
	PanelController(Panel panel) {
		this.panel = panel;
		this.textBoxMap = new HashMap<String, LabelledTextBox>();
	}

	String getTextFromTextBox(String textBoxIdentifier) {
		textBoxIdentifier = textBoxIdentifier.trim().toLowerCase();
		LabelledTextBox ltb = textBoxMap.get(textBoxIdentifier);
		if (ltb == null) {
			return null;
		}
		return ltb.getEnteredText();
	}

	void clearAllTextBoxes() {
		for (LabelledTextBox ltb : textBoxMap.values()) {
			ltb.clearEnteredText();
		}
	}

	void addLabelledTextBox(String labelText, String labelCssClass, String textBoxCssClass) {
		addLabelledTextBox(labelText, labelCssClass, textBoxCssClass, "");
	}
	
	void addLabelledTextBox(String labelText, String labelCssClass, String textBoxCssClass, String panelCssClass) {
		labelText = labelText.trim();
		LabelledTextBox ltb = new LabelledTextBox(labelText, labelCssClass, textBoxCssClass, panelCssClass);
		panel.add(ltb);
		textBoxMap.put(ltb.getLabelText().toLowerCase(), ltb);
	}

	void addButtonToPanel(String buttonText, String buttonCssClass, ClickHandler clickHandler) {
		Button button = new Button(buttonText);
		button.setStyleName(buttonCssClass);
		panel.add(button);
        button.addClickHandler(clickHandler);		
	}
	
	void addLabel(String labelText, String labelCss) {
		labelText = labelText.trim();
		Label label = new Label(labelText);
		label.setStyleName(labelCss);
		panel.add(label);
	}
}
