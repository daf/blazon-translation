package blazon.client.ui;

import blazon.client.BlazonParsingService;
import blazon.client.BlazonParsingServiceAsync;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.TextBox;

public class ButtonClickHandler implements ClickHandler {

	private final SVGPanelController svgPanelController;
	private final TextBox textBox;
	
	public ButtonClickHandler(final SVGPanelController svgPanelController, TextBox textBox) {
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