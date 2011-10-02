package blazon.shared.shield.charges;

import java.io.Serializable;

import blazon.shared.shield.tinctures.Tincture;

public class Ordinary implements Serializable {

	private static final long serialVersionUID = -4970206075746766696L;
	public static final String CROSS = "CROSS";
	public static final String PALE = "PALE";
	public static final String FESS = "FESS";
	public static final String BEND = "BEND";
	public static final String BEND_SINISTER = "BEND_SINISTER";
	public static final String SALTIRE = "SALTIRE";
	public static final String CHIEF = "CHIEF";
	public static final String BASE = "BASE";
	public static final String CHEVRON = "CHEVRON";
	public static final String CHEVRON_REVERSED = "CHEVRON_REVERSED";
	Tincture tincture;
	String name;
	
	private Ordinary() {}
	
	public static Ordinary build(String name, Tincture t) {
		Ordinary o = new Ordinary();
		o.tincture = t;
		o.name = name.toUpperCase();
		return o;
	}
	
	public String getName() {
		return name;
	}
	
	public Tincture getTincture() {
		return tincture;
	}
	
	@Override
	public String toString() {
		return "Tincture=" + tincture + ":Name=" + name;
	}

}
