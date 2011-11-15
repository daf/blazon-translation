package blazon.client.drawing.field;

import java.util.Iterator;

import org.vectomatic.dom.svg.OMSVGDefsElement;
import org.vectomatic.dom.svg.OMSVGGElement;

import blazon.client.drawing.shapes.CubicBezierCurve;
import blazon.client.drawing.shapes.Point;
import blazon.client.drawing.shapes.RightAngleTriangle;
import blazon.shared.shield.Field;
import blazon.shared.shield.tinctures.Tincture;
import blazon.shared.shield.tinctures.Tinctures;

class SVGPallDrawer extends SVGFieldDrawer {

	protected SVGPallDrawer(Field field, OMSVGDefsElement defs,	int shieldWidth, int shieldHeight) {
		super(field, defs, shieldWidth, shieldHeight);
	}

	@Override
	public OMSVGGElement drawField(CubicBezierCurve curve) {
		final OMSVGGElement svgField = doc.createSVGGElement();
		final int xMid = xMax/2;
		final int yMid = yMax/2;
		final Tinctures tinctures = field.getTinctures();
		final Iterator<Tincture> it = tinctures.getTincturesOnLayer().iterator();
		Tincture t = it.next();
		putNewRectElementOnGElement(svgField, xMin, yMin, xMid, yMax, it.next());
		putNewRectElementOnGElement(svgField, xMid, yMin, xMid, yMax, it.next());
		Point pointA = new Point(xMin, yMin);
		Point pointB = new Point(xMid, yMid);
		Point pointC = new Point(xMax, yMin);
		RightAngleTriangle triangle = new RightAngleTriangle(pointA, pointB, pointC);
		putNewPolygonElementOnGElement(svgField, t, triangle);
		return svgField;
	}
}
