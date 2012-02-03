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
    	createShieldDrawingUI();
    	createChargeAddingPanel();
    }

	private void createChargeAddingPanel() {
		final Panel chargeAddingPanel = RootPanel.get("newChargePanel");
		OptionalTextBoxPanelController panelController = new OptionalTextBoxPanelController(chargeAddingPanel);
		panelController.addLabelledTextBox("Charge");
		panelController.addLabelledTextBox("Attitude");
		panelController.addLabelledTextBox("Attitude Modifier");
		panelController.addLabelledTextBox("Charge Tincture");
		panelController.addListBoxForAdditionalTextBoxesAndLabels("Body Part");
		panelController.addLabelledTextBox("Image Location");
		panelController.addButtonToPanel("Add Charge", new AddChargeButtonClickHandler(panelController));
	}

	private void createShieldDrawingUI() {
		final Panel mainPanel = RootPanel.get("mainPanel");
    	SVGPanelController svgPanelController = new SVGPanelController(mainPanel);
    	svgPanelController.initializePanel();
    	svgPanelController.addLabelledTextBox("Blazon");
        svgPanelController.addButtonToPanel("Draw Shield", new DrawShieldButtonClickHandler(svgPanelController));
        // passing the svgDrawer is the chain of responsibility pattern		
	}
}
