package blazon.client.drawing.charges.geometric;

import org.vectomatic.dom.svg.OMSVGDefsElement;
import org.vectomatic.dom.svg.OMSVGGElement;

import blazon.client.drawing.shapes.CubicBezierCurve;
import blazon.client.drawing.shapes.Point;
import blazon.client.drawing.shapes.Polygon;
import blazon.client.drawing.shapes.PolygonImpl;
import blazon.shared.shield.charges.GeometricCharge;

public class SVGChevronReversedDrawer extends SVGOrdinaryDrawer {

	public SVGChevronReversedDrawer(GeometricCharge charge, OMSVGDefsElement defs, int shieldWidth, int shieldHeight) {
		super(charge, defs, shieldWidth, shieldHeight);
	}

	@Override
	public OMSVGGElement drawOrdinary(OMSVGGElement shieldContainer,	CubicBezierCurve curve) {
		OMSVGGElement ordinaries = doc.createSVGGElement();
		final float xMid = xMax/2f;
		final float yMid = yMax/2f;
		final float tenthX = xMax/10f;
		final float tenthY = yMax/10f;
		Polygon polygon = new PolygonImpl(
				new Point(xMin, yMin+tenthY), new Point(xMin, yMin), new Point(xMin+tenthX, yMin), 
				new Point(xMid, yMid-tenthY),
				new Point(xMax-tenthX, yMin), new Point(xMax, yMin), new Point(xMax, yMin+tenthY),
				new Point(xMid, yMid+tenthY));
		putNewPolygonElementOnGElement(ordinaries, charge.getTincture(), polygon);
		return ordinaries;
	}
}
