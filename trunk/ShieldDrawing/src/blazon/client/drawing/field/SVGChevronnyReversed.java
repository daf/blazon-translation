package blazon.client.drawing.field;

import java.util.Iterator;

import org.vectomatic.dom.svg.OMSVGDefsElement;
import org.vectomatic.dom.svg.OMSVGGElement;

import blazon.client.drawing.shapes.CubicBezierCurve;
import blazon.client.drawing.shapes.Point;
import blazon.client.drawing.shapes.Polygon;
import blazon.client.drawing.shapes.StraightLine;
import blazon.client.drawing.shapes.Triangle;
import blazon.shared.shield.Field;
import blazon.shared.shield.ShieldDivision.ShieldDivisionType;
import blazon.shared.shield.tinctures.Tincture;
import blazon.shared.shield.tinctures.Tinctures;

class SVGChevronnyReversed extends SVGFieldDrawer {

	protected SVGChevronnyReversed(Field field, OMSVGDefsElement defs, int shieldWidth, int shieldHeight) {
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
		StraightLine tangent = curve.getTangentToCurveAtMidpoint();
		final double largestTriangleHeight = tangent.getYCoordinateWhenXIsKnown(xMid);
		final double largestTriangleWidth = (Math.abs(tangent.getXCoordinateWhenYIsKnown(yMin)) * 2) + xMax;
		
		for (int i = numberOfSections; i > 0; i--) {
			double tWidth = largestTriangleWidth * i / numberOfSections;
			double tHeight = largestTriangleHeight * i / numberOfSections;
			double leftXCoor = xMin - (tWidth - xMax) / 2;
			double rightXCoor = xMax + (tWidth - xMax) / 2;
			Point leftPoint = new Point((float) leftXCoor, 0);
			Point rightPoint = new Point((float) rightXCoor, 0);
			Point bottomPoint = new Point(200, (float) tHeight);
			Polygon triangle = new Triangle(bottomPoint, leftPoint, rightPoint);
			putNewPolygonElementOnGElement(svgField, i % 2 != 0 ? secondTincture : firstTincture, triangle);
		}
		return svgField;
	}
}
