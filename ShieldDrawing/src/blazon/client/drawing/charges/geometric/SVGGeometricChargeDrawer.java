package blazon.client.drawing.charges.geometric;

import java.util.List;

import org.vectomatic.dom.svg.OMSVGDefsElement;

import blazon.shared.shield.charges.GeometricCharge;
import blazon.shared.shield.diagnostic.ShieldDiagnostic;

public abstract class SVGGeometricChargeDrawer extends SVGChargeDrawer {

	protected GeometricCharge charge;
	
	protected SVGGeometricChargeDrawer(GeometricCharge charge, OMSVGDefsElement defs, List<ShieldDiagnostic> diags, int shieldWidth, int shieldHeight) {
		this(charge, defs, diags, shieldWidth, shieldHeight, 1);
	}

	public SVGGeometricChargeDrawer(GeometricCharge charge, OMSVGDefsElement defs, List<ShieldDiagnostic> diags, int shieldWidth, int shieldHeight, int occurrences) {
		super(defs, diags, shieldWidth, shieldHeight, occurrences);
		this.charge = charge;
	}

}
