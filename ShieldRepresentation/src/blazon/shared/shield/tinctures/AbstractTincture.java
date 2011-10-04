package blazon.shared.shield.tinctures;

/**
 * An abstract representation of a Tincture on the shield.
 * @author Luke Torjussen
 * @see Tincture, Colour, Metal, Fur
 */
public abstract class AbstractTincture implements Tincture {
	
	private static final long serialVersionUID = -3533056694345483720L;

	protected String name;

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Tincture{name=");
		sb.append(name).append(":fillText=").append(getFillText());
		return sb.append("}").toString();
	}
}
