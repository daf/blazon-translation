package blazon.shared.shield.charges;

import java.io.Serializable;

public enum GeometricChargeNames implements Serializable {
	
	CROSS(GeometricChargeType.ORDINARY),
	PALE(GeometricChargeType.ORDINARY),
	FESS(GeometricChargeType.ORDINARY),
	BEND(GeometricChargeType.ORDINARY),
	BEND_SINISTER(GeometricChargeType.ORDINARY),
	SALTIRE(GeometricChargeType.ORDINARY),
	CHIEF(GeometricChargeType.ORDINARY),
	BASE(GeometricChargeType.ORDINARY),
	CHEVRON(GeometricChargeType.ORDINARY),
	CHEVRON_REVERSED(GeometricChargeType.ORDINARY),
	
	PALL(GeometricChargeType.SUBORDINARY),
	PALL_REVERSED(GeometricChargeType.SUBORDINARY),
	PILE(GeometricChargeType.SUBORDINARY),
	PILE_REVERSED(GeometricChargeType.SUBORDINARY),
	QUARTER(GeometricChargeType.SUBORDINARY),
	CANTON(GeometricChargeType.SUBORDINARY),
	FLAUNCHES(GeometricChargeType.SUBORDINARY),
	BORDURE(GeometricChargeType.SUBORDINARY),
	ORLE(GeometricChargeType.SUBORDINARY),
	TRESSURE(GeometricChargeType.SUBORDINARY),
	GYRON(GeometricChargeType.SUBORDINARY),
	FRET(GeometricChargeType.SUBORDINARY),
	BAR(GeometricChargeType.SUBORDINARY);
	
	private GeometricChargeType geometricChargeType;
	
	private GeometricChargeNames(GeometricChargeType geometricChargeType) {
		this.geometricChargeType = geometricChargeType;
	}
	
	public GeometricCharge createObjectForGeometricChargeType() {
		switch (geometricChargeType) {
			case ORDINARY:
				return new Ordinary();
			case SUBORDINARY:
				return new Subordinary();
			default:
				return null;
		}
	}
	
	public static boolean valueExists(String s) {
		for (GeometricChargeNames v : values()) {
			if (v.toString().equals(s)) {
				return true;
			}
		}
		return false;
	}
	
	enum GeometricChargeType implements Serializable {
		ORDINARY,
		SUBORDINARY
	}
}
