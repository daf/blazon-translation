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

public class SVGStarDrawer extends SVGMobileChargeDrawer {

	public SVGStarDrawer(GeometricCharge charge, OMSVGDefsElement defs, List<ShieldDiagnostic> diags, int shieldWidth, int shieldHeight, int occurrences) {
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
		float offset = chargeHeight/8;
		Point top = new Point(column, row);
		Point topRightInner = new Point(column + offset, row+2*offset);
		Point topRight = new Point(column + chargeWidth/2, row+2*offset);
		Point rightInner = new Point(column + 2*offset, row+chargeHeight/2);
		Point bottomRight = new Point(column + chargeWidth/2, row+chargeHeight-2*offset);
		Point bottomRightInner = new Point(column + offset, row+chargeHeight-2*offset);
		Point bottom = new Point(column, row+chargeHeight);
		Point bottomLeftInner = new Point(column - offset, row+chargeHeight-2*offset);
		Point bottomLeft = new Point(column - chargeWidth/2, row+chargeHeight-2*offset);
		Point leftInner = new Point(column - 2*offset, row+chargeHeight/2);
		Point topLeft = new Point(column - chargeWidth/2, row+2*offset);
		Point topLeftInner = new Point(column - offset, row+2*offset);
		Polygon polygon = new PolygonImpl(top, topRightInner, topRight, rightInner, bottomRight, bottomRightInner, bottom, bottomLeftInner, bottomLeft, leftInner, topLeft, topLeftInner);
		putNewPolygonElementOnGElement(charges, tincture, polygon);
	}
}
