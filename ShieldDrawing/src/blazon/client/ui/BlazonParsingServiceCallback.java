package blazon.client.ui;

import blazon.client.charge.fetching.ChargeFetchingService;
import blazon.client.charge.fetching.ChargeFetchingServiceAsync;
import blazon.shared.shield.Shield;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class BlazonParsingServiceCallback implements AsyncCallback<Shield> {

	private final SVGPanelController svgPanelController;

	private final DiagnosticDisplayer diagnosticDisplayer = DiagnosticDisplayer.getInstance();

	public BlazonParsingServiceCallback(SVGPanelController svgPanelController) {
		this.svgPanelController = svgPanelController;
	}

	@Override
    public void onFailure(Throwable caught) {
		diagnosticDisplayer.displayThrowable(caught);
    }

    @Override
    public void onSuccess(Shield shield) {
    	ChargeFetchingServiceAsync service = GWT.create(ChargeFetchingService.class);
    	service.fetchImagesForCharges(shield, new ChargeFetchingServiceCallback(svgPanelController));
    }
}
