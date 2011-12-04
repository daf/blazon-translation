package blazon.server.chargeadding;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import javax.persistence.EntityManager;

import com.google.appengine.api.datastore.Blob;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import blazon.client.chargeadding.ChargeAddingService;

public class ChargeAddingServiceImpl extends RemoteServiceServlet implements ChargeAddingService {

	private static final long serialVersionUID = -8716005130771464895L;

	@Override
	public void addChargeToDatastore(String chargeName, String attitude, String attitudeModifier, String tincture, Map<String, String> bodyPartTexts, String imageLocation) {
		Blob imageData = getImageDataFromUrlLocation(imageLocation);
		Charge charge = new Charge(chargeName, attitude, attitudeModifier, tincture, bodyPartTexts, imageData, imageLocation);
		EntityManager entityManager = EMF.getInstance().createEntityManager();
		entityManager.persist(charge);
		entityManager.close();
	}

	private Blob getImageDataFromUrlLocation(String imageLocation) {
		try {
			URL url = new URL(imageLocation);
			InputStream is = url.openStream();
			ByteArrayOutputStream output = new ByteArrayOutputStream();
			byte[] buffer = new byte[1024];
			int n = 0;
			while (-1 != (n = is.read(buffer))) {
				output.write(buffer, 0, n);
			}
			is.close();
			Blob imageData = new Blob(output.toByteArray());
			output.close();
			return imageData;

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
		
	}
}
