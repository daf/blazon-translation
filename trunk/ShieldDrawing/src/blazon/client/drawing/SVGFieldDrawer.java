package blazon.client.drawing;

import java.util.Iterator;

import org.vectomatic.dom.svg.OMSVGDefsElement;
import org.vectomatic.dom.svg.OMSVGDocument;
import org.vectomatic.dom.svg.OMSVGElement;
import org.vectomatic.dom.svg.OMSVGGElement;
import org.vectomatic.dom.svg.OMSVGPointList;
import org.vectomatic.dom.svg.OMSVGPolygonElement;
import org.vectomatic.dom.svg.OMSVGSVGElement;
import org.vectomatic.dom.svg.utils.OMSVGParser;
import org.vectomatic.dom.svg.utils.SVGConstants;

import blazon.client.drawing.shapes.CubicBezierCurve;
import blazon.client.drawing.shapes.FourPointedPolygon;
import blazon.client.drawing.shapes.Point;
import blazon.client.drawing.shapes.Polygon;
import blazon.client.drawing.shapes.RightAngleTriangle;
import blazon.client.drawing.shapes.StraightLine;
import blazon.client.drawing.shapes.Triangle;
import blazon.client.drawing.shield.fur.AbstractFurSVGBuilder;
import blazon.client.drawing.shield.fur.FurSVGBuilder;
import blazon.shared.shield.*;
import blazon.shared.shield.ShieldDivision.ShieldDivisionType;
import blazon.shared.shield.tinctures.*;

public class SVGFieldDrawer {
	
	private final OMSVGDocument doc = OMSVGParser.currentDocument();
	private final ShieldImpl shield;
	private final OMSVGDefsElement defs;
	private final int xMax;
	private final int xMin;
	private final int yMax;
	private final int yMin;

	public SVGFieldDrawer(ShieldImpl shield, OMSVGDefsElement defs, final int shieldWidth, final int shieldHeight) {
		this.shield = shield;
		this.defs = defs;
		this.xMax = shieldWidth;
		this.yMax = shieldHeight;
		this.xMin = 0;
		this.yMin = 0;
	}

	public void drawField(OMSVGGElement shieldContainer, CubicBezierCurve bezCurve) {
		shieldContainer.appendChild(createField(shield.getField(), bezCurve));
	}
	
