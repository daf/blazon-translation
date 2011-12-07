package blazon.server.chargeadding;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import com.google.appengine.api.datastore.Blob;

public class ImageToBlobConverter {

	public Blob getImageDataFromUrlLocation(String imageLocation) {
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
