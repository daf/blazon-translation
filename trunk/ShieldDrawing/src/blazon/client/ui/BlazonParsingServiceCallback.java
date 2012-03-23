package blazon.client.ui;

import blazon.client.charge.fetching.ChargeFetchingService;
import blazon.client.charge.fetching.ChargeFetchingServiceAsync;
import blazon.client.ui.widget.DialogBoxDisplayer;
import blazon.shared.shield.Shield;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class BlazonParsingServiceCallback implements AsyncCallback<Shield> {

	private final SVGPanelController svgPanelController;
	private final ProgressSpinner spinner;

	public BlazonParsingServiceCallback(SVGPanelController svgPanelController, ProgressSpinner spinner) {
		this.svgPanelController = svgPanelController;
		this.spinner = spinner;
	}

	@Override
    public void onFailure(Throwable caught) {
		spinner.stop();
		if (caught instanceof IllegalArgumentException) {
			DialogBoxDisplayer dialogBox = new DialogBoxDisplayer("Blazon Error", "Can not draw a shield for an empty sentence of Blazon.");
			dialogBox.displayDialogBox();
		}
    }

    @Override
    public void onSuccess(Shield shield) {
    	ChargeFetchingServiceAsync service = GWT.create(ChargeFetchingService.class);
    	service.fetchImagesForCharges(shield, new ChargeFetchingServiceCallback(svgPanelController, spinner));
    }
}