package blazon.client.ui;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.RootPanel;

import blazon.client.ui.OptionalTextBoxPanelController;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Main implements EntryPoint {

    public void onModuleLoad() {
		final Panel applicationPanel = RootPanel.get("application");
		createShieldDrawingUI(applicationPanel);
    	createChargeAddingPanel(applicationPanel);
    }

	private void createChargeAddingPanel(Panel parent) {
		final Panel chargeAddingPanel = new AbsolutePanel();
		final OptionalTextBoxPanelController panelController = new OptionalTextBoxPanelController(chargeAddingPanel);
		panelController.addLabelledTextBox("Charge");
		panelController.addLabelledTextBox("Attitude");
		panelController.addLabelledTextBox("Attitude Modifier");
		panelController.addLabelledTextBox("Charge Tincture");
		panelController.addListBoxForAdditionalTextBoxesAndLabels("Body Part", "Body Part Tincture");
		panelController.addLabelledTextBox("Image Location");
		panelController.addButtonToPanel("Add Charge", new AddChargeButtonClickHandler(panelController));
        parent.add(chargeAddingPanel);
	}

	private void createShieldDrawingUI(Panel parent) {
		final Panel svgPanel = new AbsolutePanel();
    	final SVGPanelController svgPanelController = new SVGPanelController(svgPanel);
    	svgPanelController.initializePanel();
    	svgPanelController.addLabelledTextBox("Blazon");
        svgPanelController.addButtonToPanel("Draw Shield", new DrawShieldButtonClickHandler(svgPanelController));
        parent.add(svgPanel);
	}
}
