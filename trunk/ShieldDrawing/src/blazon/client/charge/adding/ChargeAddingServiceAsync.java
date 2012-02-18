package blazon.client.charge.adding;

import java.util.SortedSet;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface ChargeAddingServiceAsync {

	void addChargeToDatastore(String charge, String attitude, String attMod,
			String tincture, String imageLocation,
			SortedSet<String> bodyPartsSet, AsyncCallback<Void> callback);

	

}
