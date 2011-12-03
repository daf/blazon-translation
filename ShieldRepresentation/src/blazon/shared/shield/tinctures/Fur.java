package blazon.shared.shield.tinctures;

/**
 * A representation of a Fur on the shield.
 * @author Luke Torjussen
 * @see Tincture, AbstractTincture, Colour, Metal
 */
public class Fur extends AbstractTincture {

	private static final long serialVersionUID = -7358652991886352207L;
	private static final String VAIR = "vair";
	private static final String POTENT = "potent";
	private static final String ERMIN = "ermin";
	private static final String PEAN = "pean";
	private FurType furType;
	private String colour1;
	private String colour2;

	/**
	 * An enum representing the possible types of Furs
	 * to put on the shield.
	 * @author Luke Torjussen
	 *
	 */
	public enum FurType {
		/**
		 * This is used for variations of Vair.
		 */
		VAIR,
		/**
		 * This is used for variations of Potent.
		 */
		POTENT,
		/**
		 * This is used for variations of Ermine.
		 */
		ERMINE
	}
	
	/**
	 * A private constructor to ensure that Fur can only be built
	 * via the build method.
	 */
	private Fur() {}
	
	/**
	 * A static factory method used to build an instance of a Fur.
	 * @param name a string used to identify the fur e.g. "vair".
	 * @param colour1 a string used to describe the first colour 
	 * on the fur e.g. "blue".
	 * @param colour2 a string used to describe the second colour
	 * on the fur e.g. "white".
	 * @return a Fur object with name and colours set to the given values.
	 */
	static Tincture build(String name, String colour1, String colour2) {
		if (name == null || name.isEmpty() || colour1 == null
				|| colour1.isEmpty() || colour2 == null || colour2.isEmpty()) {
			throw new IllegalArgumentException(
					"Fur can not be built with null or empty argument");
		}
		Fur f = new Fur();
		if (name.contains(ERMIN) || name.equals(PEAN)) {
			f.furType = FurType.ERMINE;
		} else if (name.contains(POTENT)) {
			f.furType = FurType.POTENT;
		} else if (name.contains(VAIR)) {
			f.furType = FurType.VAIR;
		} else {
			throw new IllegalArgumentException("Unrecognised fur name: '"
					+ name + "'");
		}
		f.name = name;
		f.colour1 = colour1;
		f.colour2 = colour2;

		return f;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getFillText() {
		return "url(#" + name + ")";
	}

	/**
	 * {@inheritDoc}
	 */
	public String getName() {
		return name;
	}

	/**
	 * A Fur is made up of two colours;
	 * This method gets the representation of the first.
	 * @return a string representing the first colour
	 * the Fur is made up of.
	 */
	public String getColour1() {
		return colour1;
	}

	/**
	 * A Fur is made up of two colours;
	 * This method gets the representation of the second.
	 * @return a string representing the second colour
	 * the Fur is made up of.
	 */
	public String getColour2() {
		return colour2;
	}

	/**
	 * Get the fur type for this fur object.
	 * @return a FurType value representing 
	 * the fur type for this fur object.
	 * @see FurType
	 */
	public FurType getFurType() {
		return furType;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Fur)) {
			return false;
		}
		Fur other = (Fur)obj;
		return (name == other.name || name.equals(other.name))
			&& (colour1 == other.colour1 || colour1.equals(other.colour1))
			&& (colour2 == other.colour2 || colour2.equals(other.colour2))
			&& (furType == other.furType);
	}
	
	@Override
	public int hashCode() {
		int result = 17;
		result = 31 * result + name.hashCode();
		result = 31 * result + colour1.hashCode();
		result = 31 * result + colour2.hashCode();
		result = 31 * result + furType.hashCode();
		return result;
	}

	@Override
	public TinctureType getTinctureType() {
		return TinctureType.OTHER;
	}
}