	private OMSVGGElement createField(ShieldLayer base, CubicBezierCurve bezCurve) {
		final OMSVGGElement field = doc.createSVGGElement();
		final int xMid = xMax/2;
		final int yMid = yMax/2;
		final ShieldDivisionType division = base.getShieldDivision();
    	final int numberOfSections = division.getNumberOfSections();
		final String divisionName = division.getName();
		final Tinctures tinctures = base.getTinctures();
		final Iterator<Tincture> it = tinctures.getTincturesOnLayer().iterator();
		
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
		else if (divisionName.equals(ShieldDivision.BEND) || divisionName.equals(ShieldDivision.BEND_SINISTER)) {
			RightAngleTriangle triangle = null;
			Point pointA, pointB, pointC;
			if (divisionName.equals(ShieldDivision.BEND)) {
				pointA = new Point(xMin, yMin);
				pointB = new Point(xMax, yMin);
				pointC = new Point(xMax, yMax);
			} else {
				pointA = new Point(xMin, yMax);
				pointB = new Point(xMin, yMin);
				pointC = new Point(xMax, yMin);
			}
			triangle = new RightAngleTriangle(pointA, pointB, pointC);
			putNewPolygonElementOnGElement(field, it.next(), triangle);
			pointB = (divisionName.equals(ShieldDivision.BEND)) ? new Point(xMin, yMax) : new Point(xMax, yMax);
			triangle = new RightAngleTriangle(pointA, pointB, pointC);
			putNewPolygonElementOnGElement(field, it.next(), triangle);
		}
		else if (divisionName.startsWith(ShieldDivision.BENDY)) {
			Tincture firstTincture = it.next();
			Tincture secondTincture = it.next();
			Point curveMidPoint = bezCurve.findMidpointOnCurve();
			StraightLine lineFromTopRightToMidPointOfCurve = new StraightLine(curveMidPoint, new Point(xMax, yMin));
			final double lengthFromTopRightCornerToMidPointOfCurve = lineFromTopRightToMidPointOfCurve.getLength();
			final double widthOfBendlet = lengthFromTopRightCornerToMidPointOfCurve / numberOfSections;
			
			if (divisionName.startsWith(ShieldDivision.BENDY_SINISTER)) {
				final Point leftCorner = new Point(xMin, yMin);
				for (int i = numberOfSections; i > 0; i--) {
					double triangleHeight = widthOfBendlet * i;
					float triangleSideLength = (float) Math.sqrt(2 * Math.pow(triangleHeight, 2));
					Point rightCorner = new Point(triangleSideLength, yMin);
					Point bottomCorner = new Point(xMin, triangleSideLength);
					RightAngleTriangle triangle = new RightAngleTriangle(rightCorner, leftCorner, bottomCorner);
					putNewPolygonElementOnGElement(field, i % 2 != 0 ? secondTincture : firstTincture, triangle);
				}
			} else {
				final Point topCorner = new Point(xMax, yMin);
				for (int i = numberOfSections; i > 0; i--) {
					double triangleHeight = widthOfBendlet * i;
					float triangleSideLength = (float) Math.sqrt(2 * Math.pow(triangleHeight, 2));
					Point leftCorner = new Point(xMax - triangleSideLength, yMin);
					Point bottomCorner = new Point(xMax, triangleSideLength);
					RightAngleTriangle triangle = new RightAngleTriangle(topCorner, leftCorner, bottomCorner);
					putNewPolygonElementOnGElement(field, i % 2 != 0 ? secondTincture : firstTincture, triangle);
				}
			}
		}
		else if (divisionName.equals(ShieldDivision.CHEVRON) || divisionName.equals(ShieldDivision.CHEVRON_REVERSED)) {
			Point pointB = new Point(xMid, yMid);
			Point pointA, pointC;
			Tincture firstTincture = it.next();
			Tincture secondTincture = it.next();
			if (divisionName.equals(ShieldDivision.CHEVRON)) {
				putNewRectElementOnGElement(field, xMin, yMin, xMax, yMax, firstTincture);
				pointA = new Point(xMin, yMax);
				pointC = new Point(xMax, yMax);
				Triangle triangle = new RightAngleTriangle(pointA, pointB, pointC);
				putNewPolygonElementOnGElement(field, secondTincture, triangle);
			} else {
				putNewRectElementOnGElement(field, xMin, yMin, xMax, yMax, secondTincture);
				pointA = new Point(xMin, yMin);
				pointC = new Point(xMax, yMin);
				Triangle triangle = new Triangle(pointA, pointB, pointC);
				putNewPolygonElementOnGElement(field, firstTincture, triangle);
			}
		}
		else if (divisionName.startsWith(ShieldDivision.CHEVRONNY) && !divisionName.startsWith(ShieldDivision.CHEVRONNY_REVERSED)) {
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
				putNewPolygonElementOnGElement(field, i % 2 != 0 ? secondTincture : firstTincture, triangle);
			}
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
				Point leftPoint = new Point((float) leftXCoor, 0);
				Point rightPoint = new Point((float) rightXCoor, 0);
				Point bottomPoint = new Point(200, (float) tHeight);
				Polygon triangle = new Triangle(bottomPoint, leftPoint, rightPoint);
				putNewPolygonElementOnGElement(field, i % 2 != 0 ? secondTincture : firstTincture, triangle);
			}
		}
		else if (divisionName.startsWith(ShieldDivision.PALL)) {
			Point pointB = new Point(xMid, yMid);
			Tincture t = it.next();
			Point pointA = null, pointC = null;
			if (divisionName.equals(ShieldDivision.PALL)) {
				putNewRectElementOnGElement(field, xMin, yMin, xMid, yMax, it.next());
				putNewRectElementOnGElement(field, xMid, yMin, xMid, yMax, it.next());
				pointA = new Point(xMin, yMin);
				pointC = new Point(xMax, yMin);
			}
			else if (divisionName.equals(ShieldDivision.PALL_REVERSED)) {
				putNewRectElementOnGElement(field, xMin, yMin, xMid, yMax, t);
				putNewRectElementOnGElement(field, xMid, yMin, xMid, yMax, it.next());
				pointA = new Point(xMin, yMax);
				pointC = new Point(xMax, yMax);
				t = it.next();
			}
			RightAngleTriangle triangle = new RightAngleTriangle(pointA, pointB, pointC);
			putNewPolygonElementOnGElement(field, t, triangle);
		}
		else if (divisionName.equals(ShieldDivision.CROSS)) {
			Tincture firstTincture = it.next();
			Tincture secondTincture = it.next();
			putNewRectElementOnGElement(field, xMin, yMin, xMid, xMid, firstTincture);
			putNewRectElementOnGElement(field, xMid, yMid, xMid, yMid, firstTincture);
			putNewRectElementOnGElement(field, xMin, yMid, xMid, yMid, secondTincture);
			putNewRectElementOnGElement(field, xMid, yMin, xMid, yMid, secondTincture);			
		}
		else if (divisionName.equals(ShieldDivision.SALTIRE)) {
			Point pointB = new Point(xMid, yMid);
			for (int i = 0; i < 2; i++) {
				Tincture t = it.next();
				Point pointA = new Point(xMin, yMin);
				Point pointC = (i == 0) ? new Point(xMax, yMin) : new Point(xMin, yMax);;
				RightAngleTriangle triangle = new RightAngleTriangle(pointA, pointB, pointC);
				putNewPolygonElementOnGElement(field, t, triangle);
				pointA = (i == 0) ? new Point(xMin, yMax) : new Point(xMax, yMin);
				pointC = new Point(xMax, yMax);
				triangle = new RightAngleTriangle(pointA, pointB, pointC);
				putNewPolygonElementOnGElement(field, t, triangle);
			}
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
			final Point pointA = new Point(xMid, yTop);
			final Point pointB = new Point(xMid, yMid);
			final Point pointC = new Point(xMid + lengthA, yTop);
			final Triangle triangle = new RightAngleTriangle(pointA, pointB, pointC);
			final Point rPoint = new Point(xMid, yMid);
			
			for (int i = 0; i < numberOfSections; i++) {
				double rotateBy = radPerDivision * i;
				Triangle rotatedTriangle = triangle.rotate(rPoint, rotateBy);
				putNewPolygonElementOnGElement(field, i % 2 != 0 ? firstTincture : secondTincture, rotatedTriangle);
			}
		}
		else if (divisionName.equals(ShieldDivision.CHEQUY)) {
			final Tincture firstTincture = it.next();
			final Tincture secondTincture = it.next();
			final double rootOfNumberOfSectionsRoundedToPerfectSquare = Math.ceil(Math.sqrt(numberOfSections));
			final int heightOfRect = (int) Math.ceil(yMax / rootOfNumberOfSectionsRoundedToPerfectSquare);
			final int widthOfRect = (int) Math.ceil(xMax / rootOfNumberOfSectionsRoundedToPerfectSquare);
			
			for (int i = 0; i < rootOfNumberOfSectionsRoundedToPerfectSquare; i++) {
				int xPos = i * widthOfRect;
				for (int j = 0; j < rootOfNumberOfSectionsRoundedToPerfectSquare; j++) {
					int yPos = j * heightOfRect;
					Tincture currentTincture = (i % 2 == j % 2) ? firstTincture : secondTincture;
					putNewRectElementOnGElement(field, xPos, yPos, widthOfRect, heightOfRect, currentTincture);
				}
			}
		}
		else if (divisionName.equals(ShieldDivision.LOZENGY)) {
			final Tincture firstTincture = it.next();
			final Tincture secondTincture = it.next();
			final double rootOfNumberOfSectionsRoundedToPerfectSquare = Math.ceil(Math.sqrt(numberOfSections));
			final int heightOfLozenge = (int) Math.ceil(yMax / rootOfNumberOfSectionsRoundedToPerfectSquare);
			final int widthOfLozenge = (int) Math.ceil(xMax / rootOfNumberOfSectionsRoundedToPerfectSquare);
			final float halfWidthOfLozenge = widthOfLozenge / 2f;
			final float halfHeightOfLozenge = heightOfLozenge / 2f;
			
			for (int i = 0; i <= rootOfNumberOfSectionsRoundedToPerfectSquare; i++) {
				for (int j = 0; j <= rootOfNumberOfSectionsRoundedToPerfectSquare; j++) {
					float xPos = (i * widthOfLozenge) - halfWidthOfLozenge;
					float yPos = (j * heightOfLozenge) - halfHeightOfLozenge;
					Polygon polygon = new FourPointedPolygon(new Point(xPos, yPos), new Point(xPos + widthOfLozenge, yPos), new Point(xPos, yPos + heightOfLozenge), new Point(xPos + widthOfLozenge, yPos + heightOfLozenge));
					putNewPolygonElementOnGElement(field, firstTincture, polygon);
					xPos += halfWidthOfLozenge;
					yPos += halfHeightOfLozenge;
					polygon = new FourPointedPolygon(new Point(xPos, yPos), new Point(xPos + widthOfLozenge, yPos), new Point(xPos, yPos + heightOfLozenge), new Point(xPos + widthOfLozenge, yPos + heightOfLozenge));
					putNewPolygonElementOnGElement(field, secondTincture, polygon);
				}
			}
		}
		else {//NONE: default:
			putNewRectElementOnGElement(field, xMin, yMin, xMax, yMax, it.next());
		}
		
		return field;
	}

	private void putNewPolygonElementOnGElement(OMSVGGElement field, Tincture t, Polygon polygon) {
		OMSVGSVGElement svgElement = doc.createSVGSVGElement();
		OMSVGPolygonElement polygonElement = doc.createSVGPolygonElement();
		OMSVGPointList points = polygonElement.getPoints();
		for (Point point : polygon.getPoints()) {
			points.appendItem(svgElement.createSVGPoint(point.getX(), point.getY()));
		}
		Point first = polygon.getPoints().iterator().next();
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
			FurSVGBuilder furBuilder = AbstractFurSVGBuilder.build(defs, (Fur)t);
			furBuilder.createPatternDefinition();
		}
		element.setAttribute(SVGConstants.CSS_FILL_VALUE, t.getFillText());
	}
}
