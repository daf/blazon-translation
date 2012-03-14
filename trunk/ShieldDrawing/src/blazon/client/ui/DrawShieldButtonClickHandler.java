package blazon.client.ui;

import blazon.client.drawing.BlazonParsingService;
import blazon.client.drawing.BlazonParsingServiceAsync;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;

class DrawShieldButtonClickHandler implements ClickHandler {

	private final SVGPanelController svgPanelController;
	
	DrawShieldButtonClickHandler(final SVGPanelController svgPanelController) {
		this.svgPanelController = svgPanelController;
	}
	
	@Override
	public void onClick(ClickEvent event) {
		processInput();
	}

	private void processInput() {
        final String enteredText = svgPanelController.getTextFromTextBox("Enter Blazon");
        final BlazonParsingServiceAsync service = GWT.create(BlazonParsingService.class);
        ProgressSpinner spinner = new ProgressSpinner();
        spinner.start(svgPanelController.getPanelElement().getId());
        service.createShieldRepresentation(enteredText, new BlazonParsingServiceCallback(svgPanelController, spinner));
    }
	

}