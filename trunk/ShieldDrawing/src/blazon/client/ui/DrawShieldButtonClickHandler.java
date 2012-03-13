package blazon.client.ui;

import blazon.client.drawing.BlazonParsingService;
import blazon.client.drawing.BlazonParsingServiceAsync;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
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
        JavaScriptObject spinner = startProgressSpin(svgPanelController.getPanelElement().getId());
        service.createShieldRepresentation(enteredText, new BlazonParsingServiceCallback(svgPanelController, spinner));
    }
	
	private native JavaScriptObject startProgressSpin(String elementId)/*-{
		var opts = {
		  lines: 14, // The number of lines to draw
		  length: 13, // The length of each line
		  width: 5, // The line thickness
		  radius: 27, // The radius of the inner circle
		  color: '#000', // #rgb or #rrggbb
		  speed: 1, // Rounds per second
		  trail: 100, // Afterglow percentage
		  shadow: true, // Whether to render a shadow
		  hwaccel: false, // Whether to use hardware acceleration
		  className: 'spinner', // The CSS class to assign to the spinner
		  zIndex: 2e9, // The z-index (defaults to 2000000000)
		  top: 'auto', // Top position relative to parent in px
		  left: 'auto' // Left position relative to parent in px
		};
		
		var spinner = new $wnd.Spinner(opts).spin($wnd.document.getElementById(elementId)); // Place in DOM node called "ajaxContentHolder"
		return spinner;
	}-*/;
}