package blazon.shared.shield.tinctures;

public class Fur extends TinctureImpl {

	private static final long serialVersionUID = -7358652991886352207L;
	public static final String VAIR = "vair";
	public static final String POTENT = "potent";
	public static final String ERMINE = "ermine";
	public static final String ERMIN = "ermin";
	public static final String PEAN = "pean";
	private String furType;

	public static Fur build(String name, String colour1, String colour2) {
        Fur f = new Fur();
        f.name = name;
        f.colour1 = colour1;
        f.colour2 = colour2;
        if (name.contains(ERMIN) || name.equals(PEAN)) {
        	f.furType = ERMINE;
        } else if (name.contains(POTENT)) {
        	f.furType = POTENT;
        } else if (name.contains(VAIR)) {
        	f.furType = VAIR;
        }
        return f;
    }

    public String getPatternReference() {
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
