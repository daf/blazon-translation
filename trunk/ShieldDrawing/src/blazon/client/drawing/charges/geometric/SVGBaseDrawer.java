package blazon.client.drawing.charges.geometric;


import java.util.EnumSet;

import org.vectomatic.dom.svg.OMSVGDefsElement;
import org.vectomatic.dom.svg.OMSVGGElement;

import blazon.client.drawing.charges.ChargeOffset;
import blazon.client.drawing.shapes.CubicBezierCurve;
import blazon.shared.shield.charges.GeometricCharge;
import blazon.shared.shield.tinctures.Tincture;

public class SVGBaseDrawer extends SVGGeometricChargeDrawer {

	protected SVGBaseDrawer(GeometricCharge charge, OMSVGDefsElement defs, int shieldWidth, int shieldHeight) {
		super(charge, defs, shieldWidth, shieldHeight);
	}

	@Override
	public OMSVGGElement drawCharge(CubicBezierCurve curve) {
		OMSVGGElement ordinaries = doc.createSVGGElement();
		Tincture tincture = charge.getTincture();
		final float thirdY = getXDiff()/3f;
		putNewRectElementOnGElement(ordinaries, shieldXMin, shieldYMax-thirdY, shieldXMax, thirdY, tincture);
		return ordinaries;
	}

	@Override
	public void setChargeOffset(EnumSet<ChargeOffset> chargeOffset) {
		//NO-OP
	}
}
