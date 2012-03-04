package blazon.client.drawing.charges.geometric;


import org.vectomatic.dom.svg.OMSVGDefsElement;
import org.vectomatic.dom.svg.OMSVGGElement;

import blazon.client.drawing.shapes.CubicBezierCurve;
import blazon.client.drawing.shapes.Point;
import blazon.client.drawing.shapes.Polygon;
import blazon.client.drawing.shapes.PolygonImpl;
import blazon.shared.shield.charges.GeometricCharge;
import blazon.shared.shield.tinctures.Tincture;

public class SVGBendSinisterDrawer extends SVGGeometricChargeDrawer {
	
	protected SVGBendSinisterDrawer(GeometricCharge charge, OMSVGDefsElement defs, int shieldWidth, int shieldHeight) {
		super(charge, defs, shieldWidth, shieldHeight);
	}

	@Override
	public OMSVGGElement drawCharge(CubicBezierCurve curve) {
		OMSVGGElement ordinaries = doc.createSVGGElement();
		Tincture tincture = charge.getTincture();
		final float chargeXSize = getXDiff()/10f;
		final float chargeYSize = getYDiff()/10f;
		Polygon polygon = new PolygonImpl(
				new Point(chargeAreaXMax-chargeXSize, chargeAreaYMin), new Point(chargeAreaXMax, chargeAreaYMin), new Point(chargeAreaXMax, chargeAreaYMin+chargeYSize),
				new Point(chargeAreaXMin+chargeXSize, chargeAreaYMax), new Point(chargeAreaXMin, chargeAreaYMax), new Point(chargeAreaXMin, chargeAreaYMax-chargeYSize));
		putNewPolygonElementOnGElement(ordinaries, tincture, polygon);
		return ordinaries;
	}
}