package blazon.client.drawing.charges.geometric;


import org.vectomatic.dom.svg.OMSVGDefsElement;
import org.vectomatic.dom.svg.OMSVGGElement;

import blazon.client.drawing.shapes.CubicBezierCurve;
import blazon.client.drawing.shapes.Point;
import blazon.client.drawing.shapes.Polygon;
import blazon.client.drawing.shapes.Triangle;
import blazon.shared.shield.charges.GeometricCharge;
import blazon.shared.shield.tinctures.Tincture;

public class SVGPileDrawer extends SVGGeometricChargeDrawer {

	protected SVGPileDrawer(GeometricCharge charge, OMSVGDefsElement defs, int shieldWidth, int shieldHeight) {
		super(charge, defs, shieldWidth, shieldHeight);
	}

	@Override
	public OMSVGGElement drawCharge(CubicBezierCurve curve) {
		OMSVGGElement ordinaries = doc.createSVGGElement();
		Tincture tincture = charge.getTincture();
		final float xMid = getXDiff()/2f;
		final float thirdX = getXDiff()/3f;
		Polygon polygon = new Triangle(new Point(xMid-thirdX/2, chargeAreaYMin), new Point(xMid+thirdX/2, chargeAreaYMin), new Point(xMid, chargeAreaYMax));
		putNewPolygonElementOnGElement(ordinaries, tincture, polygon);
		return ordinaries;
	}
}
