package blazon.shared.shield.charges;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import blazon.shared.shield.diagnostic.ShieldDiagnostic;
import blazon.shared.shield.diagnostic.ShieldDiagnostic.LogLevel;
import blazon.shared.shield.tinctures.Tincture;

public abstract class GeometricCharge implements Serializable {

	private static final long serialVersionUID = 7555507684783697344L;
	
	protected Tincture tincture;
	protected GeometricChargeNames name;
	
	protected GeometricCharge() {}
	
	public static GeometricCharge build(String name, Tincture t, List<ShieldDiagnostic> errorsList) {
		if (name == null || name.trim().isEmpty()) {
			throw new IllegalArgumentException("Can not get geometric charge with null or empty name");
		}
		if (t == null) {
			throw new IllegalArgumentException("Can not get geometric charge with null tincture");
		}
		if (errorsList == null) {
			errorsList = new ArrayList<ShieldDiagnostic>();
		}
		
		name = name.toUpperCase().trim().replace(' ', '_');
		if (GeometricChargeNames.valueExists(name)) {
			GeometricChargeNames chargeName = GeometricChargeNames.valueOf(name);
			GeometricCharge gCharge;
			gCharge = chargeName.createObjectForGeometricChargeType();
			gCharge.name = chargeName;
			gCharge.tincture = t;
			return gCharge;
		} else {
			errorsList.add(ShieldDiagnostic.build(LogLevel.WARN, "Unknown geometric charge '" + name + "'. No geometric charge used."));
			return null;
		}
	}
	
	public GeometricChargeNames getName() {
		return name;
	}

	public Tincture getTincture() {
		return tincture;
	}
	
	@Override
	public int hashCode() {
		int result = 17;
		result = 31 * result + (name == null ? 0 : name.hashCode());
		result = 31 * result + (tincture == null ? 0 : tincture.hashCode());
		return result;
	}
}
