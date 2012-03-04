package blazon.client.drawing.charges.geometric;

import org.vectomatic.dom.svg.OMSVGDefsElement;
import org.vectomatic.dom.svg.OMSVGGElement;

import blazon.client.drawing.shapes.CubicBezierCurve;
import blazon.client.drawing.shapes.Point;
import blazon.client.drawing.shapes.Polygon;
import blazon.client.drawing.shapes.PolygonImpl;
import blazon.shared.shield.charges.GeometricCharge;
import blazon.shared.shield.tinctures.Tincture;

public class SVGPallDrawer extends SVGGeometricChargeDrawer {

	protected SVGPallDrawer(GeometricCharge charge, OMSVGDefsElement defs, int shieldWidth, int shieldHeight) {
		super(charge, defs, shieldWidth, shieldHeight);
	}

	@Override
	public OMSVGGElement drawCharge(CubicBezierCurve curve) {
		OMSVGGElement ordinaries = doc.createSVGGElement();
		Tincture tincture = charge.getTincture();
		final float xMid = chargeAreaXMin + getXDiff()/2f;
		final float yMid = chargeAreaYMin + getYDiff()/2f;
		final float tenthX = getXDiff()/10f;
		final float tenthY = getYDiff()/10f;
		float root2 = (float) Math.sqrt(2);
		Polygon polygon = new PolygonImpl(
				new Point(chargeAreaXMin, chargeAreaYMin+tenthY*root2), new Point(chargeAreaXMin, chargeAreaYMin), new Point(chargeAreaXMin+tenthX*root2, chargeAreaYMin), 
				new Point(xMid, yMid-tenthY*root2),
				new Point(chargeAreaXMax-tenthX*root2, chargeAreaYMin), new Point(chargeAreaXMax, chargeAreaYMin), new Point(chargeAreaXMax, chargeAreaYMin+tenthY*root2),
				new Point(xMid+tenthX, yMid),
				new Point(xMid+tenthX, chargeAreaYMax), new Point(xMid-tenthX, chargeAreaYMax),
				new Point(xMid-tenthX, yMid));
		putNewPolygonElementOnGElement(ordinaries, tincture, polygon);
		return ordinaries;
	}
}
