package blazon.client.ui;

import blazon.client.charge.fetching.ChargeFetchingService;
import blazon.client.charge.fetching.ChargeFetchingServiceAsync;
import blazon.client.ui.widget.DialogBoxDisplayer;
import blazon.shared.shield.Shield;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class BlazonParsingServiceCallback implements AsyncCallback<Shield> {

	private final SVGPanelController svgPanelController;

	public BlazonParsingServiceCallback(SVGPanelController svgPanelController) {
		this.svgPanelController = svgPanelController;
	}

	@Override
    public void onFailure(Throwable caught) {
		if (caught instanceof IllegalArgumentException) {
			DialogBoxDisplayer dialogBox = new DialogBoxDisplayer("Shield Drawing Failed", "Can not draw a shield for an empty sentence of Blazon.", caught);
			dialogBox.displayDialogBox();
		}
    }

    @Override
    public void onSuccess(Shield shield) {
    	ChargeFetchingServiceAsync service = GWT.create(ChargeFetchingService.class);
    	service.fetchImagesForCharges(shield, new ChargeFetchingServiceCallback(svgPanelController));
    }
}
