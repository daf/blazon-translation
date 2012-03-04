package blazon.client.ui;

import blazon.client.drawing.BlazonParsingService;
import blazon.client.drawing.BlazonParsingServiceAsync;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;

public class DrawShieldButtonClickHandler implements ClickHandler {

	private final SVGPanelController svgPanelController;
	
	public DrawShieldButtonClickHandler(final SVGPanelController svgPanelController) {
		this.svgPanelController = svgPanelController;
	}
	
	@Override
	public void onClick(ClickEvent event) {
		processInput();
	}

	private void processInput() {
		DiagnosticDisplayer.getInstance().clearPanel();
        final String enteredText = svgPanelController.getTextFromTextBox("Enter Blazon");
        final BlazonParsingServiceAsync service = GWT.create(BlazonParsingService.class);
        service.createShieldRepresentation(enteredText, new BlazonParsingServiceCallback(svgPanelController));
    }
}