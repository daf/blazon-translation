package blazon.shared.shield;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

import blazon.shared.shield.ShieldDivision.ShieldDivisionType;
import blazon.shared.shield.diagnostic.ShieldDiagnostic;
import blazon.shared.shield.tinctures.Tincture;
import blazon.shared.shield.tinctures.TinctureType;
import blazon.shared.shield.tinctures.Tinctures;

public class FieldImpl implements Serializable, Field {

	private static final long serialVersionUID = -1398608222570349005L;
	protected Tinctures tinctures = null;
	protected ShieldDivisionType division;

	protected FieldImpl() {}
	
	public static Field buildUndividedShieldLayer(Tinctures t) {
		ShieldDivision divisions = new ShieldDivision();
		return buildDividedShieldLayer(t, divisions.getDivisionType(ShieldDivision.NONE, new ArrayList<ShieldDiagnostic>()));
	}

	public static Field buildDividedShieldLayer(Tinctures t, ShieldDivisionType division) {
		if (t == null || division == null) {
			throw new IllegalArgumentException("Can not build a ShieldLayer with null tinctures or division");
		}
		FieldImpl shieldLayer = new FieldImpl();
		shieldLayer.tinctures = t;
		shieldLayer.division = division;
		return shieldLayer;
	}

	public Tinctures getTinctures() {
		return tinctures;
	}

	public ShieldDivisionType getShieldDivision() {
		return division;
	}

	public TinctureType getTinctureTypeOfLayer() {
		Iterator<Tincture> it = tinctures.getTincturesOnLayer().iterator();
		if (!it.hasNext()) {
			return TinctureType.OTHER;
		}
		TinctureType first = it.next().getTinctureType();
		if (first == TinctureType.OTHER) {
			return first;
		}
		while (it.hasNext()) {
			TinctureType tt = it.next().getTinctureType();
			if (tt != first) {
				return TinctureType.OTHER;
			}
		}
		return first;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("ShieldLayer{tinctures=");
		sb.append(tinctures).append(":division=").append(division).append("}");
		return sb.toString();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof FieldImpl)) {
			return false;
		}
		FieldImpl other = (FieldImpl)obj;
		boolean tincturesMatch = tinctures.equals(other.tinctures);
		boolean divisionMatch = division.equals(other.division);
		return tincturesMatch && divisionMatch;
	}
	
	@Override
	public int hashCode() {
		int result = 17;
		result = 31 * result + tinctures.hashCode();
		result = 31 * result + division.hashCode();
		return result;
	}
}
