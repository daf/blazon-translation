package blazon.client.drawing.charges.geometric;

import java.util.List;

import org.vectomatic.dom.svg.OMSVGDefsElement;
import org.vectomatic.dom.svg.OMSVGGElement;

import blazon.client.drawing.shapes.CubicBezierCurve;
import blazon.client.drawing.shapes.Point;
import blazon.client.drawing.shapes.Polygon;
import blazon.client.drawing.shapes.PolygonImpl;
import blazon.shared.shield.charges.GeometricCharge;
import blazon.shared.shield.diagnostic.ShieldDiagnostic;
import blazon.shared.shield.tinctures.Tincture;

public class SVGBendDrawer extends SVGOrdinaryDrawer {

	private final float chargeSize = xMax/10f;
	
	protected SVGBendDrawer(GeometricCharge charge, OMSVGDefsElement defs, List<ShieldDiagnostic> diags, int shieldWidth, int shieldHeight) {
		super(charge, defs, diags, shieldWidth, shieldHeight);
	}

	@Override
	public OMSVGGElement drawOrdinary(CubicBezierCurve curve) {
		OMSVGGElement ordinaries = doc.createSVGGElement();
		Tincture tincture = charge.getTincture();
		final float chargeSideLength = (float) Math.sqrt(2 * Math.pow(chargeSize, 2));
		Polygon polygon = new PolygonImpl(
				new Point(xMin, yMin+chargeSideLength), new Point(xMin, yMin), new Point(xMin+chargeSideLength, yMin), 
				new Point(xMax, yMax-chargeSideLength), new Point(xMax, yMax), new Point(xMax-chargeSideLength, yMax));
		putNewPolygonElementOnGElement(ordinaries, tincture, polygon);
		return ordinaries;
	}
}
