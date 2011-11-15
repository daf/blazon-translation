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

class SVGSaltireDrawer extends SVGFieldDrawer {

	protected SVGSaltireDrawer(Field field, OMSVGDefsElement defs,	int shieldWidth, int shieldHeight) {
		super(field, defs, shieldWidth, shieldHeight);
	}

	@Override
	public OMSVGGElement drawField(CubicBezierCurve curve) {
		final OMSVGGElement svgField = doc.createSVGGElement();
		final int xMid = xMax/2;
		final int yMid = yMax/2;
		final Tinctures tinctures = field.getTinctures();
		final Iterator<Tincture> it = tinctures.getTincturesOnLayer().iterator();

		Point pointB = new Point(xMid, yMid);
		for (int i = 0; i < 2; i++) {
			Tincture t = it.next();
			Point pointA = new Point(xMin, yMin);
			Point pointC = (i == 0) ? new Point(xMax, yMin) : new Point(xMin, yMax);;
			RightAngleTriangle triangle = new RightAngleTriangle(pointA, pointB, pointC);
			putNewPolygonElementOnGElement(svgField, t, triangle);
			pointA = (i == 0) ? new Point(xMin, yMax) : new Point(xMax, yMin);
			pointC = new Point(xMax, yMax);
			triangle = new RightAngleTriangle(pointA, pointB, pointC);
			putNewPolygonElementOnGElement(svgField, t, triangle);
		}
		return svgField;
	}

}
