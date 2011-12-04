package blazon.client.chargeadding;

import java.util.Map;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("addCharge")
public interface ChargeAddingService extends RemoteService {
	void addChargeToDatastore(String chargeName, String attitude,
			String attitudeModifier, String tincture,
			Map<String, String> bodyPartTexts, String imageLocation);
}
