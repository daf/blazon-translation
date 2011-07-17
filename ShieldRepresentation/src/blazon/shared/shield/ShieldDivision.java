package blazon.shared.shield;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import blazon.shared.numberconversion.WordToNumberConverter;

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

	public ShieldDivisionType getDivisionType(String name) {
		if (name == null || name.trim().isEmpty()) {
			throw new IllegalArgumentException(
					"Can not get ShieldDivisionType with null or empty name");
		}
		name = transformName(name);
		final String gyronnyOf = "GYRONNY_OF_";
		ShieldDivisionType div = map.get(name);
		if (div == null) {
			if (name.startsWith(gyronnyOf)) {
				String numSectionsString = name.replaceFirst(gyronnyOf, "");
				WordToNumberConverter converter = new WordToNumberConverter();
				int numSections;
				try {
					numSections = converter.convert(numSectionsString);
					if (numSections < 4) {
						System.err
								.println("Can not have gyronny of less than 6. Using division NONE");
						return map.get(NONE);
					}
					if (numSections == 4) {
						System.err
								.println("Can not have gyronny of less than 6. Using division CROSS");
						return map.get(CROSS);
					}
					if (numSections % 2 == 1) {
						numSections++;
						System.err
								.println("Can not have gyronny of an odd number. Using division GYRONNY_OF_"
										+ numSections);
					}

					div = ShieldDivisionType.build(gyronnyOf + numSections,
							numSections, 2);
					map.put(name, div);
				} catch (Exception e) {
					System.err
							.println("Caught: " + e + "\nUsing division NONE");
					return map.get(NONE);
				}
			} else {
				System.err.println("Do not recognise division name '" + name
						+ "'\nUsing division NONE");
				return map.get(NONE);
			}
		}
		return div;
	}

	private String transformName(String name) {
		name = name.toUpperCase().trim().replace(' ', '_');
		return name;
	}

	public static class ShieldDivisionType implements Serializable {

		private static final long serialVersionUID = 3245344480706458315L;
		private int numberOfSections;
		private int numberOfAllowableTinctures;
		private String name;

		private static ShieldDivisionType build(final String name,
				final int numberOfSections, final int numberOfAllowableTinctures) {
			if (name == null || name.trim().isEmpty()) {
				throw new IllegalArgumentException(
						"Can not construct ShieldDivision with null or empty name");
			}
			if (numberOfSections < 1) {
				throw new IllegalArgumentException(
						"Can not construct ShieldDivision with numberOfSections < 1");
			}
			if (numberOfAllowableTinctures > numberOfAllowableTinctures) {
				throw new IllegalArgumentException(
						"Can not construct ShieldDivision with numberOfAllowableTinctures > numberOfSections");
			}
			if (numberOfAllowableTinctures < 2) {
				if (numberOfAllowableTinctures != 1 || numberOfSections != 1) {
					throw new IllegalArgumentException(
							"Can not construct ShieldDivision enum value with number of tinctures < 2");
				}
			}
			ShieldDivisionType divType = new ShieldDivisionType();
			divType.numberOfSections = numberOfSections;
			divType.numberOfAllowableTinctures = numberOfAllowableTinctures;
			divType.name = name.toUpperCase().trim().replace(' ', '_');
			return divType;
		}

		public int getNumberOfSections() {
			return numberOfSections;
		}

		public int getNumberOfAllowableTinctures() {
			return numberOfAllowableTinctures;
		}

		public String getName() {
			return name;
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder("ShieldDivisionType{name=");
			sb.append(name).append(":numberOfSections=")
					.append(numberOfSections);
			sb.append(":numberOfAllowableTinctures=");
			sb.append(numberOfAllowableTinctures).append("}");
			return sb.toString();
		}
	}

}