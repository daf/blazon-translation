package blazon.client.ui;

import com.google.gwt.core.client.JavaScriptObject;

public class ProgressSpinner {

	private JavaScriptObject spinner;
	
	public ProgressSpinner() {
		setUpSpinner();
	}
	
	private native void setUpSpinner() /*-{
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
		this.@blazon.client.ui.ProgressSpinner::spinner = new $wnd.Spinner(opts);
	}-*/;
	
	native void stop()/*-{
	  this.@blazon.client.ui.ProgressSpinner::spinner.stop();
    }-*/;
	
	native void start(String elementId)/*-{
		this.@blazon.client.ui.ProgressSpinner::spinner.spin($wnd.document.getElementById(elementId));
	}-*/;
}