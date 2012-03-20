package blazon.shared.shield.tinctures;

/**
 * A representation of a Metal on the shield.
 * @author Luke Torjussen
 * @see Tincture, AbstractTincture, Colour, Fur
 */
public class Metal extends AbstractTincture {

	private static final long serialVersionUID = 6266304772402209638L;
	private String colour;

	/**
	 * A private constructor to ensure that Metal can only be built
	 * via the build method.
	 */
	private Metal() {}
	
	/**
	 * A static factory method used to build an instance of a Metal.
	 * @param name a string used to identify the metal e.g. "Or".
	 * @param colour a string used to describe the metal e.g. "yellow".
	 * @return a Metal object with name and colour set to the given values.
	 */
	static Tincture build(String name, String colour) {
		if (name == null || name.isEmpty() || colour == null
				|| colour.isEmpty()) {
			throw new IllegalArgumentException(
					"Metal can not be built with null or empty argument");
		}

		Metal m = new Metal();
		m.name = name;
		m.colour = colour;
		return m;
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
		if (!(obj instanceof Metal)) {
			return false;
		}
		Metal other = (Metal)obj;
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
		return TinctureType.METAL;
	}
}
