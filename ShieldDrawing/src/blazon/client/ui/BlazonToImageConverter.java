package blazon.client.ui;

import java.util.HashMap;
import java.util.Map;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class BlazonToImageConverter implements EntryPoint {
    
    public void onModuleLoad() {
    	createShieldDrawingUI();
    	createChargeAddingPanel();
    }
    
	private void createChargeAddingPanel() {
		final Panel chargeAddingPanel = RootPanel.get("newChargePanel");
		final TextBox chargeTextBox = addLabelWithGivenTextAndTextBoxToPanel(chargeAddingPanel, "Charge:");
		final TextBox attituteTextBox = addLabelWithGivenTextAndTextBoxToPanel(chargeAddingPanel, "Attitude:");
		final TextBox attitudeModifierTextBox = addLabelWithGivenTextAndTextBoxToPanel(chargeAddingPanel, "Attitude Modifier:");
		final TextBox tinctureTextBox = addLabelWithGivenTextAndTextBoxToPanel(chargeAddingPanel, "Charge Tincture:");
		
		// TODO add dropdown for number of body parts, and add appropriate number of text boxes
		Map<TextBox, TextBox> bodyParts = new HashMap<TextBox, TextBox>();
		
		TextBox bodyPart = addLabelWithGivenTextAndTextBoxToPanel(chargeAddingPanel, "Body Part 1:");
		TextBox bodyPartTincture = addLabelWithGivenTextAndTextBoxToPanel(chargeAddingPanel, "Body Part Tincture 1:");
		bodyParts.put(bodyPart, bodyPartTincture);
		bodyPart = addLabelWithGivenTextAndTextBoxToPanel(chargeAddingPanel, "Body Part 2:");
		bodyPartTincture = addLabelWithGivenTextAndTextBoxToPanel(chargeAddingPanel, "Body Part Tincture 2:");
		bodyParts.put(bodyPart, bodyPartTincture);
		
		final TextBox imageLocationTextBox = addLabelWithGivenTextAndTextBoxToPanel(chargeAddingPanel, "Image location:");
		Button button = new Button("Add Charge");
		chargeAddingPanel.add(button);
        button.addClickHandler(new AddChargeButtonClickHandler(chargeTextBox, attituteTextBox, attitudeModifierTextBox, tinctureTextBox, bodyParts, imageLocationTextBox));
        
//		TODO add feedback for image adding and tidy the callback code
	}

	private TextBox addLabelWithGivenTextAndTextBoxToPanel(Panel panel, String labelText) {
		Label label = new Label(labelText);
		TextBox textBox = new TextBox();
		panel.add(label);
		panel.add(textBox);
		return textBox;
	}

	private void createShieldDrawingUI() {
		final Panel mainPanel = RootPanel.get("mainPanel");
    	SVGPanelController svgPanelController = new SVGPanelController();
    	Panel svgPanel = svgPanelController.initializePanel();
    	mainPanel.add(svgPanel);
    	final TextBox textBox = new TextBox();
        mainPanel.add(textBox);
        Button button = new Button("Draw Shield");
        mainPanel.add(button);
        button.addClickHandler(new DrawShieldButtonClickHandler(svgPanelController, textBox));
        // passing the svgDrawer is the chain of responsibility pattern		
	}
}
