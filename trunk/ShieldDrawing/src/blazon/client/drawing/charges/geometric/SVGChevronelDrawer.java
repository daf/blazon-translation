package blazon.client.drawing.charges.geometric;

import org.vectomatic.dom.svg.OMSVGDefsElement;
import org.vectomatic.dom.svg.OMSVGGElement;

import blazon.client.drawing.shapes.CubicBezierCurve;
import blazon.client.drawing.shapes.Point;
import blazon.client.drawing.shapes.Polygon;
import blazon.client.drawing.shapes.PolygonImpl;
import blazon.shared.shield.charges.GeometricCharge;

public class SVGChevronelDrawer extends SVGOrdinaryDrawer {

	protected SVGChevronelDrawer(GeometricCharge charge, OMSVGDefsElement defs,	int shieldWidth, int shieldHeight, int occurrences) {
		super(charge, defs, shieldWidth, shieldHeight, occurrences);
	}

	@Override
	public OMSVGGElement drawOrdinary(CubicBezierCurve curve) {
		OMSVGGElement ordinaries = doc.createSVGGElement();
		final float xMid = xMax/2f;
		final float yMid = yMax/2f;
		final float chargeSize = xMax/20f;
		final float chargeSideLength = (float) Math.sqrt(2 * Math.pow(chargeSize, 2));
		final float chargeLengthX = (float) (xMax - Math.sqrt((Math.pow(chargeSideLength, 2) + (3*Math.pow(yMax, 2)) - Math.pow(xMax, 2)) / 4))/2;
		final float chargeLengthY = (float) (yMax - Math.sqrt((Math.pow(chargeSideLength, 2) + (3*Math.pow(xMax, 2)) - Math.pow(yMax, 2)) / 4))/2;
		float offsetY = yMax/30f;
		float offsetX = xMax/30f;

		Polygon polygon;

		switch (occurrences) {
		
			case 1:
				polygon = middleChevronel(xMid, yMid, chargeSideLength);
			    putNewPolygonElementOnGElement(ordinaries, charge.getTincture(), polygon);
				break;
			case 2:
				drawPair(ordinaries, xMid, yMid, chargeLengthX, chargeLengthY, offsetY, offsetX);
				break;
			case 3:
			    polygon = middleChevronel(xMid, yMid, chargeSideLength);
			    putNewPolygonElementOnGElement(ordinaries, charge.getTincture(), polygon);
				offsetX += chargeLengthX;
				offsetY += chargeLengthY;
				drawPair(ordinaries, xMid, yMid, chargeLengthX, chargeLengthY, offsetY, offsetX);
				break;
			case 4:
				drawPair(ordinaries, xMid, yMid, chargeLengthX, chargeLengthY, offsetY, offsetX);
				offsetX += chargeLengthX + chargeSideLength;
				offsetY += chargeLengthY + chargeSideLength;
				drawPair(ordinaries, xMid, yMid, chargeLengthX, chargeLengthY, offsetY, offsetX);
				break;
			default:
				//TODO add errors
		}
		
		
	    return ordinaries;
	}

	private void drawPair(OMSVGGElement ordinaries, final float xMid,
			final float yMid, final float chargeLengthX,
			final float chargeLengthY, float offsetY, float offsetX) {
		Polygon polygon;
		polygon = new PolygonImpl(
				new Point(xMax, yMax-offsetY), new Point(xMax, yMax-chargeLengthY-offsetY),
				new Point(xMid, yMid-offsetY-chargeLengthY),
				new Point(xMin, yMax-chargeLengthY-offsetY), new Point(xMin, yMax-offsetY),
				new Point(xMid, yMid-offsetY));
		putNewPolygonElementOnGElement(ordinaries, charge.getTincture(), polygon);
		polygon = new PolygonImpl(
				new Point(xMax-offsetX, yMax), new Point(xMax-offsetX-chargeLengthX, yMax), 
				new Point(xMid, yMid+offsetY+chargeLengthY),
				new Point(xMin+chargeLengthX+offsetX, yMax), new Point(xMin+offsetX, yMax), 
				new Point(xMid, yMid+offsetY));
		putNewPolygonElementOnGElement(ordinaries, charge.getTincture(), polygon);
	}

	private Polygon middleChevronel(final float xMid, final float yMid,
			final float chargeSideLength) {
		Polygon polygon;
		polygon = new PolygonImpl(
				new Point(xMax, yMax-chargeSideLength), new Point(xMax, yMax), new Point(xMax-chargeSideLength, yMax),
				new Point(xMid, yMid+chargeSideLength),
				new Point(xMin+chargeSideLength, yMax), new Point(xMin, yMax),	new Point(xMin, yMax-chargeSideLength),
				new Point(xMid, yMid-chargeSideLength));
		return polygon;
	}
}
