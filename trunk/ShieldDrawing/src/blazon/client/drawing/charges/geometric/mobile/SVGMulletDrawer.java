package blazon.client.drawing.charges.geometric.mobile;

import java.util.List;

import org.vectomatic.dom.svg.OMSVGDefsElement;
import org.vectomatic.dom.svg.OMSVGGElement;

import blazon.client.drawing.shapes.CubicBezierCurve;
import blazon.client.drawing.shapes.Point;
import blazon.client.drawing.shapes.Polygon;
import blazon.client.drawing.shapes.PolygonImpl;
import blazon.shared.shield.charges.GeometricCharge;
import blazon.shared.shield.diagnostic.ShieldDiagnostic;
import blazon.shared.shield.tinctures.Tincture;

public class SVGMulletDrawer extends SVGMobileChargeDrawer {

	public SVGMulletDrawer(GeometricCharge charge, OMSVGDefsElement defs, List<ShieldDiagnostic> diags, int shieldWidth, int shieldHeight, int occurrences) {
		super(charge, defs, diags, shieldWidth, shieldHeight, occurrences);
	}

	@Override
	public OMSVGGElement drawOrdinary(CubicBezierCurve curve) {
		OMSVGGElement charges = doc.createSVGGElement();
		Tincture tincture = charge.getTincture();
		final float chargeHeight = yMax/(1+occurrences);
		final float chargeWidth = chargeHeight;
		return drawMobileCharges(chargeHeight, chargeWidth, charges, tincture, curve);
	}
	
	@Override
	protected float rowOffset(int multiplier, float chargeHeight) {
		int rowDivisor = (occurrences+1)/2*2; // convert to next even number
		float rowMidPoint = yMax/rowDivisor;
		return multiplier*rowMidPoint - chargeHeight/2;
	}
	
	@Override
	protected float columnOffset(int multiplier, int numberOfColumns, float chargeWidth) {
		return multiplier*xMax/numberOfColumns;
	}
	
	@Override
	protected void drawMobileCharge(OMSVGGElement charges, float column, float row, float chargeWidth, float chargeHeight, Tincture tincture, CubicBezierCurve curve) {
		float offset = chargeHeight/10;
		Point top = new Point(column, row);
		Point rightInner = new Point(column+chargeWidth/2 - 3*offset, row + 4*offset);
		Point right = new Point(column+chargeWidth/2, row + 4*offset);
		Point bottomRightInner = new Point(column + chargeWidth/2 - 2*offset, row + chargeHeight - offset*3);
		Point bottomRight = new Point(column + chargeWidth/2 - offset, row + chargeHeight);
		Point bottomMiddle = new Point(column, row + chargeHeight - 1.5f*offset);
		Point bottomLeft = new Point(column - chargeWidth/2 + offset, row + chargeHeight);
		Point bottomLeftInner = new Point(column - chargeWidth/2 + 2*offset, row + chargeHeight - offset*3);
		Point left = new Point(column-chargeWidth/2, row + 4*offset);
		Point leftInner = new Point(column-chargeWidth/2 + 3*offset, row + 4*offset);

		Polygon polygon = new PolygonImpl(top, rightInner, right, bottomRightInner, bottomRight, bottomMiddle, bottomLeft, bottomLeftInner, left, leftInner);
		putNewPolygonElementOnGElement(charges, tincture, polygon);
	}
}
