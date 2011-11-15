package blazon.client.drawing.field;

import java.util.Iterator;

import org.vectomatic.dom.svg.OMSVGDefsElement;
import org.vectomatic.dom.svg.OMSVGGElement;

import blazon.client.drawing.shapes.CubicBezierCurve;
import blazon.client.drawing.shapes.Point;
import blazon.client.drawing.shapes.Triangle;
import blazon.shared.shield.Field;
import blazon.shared.shield.tinctures.Tincture;
import blazon.shared.shield.tinctures.Tinctures;

class SVGChevronReversedDrawer extends SVGFieldDrawer {

	protected SVGChevronReversedDrawer(Field field, OMSVGDefsElement defs, int shieldWidth, int shieldHeight) {
		super(field, defs, shieldWidth, shieldHeight);
	}

	@Override
	public OMSVGGElement drawField(CubicBezierCurve curve) {
		final OMSVGGElement svgField = doc.createSVGGElement();
		final int xMid = xMax/2;
		final int yMid = yMax/2;
		final Tinctures tinctures = field.getTinctures();
		final Iterator<Tincture> it = tinctures.getTincturesOnLayer().iterator();
		Tincture firstTincture = it.next();
		putNewRectElementOnGElement(svgField, xMin, yMin, xMax, yMax, it.next());
		Point pointB = new Point(xMid, yMid);
		Point pointA = new Point(xMin, yMin);
		Point pointC = new Point(xMax, yMin);
		Triangle triangle = new Triangle(pointA, pointB, pointC);
		putNewPolygonElementOnGElement(svgField, firstTincture, triangle);
		return svgField;
	}
}
