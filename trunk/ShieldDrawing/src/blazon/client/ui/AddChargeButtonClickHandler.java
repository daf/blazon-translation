package blazon.client.ui;

import blazon.client.charge.adding.ChargeAddingService;
import blazon.client.charge.adding.ChargeAddingServiceAsync;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;

class AddChargeButtonClickHandler implements ClickHandler {

	private final OptionalTextBoxPanelController panelController;

	AddChargeButtonClickHandler(OptionalTextBoxPanelController panelController) {
		this.panelController = panelController;
	}

	@Override
	public void onClick(ClickEvent event) {
		DiagnosticDisplayer.getInstance().clearPanel();
        final ChargeAddingServiceAsync service = GWT.create(ChargeAddingService.class);
        service.addChargeToDatastore(panelController, new AddChargeToDatastoreCallback<Void>(panelController));
	}

}
