package blazon.shared.shield;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import blazon.shared.numberconversion.WordToNumberConverter;
import blazon.shared.shield.tinctures.Colour;

/**
 * A class that represents the ways a shield can be divided.
 * @author Luke Torjussen
 *
 */
public class ShieldDivision implements Serializable {

	public static final String GYRONNY = "GYRONNY";
	public static final String PALL_REVERSED = "PALL_REVERSED";
	public static final String PALL = "PALL";
	public static final String CHEVRON_REVERSED = "CHEVRON_REVERSED";
	public static final String CHEVRON = "CHEVRON";
	public static final String SALTIRE = "SALTIRE";
	public static final String CROSS = "CROSS";
	public static final String BEND_SINISTER = "BEND_SINISTER";
	public static final String BEND = "BEND";
	public static final String FESS = "FESS";
	public static final String PALE = "PALE";
	public static final String NONE = "NONE";
	private static final long serialVersionUID = 88067752583187630L;
	private Map<String, ShieldDivisionType> map;

	/**
	 * Construct a ShieldDivision object and fill
	 * a map of known shield division types.
	 */
	public ShieldDivision() {
		map = new HashMap<String, ShieldDivisionType>();
		ShieldDivisionType div = ShieldDivisionType.build(NONE, 1, 1);
		map.put(div.getName(), div);
		div = ShieldDivisionType.build(PALE, 2, 2);
		map.put(div.getName(), div);
		div = ShieldDivisionType.build(FESS, 2, 2);
		map.put(div.getName(), div);
		div = ShieldDivisionType.build(BEND, 2, 2);
		map.put(div.getName(), div);
		div = ShieldDivisionType.build(BEND_SINISTER, 2, 2);
		map.put(div.getName(), div);
		div = ShieldDivisionType.build(CROSS, 4, 2);
		map.put(div.getName(), div);
		div = ShieldDivisionType.build(SALTIRE, 4, 2);
		map.put(div.getName(), div);
		div = ShieldDivisionType.build(CHEVRON, 2, 2);
		map.put(div.getName(), div);
		div = ShieldDivisionType.build(CHEVRON_REVERSED, 2, 2);
		map.put(div.getName(), div);
		div = ShieldDivisionType.build(PALL, 3, 3);
		map.put(div.getName(), div);
		div = ShieldDivisionType.build(PALL_REVERSED, 3, 3);
		map.put(div.getName(), div);
		div = ShieldDivisionType.build(GYRONNY, 8, 2);
		map.put(div.getName(), div);
	}

	/**
	 * get a ShieldDivisionType object representing the 
	 * type of shield division of the given name.
	 * @param name the name of the type of shield division
	 * you want to get.
	 * @return a ShieldDivisionType of the given name.
	 * If you specify an unknown name for a division type
	 * then this method will return a ShieldDivisionType
	 * representing an undivided shield.
	 * 
	 * If you specify a name "GYRONNY_OF_X" where X is less 
	 * than 4, this method will return a ShieldDivisionType
	 * representing an undivided shield.
	 * If X = 4 then this method will return a ShieldDivisionType
	 * representing a shield divided "PER_CROSS".
	 * If X is odd then this method will return a ShieldDivisionType
	 * representing a shield divided "GYRONNY_OF_X+1"
	 */
	public ShieldDivisionType getDivisionType(String name) {
		if (name == null || name.trim().isEmpty()) {
			throw new IllegalArgumentException("Can not get ShieldDivisionType with null or empty name");
		}
		name = name.toUpperCase().trim().replace(' ', '_');;
		ShieldDivisionType div = map.get(name);
		if (div != null) {
			return div;
		}
		final String gyronnyOf = "GYRONNY_OF_";
		if (name.startsWith(gyronnyOf)) {
			try {
				WordToNumberConverter converter = new WordToNumberConverter();
				int numSections;
				String numSectionsString = name.replaceFirst(gyronnyOf, "");
				numSections = converter.convert(numSectionsString);
				if (numSections < 4) {
					System.err.println("Can't have gyronny of less than 6. Using division NONE");
					return map.get(NONE);
				} else if (numSections == 4) {
					System.err.println("Can't have gyronny of less than 6. Using division CROSS");
					return map.get(CROSS);
				}
				
				if (numSections % 2 != 0) {
					numSections++;
					System.err.println("Can't have gyronny of an odd number. Using division GYRONNY_OF_"
							+ numSections);
				}
				name = gyronnyOf + numSections;
				div = ShieldDivisionType.build(name, numSections, 2);
				map.put(name, div);
				return div;
			} catch (Exception e) {
				System.err.println("Caught: " + e + "\nUsing division NONE");
			}
		} else {
			System.err.println("Do not recognise division name '" + name + "'\nUsing division NONE");
		}
		return map.get(NONE);
	}

