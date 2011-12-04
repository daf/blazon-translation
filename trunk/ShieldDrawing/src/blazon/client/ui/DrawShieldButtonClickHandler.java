package blazon.client.ui;

import blazon.client.drawing.BlazonParsingService;
import blazon.client.drawing.BlazonParsingServiceAsync;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.TextBox;

public class DrawShieldButtonClickHandler implements ClickHandler {

	private final SVGPanelController svgPanelController;
	private final TextBox textBox;
	
	public DrawShieldButtonClickHandler(final SVGPanelController svgPanelController, TextBox textBox) {
		this.svgPanelController = svgPanelController;
		this.textBox = textBox;
	}
	
	@Override
	public void onClick(ClickEvent event) {
		processInput();
	}

	private void processInput() {
        final String enteredText = textBox.getText();
        final BlazonParsingServiceAsync service = GWT.create(BlazonParsingService.class);
        service.createShieldRepresentation(enteredText, new BlazonParsingServiceCallback(svgPanelController));
    }
}