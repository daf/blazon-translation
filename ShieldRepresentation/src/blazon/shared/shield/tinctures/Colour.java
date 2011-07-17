package blazon.shared.shield.tinctures;

public class Colour extends AbstractTincture {

	private static final long serialVersionUID = 6929245090350777329L;
	private String colour;

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

	@Override
	public String getFillText() {
		return colour;
	}

	@Override
	public String getName() {
		return name;
	}

}
