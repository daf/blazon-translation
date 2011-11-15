package blazon.client.drawing.charges.geometric;

import org.vectomatic.dom.svg.OMSVGDefsElement;
import org.vectomatic.dom.svg.OMSVGGElement;

import blazon.client.drawing.shapes.CubicBezierCurve;
import blazon.client.drawing.shapes.Point;
import blazon.client.drawing.shapes.Polygon;
import blazon.client.drawing.shapes.Triangle;
import blazon.shared.shield.charges.GeometricCharge;

public class SVGPileReversedDrawer extends SVGOrdinaryDrawer {

	protected SVGPileReversedDrawer(GeometricCharge charge, OMSVGDefsElement defs, int shieldWidth, int shieldHeight) {
		super(charge, defs, shieldWidth, shieldHeight);
	}

	@Override
	public OMSVGGElement drawOrdinary(CubicBezierCurve curve) {
		OMSVGGElement ordinaries = doc.createSVGGElement();
		final float xMid = xMax/2f;
		final float thirdX = xMax/3f;
		Polygon polygon = new Triangle(new Point(xMid-thirdX/2, yMax), new Point(xMid+thirdX/2, yMax), new Point(xMid, yMin));
		putNewPolygonElementOnGElement(ordinaries, charge.getTincture(), polygon);
		return ordinaries;
	}
}