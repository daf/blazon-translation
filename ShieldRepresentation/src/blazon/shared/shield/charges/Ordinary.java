package blazon.shared.shield.charges;

import java.util.List;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

import blazon.shared.shield.diagnostic.ShieldDiagnostic;
import blazon.shared.shield.diagnostic.ShieldDiagnostic.LogLevel;
import blazon.shared.shield.tinctures.Tincture;

public class Ordinary implements Serializable {

	private static final long serialVersionUID = -4970206075746766696L;
	public static final String CROSS = "CROSS";
	public static final String PALE = "PALE";
	public static final String FESS = "FESS";
	public static final String BEND = "BEND";
	public static final String BEND_SINISTER = "BEND_SINISTER";
	public static final String SALTIRE = "SALTIRE";
	public static final String CHIEF = "CHIEF";
	public static final String BASE = "BASE";
	public static final String CHEVRON = "CHEVRON";
	public static final String CHEVRON_REVERSED = "CHEVRON_REVERSED";
	private static final String NONE = "NONE";
	Collection<String> setOfValidNames;
	
	public Ordinary() {
		setOfValidNames = new HashSet<String>();
		setOfValidNames.add(CROSS);
		setOfValidNames.add(PALE);
		setOfValidNames.add(FESS);
		setOfValidNames.add(BEND);
		setOfValidNames.add(BEND_SINISTER);
		setOfValidNames.add(SALTIRE);
		setOfValidNames.add(CHIEF);
		setOfValidNames.add(BASE);
		setOfValidNames.add(CHEVRON);
		setOfValidNames.add(CHEVRON_REVERSED);
	}
	
	public OrdinaryType getOrdinaryType(String name, Tincture t, List<ShieldDiagnostic> errorsList) {
		if (name == null || name.trim().isEmpty()) {
			throw new IllegalArgumentException("Can not get OrdinaryType with null or empty name");
		}
		if (t == null) {
			throw new IllegalArgumentException("Can not get OrdinaryType with null tincture");
		}
		if (errorsList == null) {
			errorsList = new ArrayList<ShieldDiagnostic>();
		}
		
		name = name.toUpperCase().trim().replace(' ', '_');
		if (setOfValidNames.contains(name)) {
			return OrdinaryType.build(name, t);
		} else {
			errorsList.add(ShieldDiagnostic.build(LogLevel.WARN, "Unknown Ordinary '" + name + "'. No ordinary used."));
			return OrdinaryType.build(NONE, null);
		}
	}
	
	public static class OrdinaryType implements Serializable {
		private Tincture tincture;
		private String name;
		private static final long serialVersionUID = 8036539477329506075L;
		
		private OrdinaryType() {}
		
		private static OrdinaryType build(String name, Tincture t) {
			OrdinaryType o = new OrdinaryType();
			o.tincture = t;
			o.name = name;
			return o;
		}
		
		public String getName() {
			return name;
		}
		
		public Tincture getTincture() {
			return tincture;
		}
		
		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder("OrdinaryType{tincture=");
			sb.append(tincture).append(":name=").append(name).append("}");
			return sb.toString();
		}
		
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (!(obj instanceof OrdinaryType))
				return false;
			OrdinaryType other = (OrdinaryType)obj;
			boolean nameMatch = name == other.name || name.equals(other.name);
			boolean tinctureMatch = tincture == other.tincture || tincture.equals(other.tincture);
			return nameMatch && tinctureMatch;
		}
		
		@Override
		public int hashCode() {
			int result = 17;
			result = 31 * result + (name == null ? 0 : name.hashCode());
			result = 31 * result + (tincture == null ? 0 : tincture.hashCode());
			return result;
		}
	}
}
