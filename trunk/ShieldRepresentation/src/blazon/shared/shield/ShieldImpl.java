package blazon.shared.shield;

import java.util.ArrayList;
import java.util.List;

import blazon.shared.shield.charges.Charge;

/**
 * A class representing the entire shield to be drawn.
 * @author Luke Torjussen
 *
 */
public class ShieldImpl extends AbstractShield {

	private static final long serialVersionUID = 4665249893045885094L;
	private Field field;
	private List<Charge> charges;

	private ShieldImpl() {}
	
	/**
	 * Build a Shield setting the field to the given parameter.
	 * @param field the ShieldLayer that will be the field of the shield.
	 * @return
	 */
	public static Shield build(Field field, String blazon) {
		if (field == null) {
			throw new IllegalArgumentException(
					"Can not create shield with null base shield layer");
		}
		ShieldImpl shield = new ShieldImpl();
		shield.field = field;
		shield.blazon = blazon;
		return shield;
	}

	/**
	 * Get the bottom layer from the shield.
	 * @return a ShieldLayer object representing the field.
	 */
	@Override
	public Field getField() {
		return field;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("ShieldImpl{field=").append(field);
		return sb.append("}").toString();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof ShieldImpl)) {
			return false;
		}
		ShieldImpl other = (ShieldImpl)obj;
		return field.equals(other.field);
	}
	
	@Override
	public int hashCode() {
		int result = 17;
		result = 31 * result + field.hashCode();
		return result;
	}

	@Override
	public void addCharges(List<Charge> charges) {
		if (charges == null) { return; }
		if (this.charges == null || this.charges.isEmpty()) {
			this.charges = charges;
		} else {
			this.charges.addAll(charges);
		}
	}

	@Override
	public List<Charge> getCharges() {
		if (charges == null) {
			charges = new ArrayList<Charge>();
		}
		return charges;
	}
}
