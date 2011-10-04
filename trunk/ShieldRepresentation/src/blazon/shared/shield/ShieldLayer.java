package blazon.shared.shield;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

import blazon.shared.shield.ShieldDivision.ShieldDivisionType;
import blazon.shared.shield.diagnostic.ShieldDiagnostic;
import blazon.shared.shield.tinctures.Tincture;
import blazon.shared.shield.tinctures.TinctureType;
import blazon.shared.shield.tinctures.Tinctures;

public class ShieldLayer implements Serializable {

	private static final long serialVersionUID = -1398608222570349005L;
	protected Tinctures tinctures = null;
	protected ShieldLayer nextLayer = null;
	protected ShieldDivisionType division;

	protected ShieldLayer() {}
	
	public static ShieldLayer buildUndividedShieldLayer(Tinctures t) {
		ShieldDivision divisions = new ShieldDivision();
		return buildDividedShieldLayer(t, divisions.getDivisionType(ShieldDivision.NONE, new ArrayList<ShieldDiagnostic>()));
	}

	public static ShieldLayer buildDividedShieldLayer(Tinctures t, ShieldDivisionType division) {
		if (t == null) {
			throw new IllegalArgumentException("Can not build a ShieldLayer with null tinctures");
		}
		ShieldLayer shieldLayer = new ShieldLayer();
		shieldLayer.tinctures = t;
		shieldLayer.division = division;
		return shieldLayer;
	}

	public void addNextLayer(ShieldLayer l) {
		if (nextLayer == null) {
			nextLayer = l;
		} else {
			nextLayer.addNextLayer(l);
		}
	}

	public ShieldLayer getNextLayer() {
		return nextLayer;
	}

	public Tinctures getTinctures() {
		return tinctures;
	}

	public ShieldDivisionType getShieldDivision() {
		return division;
	}

	public TinctureType getTinctureTypeOfLayer() {
		Iterator<Tincture> it = tinctures.getTincturesOnLayer().iterator();
		TinctureType first = it.next().getTinctureType();
		if (first == TinctureType.OTHER) {
			return first;
		}
		for (TinctureType tt = it.next().getTinctureType(); it.hasNext();) {
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
		if (!(obj instanceof ShieldLayer)) {
			return false;
		}
		ShieldLayer other = (ShieldLayer)obj;
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
