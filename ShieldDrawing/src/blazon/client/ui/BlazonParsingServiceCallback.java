package blazon.client.ui;

import blazon.shared.shield.Shield;

import com.google.gwt.user.client.rpc.AsyncCallback;

public class BlazonParsingServiceCallback implements AsyncCallback<Shield> {

	private final SVGPanelController svgPanelController;

	private final DiagnosticDisplayer diagnosticDisplayer = new DiagnosticDisplayer();

	public BlazonParsingServiceCallback(SVGPanelController svgPanelController) {
		this.svgPanelController = svgPanelController;
	}

	@Override
    public void onFailure(Throwable caught) {
		diagnosticDisplayer.displayThrowable(caught);
    }

    @Override
    public void onSuccess(Shield shield) {
    	svgPanelController.displayShield(shield);
    	diagnosticDisplayer.displayDiagnostics(shield.getShieldDiagnostics());
    }
}
