package blazon.shared.shield;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

import blazon.shared.shield.ShieldDivision.ShieldDivisionType;
import blazon.shared.shield.diagnostic.ShieldDiagnostic;
import blazon.shared.shield.tinctures.Tincture;
import blazon.shared.shield.tinctures.TinctureType;
import blazon.shared.shield.tinctures.Tinctures;

public class Field implements Serializable, ShieldLayer {

	private static final long serialVersionUID = -1398608222570349005L;
	protected Tinctures tinctures = null;
	protected Field nextLayer = null;
	protected ShieldDivisionType division;

	protected Field() {}
	
	public static Field buildUndividedShieldLayer(Tinctures t) {
		ShieldDivision divisions = new ShieldDivision();
		return buildDividedShieldLayer(t, divisions.getDivisionType(ShieldDivision.NONE, new ArrayList<ShieldDiagnostic>()));
	}

	public static Field buildDividedShieldLayer(Tinctures t, ShieldDivisionType division) {
		if (t == null) {
			throw new IllegalArgumentException("Can not build a ShieldLayer with null tinctures");
		}
		Field shieldLayer = new Field();
		shieldLayer.tinctures = t;
		shieldLayer.division = division;
		return shieldLayer;
	}

	@Override
	public Tinctures getTinctures() {
		return tinctures;
	}

	@Override
	public ShieldDivisionType getShieldDivision() {
		return division;
	}

	@Override
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
		sb.append(tinctures).append(":division=").append(division);
		sb.append(":nextLayer=").append(nextLayer).append("}");
		return sb.toString();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Field)) {
			return false;
		}
		Field other = (Field)obj;
		boolean tincturesMatch = tinctures == other.tinctures || tinctures.equals(other.tinctures);
		boolean divisionMatch = division == other.division || division.equals(other.division);
		boolean nextLayerMatch = nextLayer == other.nextLayer || nextLayer.equals(other.nextLayer);
		return tincturesMatch && divisionMatch && nextLayerMatch;
	}
	
	@Override
	public int hashCode() {
		int result = 17;
		result = 31 * result + (tinctures == null ? 0 : tinctures.hashCode());
		result = 31 * result + (division == null ? 0 : division.hashCode());
		result = 31 * result + (nextLayer == null ? 0 : nextLayer.hashCode());
		return result;
	}
}
