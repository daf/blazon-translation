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
import blazon.client.svg.shapes.CubicBezierCurve;
import blazon.client.svg.shapes.Point;
import blazon.client.svg.shapes.RightAngleTriangle;
import blazon.client.svg.shapes.StraightLine;
import blazon.client.svg.shapes.Triangle;
import blazon.shared.shield.*;
import blazon.shared.shield.ShieldDivision.ShieldDivisionType;
import blazon.shared.shield.tinctures.*;

public class ShieldSVGDrawer {
	
	private OMSVGDocument doc;
	private ShieldImpl shield;
	private OMSVGDefsElement defs;

	//TODO refactor to have field drawer
	//LATER reuse elements in chequy etc but translate them to save rendering..?
	public static ShieldSVGDrawer build(ShieldImpl shield, OMSVGDocument doc, OMSVGDefsElement defs) {
		ShieldSVGDrawer drawer = new ShieldSVGDrawer();
		drawer.doc = doc;
		drawer.shield = shield;
		drawer.defs = defs;
		return drawer;
	}

	public void drawSVGShield(OMSVGGElement shieldContainer, CubicBezierCurve bezCurve) {
		OMSVGGElement field = doc.createSVGGElement();
        ShieldLayer base = shield.getField();
    	ShieldDivisionType division = base.getShieldDivision();
    	Tinctures tinctures = base.getTinctures();
    	createElementsForField(division, tinctures, field, bezCurve);
		shieldContainer.appendChild(field);
	}
	
