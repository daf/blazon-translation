package blazon.client.drawing.charges.geometric;

import java.util.List;

import org.vectomatic.dom.svg.OMSVGDefsElement;
import org.vectomatic.dom.svg.OMSVGGElement;

import blazon.client.drawing.shapes.CubicBezierCurve;
import blazon.client.drawing.shapes.Point;
import blazon.client.drawing.shapes.Polygon;
import blazon.client.drawing.shapes.PolygonImpl;
import blazon.shared.shield.charges.GeometricCharge;
import blazon.shared.shield.diagnostic.ShieldDiagnostic;
import blazon.shared.shield.diagnostic.ShieldDiagnostic.LogLevel;
import blazon.shared.shield.tinctures.Tincture;

public class SVGBendletSinisterDrawer extends SVGOrdinaryDrawer {

	protected SVGBendletSinisterDrawer(GeometricCharge charge, OMSVGDefsElement defs, List<ShieldDiagnostic> diags, int shieldWidth, int shieldHeight, int occurrences) {
		super(charge, defs, diags, shieldWidth, shieldHeight, occurrences);
	}

	@Override
	public OMSVGGElement drawOrdinary(CubicBezierCurve curve) {
		final float chargeSize = xMax/20f;
		final float chargeSideLength = (float) Math.sqrt(2 * Math.pow(chargeSize, 2));
		final float chargeXLength = (float) (xMax - Math.sqrt((Math.pow(chargeSideLength, 2) + (3*Math.pow(yMax, 2)) - Math.pow(xMax, 2)) / 4))/2;
		final float chargeYLength = (float) (yMax - Math.sqrt((Math.pow(chargeSideLength, 2) + (3*Math.pow(xMax, 2)) - Math.pow(yMax, 2)) / 4))/2;
		OMSVGGElement ordinaries = doc.createSVGGElement();
		Polygon polygon;
		Tincture tincture = charge.getTincture();

		float offsetX = (occurrences%2 == 0) ? xMax/30f : 0;
		float offsetY = (occurrences%2 == 0) ? yMax/30f : 0;
		
		switch(occurrences) {
		case 1:
			polygon = middleBendlet(chargeSideLength);
			putNewPolygonElementOnGElement(ordinaries, tincture, polygon);
			break;
		case 2:
			drawPair(chargeXLength, chargeYLength, ordinaries, offsetX, offsetY, tincture);
			break;
		case 3:
			polygon = middleBendlet(chargeSideLength);
			putNewPolygonElementOnGElement(ordinaries, tincture, polygon);offsetX += chargeXLength;
			offsetY += chargeYLength;
			drawPair(chargeXLength, chargeYLength, ordinaries, offsetX, offsetY, tincture);
			break;
		case 4:
			drawPair(chargeXLength, chargeYLength, ordinaries, offsetX, offsetY, tincture);
			offsetX += chargeXLength + chargeSideLength;
			offsetY += chargeYLength + chargeSideLength;
			drawPair(chargeXLength, chargeYLength, ordinaries, offsetX, offsetY, tincture);
			break;
		default:
				diags.add(ShieldDiagnostic.build(LogLevel.ERROR, "SVGBebdletSinisterDrawer only knows how to draw 1 to 4 bendlets."));

		}

		return ordinaries;
	}

	private void drawPair(final float chargeXLength, final float chargeYLength,
			OMSVGGElement ordinaries, float offsetX, float offsetY, Tincture tincture) {
		Polygon polygon;
		polygon = new PolygonImpl(
				new Point(xMin+offsetX, yMax), new Point(xMin+offsetX+chargeXLength, yMax),
				new Point(xMax, yMin+offsetY+chargeYLength), new Point(xMax, yMin+offsetY));
		putNewPolygonElementOnGElement(ordinaries, tincture, polygon);
		polygon = new PolygonImpl(
				new Point(xMin, yMax-offsetY), new Point(xMin, yMax-offsetY-chargeYLength),
				new Point(xMax-offsetX-chargeXLength, yMin), new Point(xMax-offsetX, yMin));
		putNewPolygonElementOnGElement(ordinaries, tincture, polygon);
	}

	private Polygon middleBendlet(final float chargeSideLength) {
		Polygon polygon;
		polygon = new PolygonImpl(
				new Point(xMax, yMin+chargeSideLength), new Point(xMax, yMin), new Point(xMax-chargeSideLength, yMin), 
				new Point(xMin, yMax-chargeSideLength), new Point(xMin, yMax), new Point(xMin+chargeSideLength, yMax));
		return polygon;
	}


}
