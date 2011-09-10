package blazon.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

import blazon.shared.shield.Shield;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface BlazonParsingServiceAsync {
	void createShieldRepresentation(String blazon,
			AsyncCallback<Shield> callback);
}
