package blazon.shared.shield;

import java.io.Serializable;

import blazon.shared.shield.tinctures.Tinctures;

public class ShieldLayer implements Serializable {
    
	/**
	 * 
	 */
	private static final long serialVersionUID = -1398608222570349005L;
	private Tinctures tinctures = null;
    private ShieldLayer nextLayer = null;
    
    public static ShieldLayer build(Tinctures t) {
    	ShieldLayer shieldLayer = new ShieldLayer();
    	shieldLayer.tinctures = t;
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
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Layer : \n------ ");
        sb.append(tinctures);
        return sb.toString();
    }
}

