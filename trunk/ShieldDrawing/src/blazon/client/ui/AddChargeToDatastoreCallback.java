package blazon.client.ui;

import blazon.client.ui.widget.DialogBoxDisplayer;

import com.google.gwt.user.client.rpc.AsyncCallback;

public class AddChargeToDatastoreCallback<T> implements AsyncCallback<Void> {

	private final PanelController panelController;

	public AddChargeToDatastoreCallback(PanelController panelController) {
		this.panelController = panelController;
	}

	@Override
	public void onFailure(Throwable caught) {
		String errorMessage = caught.getMessage();
		if (caught instanceof IllegalArgumentException) {
			errorMessage = "Some of the necessary data needed about the charge was not specified";
		}
		DialogBoxDisplayer dialogBox = new DialogBoxDisplayer("Adding Charge Failed", "The charge you specified was not added to the datastore.\n" + errorMessage, caught);
		dialogBox.displayDialogBox();
	}

	@Override
	public void onSuccess(Void result) {
		DialogBoxDisplayer dialogBox = new DialogBoxDisplayer("Adding Charge Successful", "The charge has been successfully added to the datastore.");
		dialogBox.displayDialogBox();
		panelController.clearAllTextBoxes();
	}
	

}
