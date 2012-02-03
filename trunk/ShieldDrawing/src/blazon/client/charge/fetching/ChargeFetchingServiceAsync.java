package blazon.client.charge.fetching;

import blazon.shared.shield.Shield;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface ChargeFetchingServiceAsync {
	void fetchImagesForCharges(Shield shield, AsyncCallback<Shield> callback);
}
