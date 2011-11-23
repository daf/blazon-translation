package blazon.client.drawing.charges.geometric;

import java.util.List;

import org.vectomatic.dom.svg.OMSVGDefsElement;
import org.vectomatic.dom.svg.OMSVGGElement;

import blazon.client.drawing.charges.geometric.mobile.SVGMascleDrawer;
import blazon.client.drawing.shapes.CubicBezierCurve;
import blazon.client.drawing.shapes.Point;
import blazon.client.drawing.shapes.Polygon;
import blazon.client.drawing.shapes.PolygonImpl;
import blazon.shared.shield.charges.GeometricCharge;
import blazon.shared.shield.diagnostic.ShieldDiagnostic;

public class SVGFretDrawer extends SVGOrdinaryDrawer {

	public SVGFretDrawer(GeometricCharge charge, OMSVGDefsElement defs,	List<ShieldDiagnostic> diags, int shieldWidth, int shieldHeight) {
		super(charge, defs, diags, shieldWidth, shieldHeight);
	}

	@Override
	public OMSVGGElement drawOrdinary(CubicBezierCurve curve) {
		OMSVGGElement fret = doc.createSVGGElement();
		SVGMascleDrawer mascleDrawer = new SVGMascleDrawer(charge, defs, diags, xMax, yMax, occurrences);
		OMSVGGElement mascle = mascleDrawer.drawOrdinary(curve, true);
		fret.appendChild(mascle);
		SVGBendletSinisterDrawer bendletSinisterDrawer = new SVGBendletSinisterDrawer(charge, defs, diags, xMax, yMax, occurrences);
		OMSVGGElement bendletSinister = bendletSinisterDrawer.drawOrdinary(curve);
		fret.appendChild(bendletSinister);
		final float bendletWidth = xMax/20f;
		final float bendletSideLength = (float) Math.sqrt(2 * Math.pow(bendletWidth, 2));
		float scale = 0.365f;
		Polygon bendletPart = new PolygonImpl(
				new Point(xMin, yMin+bendletSideLength), new Point(xMin, yMin), new Point(xMin+bendletSideLength, yMin), 
				new Point(xMax*scale, yMax*scale-bendletSideLength), new Point(xMax*scale-bendletSideLength, yMax*scale));
		putNewPolygonElementOnGElement(fret, charge.getTincture(), bendletPart);
		scale = 0.455f;
		float scale2 = 0.615f;
		bendletPart = new PolygonImpl(
				new Point(xMax*scale, yMax*scale-bendletSideLength), new Point(xMax*scale-bendletSideLength, yMax*scale),
				new Point(xMax*scale2-bendletSideLength, yMax*scale2), new Point(xMax*scale2, yMax*scale2-bendletSideLength));
		putNewPolygonElementOnGElement(fret, charge.getTincture(), bendletPart);
		scale = 0.705f;
		bendletPart = new PolygonImpl(
				new Point(xMax*scale-bendletSideLength, yMax*scale), new Point(xMax*scale, yMax*scale-bendletSideLength), 
				new Point(xMax, yMax-bendletSideLength), new Point(xMax, yMax), new Point(xMax-bendletSideLength, yMax));
		putNewPolygonElementOnGElement(fret, charge.getTincture(), bendletPart);
		return fret;
	}

}
