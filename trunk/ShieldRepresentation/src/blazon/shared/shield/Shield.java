package blazon.shared.shield;

import java.io.Serializable;

/**
 * A class representing the entire shield to be drawn.
 * @author Luke Torjussen
 *
 */
public class Shield implements Serializable {

	private static final long serialVersionUID = 4665249893045885094L;
	private ShieldLayer field;

	private Shield() {}
	//TODO add diagnostics
	
	/**
	 * Build a Shield setting the field to the given parameter.
	 * @param field the ShieldLayer that will be the field of the shield.
	 * @return
	 */
	public static Shield build(ShieldLayer field) {
		if (field == null) {
			throw new IllegalArgumentException(
					"Can not create shield with null base shield layer");
		}
		Shield shield = new Shield();
		shield.field = field;
		return shield;
	}

	
	/**
	 * Get the bottom layer from the shield.
	 * @return a ShieldLayer object representing the field.
	 */
	public ShieldLayer getField() {
		return field;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Shield{field=").append(field);
		return sb.append("}").toString();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Shield)) {
			return false;
		}
		Shield other = (Shield)obj;
		return field.equals(other.field);
	}
	
	@Override
	public int hashCode() {
		int result = 17;
		result = 31 * result + (field == null ? 0 : field.hashCode());
		return result;
	}

}
