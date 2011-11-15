package blazon.client.drawing.field;

import java.util.Iterator;

import org.vectomatic.dom.svg.OMSVGDefsElement;
import org.vectomatic.dom.svg.OMSVGGElement;

import blazon.client.drawing.shapes.CubicBezierCurve;
import blazon.client.drawing.shapes.Point;
import blazon.client.drawing.shapes.RightAngleTriangle;
import blazon.client.drawing.shapes.StraightLine;
import blazon.shared.shield.Field;
import blazon.shared.shield.ShieldDivision.ShieldDivisionType;
import blazon.shared.shield.tinctures.Tincture;
import blazon.shared.shield.tinctures.Tinctures;

class SVGBendyDrawer extends SVGFieldDrawer {

	protected SVGBendyDrawer(Field field, OMSVGDefsElement defs, int shieldWidth, int shieldHeight) {
		super(field, defs, shieldWidth, shieldHeight);
	}

	@Override
	public OMSVGGElement drawField(CubicBezierCurve curve) {
		final OMSVGGElement svgField = doc.createSVGGElement();
		final ShieldDivisionType division = field.getShieldDivision();
    	final int numberOfSections = division.getNumberOfSections();
		final Tinctures tinctures = field.getTinctures();
		final Iterator<Tincture> it = tinctures.getTincturesOnLayer().iterator();

		Tincture firstTincture = it.next();
		Tincture secondTincture = it.next();
		Point curveMidPoint = curve.findMidpointOnCurve();
		StraightLine lineFromTopRightToMidPointOfCurve = new StraightLine(curveMidPoint, new Point(xMax, yMin));
		final double lengthFromTopRightCornerToMidPointOfCurve = lineFromTopRightToMidPointOfCurve.getLength();
		final double widthOfBendlet = lengthFromTopRightCornerToMidPointOfCurve / numberOfSections;
		
		final Point topCorner = new Point(xMax, yMin);
		for (int i = numberOfSections; i > 0; i--) {
			double triangleHeight = widthOfBendlet * i;
			float triangleSideLength = (float) Math.sqrt(2 * Math.pow(triangleHeight, 2));
			Point leftCorner = new Point(xMax - triangleSideLength, yMin);
			Point bottomCorner = new Point(xMax, triangleSideLength);
			RightAngleTriangle triangle = new RightAngleTriangle(topCorner, leftCorner, bottomCorner);
			putNewPolygonElementOnGElement(svgField, i % 2 != 0 ? secondTincture : firstTincture, triangle);
		}
		return svgField;
	}
}
