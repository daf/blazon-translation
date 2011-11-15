package blazon.client.drawing.field;

import java.util.Iterator;

import org.vectomatic.dom.svg.OMSVGDefsElement;
import org.vectomatic.dom.svg.OMSVGGElement;

import blazon.client.drawing.shapes.CubicBezierCurve;
import blazon.client.drawing.shapes.Point;
import blazon.client.drawing.shapes.RightAngleTriangle;
import blazon.shared.shield.Field;
import blazon.shared.shield.ShieldDivision.ShieldDivisionType;
import blazon.shared.shield.tinctures.Tincture;
import blazon.shared.shield.tinctures.Tinctures;

class SVGChevronnyDrawer extends SVGFieldDrawer {

	protected SVGChevronnyDrawer(Field field, OMSVGDefsElement defs, int shieldWidth, int shieldHeight) {
		super(field, defs, shieldWidth, shieldHeight);
	}

	@Override
	public OMSVGGElement drawField(CubicBezierCurve curve) {
		final OMSVGGElement svgField = doc.createSVGGElement();
		final int xMid = xMax/2;
		final ShieldDivisionType division = field.getShieldDivision();
    	final int numberOfSections = division.getNumberOfSections();
		final Tinctures tinctures = field.getTinctures();
		final Iterator<Tincture> it = tinctures.getTincturesOnLayer().iterator();

		Tincture firstTincture = it.next();
		Tincture secondTincture = it.next();
		for (int i = numberOfSections; i > 0; i--) {
			float topYCoor = yMax - (1.5f * i * yMax / numberOfSections);
			float triangleWidth = 3f * i * xMax / numberOfSections;
			float rightXCoor = xMax + (triangleWidth - xMax) / 2;
			float leftXCoor = xMin - (triangleWidth - xMax) / 2;
			Point topPoint = new Point(xMid, topYCoor);
			Point leftPoint = new Point(leftXCoor, yMax);
			Point rightPoint = new Point(rightXCoor, yMax);
			RightAngleTriangle triangle = new RightAngleTriangle(topPoint, leftPoint, rightPoint);
			putNewPolygonElementOnGElement(svgField, i % 2 != 0 ? secondTincture : firstTincture, triangle);
		}
		return svgField;
	}
}
