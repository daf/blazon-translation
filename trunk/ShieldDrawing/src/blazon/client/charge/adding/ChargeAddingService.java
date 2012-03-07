package blazon.client.charge.adding;

import java.util.SortedSet;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("addCharge")
public interface ChargeAddingService extends RemoteService {

	void addChargeToDatastore(String charge, String attitude, String attMod,
			String tincture, String imageLocation,
			SortedSet<String> bodyPartsSet) throws IllegalArgumentException;
}
