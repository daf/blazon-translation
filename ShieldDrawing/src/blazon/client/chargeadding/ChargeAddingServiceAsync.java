package blazon.client.chargeadding;

import java.util.Map;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface ChargeAddingServiceAsync {

	void addChargeToDatastore(String chargeName, String attitude,
			String attitudeModifier, String tincture,
			Map<String, String> bodyPartTexts, String imageLocation,
			AsyncCallback<Void> callback);

	

}
