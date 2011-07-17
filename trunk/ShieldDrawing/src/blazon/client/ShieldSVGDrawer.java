package blazon.client;

import java.util.Iterator;

import org.vectomatic.dom.svg.OMSVGDefsElement;
import org.vectomatic.dom.svg.OMSVGDocument;
import org.vectomatic.dom.svg.OMSVGElement;
import org.vectomatic.dom.svg.OMSVGGElement;
import org.vectomatic.dom.svg.OMSVGPointList;
import org.vectomatic.dom.svg.OMSVGPolygonElement;
import org.vectomatic.dom.svg.OMSVGSVGElement;
import org.vectomatic.dom.svg.utils.SVGConstants;

import blazon.client.svg.fur.FurSVGBuilder;
import blazon.client.svg.fur.AbstractFurSVGBuilder;
import blazon.client.svg.shapes.Point;
import blazon.client.svg.shapes.Triangle;
import blazon.shared.shield.*;
import blazon.shared.shield.ShieldDivision.ShieldDivisionType;
import blazon.shared.shield.tinctures.*;

public class ShieldSVGDrawer {
	
	private OMSVGDocument doc;
	private Shield shield;
	private OMSVGDefsElement defs;

	public static ShieldSVGDrawer build(Shield shield, OMSVGDocument doc, OMSVGDefsElement defs) {
		ShieldSVGDrawer drawer = new ShieldSVGDrawer();
		drawer.doc = doc;
		drawer.shield = shield;
		drawer.defs = defs;
		return drawer;
	}

	public void drawSVGShield(OMSVGGElement shieldContainer) {
		OMSVGGElement field = doc.createSVGGElement();
        ShieldLayer base = shield.getField();
    	ShieldDivisionType division = base.getShieldDivision();
    	Tinctures tinctures = base.getTinctures();
    	createElementsForField(division, tinctures, field);
		shieldContainer.appendChild(field);
	}
	
