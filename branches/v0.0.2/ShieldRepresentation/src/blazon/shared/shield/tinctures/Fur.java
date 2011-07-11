package blazon.shared.shield.tinctures;

public class Fur extends AbstractTincture {

	private static final long serialVersionUID = -7358652991886352207L;
	public static final String VAIR = "vair";
	public static final String POTENT = "potent";
	public static final String ERMINE = "ermine";
	public static final String ERMIN = "ermin";
	public static final String PEAN = "pean";
	private String furType;
	protected String colour1;
	protected String colour2;

	static Tincture build(String name, String colour1, String colour2) {
		if (name == null || name.isEmpty() || colour1 == null || colour1.isEmpty()
				|| colour2 == null || colour2.isEmpty()) {
			throw new IllegalArgumentException("Fur can not be built with null or empty argument");
		}
		Fur f = new Fur();
		if (name.contains(ERMIN) || name.equals(PEAN)) {
        	f.furType = ERMINE;
        } else if (name.contains(POTENT)) {
        	f.furType = POTENT;
        } else if (name.contains(VAIR)) {
        	f.furType = VAIR;
        } else {
        	throw new IllegalArgumentException("Unrecognised fur name: '" + name + "'");
        }
		f.name = name;
        f.colour1 = colour1;
        f.colour2 = colour2;
        
        return f;
    }

    public String getFillText() {
        return "url(#" + name + ")";
    }

	@Override
	public String getName() {
		return name;
	}
	
	public String getColour1() {
		return colour1;
	}
	
	public String getColour2() {
		return colour2;
	}

	public String getFurType() {
		return furType;
	}
}
