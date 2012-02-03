package blazon.client.charge.adding;

import blazon.client.ui.OptionalTextBoxPanelController;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("addCharge")
public interface ChargeAddingService extends RemoteService {
	void addChargeToDatastore(OptionalTextBoxPanelController panelController);
}
