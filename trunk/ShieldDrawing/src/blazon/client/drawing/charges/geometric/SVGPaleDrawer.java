package blazon.client.drawing.charges.geometric;


import org.vectomatic.dom.svg.OMSVGDefsElement;
import org.vectomatic.dom.svg.OMSVGGElement;

import blazon.client.drawing.shapes.CubicBezierCurve;
import blazon.shared.shield.charges.GeometricCharge;
import blazon.shared.shield.tinctures.Tincture;

public class SVGPaleDrawer extends SVGGeometricChargeDrawer {

	protected SVGPaleDrawer(GeometricCharge charge, OMSVGDefsElement defs, int shieldWidth, int shieldHeight) {
		super(charge, defs, shieldWidth, shieldHeight);
	}

	@Override
	public OMSVGGElement drawCharge(CubicBezierCurve curve) {
		OMSVGGElement ordinaries = doc.createSVGGElement();
		Tincture tincture = charge.getTincture();
		final float thirdX = getXDiff()/3f;
		putNewRectElementOnGElement(ordinaries, thirdX, chargeAreaYMin, thirdX, chargeAreaYMax, tincture);
		return ordinaries;
	}
}
