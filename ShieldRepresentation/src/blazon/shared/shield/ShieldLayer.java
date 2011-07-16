package blazon.shared.shield;

import java.io.Serializable;

import blazon.shared.shield.ShieldDivision.ShieldDivisionType;
import blazon.shared.shield.tinctures.Tinctures;

public class ShieldLayer implements Serializable {
    
	private static final long serialVersionUID = -1398608222570349005L;
	private Tinctures tinctures = null;
	private ShieldLayer nextLayer = null;
    private ShieldDivisionType division;
    
    public static ShieldLayer build(Tinctures t) {
    	ShieldDivision divisions = new ShieldDivision();
    	return build(t, divisions.getDivisionType("none"));
    }
    
    public static ShieldLayer build(Tinctures t, ShieldDivisionType division) {
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
	
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("DividedShieldLayer:tinctures=");
        sb.append(tinctures).append(":division=").append(division);
        sb.append(":nextLayer=").append(nextLayer);
        
        return sb.toString();
    }
}

