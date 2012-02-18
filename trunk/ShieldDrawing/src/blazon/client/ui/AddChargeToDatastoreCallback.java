package blazon.client.ui;

import blazon.client.ui.widget.DialogBoxDisplayer;

import com.google.gwt.user.client.rpc.AsyncCallback;

public class AddChargeToDatastoreCallback<T> implements AsyncCallback<Void> {

	private final DiagnosticDisplayer diagnosticDisplayer = DiagnosticDisplayer.getInstance();
	private final PanelController panelController;

	public AddChargeToDatastoreCallback(PanelController panelController) {
		this.panelController = panelController;
	}

	@Override
	public void onFailure(Throwable caught) {
		diagnosticDisplayer.displayThrowable(caught);
		DialogBoxDisplayer dialogBox = new DialogBoxDisplayer("Adding Charge Failed", "The charge you specified was not added to the datastore. " + caught);
		dialogBox.displayDialogBox();
	}

	@Override
	public void onSuccess(Void result) {
		DialogBoxDisplayer dialogBox = new DialogBoxDisplayer("Adding Charge Successful", "The charge has been successfully added to the datastore.");
		dialogBox.displayDialogBox();
		panelController.clearAllTextBoxes();
	}
	

}
