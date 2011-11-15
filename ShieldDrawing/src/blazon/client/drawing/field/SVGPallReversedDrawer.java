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

class SVGPallReversedDrawer extends SVGFieldDrawer {

	protected SVGPallReversedDrawer(Field field, OMSVGDefsElement defs, int shieldWidth, int shieldHeight) {
		super(field, defs, shieldWidth, shieldHeight);
	}

	@Override
	public OMSVGGElement drawField(CubicBezierCurve curve) {
		final OMSVGGElement svgField = doc.createSVGGElement();
		final int xMid = xMax/2;
		final int yMid = yMax/2;
		final Tinctures tinctures = field.getTinctures();
		final Iterator<Tincture> it = tinctures.getTincturesOnLayer().iterator();
		putNewRectElementOnGElement(svgField, xMin, yMin, xMid, yMax, it.next());
		putNewRectElementOnGElement(svgField, xMid, yMin, xMid, yMax, it.next());
		Point pointA = new Point(xMin, yMax);
		Point pointB = new Point(xMid, yMid);
		Point pointC = new Point(xMax, yMax);
		RightAngleTriangle triangle = new RightAngleTriangle(pointA, pointB, pointC);
		putNewPolygonElementOnGElement(svgField, it.next(), triangle);
		return svgField;
	}

}
