package blazon.shared.shield;

import java.util.ArrayList;

import blazon.shared.shield.charges.Ordinary.OrdinaryType;
import blazon.shared.shield.diagnostic.ShieldDiagnostic;
import blazon.shared.shield.tinctures.Tinctures;

public class ChargedShieldLayer extends ShieldLayer {

	private static final long serialVersionUID = -1842958628522126820L;
	private ChargedShieldLayer() { super(); }
	
	private OrdinaryType ordinary;
	
	public static ChargedShieldLayer build(Tinctures tinctures, OrdinaryType ordinary) {
		ChargedShieldLayer layer = new ChargedShieldLayer();
		layer.ordinary = ordinary;
		layer.tinctures = tinctures;
		layer.division = new ShieldDivision().getDivisionType(ShieldDivision.NONE, new ArrayList<ShieldDiagnostic>());
		return layer;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("ChargedShieldLayer{tinctures=");
		sb.append(tinctures).append(":division=").append(division);
		sb.append(":ordinary=").append(ordinary);
		sb.append(":nextLayer=").append(nextLayer).append("}");
		return sb.toString();
	}


	public OrdinaryType getOrdinary() {
		return ordinary;
	}
	
}
