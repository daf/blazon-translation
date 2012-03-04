package blazon.client.drawing.charges.geometric;


import org.vectomatic.dom.svg.OMSVGDefsElement;
import org.vectomatic.dom.svg.OMSVGGElement;

import blazon.client.drawing.shapes.CubicBezierCurve;
import blazon.client.drawing.shapes.Point;
import blazon.client.drawing.shapes.Polygon;
import blazon.client.drawing.shapes.PolygonImpl;
import blazon.shared.shield.charges.GeometricCharge;
import blazon.shared.shield.tinctures.Tincture;

public class SVGChevronDrawer extends SVGGeometricChargeDrawer {

	protected SVGChevronDrawer(GeometricCharge charge, OMSVGDefsElement defs, int shieldWidth, int shieldHeight) {
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
	    Polygon polygon = new PolygonImpl(
	    		new Point(chargeAreaXMax, chargeAreaYMax-tenthY), new Point(chargeAreaXMax, chargeAreaYMax), new Point(chargeAreaXMax-tenthX, chargeAreaYMax),
				new Point(xMid, yMid+tenthY),
				new Point(chargeAreaXMin+tenthX, chargeAreaYMax), new Point(chargeAreaXMin, chargeAreaYMax),	new Point(chargeAreaXMin, chargeAreaYMax-tenthY),
	    		new Point(xMid, yMid-tenthY));
	    putNewPolygonElementOnGElement(ordinaries, tincture, polygon);
		return ordinaries;
	}
}
