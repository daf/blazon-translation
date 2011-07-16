package blazon.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import blazon.shared.shield.Shield;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface ShieldDrawingServiceAsync {
	void createShieldRepresentation(String input, AsyncCallback<Shield> callback)
			throws IllegalArgumentException;
}
