package blazon.shared.shield.charges;

import blazon.shared.shield.tinctures.Tincture;

public interface Charge {
	public boolean hasSource();
	public boolean setSource(String source);
	public String getSource();
	public String getName();
	public Tincture getTincture();
	public String getTextDescription();
}
