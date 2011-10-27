package blazon.client.drawing.charges.geometric;

import org.vectomatic.dom.svg.OMSVGDefsElement;
import org.vectomatic.dom.svg.OMSVGGElement;

import blazon.client.drawing.shapes.CubicBezierCurve;
import blazon.client.drawing.shapes.Point;
import blazon.client.drawing.shapes.Polygon;
import blazon.client.drawing.shapes.PolygonImpl;
import blazon.shared.shield.charges.GeometricCharge;

public class SVGBendDrawer extends SVGOrdinaryDrawer {

	public SVGBendDrawer(GeometricCharge charge, OMSVGDefsElement defs, int shieldWidth, int shieldHeight) {
		super(charge, defs, shieldWidth, shieldHeight);
	}

	@Override
	public OMSVGGElement drawOrdinary(OMSVGGElement shieldContainer,	CubicBezierCurve curve) {
		OMSVGGElement ordinaries = doc.createSVGGElement();
		final float tenthX = xMax/10f;
		final float tenthY = yMax/10f;
		Polygon polygon = new PolygonImpl(
				new Point(xMin, yMin+tenthY), new Point(xMin, yMin), new Point(xMin+tenthX, yMin), 
				new Point(xMax, yMax-tenthY), new Point(xMax, yMax), new Point(xMax-tenthX, yMax));
		putNewPolygonElementOnGElement(ordinaries, charge.getTincture(), polygon);
		return ordinaries;
	}
}
