package blazon.client.drawing.charges.geometric;


import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import org.vectomatic.dom.svg.OMSVGDefsElement;

import blazon.client.drawing.charges.ChargeOffset;
import blazon.shared.shield.charges.GeometricCharge;

public abstract class SVGGeometricChargeDrawer extends SVGChargeDrawer {

	protected List<SVGChargeDrawer> nestedDrawers = new ArrayList<SVGChargeDrawer>();
	
	protected SVGGeometricChargeDrawer(GeometricCharge charge, OMSVGDefsElement defs, float shieldWidth, float shieldHeight) {
		this(charge, defs, shieldWidth, shieldHeight, 1);
	}

	public SVGGeometricChargeDrawer(GeometricCharge charge, OMSVGDefsElement defs, float shieldWidth, float shieldHeight, int occurrences) {
		super(charge, defs, shieldWidth, shieldHeight, occurrences);
	}

	@Override 
	public void setChargeOffset(EnumSet<ChargeOffset> chargeOffsetFlag) {
		super.setChargeOffset(chargeOffsetFlag);
		for (SVGChargeDrawer chargeDrawer : nestedDrawers) {
			chargeDrawer.setChargeOffset(chargeOffsetFlag);
		}
	}	
}
