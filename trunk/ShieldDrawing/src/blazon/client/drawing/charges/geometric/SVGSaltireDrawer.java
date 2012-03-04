package blazon.client.drawing.charges.geometric;

import org.vectomatic.dom.svg.OMSVGDefsElement;
import org.vectomatic.dom.svg.OMSVGGElement;

import blazon.client.drawing.shapes.CubicBezierCurve;
import blazon.client.drawing.shapes.Point;
import blazon.client.drawing.shapes.Polygon;
import blazon.client.drawing.shapes.PolygonImpl;
import blazon.shared.shield.charges.GeometricCharge;
import blazon.shared.shield.tinctures.Tincture;

public class SVGSaltireDrawer extends SVGGeometricChargeDrawer {

	protected SVGSaltireDrawer(GeometricCharge charge, OMSVGDefsElement defs, int shieldWidth, int shieldHeight) {
		super(charge, defs, shieldWidth, shieldHeight);
	}

	@Override
	public OMSVGGElement drawCharge(CubicBezierCurve curve) {
		OMSVGGElement ordinaries = doc.createSVGGElement();
		Tincture tincture = charge.getTincture();
		final float xMid = chargeAreaXMin + getXDiff()/2f;
		final float yMid = chargeAreaYMin + getYDiff()/2f;
		final float tenthX = chargeAreaXMax/10f;
		final float tenthY = chargeAreaYMax/10f;
		Polygon polygon = new PolygonImpl(
				new Point(chargeAreaXMin, chargeAreaYMin+tenthY), new Point(chargeAreaXMin, chargeAreaYMin), new Point(chargeAreaXMin+tenthX, chargeAreaYMin), 
				new Point(xMid, yMid-tenthY),
				new Point(chargeAreaXMax-tenthX, chargeAreaYMin), new Point(chargeAreaXMax, chargeAreaYMin), new Point(chargeAreaXMax, chargeAreaYMin+tenthY),
				new Point(xMid+tenthX, yMid),
				new Point(chargeAreaXMax, chargeAreaYMax-tenthY), new Point(chargeAreaXMax, chargeAreaYMax), new Point(chargeAreaXMax-tenthX, chargeAreaYMax),
				new Point(xMid, yMid+tenthY),
				new Point(chargeAreaXMin+tenthX, chargeAreaYMax), new Point(chargeAreaXMin, chargeAreaYMax),	new Point(chargeAreaXMin, chargeAreaYMax-tenthY),
				new Point(xMid-tenthX, yMid));
		putNewPolygonElementOnGElement(ordinaries, tincture, polygon);
		return ordinaries;
	}
}