	/**
	 * A class to represent the way a shield is divided.
	 * @author Luke Torjussen
	 *
	 */
	public static class ShieldDivisionType implements Serializable {

		private static final long serialVersionUID = 3245344480706458315L;
		private int numberOfSections;
		private int numberOfTinctures;
		private String name;

		/**
		 * Private constructor to ensure that ShieldDivisionType objects are
		 * created and populated via the build method.
		 */
		private ShieldDivisionType() {}
		
		/**
		 * Construct a ShildDivisionType of the given name, divided into the given
		 * number of sections that can be coloured using the given number of 
		 * allowable tinctures.
		 * @param name the name for the shield division type.
		 * @param numberOfSections the number of sections the shield should be divided
		 * into.
		 * @param numberOfTinctures the number of tinctures the shield can
		 * be coloured using.
		 * @return A ShieldDivisionType with name converted to uppercase and spaces 
		 * replaced by underscores.
		 */
		private static ShieldDivisionType build(final String name, final int numberOfSections, 
				final int numberOfTinctures) {
			if (name == null || name.trim().isEmpty()) {
				throw new IllegalArgumentException(
						"Can not construct ShieldDivision with null or empty name");
			}
			if (numberOfSections < 1) {
				throw new IllegalArgumentException(
						"Can not construct ShieldDivision with numberOfSections < 1");
			}
			if (numberOfTinctures > numberOfSections) {
				throw new IllegalArgumentException(
						"Can not construct ShieldDivision with numberOfTinctures > numberOfSections");
			}
			if (numberOfTinctures < 2) {
				if (numberOfTinctures != 1 || numberOfSections != 1) {
					throw new IllegalArgumentException(
							"Can not construct ShieldDivision enum value with number of tinctures < 2");
				}
			}
			ShieldDivisionType divType = new ShieldDivisionType();
			divType.numberOfSections = numberOfSections;
			divType.numberOfTinctures = numberOfTinctures;
			divType.name = name.toUpperCase().trim().replace(' ', '_');
			return divType;
		}

		/**
		 * Get the number of sections that this ShieldDivisionType 
		 * divides the shield into.
		 * @return the number of sections the shield should be divided into.
		 */
		public int getNumberOfSections() {
			return numberOfSections;
		}

		/**
		 * Get the number of tinctures that this type of shield division 
		 * can have. 
		 * @return the number of tinctures this type of shield 
		 * division can have.
		 */
		public int getNumberOfTinctures() {
			return numberOfTinctures;
		}

		/**
		 * Get the name of this type of shield division. 
		 * @return the name of this type of shield division.
		 * The String is upper case and has underscores to 
		 * separate words.
		 */
		public String getName() {
			return name;
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder("ShieldDivisionType{name=");
			sb.append(name).append(":numberOfSections=")
					.append(numberOfSections);
			sb.append(":numberOfTinctures=");
			sb.append(numberOfTinctures).append("}");
			return sb.toString();
		}
		
		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (!(obj instanceof ShieldDivisionType)) {
				return false;
			}
			ShieldDivisionType other = (ShieldDivisionType)obj;
			boolean nameMatch = name == other.name || name.equals(other.name);
			boolean numberOfSectionsMatch = numberOfSections == other.numberOfSections;
			boolean numberOfTincturesMatch = numberOfTinctures == other.numberOfTinctures;
			return nameMatch && numberOfSectionsMatch && numberOfTincturesMatch;
		}
		
		@Override
		public int hashCode() {
			int result = 17;
			result = 31 * result + (name == null ? 0 : name.hashCode());
			result = 31 * result + numberOfSections;
			result = 31 * result + numberOfTinctures;
			return result;
		}
	}

}