package blazon.client.ui;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class BlazonToImageConverter implements EntryPoint {
    
    public void onModuleLoad() {
    	final Panel mainPanel = RootPanel.get("mainPanel");
    	SVGPanelController svgPanelController = new SVGPanelController();
    	Panel svgPanel = svgPanelController.initializePanel();
    	mainPanel.add(svgPanel);
        addTextBoxAndButtonToUI(mainPanel, svgPanelController); // passing the svgDrawer is the chain of responsibility pattern
    }
    
	private void addTextBoxAndButtonToUI(final Panel mainPanel, final SVGPanelController svgPanelController) {
		final TextBox textBox = new TextBox();
        mainPanel.add(textBox);
        Button button = new Button("Draw Shield");
        mainPanel.add(button);
        button.addClickHandler(new ButtonClickHandler(svgPanelController, textBox));
	}
}