package blazon.client.drawing.charges.geometric;

import org.vectomatic.dom.svg.OMSVGDefsElement;
import org.vectomatic.dom.svg.OMSVGGElement;

import blazon.client.drawing.shapes.CubicBezierCurve;
import blazon.client.drawing.shapes.Point;
import blazon.client.drawing.shapes.Polygon;
import blazon.client.drawing.shapes.PolygonImpl;
import blazon.shared.shield.charges.GeometricCharge;


public class SVGBendletDrawer extends SVGOrdinaryDrawer {

	protected SVGBendletDrawer(GeometricCharge charge, OMSVGDefsElement defs, int shieldWidth, int shieldHeight, int occurrences) {
		super(charge, defs, shieldWidth, shieldHeight, occurrences);
	}

	@Override
	public OMSVGGElement drawOrdinary(CubicBezierCurve curve) {
		final float chargeSize = xMax/20f;
		final float chargeSideLength = (float) Math.sqrt(2 * Math.pow(chargeSize, 2));
		final float chargeXLength = (float) (xMax - Math.sqrt((Math.pow(chargeSideLength, 2) + (3*Math.pow(yMax, 2)) - Math.pow(xMax, 2)) / 4))/2;
		final float chargeYLength = (float) (yMax - Math.sqrt((Math.pow(chargeSideLength, 2) + (3*Math.pow(xMax, 2)) - Math.pow(yMax, 2)) / 4))/2;
		OMSVGGElement ordinaries = doc.createSVGGElement();
		Polygon polygon;
		float offsetX = (occurrences%2 == 0) ? xMax/30f : 0;
		float offsetY = (occurrences%2 == 0) ? yMax/30f : 0;
		
		switch(occurrences) {
		case 1:
			polygon = middleBendlet(chargeSideLength);
			putNewPolygonElementOnGElement(ordinaries, charge.getTincture(), polygon);
			break;
		case 2:
			drawPair(chargeXLength, chargeYLength, ordinaries, offsetX, offsetY);
			break;
		case 3:
			polygon = middleBendlet(chargeSideLength);
			putNewPolygonElementOnGElement(ordinaries, charge.getTincture(), polygon);
			offsetX += chargeXLength;
			offsetY += chargeYLength;
			drawPair(chargeXLength, chargeYLength, ordinaries, offsetX, offsetY);
			break;
		case 4:
			drawPair(chargeXLength, chargeYLength, ordinaries, offsetX, offsetY);
			offsetX += chargeXLength + chargeSideLength;
			offsetY += chargeYLength + chargeSideLength;
			drawPair(chargeXLength, chargeYLength, ordinaries, offsetX, offsetY);
			break;
		default:
				//TODO give errors
		}

		return ordinaries;
	}

	private void drawPair(final float chargeXLength, final float chargeYLength,
			OMSVGGElement ordinaries, float offsetX, float offsetY) {
		Polygon polygon;
		polygon = new PolygonImpl(
				new Point(xMin+offsetX, yMin), new Point(xMin+offsetX+chargeXLength, yMin),
				new Point(xMax, yMax-offsetY-chargeYLength), new Point(xMax, yMax-offsetY));
		putNewPolygonElementOnGElement(ordinaries, charge.getTincture(), polygon);
		polygon = new PolygonImpl(
				new Point(xMin, yMin+offsetY), new Point(xMin, yMin+offsetY+chargeYLength),
				new Point(xMax-offsetX-chargeXLength, yMax), new Point(xMax-offsetX, yMax));
		putNewPolygonElementOnGElement(ordinaries, charge.getTincture(), polygon);
	}

	private Polygon middleBendlet(final float chargeSideLength) {
		Polygon polygon;
		polygon = new PolygonImpl(
				new Point(xMin, yMin+chargeSideLength), new Point(xMin, yMin), new Point(xMin+chargeSideLength, yMin), 
				new Point(xMax, yMax-chargeSideLength), new Point(xMax, yMax), new Point(xMax-chargeSideLength, yMax));
		return polygon;
	}
}