	private void createElementsForField(ShieldDivisionType division,
			Tinctures tinctures, OMSVGGElement field) {
		final int xMax = ShieldDrawing.SHIELD_MAX_X;
		final int yMax = ShieldDrawing.SHIELD_MAX_Y;
		final int xMin = ShieldDrawing.SHIELD_MIN_X;
		final int yMin = ShieldDrawing.SHIELD_MIN_Y;
		final int xMid = ShieldDrawing.SHIELD_MAX_X/2;
		final int yMid = ShieldDrawing.SHIELD_MAX_Y/2;
		Iterator<Tincture> it = tinctures.getTincturesOnLayer().iterator();
		final String divisionName = division.getName();
		if (divisionName.equals(ShieldDivision.FESS)) {
			putNewRectElementOnGElement(field, xMin, yMin, xMax, yMid, it.next());
			putNewRectElementOnGElement(field, xMin, yMid, xMax, yMid, it.next());
		}
		else if (divisionName.equals(ShieldDivision.PALE)) {
			putNewRectElementOnGElement(field, xMin, yMin, xMid, yMax, it.next());
			putNewRectElementOnGElement(field, xMid, yMin, xMid, yMax, it.next());
		}
		else if (divisionName.equals(ShieldDivision.BEND)) {
			Point pointA = Point.build(xMin, yMin);
			Point pointB = Point.build(xMax, yMin);
			Point pointC = Point.build(xMax, yMax);
			Triangle triangle = Triangle.build(pointA, pointB, pointC);
			putNewPolygonElementOnGElement(field, it.next(), triangle);
			pointA = Point.build(xMin, yMin);
			pointB = Point.build(xMax, yMax);
			pointC = Point.build(xMin, yMax);
			triangle = Triangle.build(pointA, pointB, pointC);
			putNewPolygonElementOnGElement(field, it.next(), triangle);
		}
		else if (divisionName.equals(ShieldDivision.BEND_SINISTER)) {
			Point pointA = Point.build(xMin, yMin);
			Point pointB = Point.build(xMin, yMax);
			Point pointC = Point.build(xMax, yMin);
			Triangle triangle = Triangle.build(pointA, pointB, pointC);
			putNewPolygonElementOnGElement(field, it.next(), triangle);
			pointA = Point.build(xMax, yMin);
			pointB = Point.build(xMin, yMax);
			pointC = Point.build(xMax, yMax);
			triangle = Triangle.build(pointA, pointB, pointC);
			putNewPolygonElementOnGElement(field, it.next(), triangle);
		}
		else if (divisionName.equals(ShieldDivision.CHEVRON)) {
			putNewRectElementOnGElement(field, xMin, yMin, xMax, yMax, it.next());
			Point pointA = Point.build(xMin, yMax);
			Point pointB = Point.build(xMid, yMid);
			Point pointC = Point.build(xMax, yMax);
			Triangle triangle = Triangle.build(pointA, pointB, pointC);
			putNewPolygonElementOnGElement(field, it.next(), triangle);
		}
		else if (divisionName.equals(ShieldDivision.CHEVRON_REVERSED)) {
			Tincture t = it.next();
			putNewRectElementOnGElement(field, xMin, yMin, xMax, yMax, it.next());
			Point pointA = Point.build(xMin, yMin);
			Point pointB = Point.build(xMid, yMid);
			Point pointC = Point.build(xMax, yMin);
			Triangle triangle = Triangle.build(pointA, pointB, pointC);
			putNewPolygonElementOnGElement(field, t, triangle);
		}
		else if (divisionName.equals(ShieldDivision.PALL)) {
			Tincture t = it.next();
			putNewRectElementOnGElement(field, xMin, yMin, xMid, yMax, it.next());
			putNewRectElementOnGElement(field, xMid, yMin, xMid, yMax, it.next());
			Point pointA = Point.build(xMin, yMin);
			Point pointB = Point.build(xMid, yMid);
			Point pointC = Point.build(xMax, yMin);
			Triangle triangle = Triangle.build(pointA, pointB, pointC);
			putNewPolygonElementOnGElement(field, t, triangle);
		}
		else if (divisionName.equals(ShieldDivision.PALL_REVERSED)) {
			putNewRectElementOnGElement(field, xMin, yMin, xMid, yMax, it.next());
			putNewRectElementOnGElement(field, xMid, yMin, xMid, yMax, it.next());
			Point pointA = Point.build(xMin, yMax);
			Point pointB = Point.build(xMid, yMid);
			Point pointC = Point.build(xMax, yMax);
			Triangle triangle = Triangle.build(pointA, pointB, pointC);
			putNewPolygonElementOnGElement(field, it.next(), triangle);
		}
		else if (divisionName.equals(ShieldDivision.CROSS)) {
			Tincture t = it.next();
			putNewRectElementOnGElement(field, xMin, yMin, xMid, xMid, t);
			putNewRectElementOnGElement(field, xMid, yMid, xMid, yMid, t);
			t = it.next();
			putNewRectElementOnGElement(field, xMin, yMid, xMid, yMid, t);
			putNewRectElementOnGElement(field, xMid, yMin, xMid, yMid, t);			
		}
		else if (divisionName.equals(ShieldDivision.SALTIRE)) {
			Tincture t = it.next();
			Point pointA = Point.build(xMin, yMin);
			Point pointB = Point.build(xMid, yMid);
			Point pointC = Point.build(xMax, yMin);
			Triangle triangle = Triangle.build(pointA, pointB, pointC);
			putNewPolygonElementOnGElement(field, t, triangle);
			pointA = Point.build(xMin, yMax);
			pointB = Point.build(xMid, yMid);
			pointC = Point.build(xMax, yMax);
			triangle = Triangle.build(pointA, pointB, pointC);
			putNewPolygonElementOnGElement(field, t, triangle);
			
			t = it.next();
			pointA = Point.build(xMin, yMin);
			pointB = Point.build(xMid, yMid);
			pointC = Point.build(xMin, yMax);
			triangle = Triangle.build(pointA, pointB, pointC);
			putNewPolygonElementOnGElement(field, t, triangle);
			pointA = Point.build(xMax, yMin);
			pointB = Point.build(xMid, yMid);
			pointC = Point.build(xMax, yMax);
			triangle = Triangle.build(pointA, pointB, pointC);
			putNewPolygonElementOnGElement(field, t, triangle);
		}
		else if (divisionName.startsWith(ShieldDivision.GYRONNY)) {
			putNewRectElementOnGElement(field, xMin, yMin, xMax, yMax, it.next());
			Tincture t = it.next();
			final double radPerDivision = 2 * Math.PI / division.getNumberOfSections();
			final double angleB = Math.PI / 2 - radPerDivision;
			final double sinAngleA = Math.sin(radPerDivision);
			final double sinAngleB = Math.sin(angleB);
			final float lengthB = (float) Math.sqrt(Math.pow(xMid,2) + Math.pow(yMid,2));
			final float lengthA = (float) Math.abs(lengthB * sinAngleA / sinAngleB);
			final float yTop = yMid - lengthB;
			Point rPoint = Point.build(xMid, yMid);
			
			for (double rotateBy = 0; rotateBy < 2 * Math.PI; rotateBy += radPerDivision * 2) {
				Point pointA = Point.build(xMid, yTop);
				Point pointB = Point.build(xMid, yMid);
				Point pointC = Point.build(xMid + lengthA, yTop);
				Triangle triangle = Triangle.build(pointA, pointB, pointC);
				triangle = triangle.rotate(rPoint, rotateBy);
				putNewPolygonElementOnGElement(field, t, triangle);
			}
		}
		else {//NONE: default:
			putNewRectElementOnGElement(field, xMin, yMin, xMax, yMax, it.next());
		}
	}

	private void putNewPolygonElementOnGElement(OMSVGGElement field, Tincture t, Triangle triangle) {
		OMSVGSVGElement svgElement = doc.createSVGSVGElement();
		OMSVGPolygonElement polygonElement = doc.createSVGPolygonElement();
		OMSVGPointList points = polygonElement.getPoints();
		for (Point point : triangle.getPoints()) {
			points.appendItem(svgElement.createSVGPoint(point.getX(), point.getY()));
		}
		Point first = triangle.getPoints().iterator().next();;
		points.appendItem(svgElement.createSVGPoint(first.getX(), first.getY()));
		addFillToElement(t, polygonElement);
		field.appendChild(polygonElement);
	}

	private void putNewRectElementOnGElement(OMSVGGElement gElement, int xMin, int yMin, int xMax, int yMax, Tincture t) {
		OMSVGElement element = doc.createSVGRectElement(xMin, yMin, xMax, yMax, 0, 0);
		addFillToElement(t, element);
		gElement.appendChild(element);
	}

	private void addFillToElement(Tincture t, OMSVGElement element) {
		if (t instanceof Fur) {
			FurSVGBuilder furBuilder = AbstractFurSVGBuilder.build(doc, defs, (Fur)t);
			furBuilder.createPatternDefinition();
		}
		element.setAttribute(SVGConstants.CSS_FILL_VALUE, t.getFillText());
	}
}
