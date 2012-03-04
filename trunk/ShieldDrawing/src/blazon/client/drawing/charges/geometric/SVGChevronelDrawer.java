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

public class SVGChevronelDrawer extends SVGGeometricChargeDrawer {

	protected SVGChevronelDrawer(GeometricCharge charge, OMSVGDefsElement defs,	int shieldWidth, int shieldHeight, int occurrences) {
		super(charge, defs, shieldWidth, shieldHeight, occurrences);
	}

	@Override
	public OMSVGGElement drawCharge(CubicBezierCurve curve) {
		OMSVGGElement ordinaries = doc.createSVGGElement();
		Tincture tincture = charge.getTincture();
		final float xMid = chargeAreaXMin + getXDiff()/2f;
		final float yMid = chargeAreaYMin + getYDiff()/2f;
		final float chargeXSize = getXDiff()/20f;
		final float chargeYSize = getYDiff()/20f;
		final float chargeXSideLength = (float) Math.sqrt(2 * Math.pow(chargeXSize, 2));
		final float chargeYSideLength = (float) Math.sqrt(2 * Math.pow(chargeYSize, 2));
		final float chargeLengthX = (float) (getXDiff() - Math.sqrt((Math.pow(chargeXSideLength, 2) + (3*Math.pow(getXDiff(), 2)) - Math.pow(getXDiff(), 2)) / 4))/2;
		final float chargeLengthY = (float) (getYDiff() - Math.sqrt((Math.pow(chargeYSideLength, 2) + (3*Math.pow(getYDiff(), 2)) - Math.pow(getYDiff(), 2)) / 4))/2;
		float offsetX = (occurrences % 2 == 0) ? getXDiff()/30f : 0;
		float offsetY = (occurrences % 2 == 0) ? getYDiff()/30f : 0;

		Polygon polygon;
		
		switch (occurrences) {
			case 1:
				polygon = middleChevronel(xMid, yMid, chargeXSideLength, chargeYSideLength);
			    putNewPolygonElementOnGElement(ordinaries, tincture, polygon);
				break;
			case 2:
				drawPair(ordinaries, xMid, yMid, chargeLengthX, chargeLengthY, offsetY, offsetX, tincture);
				break;
			case 3:
			    polygon = middleChevronel(xMid, yMid, chargeXSideLength, chargeYSideLength);
			    putNewPolygonElementOnGElement(ordinaries, tincture, polygon);
				offsetX += chargeLengthX;
				offsetY += chargeLengthY;
				drawPair(ordinaries, xMid, yMid, chargeLengthX, chargeLengthY, offsetY, offsetX, tincture);
				break;
			case 4:
				drawPair(ordinaries, xMid, yMid, chargeLengthX, chargeLengthY, offsetY, offsetX, tincture);
				offsetX += chargeLengthX + chargeXSideLength;
				offsetY += chargeLengthY + chargeYSideLength;
				drawPair(ordinaries, xMid, yMid, chargeLengthX, chargeLengthY, offsetY, offsetX, tincture);
				break;
			default:
				diags.add(ShieldDiagnostic.build(LogLevel.ERROR, "SVGChevronelDrawer only knows how to draw 1 to 4 chevronnels."));
		}
	    return ordinaries;
	}

	private void drawPair(OMSVGGElement ordinaries, final float xMid, final float yMid, final float chargeLengthX, final float chargeLengthY, float offsetY, float offsetX, Tincture tincture) {
		Polygon polygon;
		polygon = new PolygonImpl(
				new Point(chargeAreaXMax, chargeAreaYMax-offsetY), new Point(chargeAreaXMax, chargeAreaYMax-chargeLengthY-offsetY),
				new Point(xMid, yMid-offsetY-chargeLengthY),
				new Point(chargeAreaXMin, chargeAreaYMax-chargeLengthY-offsetY), new Point(chargeAreaXMin, chargeAreaYMax-offsetY),
				new Point(xMid, yMid-offsetY));
		putNewPolygonElementOnGElement(ordinaries, tincture, polygon);
		polygon = new PolygonImpl(
				new Point(chargeAreaXMax-offsetX, chargeAreaYMax), new Point(chargeAreaXMax-offsetX-chargeLengthX, chargeAreaYMax), 
				new Point(xMid, yMid+offsetY+chargeLengthY),
				new Point(chargeAreaXMin+chargeLengthX+offsetX, chargeAreaYMax), new Point(chargeAreaXMin+offsetX, chargeAreaYMax), 
				new Point(xMid, yMid+offsetY));
		putNewPolygonElementOnGElement(ordinaries, tincture, polygon);
	}

	private Polygon middleChevronel(final float xMid, final float yMid,	final float chargeXSideLength, float chargeYSideLength) {
		Polygon polygon;
		polygon = new PolygonImpl(
				new Point(chargeAreaXMax, chargeAreaYMax-chargeYSideLength), new Point(chargeAreaXMax, chargeAreaYMax), new Point(chargeAreaXMax-chargeXSideLength, chargeAreaYMax),
				new Point(xMid, yMid+chargeYSideLength),
				new Point(chargeAreaXMin+chargeXSideLength, chargeAreaYMax), new Point(chargeAreaXMin, chargeAreaYMax),	new Point(chargeAreaXMin, chargeAreaYMax-chargeYSideLength),
				new Point(xMid, yMid-chargeYSideLength));
		return polygon;
	}
}
