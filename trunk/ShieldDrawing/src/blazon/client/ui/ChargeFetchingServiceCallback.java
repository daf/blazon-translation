package blazon.client.ui;

import java.util.List;

import blazon.client.ui.widget.DialogBoxDisplayer;
import blazon.shared.charge.fetching.NoImageForAdvancedChargeException;
import blazon.shared.shield.Shield;
import blazon.shared.shield.diagnostic.ShieldDiagnostic;

import com.google.gwt.user.client.rpc.AsyncCallback;

public class ChargeFetchingServiceCallback implements AsyncCallback<Shield> {

	private SVGPanelController svgPanelController;
	
	public ChargeFetchingServiceCallback(SVGPanelController svgPanelController) {
		this.svgPanelController = svgPanelController;
	}

	@Override
	public void onFailure(Throwable caught) {
		if (caught instanceof NoImageForAdvancedChargeException) {
			String message = "The application was unable to find an image for one of your specified charges.\n";
			message += "You may want to refine your search or add an image to the database below.";
			DialogBoxDisplayer dialogBox = new DialogBoxDisplayer("No image found for charge", message, caught);
			dialogBox.displayDialogBox();
		} else {
			DialogBoxDisplayer dialogBox = new DialogBoxDisplayer("Error adding charges to shield", "An exception was thrown whilst fetching images for the charges.", caught);
			dialogBox.displayDialogBox();
		}
	}

	@Override
	public void onSuccess(Shield result) {
    	svgPanelController.displayShield(result);
    	List<ShieldDiagnostic> diags = result.getShieldDiagnostics();
    	if (diags != null && !diags.isEmpty()) {
        	DialogBoxDisplayer dialogBox = new DialogBoxDisplayer("Blazon Parsed with some warnings", "There were some problems when parsing your Blazon sentence.", diags);
    		dialogBox.displayDialogBox();
    	}
	}

}
