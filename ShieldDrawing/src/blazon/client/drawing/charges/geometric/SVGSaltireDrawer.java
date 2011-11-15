package blazon.client.drawing.charges.geometric;

import org.vectomatic.dom.svg.OMSVGDefsElement;
import org.vectomatic.dom.svg.OMSVGGElement;

import blazon.client.drawing.shapes.CubicBezierCurve;
import blazon.client.drawing.shapes.Point;
import blazon.client.drawing.shapes.Polygon;
import blazon.client.drawing.shapes.PolygonImpl;
import blazon.shared.shield.charges.GeometricCharge;

public class SVGSaltireDrawer extends SVGOrdinaryDrawer {

	protected SVGSaltireDrawer(GeometricCharge charge, OMSVGDefsElement defs, int shieldWidth, int shieldHeight) {
		super(charge, defs, shieldWidth, shieldHeight);
	}

	@Override
	public OMSVGGElement drawOrdinary(CubicBezierCurve curve) {
		OMSVGGElement ordinaries = doc.createSVGGElement();
		final float xMid = xMax/2f;
		final float yMid = yMax/2f;
		final float tenthX = xMax/10f;
		final float tenthY = yMax/10f;
		Polygon polygon = new PolygonImpl(
				new Point(xMin, yMin+tenthY), new Point(xMin, yMin), new Point(xMin+tenthX, yMin), 
				new Point(xMid, yMid-tenthY),
				new Point(xMax-tenthX, yMin), new Point(xMax, yMin), new Point(xMax, yMin+tenthY),
				new Point(xMid+tenthX, yMid),
				new Point(xMax, yMax-tenthY), new Point(xMax, yMax), new Point(xMax-tenthX, yMax),
				new Point(xMid, yMid+tenthY),
				new Point(xMin+tenthX, yMax), new Point(xMin, yMax),	new Point(xMin, yMax-tenthY),
				new Point(xMid-tenthX, yMid));
		putNewPolygonElementOnGElement(ordinaries, charge.getTincture(), polygon);
		return ordinaries;
	}
}
