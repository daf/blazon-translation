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

public class SVGPallReversedDrawer extends SVGGeometricChargeDrawer {

	protected SVGPallReversedDrawer(GeometricCharge charge, OMSVGDefsElement defs, List<ShieldDiagnostic> diags, int shieldWidth, int shieldHeight) {
		super(charge, defs, diags, shieldWidth, shieldHeight);
	}

	@Override
	public OMSVGGElement drawCharge(CubicBezierCurve curve) {
		OMSVGGElement ordinaries = doc.createSVGGElement();
		Tincture tincture = charge.getTincture();
		final float xMid = xMax/2f;
		final float yMid = yMax/2f;
		final float tenthX = xMax/10f;
		final float tenthY = yMax/10f;
		float root2 = (float) Math.sqrt(2);
		Polygon polygon = new PolygonImpl(
				new Point(xMin, yMax-tenthY*root2), new Point(xMin, yMax), new Point(xMin+tenthX*root2, yMax), 
				new Point(xMid, yMid+tenthY*root2),
				new Point(xMax-tenthX*root2, yMax), new Point(xMax, yMax), new Point(xMax, yMax-tenthY*root2),
				new Point(xMid+tenthX, yMid),
				new Point(xMid+tenthX, yMin), new Point(xMid-tenthX, yMin),
				new Point(xMid-tenthX, yMid));
		putNewPolygonElementOnGElement(ordinaries, tincture, polygon);
		return ordinaries;
	}
}
