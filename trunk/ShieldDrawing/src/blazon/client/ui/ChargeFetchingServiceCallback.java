package blazon.client.ui;

import blazon.client.ui.widget.DialogBoxDisplayer;
import blazon.shared.charge.fetching.NoImageForAdvancedChargeException;
import blazon.shared.shield.Shield;

import com.google.gwt.user.client.rpc.AsyncCallback;

public class ChargeFetchingServiceCallback implements AsyncCallback<Shield> {

	private final DiagnosticDisplayer diagnosticDisplayer = DiagnosticDisplayer.getInstance();
	private SVGPanelController svgPanelController;
	
	public ChargeFetchingServiceCallback(SVGPanelController svgPanelController) {
		this.svgPanelController = svgPanelController;
	}

	@Override
	public void onFailure(Throwable caught) {
		try { throw caught; } // don't need to check instance of
		catch (NoImageForAdvancedChargeException e) {
			String message = "The application was unable to find an image for one of your specified charges.\nCharge: ";
			message += e.getMissingImageInformation();
			message += "\nYou may want to refine your search or add an image to the database below.";
			DialogBoxDisplayer dialogBox = new DialogBoxDisplayer("No image found for charge", message);
			dialogBox.displayDialogBox();
		}
		catch (Exception e) {
			//TODO what types of exception when multiple images
		} catch (Throwable e) {
			diagnosticDisplayer.displayThrowable(caught);
		}
	}

	@Override
	public void onSuccess(Shield result) {
    	svgPanelController.displayShield(result);
    	diagnosticDisplayer.displayDiagnostics(result.getShieldDiagnostics());
	}

}
