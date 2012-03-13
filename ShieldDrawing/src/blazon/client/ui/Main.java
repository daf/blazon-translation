package blazon.client.ui;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.RootPanel;

import blazon.client.ui.OptionalTextBoxPanelController;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Main implements EntryPoint {

    public void onModuleLoad() {
		createShieldDrawingUI(RootPanel.get("svgPanel"));
    	createChargeAddingPanel(RootPanel.get("chargeAddingPanel"));
    }

	private void createChargeAddingPanel(Panel chargeAddingPanel) {
		final String labelCss = "chargeLabel";
		final String textBoxCss = "chargeTextBox";
		final String panelCss = "chargePanel";
		final OptionalTextBoxPanelController panelController = new OptionalTextBoxPanelController(chargeAddingPanel, labelCss, textBoxCss, panelCss);
		panelController.addLabelledTextBox("Charge", labelCss, textBoxCss, panelCss);
		panelController.addLabelledTextBox("Attitude", labelCss, textBoxCss, panelCss);
		panelController.addLabelledTextBox("Attitude Modifier", labelCss, textBoxCss, panelCss);
		panelController.addLabelledTextBox("Charge Tincture", labelCss, textBoxCss, panelCss);
		panelController.addLabelledTextBox("Image Location", labelCss, textBoxCss, panelCss);
		panelController.addListBoxForAdditionalTextBoxesAndLabels("Number of Specified Body Parts", labelCss, "chargeListBox", "Body Part", "Body Part Tincture");
		panelController.addButtonToPanel("Add Charge to Database", "chargeButton", new AddChargeButtonClickHandler(panelController));
	}

	private void createShieldDrawingUI(Panel svgPanel) {
    	final SVGPanelController svgPanelController = new SVGPanelController(svgPanel);
    	svgPanelController.addLabelledTextBox("Enter Blazon", "blazonLabel", "blazonTextBox");
    	svgPanelController.setFocusOfTextBox("Enter Blazon");
    	svgPanelController.addButtonToPanel("Draw Shield", "blazonButton", new DrawShieldButtonClickHandler(svgPanelController), true);
    	svgPanelController.createShieldSVGElement();
    	
	}
}
