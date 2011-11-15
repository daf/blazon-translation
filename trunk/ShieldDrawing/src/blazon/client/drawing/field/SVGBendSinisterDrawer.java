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

class SVGBendSinisterDrawer extends SVGFieldDrawer {

	protected SVGBendSinisterDrawer(Field field, OMSVGDefsElement defs,	int shieldWidth, int shieldHeight) {
		super(field, defs, shieldWidth, shieldHeight);
	}

	@Override
	public OMSVGGElement drawField(CubicBezierCurve curve) {
		final OMSVGGElement svgField = doc.createSVGGElement();
		final Tinctures tinctures = field.getTinctures();
		final Iterator<Tincture> it = tinctures.getTincturesOnLayer().iterator();
		Point pointA = new Point(xMin, yMax);
		Point pointB = new Point(xMin, yMin);
		Point pointC = new Point(xMax, yMin);
		RightAngleTriangle triangle = new RightAngleTriangle(pointA, pointB, pointC);
		putNewPolygonElementOnGElement(svgField, it.next(), triangle);
		pointB = new Point(xMax, yMax);
		triangle = new RightAngleTriangle(pointA, pointB, pointC);
		putNewPolygonElementOnGElement(svgField, it.next(), triangle);
		return svgField;
	}
}
