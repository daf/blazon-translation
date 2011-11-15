package blazon.client.drawing.field;

import java.util.Iterator;

import org.vectomatic.dom.svg.OMSVGDefsElement;
import org.vectomatic.dom.svg.OMSVGGElement;

import blazon.client.drawing.shapes.CubicBezierCurve;
import blazon.client.drawing.shapes.Point;
import blazon.client.drawing.shapes.RightAngleTriangle;
import blazon.client.drawing.shapes.Triangle;
import blazon.shared.shield.Field;
import blazon.shared.shield.ShieldDivision.ShieldDivisionType;
import blazon.shared.shield.tinctures.Tincture;
import blazon.shared.shield.tinctures.Tinctures;

class SVGGyronnyDrawer extends SVGFieldDrawer {

	protected SVGGyronnyDrawer(Field field, OMSVGDefsElement defs, int shieldWidth, int shieldHeight) {
		super(field, defs, shieldWidth, shieldHeight);
	}

	@Override
	public OMSVGGElement drawField(CubicBezierCurve curve) {
		final OMSVGGElement svgField = doc.createSVGGElement();
		final int xMid = xMax/2;
		final int yMid = yMax/2;
		final ShieldDivisionType division = field.getShieldDivision();
    	final int numberOfSections = division.getNumberOfSections();
		final Tinctures tinctures = field.getTinctures();
		final Iterator<Tincture> it = tinctures.getTincturesOnLayer().iterator();
		final Tincture firstTincture = it.next();
		final Tincture secondTincture = it.next();
		final double radPerDivision = 2 * Math.PI / numberOfSections;
		final double angleB = Math.PI / 2 - radPerDivision;
		final double sinAngleA = Math.sin(radPerDivision);
		final double sinAngleB = Math.sin(angleB);
		final float lengthB = (float) Math.sqrt(Math.pow(xMid,2) + Math.pow(yMid,2));
		final float lengthA = (float) Math.abs(lengthB * sinAngleA / sinAngleB);
		final float yTop = yMid - lengthB;
		final Point pointA = new Point(xMid, yTop);
		final Point pointB = new Point(xMid, yMid);
		final Point pointC = new Point(xMid + lengthA, yTop);
		final Triangle triangle = new RightAngleTriangle(pointA, pointB, pointC);
		final Point rPoint = new Point(xMid, yMid);
		
		for (int i = 0; i < numberOfSections; i++) {
			double rotateBy = radPerDivision * i;
			Triangle rotatedTriangle = triangle.rotate(rPoint, rotateBy);
			putNewPolygonElementOnGElement(svgField, i % 2 != 0 ? firstTincture : secondTincture, rotatedTriangle);
		}
		return svgField;
	}
}
