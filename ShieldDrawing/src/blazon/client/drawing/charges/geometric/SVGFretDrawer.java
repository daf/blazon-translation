package blazon.client.drawing.charges.geometric;

import org.vectomatic.dom.svg.OMSVGDefsElement;
import org.vectomatic.dom.svg.OMSVGGElement;

import blazon.client.drawing.charges.geometric.mobile.SVGMascleDrawer;
import blazon.client.drawing.shapes.CubicBezierCurve;
import blazon.client.drawing.shapes.Point;
import blazon.client.drawing.shapes.Polygon;
import blazon.client.drawing.shapes.PolygonImpl;
import blazon.shared.shield.charges.GeometricCharge;

public class SVGFretDrawer extends SVGGeometricChargeDrawer {

	public SVGFretDrawer(GeometricCharge charge, OMSVGDefsElement defs,	int shieldWidth, int shieldHeight) {
		super(charge, defs, shieldWidth, shieldHeight);
		SVGMascleDrawer mascleDrawer = new SVGMascleDrawer(charge, defs, shieldXMax, shieldYMax, occurrences, true);
		nestedDrawers.add(mascleDrawer);
		SVGBendletDrawer bendletDrawer = new SVGBendletDrawer(charge, defs, shieldXMax, shieldYMax, occurrences);
		nestedDrawers.add(bendletDrawer);
	}

	@Override
	public OMSVGGElement drawCharge(CubicBezierCurve curve) {
		OMSVGGElement fret = doc.createSVGGElement();
		SVGChargeDrawer mascleDrawer = nestedDrawers.get(0);
		OMSVGGElement mascle = mascleDrawer.drawCharge(curve);
		fret.appendChild(mascle);
		SVGChargeDrawer bendletDrawer = nestedDrawers.get(1);
		OMSVGGElement bendlet = bendletDrawer.drawCharge(curve);
		fret.appendChild(bendlet);

		final float bendletSinisterXSize = getXDiff()/20f;
		final float bendletSinisterXSideLength = (float) Math.sqrt(2 * Math.pow(bendletSinisterXSize, 2));
		final float bendletSinisterYSize = getYDiff()/20f;
		final float bendletSinisterYSideLength = (float) Math.sqrt(2 * Math.pow(bendletSinisterYSize, 2));
		float scale = 0.41f;
		Polygon bendletPart = new PolygonImpl(
				new Point(chargeAreaXMax, chargeAreaYMin+bendletSinisterYSideLength), new Point(chargeAreaXMax, chargeAreaYMin), new Point(chargeAreaXMax - bendletSinisterXSideLength, chargeAreaYMin), 
				new Point(chargeAreaXMax - getXDiff()*scale, chargeAreaYMin + getYDiff()*scale-bendletSinisterYSideLength), new Point(chargeAreaXMax - getXDiff()*scale+bendletSinisterXSideLength, chargeAreaYMin + getYDiff()*scale));
		putNewPolygonElementOnGElement(fret, charge.getTincture(), bendletPart);
		scale = 0.473f;
		float scale2 = 0.598f;
		bendletPart = new PolygonImpl(
				new Point(chargeAreaXMax - getXDiff()*scale, chargeAreaYMin + getYDiff()*scale-bendletSinisterYSideLength), new Point(chargeAreaXMax - getXDiff()*scale+bendletSinisterXSideLength, chargeAreaYMin + getYDiff()*scale),
				new Point(chargeAreaXMax - getXDiff()*scale2+bendletSinisterXSideLength, chargeAreaYMin + getYDiff()*scale2), new Point(chargeAreaXMax - getXDiff()*scale2, chargeAreaYMin + getYDiff()*scale2-bendletSinisterYSideLength));
		putNewPolygonElementOnGElement(fret, charge.getTincture(), bendletPart);
		scale = 0.34f;
		bendletPart = new PolygonImpl(
				new Point(chargeAreaXMin + getXDiff()*scale+bendletSinisterXSideLength, chargeAreaYMax - getYDiff()*scale), new Point(chargeAreaXMin + getXDiff()*scale, chargeAreaYMax - getYDiff()*scale-bendletSinisterYSideLength), 
				new Point(chargeAreaXMin, chargeAreaYMax-bendletSinisterYSideLength), new Point(chargeAreaXMin, chargeAreaYMax), new Point(chargeAreaXMin+bendletSinisterXSideLength, chargeAreaYMax));
		putNewPolygonElementOnGElement(fret, charge.getTincture(), bendletPart);
		return fret;
	}

}
