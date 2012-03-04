package blazon.client.drawing.charges.geometric;


import org.vectomatic.dom.svg.OMSVGDefsElement;
import org.vectomatic.dom.svg.OMSVGGElement;

import blazon.client.drawing.shapes.CubicBezierCurve;
import blazon.client.drawing.shapes.Point;
import blazon.client.drawing.shapes.Polygon;
import blazon.client.drawing.shapes.PolygonImpl;
import blazon.shared.shield.charges.GeometricCharge;
import blazon.shared.shield.tinctures.Tincture;

public class SVGCrossDrawer extends SVGGeometricChargeDrawer {

	protected SVGCrossDrawer(GeometricCharge charge, OMSVGDefsElement defs,	int shieldWidth, int shieldHeight) {
		super(charge, defs, shieldWidth, shieldHeight);
	}

	@Override
	public OMSVGGElement drawCharge(CubicBezierCurve curve) {
		OMSVGGElement ordinaries = doc.createSVGGElement();
		Tincture tincture = charge.getTincture();
		final float xDiff = getXDiff();
		final float xMid = shieldXMin + xDiff/2f;
		final float yDiff = chargeAreaYMax-chargeAreaYMin;
		final float yMid = chargeAreaYMin + yDiff/2f;
		final float breadth = (xDiff + yDiff)/20.0f;
		Polygon polygon = new PolygonImpl(
				new Point(xMid-breadth, chargeAreaYMin), new Point(xMid+breadth, chargeAreaYMin), new Point(xMid+breadth, yMid-breadth), 
				new Point(chargeAreaXMax, yMid-breadth), new Point(chargeAreaXMax, yMid+breadth), new Point(xMid+breadth, yMid+breadth),
				new Point(xMid+breadth, chargeAreaYMax), new Point(xMid-breadth, chargeAreaYMax), new Point(xMid-breadth, yMid+breadth),
				new Point(chargeAreaXMin, yMid+breadth), new Point(chargeAreaXMin, yMid-breadth), new Point(xMid-breadth, yMid-breadth));
		putNewPolygonElementOnGElement(ordinaries, tincture, polygon);
		return ordinaries;
	}
	
	

}
