package blazon.client.drawing.charges.geometric;

import org.vectomatic.dom.svg.OMSVGDefsElement;
import org.vectomatic.dom.svg.OMSVGGElement;

import blazon.client.drawing.shapes.CubicBezierCurve;
import blazon.client.drawing.shapes.Point;
import blazon.client.drawing.shapes.Polygon;
import blazon.client.drawing.shapes.PolygonImpl;
import blazon.shared.shield.charges.GeometricCharge;

public class SVGCrossDrawer extends SVGOrdinaryDrawer {

	protected SVGCrossDrawer(GeometricCharge charge, OMSVGDefsElement defs,	int shieldWidth, int shieldHeight) {
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
				new Point(xMid-tenthX, yMin), new Point(xMid+tenthX, yMin), new Point(xMid+tenthX, yMid-tenthY), 
				new Point(xMax, xMid-tenthY), new Point(xMax, yMid+tenthY), new Point(xMid+tenthX, yMid+tenthY),
				new Point(xMid+tenthX, yMax), new Point(xMid-tenthX, yMax), new Point(xMid-tenthX, yMid+tenthY),
				new Point(xMin, xMid+tenthY), new Point(xMin, yMid-tenthY), new Point(xMid-tenthX, yMid-tenthY));
		putNewPolygonElementOnGElement(ordinaries, charge.getTincture(), polygon);
		return ordinaries;
	}
	
	

}