	private void createElementsForField(ShieldDivisionType division,
			Tinctures tinctures, OMSVGGElement field, CubicBezierCurve bezCurve) {
		final int xMax = ShieldDrawing.SHIELD_MAX_X;
		final int yMax = ShieldDrawing.SHIELD_MAX_Y;
		final int xMin = ShieldDrawing.SHIELD_MIN_X;
		final int yMin = ShieldDrawing.SHIELD_MIN_Y;
		final int xMid = ShieldDrawing.SHIELD_MAX_X/2;
		final int yMid = ShieldDrawing.SHIELD_MAX_Y/2;
		Iterator<Tincture> it = tinctures.getTincturesOnLayer().iterator();
		final int numberOfSections = division.getNumberOfSections();
		final String divisionName = division.getName();
		
		if (divisionName.startsWith(ShieldDivision.BARRY) || divisionName.equals(ShieldDivision.TIERCED_FESS) || divisionName.equals(ShieldDivision.FESS)) {
			final int heightOfBar = (int) Math.ceil(yMax / (double) numberOfSections);
			final Tincture[] tincturesOnLayer = tinctures.getTincturesOnLayer().toArray(new Tincture[0]);
			final int numberOfTinctures = division.getNumberOfTinctures();
			
			for (int i = 0; i < numberOfSections; i++) {
				int yPos = i * heightOfBar;
				Tincture currentTincture = tincturesOnLayer[i % numberOfTinctures];
				putNewRectElementOnGElement(field, xMin, yPos, xMax, heightOfBar, currentTincture);
			}
		}
		else if (divisionName.startsWith(ShieldDivision.PALY) || divisionName.equals(ShieldDivision.TIERCED_PALE) || divisionName.equals(ShieldDivision.PALE)) {
			final int widthOfBar = (int) Math.ceil(xMax / (double) numberOfSections);
			final Tincture[] tincturesOnLayer = tinctures.getTincturesOnLayer().toArray(new Tincture[0]);
			final int numberOfTinctures = division.getNumberOfTinctures();
			
			for (int i = 0; i < numberOfSections; i++) {
				int xPos = i * widthOfBar;
				Tincture currentTincture = tincturesOnLayer[i % numberOfTinctures];
				putNewRectElementOnGElement(field, xPos, yMin, widthOfBar, yMax, currentTincture);
			}
		}
		else if (divisionName.equals(ShieldDivision.BEND)){
			Point pointA = Point.build(xMin, yMin);
			Point pointB = Point.build(xMax, yMin);
			Point pointC = Point.build(xMax, yMax);
			RightAngleTriangle triangle = RightAngleTriangle.build(pointA, pointB, pointC);
			putNewPolygonElementOnGElement(field, it.next(), triangle);
			
			pointB = Point.build(xMin, yMax);
			triangle = RightAngleTriangle.build(pointA, pointB, pointC);
			putNewPolygonElementOnGElement(field, it.next(), triangle);
		}
		else if (divisionName.startsWith(ShieldDivision.BENDY) && !divisionName.startsWith(ShieldDivision.BENDY_SINISTER)) {
			Tincture firstTincture = it.next();
			Tincture secondTincture = it.next();
			
			Point curveMidPoint = bezCurve.findMidpointOnCurve();
			StraightLine lineFromTopRightToMidPointOfCurve = StraightLine.build(curveMidPoint, Point.build(xMax, yMin));
			
			final double lengthFromTopRightCornerToMidPointOfCurve = lineFromTopRightToMidPointOfCurve.getLength();
			final double widthOfBendlet = lengthFromTopRightCornerToMidPointOfCurve / numberOfSections;
			
			final Point topCorner = Point.build(xMax, yMin);
			for (int i = numberOfSections; i > 0; i--) {
				double triangleHeight = widthOfBendlet * i;
				float triangleSideLength = (float) Math.sqrt(2 * Math.pow(triangleHeight, 2));
				Point leftCorner = Point.build(xMax - triangleSideLength, yMin);
				Point bottomCorner = Point.build(xMax, triangleSideLength);
				RightAngleTriangle triangle = RightAngleTriangle.build(topCorner, leftCorner, bottomCorner);
				putNewPolygonElementOnGElement(field, i % 2 != 0 ? secondTincture : firstTincture, triangle);
			}
		}
		else if (divisionName.equals(ShieldDivision.BEND_SINISTER)) {
			Point pointA = Point.build(xMin, yMax);
			Point pointB = Point.build(xMin, yMin);
			Point pointC = Point.build(xMax, yMin);
			RightAngleTriangle triangle = RightAngleTriangle.build(pointA, pointB, pointC);
			putNewPolygonElementOnGElement(field, it.next(), triangle);
			pointB = Point.build(xMax, yMax);
			triangle = RightAngleTriangle.build(pointA, pointB, pointC);
			putNewPolygonElementOnGElement(field, it.next(), triangle);
		}
		else if (divisionName.startsWith(ShieldDivision.BENDY_SINISTER)) {
			Tincture firstTincture = it.next();
			Tincture secondTincture = it.next();
			
			Point curveMidPoint = bezCurve.findMidpointOnCurve();
			StraightLine lineFromTopRightToMidPointOfCurve = StraightLine.build(curveMidPoint, Point.build(xMax, yMin));
			
			final double lengthFromTopRightCornerToMidPointOfCurve = lineFromTopRightToMidPointOfCurve.getLength();
			final double widthOfBendlet = lengthFromTopRightCornerToMidPointOfCurve / numberOfSections;
			
			final Point leftCorner = Point.build(xMin, yMin);
			for (int i = numberOfSections; i > 0; i--) {
				double triangleHeight = widthOfBendlet * i;
				float triangleSideLength = (float) Math.sqrt(2 * Math.pow(triangleHeight, 2));
				Point rightCorner = Point.build(triangleSideLength, yMin);
				Point bottomCorner = Point.build(xMin, triangleSideLength);
				RightAngleTriangle triangle = RightAngleTriangle.build(rightCorner, leftCorner, bottomCorner);
				putNewPolygonElementOnGElement(field, i % 2 != 0 ? secondTincture : firstTincture, triangle);
			}
		}
		else if (divisionName.equals(ShieldDivision.CHEVRON)) {
			putNewRectElementOnGElement(field, xMin, yMin, xMax, yMax, it.next());
			Point pointA = Point.build(xMin, yMax);
			Point pointB = Point.build(xMid, yMid);
			Point pointC = Point.build(xMax, yMax);
			RightAngleTriangle triangle = RightAngleTriangle.build(pointA, pointB, pointC);
			putNewPolygonElementOnGElement(field, it.next(), triangle);
		}
		else if (divisionName.startsWith(ShieldDivision.CHEVRONNY) && !divisionName.startsWith(ShieldDivision.CHEVRONNY_REVERSED)) {
			Tincture firstTincture = it.next();
			Tincture secondTincture = it.next();
			
			Point topPoint;
			Point leftPoint;
			Point rightPoint;
			
			for (int i = numberOfSections; i > 0; i--) {
				float topYCoor = yMax - (1.5f * i * yMax / numberOfSections);
				float triangleWidth = 3f * i * xMax / numberOfSections;
				float rightXCoor = xMax + (triangleWidth - xMax) / 2;
				float leftXCoor = xMin - (triangleWidth - xMax) / 2;
				topPoint = Point.build(xMid, topYCoor);
				leftPoint = Point.build(leftXCoor, yMax);
				rightPoint = Point.build(rightXCoor, yMax);
				RightAngleTriangle triangle = RightAngleTriangle.build(topPoint, leftPoint, rightPoint);
				putNewPolygonElementOnGElement(field, i % 2 != 0 ? secondTincture : firstTincture, triangle);
			}
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
		else if (divisionName.startsWith(ShieldDivision.CHEVRONNY_REVERSED)) {
			Tincture firstTincture = it.next();
			Tincture secondTincture = it.next();
			
			StraightLine tangent = bezCurve.getTangentToCurveAtMidpoint();
			final double largestTriangleHeight = tangent.getYCoordinateWhenXIsKnown(xMid);
			final double largestTriangleWidth = (Math.abs(tangent.getXCoordinateWhenYIsKnown(yMin)) * 2) + xMax;
			
			for (int i = numberOfSections; i > 0; i--) {
				double tWidth = largestTriangleWidth * i / numberOfSections;
				double tHeight = largestTriangleHeight * i / numberOfSections;
				double leftXCoor = xMin - (tWidth - xMax) / 2;
				double rightXCoor = xMax + (tWidth - xMax) / 2;
				Point leftPoint = Point.build((float) leftXCoor, 0);
				Point rightPoint = Point.build((float) rightXCoor, 0);
				Point bottomPoint = Point.build(200, (float) tHeight);
				Triangle triangle = Triangle.build(bottomPoint, leftPoint, rightPoint);
				putNewPolygonElementOnGElement(field, i % 2 != 0 ? secondTincture : firstTincture, triangle);
			}
		}
		else if (divisionName.equals(ShieldDivision.PALL)) {
			Tincture t = it.next();
			putNewRectElementOnGElement(field, xMin, yMin, xMid, yMax, it.next());
			putNewRectElementOnGElement(field, xMid, yMin, xMid, yMax, it.next());
			Point pointA = Point.build(xMin, yMin);
			Point pointB = Point.build(xMid, yMid);
			Point pointC = Point.build(xMax, yMin);
			RightAngleTriangle triangle = RightAngleTriangle.build(pointA, pointB, pointC);
			putNewPolygonElementOnGElement(field, t, triangle);
		}
		else if (divisionName.equals(ShieldDivision.PALL_REVERSED)) {
			putNewRectElementOnGElement(field, xMin, yMin, xMid, yMax, it.next());
			putNewRectElementOnGElement(field, xMid, yMin, xMid, yMax, it.next());
			Point pointA = Point.build(xMin, yMax);
			Point pointB = Point.build(xMid, yMid);
			Point pointC = Point.build(xMax, yMax);
			RightAngleTriangle triangle = RightAngleTriangle.build(pointA, pointB, pointC);
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
			RightAngleTriangle triangle = RightAngleTriangle.build(pointA, pointB, pointC);
			putNewPolygonElementOnGElement(field, t, triangle);
			pointA = Point.build(xMin, yMax);
			pointC = Point.build(xMax, yMax);
			triangle = RightAngleTriangle.build(pointA, pointB, pointC);
			putNewPolygonElementOnGElement(field, t, triangle);
			
			t = it.next();
			pointA = Point.build(xMin, yMin);
			pointC = Point.build(xMin, yMax);
			triangle = RightAngleTriangle.build(pointA, pointB, pointC);
			putNewPolygonElementOnGElement(field, t, triangle);
			pointA = Point.build(xMax, yMin);
			pointC = Point.build(xMax, yMax);
			triangle = RightAngleTriangle.build(pointA, pointB, pointC);
			putNewPolygonElementOnGElement(field, t, triangle);
		}
		else if (divisionName.startsWith(ShieldDivision.GYRONNY)) {
			final Tincture firstTincture = it.next();
			final Tincture secondTincture = it.next();
			final double radPerDivision = 2 * Math.PI / numberOfSections;
			final double angleB = Math.PI / 2 - radPerDivision;
			final double sinAngleA = Math.sin(radPerDivision);
			final double sinAngleB = Math.sin(angleB);
			final float lengthB = (float) Math.sqrt(Math.pow(xMid,2) + Math.pow(yMid,2));
			final float lengthA = (float) Math.abs(lengthB * sinAngleA / sinAngleB);
			final float yTop = yMid - lengthB;
			final Point rPoint = Point.build(xMid, yMid);
			
			for (int i = 0; i < numberOfSections; i++) {
				double rotateBy = radPerDivision * i;
				Point pointA = Point.build(xMid, yTop);
				Point pointB = Point.build(xMid, yMid);
				Point pointC = Point.build(xMid + lengthA, yTop);
				Triangle triangle = Triangle.build(pointA, pointB, pointC);
				triangle = triangle.rotate(rPoint, rotateBy);
				putNewPolygonElementOnGElement(field, i % 2 != 0 ? firstTincture : secondTincture, triangle);
			}
		}
		else if (divisionName.equals(ShieldDivision.CHEQUY)) {
			final Tincture firstTincture = it.next();
			final Tincture secondTincture = it.next();
			int rootOfNumberOfSectionsRoundedToPerfectSquare = (int)Math.sqrt(numberOfSections) + 1;
			final int heightOfRect = (int) Math.ceil(yMax / (double) rootOfNumberOfSectionsRoundedToPerfectSquare);
			final int widthOfRect = (int) Math.ceil(xMax / (double) rootOfNumberOfSectionsRoundedToPerfectSquare);
			
			for (int i = 0; i < rootOfNumberOfSectionsRoundedToPerfectSquare; i++) {
				for (int j = 0; j < rootOfNumberOfSectionsRoundedToPerfectSquare; j++) {
					int xPos = i * widthOfRect;
					int yPos = j * heightOfRect;
					Tincture currentTincture = (i % 2 == j % 2) ? firstTincture : secondTincture;
					putNewRectElementOnGElement(field, xPos, yPos, widthOfRect, heightOfRect, currentTincture);
				}
			}
		}
		else if (divisionName.equals(ShieldDivision.LOZENGY)) {
			//FIXME draw lozengy
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
		Point first = triangle.getPoints().iterator().next();
		points.appendItem(svgElement.createSVGPoint(first.getX(), first.getY()));
		addFillToElement(t, polygonElement);
		field.appendChild(polygonElement);
	}

	private void putNewRectElementOnGElement(OMSVGGElement gElement, int xMin, int yMin, int width, int height, Tincture t) {
		OMSVGElement element = doc.createSVGRectElement(xMin, yMin, width, height, 0, 0);
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
