package blazon.shared.shield;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import blazon.shared.numberconversion.WordToNumberConverter;

public class ShieldDivision implements Serializable {

	private static final long serialVersionUID = 88067752583187630L;
	private Map<String,ShieldDivisionType> map;
	
	public ShieldDivision() {
		map = new HashMap<String, ShieldDivisionType>();
		ShieldDivisionType div = ShieldDivisionType.build("none", 1, 1);
		map.put(div.getName(), div);
		div = ShieldDivisionType.build("pale", 2, 2);
		map.put(div.getName(), div);
		div = ShieldDivisionType.build("fess", 2, 2);
		map.put(div.getName(), div);
		div = ShieldDivisionType.build("bend", 2, 2);
		map.put(div.getName(), div);
		div = ShieldDivisionType.build("bend sinister", 2, 2);
		map.put(div.getName(), div);
		div = ShieldDivisionType.build("cross", 4, 2);
		map.put(div.getName(), div);
		div = ShieldDivisionType.build("saltire", 4, 2);
		map.put(div.getName(), div);
		div = ShieldDivisionType.build("chevron", 2, 2);
		map.put(div.getName(), div);
		div = ShieldDivisionType.build("chevron reversed", 2, 2);
		map.put(div.getName(), div);
		div = ShieldDivisionType.build("pall", 3, 3);
		map.put(div.getName(), div);
		div = ShieldDivisionType.build("pall reversed", 3, 3);
		map.put(div.getName(), div);
		div = ShieldDivisionType.build("gyronny", 8, 2);
		map.put(div.getName(), div);
	}
	
	public ShieldDivisionType getDivisionType(String name) {
		name = name.toUpperCase().trim().replace(' ', '_');
		ShieldDivisionType div = map.get(name);
		if (div == null) {
			if (name.startsWith("GYRONNY_OF_")) {
				String numSectionsString = name.replaceFirst("GYRONNY_OF_", "");
				WordToNumberConverter converter = new WordToNumberConverter();
				int numSections;
				try {
					numSections = converter.convert(numSectionsString);
					div = ShieldDivisionType.build(name, numSections, 2);
					map.put(name, div);
				} catch (Exception e) {
					return null;
				}
			}
		}
		return div;
	}
	
	 public static class ShieldDivisionType implements Serializable {

		private static final long serialVersionUID = 3245344480706458315L;
		private int numberOfSections;
		private int numberOfAllowableTinctures;
		private String name;

		private static ShieldDivisionType build(final String name, final int numberOfSections,
				final int numberOfAllowableTinctures) {
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
			StringBuilder sb = new StringBuilder("ShieldDivisionType:name=");
			sb.append(name).append(":numberOfSections=").append(numberOfSections);
			sb.append(":numberOfAllowableTinctures=").append(
					numberOfAllowableTinctures);
			return sb.toString();
		}
	}
}