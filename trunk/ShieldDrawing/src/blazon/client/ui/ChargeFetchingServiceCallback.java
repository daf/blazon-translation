package blazon.client.ui;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

import blazon.client.ui.widget.DialogBoxDisplayer;
import blazon.shared.charge.fetching.NoImageForAdvancedChargeException;
import blazon.shared.shield.Shield;
import blazon.shared.shield.diagnostic.ShieldDiagnostic;
import blazon.shared.shield.diagnostic.ShieldDiagnostic.LogLevel;

public class ChargeFetchingServiceCallback implements AsyncCallback<Shield> {

	private SVGPanelController svgPanelController;
	private final ProgressSpinner spinner;
	
	public ChargeFetchingServiceCallback(SVGPanelController svgPanelController, ProgressSpinner spinner) {
		this.svgPanelController = svgPanelController;
		this.spinner = spinner;
	}

	@Override
	public void onFailure(Throwable caught) {
		if (caught instanceof NoImageForAdvancedChargeException) {
			String message = "The application was unable to find an image for one of your specified charges.<br />";
			message += "You may want to refine your search or add an image to the database below.<br />";
			message += "Charge: '" + ((NoImageForAdvancedChargeException)caught).getMissingImageInformation() + "'.";
			DialogBoxDisplayer dialogBox = new DialogBoxDisplayer("Application Error", message);
			dialogBox.displayDialogBox();
		} else {
			DialogBoxDisplayer dialogBox = new DialogBoxDisplayer("Application Error", "An exception was thrown whilst fetching images for the charges.", caught);
			dialogBox.displayDialogBox();
		}
	}

	@Override
	public void onSuccess(final Shield result) {
		svgPanelController.displayShield(result);
		spinner.stop();
    	List<ShieldDiagnostic> diags = result.getShieldDiagnostics();
    	if (diags != null && !diags.isEmpty()) {
    		DialogBoxDisplayer dialogBox;
    		if (diags.size() == 1) {
    			ShieldDiagnostic diag = diags.get(0);
    			String header = "Blazon Warning";
    			if (diag.getSeverity() == LogLevel.ERROR) {
    				header = "Blazon Error";
    			}
    			String message = "There was a problem when parsing your Blazon sentence.<br />" + diag.getMessage();
            	dialogBox = new DialogBoxDisplayer(header, message);
    		} else {
    			dialogBox = new DialogBoxDisplayer("Blazon Error", "There were multiple problems when parsing your Blazon sentence.", diags);
    		}
    		dialogBox.displayDialogBox();
    	}
	}
}
