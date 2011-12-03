package blazon.shared.shield;

import blazon.shared.shield.ShieldDivision.ShieldDivisionType;
import blazon.shared.shield.tinctures.TinctureType;
import blazon.shared.shield.tinctures.Tinctures;

public interface ShieldLayer {
	Tinctures getTinctures();
	ShieldDivisionType getShieldDivision();
	TinctureType getTinctureTypeOfLayer();
}