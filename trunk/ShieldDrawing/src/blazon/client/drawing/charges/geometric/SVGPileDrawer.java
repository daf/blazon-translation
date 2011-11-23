package blazon.client.drawing.charges.geometric;

import java.util.List;

import org.vectomatic.dom.svg.OMSVGDefsElement;
import org.vectomatic.dom.svg.OMSVGGElement;

import blazon.client.drawing.shapes.CubicBezierCurve;
import blazon.client.drawing.shapes.Point;
import blazon.client.drawing.shapes.Polygon;
import blazon.client.drawing.shapes.Triangle;
import blazon.shared.shield.charges.GeometricCharge;
import blazon.shared.shield.diagnostic.ShieldDiagnostic;
import blazon.shared.shield.tinctures.Tincture;

public class SVGPileDrawer extends SVGOrdinaryDrawer {

	protected SVGPileDrawer(GeometricCharge charge, OMSVGDefsElement defs, List<ShieldDiagnostic> diags, int shieldWidth, int shieldHeight) {
		super(charge, defs, diags, shieldWidth, shieldHeight);
	}

	@Override
	public OMSVGGElement drawOrdinary(CubicBezierCurve curve) {
		OMSVGGElement ordinaries = doc.createSVGGElement();
		Tincture tincture = charge.getTincture();
		final float xMid = xMax/2f;
		final float thirdX = xMax/3f;
		Polygon polygon = new Triangle(new Point(xMid-thirdX/2, yMin), new Point(xMid+thirdX/2, yMin), new Point(xMid, yMax));
		putNewPolygonElementOnGElement(ordinaries, tincture, polygon);
		return ordinaries;
	}
}
