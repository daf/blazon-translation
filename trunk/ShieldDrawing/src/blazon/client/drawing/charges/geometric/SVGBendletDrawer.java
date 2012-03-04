package blazon.client.drawing.charges.geometric;

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


public class SVGBendletDrawer extends SVGGeometricChargeDrawer {

	protected SVGBendletDrawer(GeometricCharge charge, OMSVGDefsElement defs, float shieldWidth, float shieldHeight, int occurrences) {
		super(charge, defs, shieldWidth, shieldHeight, occurrences);
	}

	@Override
	public OMSVGGElement drawCharge(CubicBezierCurve curve) {
		final float chargeXSize = getXDiff()/20f;
		final float chargeYSize = getYDiff()/20f;
		final float chargeXSideLength = (float) Math.sqrt(2 * Math.pow(chargeXSize, 2));
		final float chargeYSideLength = (float) Math.sqrt(2 * Math.pow(chargeYSize, 2));
		final float chargeXLength = (float) (getXDiff() - Math.sqrt((Math.pow(chargeXSideLength, 2) + (3*Math.pow(getXDiff(), 2)) - Math.pow(getXDiff(), 2)) / 4))/2;
		final float chargeYLength = (float) (getYDiff() - Math.sqrt((Math.pow(chargeYSideLength, 2) + (3*Math.pow(getYDiff(), 2)) - Math.pow(getYDiff(), 2)) / 4))/2;
		Polygon polygon;
		OMSVGGElement ordinaries = doc.createSVGGElement();
		Tincture tincture = charge.getTincture();
		float offsetX = (occurrences % 2 == 0) ? getXDiff()/30f : 0;
		float offsetY = (occurrences % 2 == 0) ? getYDiff()/30f : 0;
		
		switch(occurrences) {
		case 1:
			polygon = middleBendlet(chargeXSideLength, chargeYSideLength);
			putNewPolygonElementOnGElement(ordinaries, tincture, polygon);
			break;
		case 2:
			drawPair(chargeXLength, chargeYLength, ordinaries, offsetX, offsetY, tincture);
			break;
		case 3:
			polygon = middleBendlet(chargeXSideLength, chargeYSideLength);
			putNewPolygonElementOnGElement(ordinaries, tincture, polygon);
			offsetX += chargeXLength;
			offsetY += chargeYLength;
			drawPair(chargeXLength, chargeYLength, ordinaries, offsetX, offsetY, tincture);
			break;
		case 4:
			drawPair(chargeXLength, chargeYLength, ordinaries, offsetX, offsetY, tincture);
			offsetX += chargeXLength + chargeXSideLength;
			offsetY += chargeYLength + chargeYSideLength;
			drawPair(chargeXLength, chargeYLength, ordinaries, offsetX, offsetY, tincture);
			break;
		default:
			diags.add(ShieldDiagnostic.build(LogLevel.ERROR, "SVGBendletDrawer only knows how to draw 1 to 4 bendlets."));
		}
		return ordinaries;
	}

	private void drawPair(final float chargeXLength, final float chargeYLength, OMSVGGElement ordinaries, float offsetX, float offsetY, Tincture tincture) {
		Polygon polygon;
		polygon = new PolygonImpl(
				new Point(chargeAreaXMin+offsetX, chargeAreaYMin), new Point(chargeAreaXMin+offsetX+chargeXLength, chargeAreaYMin),
				new Point(chargeAreaXMax, chargeAreaYMax-offsetY-chargeYLength), new Point(chargeAreaXMax, chargeAreaYMax-offsetY));
		putNewPolygonElementOnGElement(ordinaries, tincture, polygon);
		polygon = new PolygonImpl(
				new Point(chargeAreaXMin, chargeAreaYMin+offsetY), new Point(chargeAreaXMin, chargeAreaYMin+offsetY+chargeYLength),
				new Point(chargeAreaXMax-offsetX-chargeXLength, chargeAreaYMax), new Point(chargeAreaXMax-offsetX, chargeAreaYMax));
		putNewPolygonElementOnGElement(ordinaries, tincture, polygon);
	}

	private Polygon middleBendlet(final float chargeXSize, float chargeYSize) {
		Polygon polygon;
		polygon = new PolygonImpl(
				new Point(chargeAreaXMin, chargeAreaYMin+chargeYSize), new Point(chargeAreaXMin, chargeAreaYMin),
				new Point(chargeAreaXMin+chargeXSize, chargeAreaYMin), 
				new Point(chargeAreaXMax, chargeAreaYMax-chargeYSize), new Point(chargeAreaXMax, chargeAreaYMax),
				new Point(chargeAreaXMax-chargeXSize, chargeAreaYMax));
		return polygon;
	}
}