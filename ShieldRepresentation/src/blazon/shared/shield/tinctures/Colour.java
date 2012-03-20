package blazon.shared.shield.tinctures;

/**
 * A representation of a Colour on the shield.
 * @author Luke Torjussen
 * @see Tincture, AbstractTincture, Metal, Fur
 */
public class Colour extends AbstractTincture {

	private static final long serialVersionUID = 6929245090350777329L;
	private String colour;
	
	/**
	 * A private constructor to ensure that Colour can only be built
	 * via the build method.
	 */
	private Colour() {}
	
	/**
	 * A static factory method used to build an instance of a Colour.
	 * @param name a string used to identify the colour e.g. "Gules".
	 * @param colour a string used to describe the colour e.g. "red".
	 * @return a Colour object with name and colour set to the given values.
	 */
	static Tincture build(String name, String colour) {
		if (name == null || name.isEmpty() || colour == null
				|| colour.isEmpty()) {
			throw new IllegalArgumentException(
					"Colour can not be built with null or empty argument");
		}

		Colour c = new Colour();
		c.name = name;
		c.colour = colour;
		return c;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getFillText() {
		return colour;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public String getName() {
		return name;
	}

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Colour)) {
			return false;
		}
		Colour other = (Colour)obj;
		return name.equals(other.name) && colour.equals(other.colour);
	}
	
	@Override
	public int hashCode() {
		int result = 17;
		result = 31 * result + name.hashCode();
		result = 31 * result + colour.hashCode();
		return result;
	}

	@Override
	public TinctureType getTinctureType() {
		return TinctureType.COLOUR;
	}
}
