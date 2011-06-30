package blazon.client;

import blazon.shared.shield.Shield;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("draw")
public interface ShieldDrawingService extends RemoteService {
	Shield drawShield(String blazon) throws IllegalArgumentException;
}
