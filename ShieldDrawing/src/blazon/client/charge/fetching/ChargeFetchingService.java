package blazon.client.charge.fetching;

import blazon.shared.charge.fetching.NoImageForAdvancedChargeException;
import blazon.shared.shield.Shield;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("fetchCharge")
public interface ChargeFetchingService extends RemoteService {
	Shield fetchImagesForCharges(Shield shield) throws NoImageForAdvancedChargeException;
}
