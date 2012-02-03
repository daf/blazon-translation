package blazon.client.charge.adding;

import blazon.client.ui.OptionalTextBoxPanelController;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface ChargeAddingServiceAsync {

	void addChargeToDatastore(OptionalTextBoxPanelController panelController, AsyncCallback<Void> callback);

	

}
