package blazon.client.drawing.charges.geometric;

import org.vectomatic.dom.svg.OMSVGDefsElement;
import org.vectomatic.dom.svg.OMSVGGElement;

import blazon.client.drawing.shapes.CubicBezierCurve;
import blazon.shared.shield.charges.GeometricCharge;

public class SVGFessDrawer extends SVGOrdinaryDrawer {

	public SVGFessDrawer(GeometricCharge charge, OMSVGDefsElement defs, int shieldWidth, int shieldHeight) {
		super(charge, defs, shieldWidth, shieldHeight);
	}

	@Override
	public OMSVGGElement drawOrdinary(OMSVGGElement shieldContainer,	CubicBezierCurve curve) {
		OMSVGGElement ordinaries = doc.createSVGGElement();
		final float thirdY = yMax/3f;
		putNewRectElementOnGElement(ordinaries, xMin, thirdY, xMax, thirdY, charge.getTincture());
		return ordinaries;
	}
}
