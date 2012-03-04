package blazon.client.drawing.charges.geometric.mobile;

import org.vectomatic.dom.svg.OMSVGDefsElement;
import org.vectomatic.dom.svg.OMSVGGElement;

import blazon.client.drawing.charges.geometric.SVGGeometricChargeDrawer;
import blazon.client.drawing.shapes.CubicBezierCurve;
import blazon.shared.shield.charges.GeometricCharge;
import blazon.shared.shield.diagnostic.ShieldDiagnostic;
import blazon.shared.shield.diagnostic.ShieldDiagnostic.LogLevel;
import blazon.shared.shield.tinctures.Tincture;

public abstract class SVGMobileChargeDrawer extends SVGGeometricChargeDrawer {

	protected SVGMobileChargeDrawer(GeometricCharge charge, OMSVGDefsElement defs, float shieldWidth, float shieldHeight, int occurrences) {
		super(charge, defs, shieldWidth, shieldHeight, occurrences);
	}

	protected abstract float columnOffset(int multiplier, int numberOfColumns, float chargeWidth);

	protected abstract float rowOffset(int multiplier, float chargeHeight);
	
	protected abstract void drawMobileCharge(OMSVGGElement charges, float column, float row, float chargeWidth, float chargeHeight, Tincture tincture, CubicBezierCurve curve);

	protected OMSVGGElement drawMobileCharges(float chargeHeight, float chargeWidth, OMSVGGElement charges, Tincture tincture, CubicBezierCurve curve) {
		final float firstRow = rowOffset(1, chargeHeight);
		final float secondRow = rowOffset(3, chargeHeight);
		final float thirdRow = rowOffset(5, chargeHeight);
		final float centreColumn = columnOffset(2, 4, chargeWidth);
		final float leftMidCol = columnOffset(1, 4, chargeWidth);
		final float rightMidCol = columnOffset(3, 4, chargeWidth);
		switch (occurrences) {
			case 1:
				drawMobileCharge(charges, centreColumn, firstRow, chargeWidth, chargeHeight, tincture, curve);
				break;
			case 2:
				drawMobileCharge(charges, leftMidCol, firstRow, chargeWidth, chargeHeight, tincture, curve);
				drawMobileCharge(charges, rightMidCol, firstRow, chargeWidth, chargeHeight, tincture, curve);
				break;
			case 3:
				drawMobileCharge(charges, leftMidCol, firstRow, chargeWidth, chargeHeight, tincture, curve);
				drawMobileCharge(charges, rightMidCol, firstRow, chargeWidth, chargeHeight, tincture, curve);
				drawMobileCharge(charges, centreColumn, secondRow, chargeWidth, chargeHeight, tincture, curve);
				break;
			case 4:
				drawMobileCharge(charges, leftMidCol, firstRow, chargeWidth, chargeHeight, tincture, curve);
				drawMobileCharge(charges, rightMidCol, firstRow, chargeWidth, chargeHeight, tincture, curve);
				drawMobileCharge(charges, leftMidCol, secondRow, chargeWidth, chargeHeight, tincture, curve);
				drawMobileCharge(charges, rightMidCol, secondRow, chargeWidth, chargeHeight, tincture, curve);
				break;
			case 5:
				drawMobileCharge(charges, leftMidCol, firstRow, chargeWidth, chargeHeight, tincture, curve);
				drawMobileCharge(charges, rightMidCol, firstRow, chargeWidth, chargeHeight, tincture, curve);
				drawMobileCharge(charges, leftMidCol, secondRow, chargeWidth, chargeHeight, tincture, curve);
				drawMobileCharge(charges, rightMidCol, secondRow, chargeWidth, chargeHeight, tincture, curve);
				drawMobileCharge(charges, centreColumn, thirdRow, chargeWidth, chargeHeight, tincture, curve);
				break;
			case 6:
				float columnOffset = columnOffset(1, 6, chargeWidth);
				drawMobileCharge(charges, columnOffset, firstRow, chargeWidth, chargeHeight, tincture, curve);
				drawMobileCharge(charges, centreColumn, firstRow, chargeWidth, chargeHeight, tincture, curve);
				columnOffset = columnOffset(5, 6, chargeWidth);
				drawMobileCharge(charges, columnOffset, firstRow, chargeWidth, chargeHeight, tincture, curve);
				columnOffset = columnOffset(2, 6, chargeWidth);
				drawMobileCharge(charges, columnOffset, secondRow, chargeWidth, chargeHeight, tincture, curve);
				columnOffset = columnOffset(4, 6, chargeWidth);
				drawMobileCharge(charges, columnOffset, secondRow, chargeWidth, chargeHeight, tincture, curve);
				drawMobileCharge(charges, centreColumn, thirdRow, chargeWidth, chargeHeight, tincture, curve);
				break;
			default:
				diags.add(ShieldDiagnostic.build(LogLevel.ERROR, "SVGMobileChargeDrawer does not know how to draw " + occurrences + " '" + charge.getName() + "'."));
		}
		return charges;
	}
	
	protected boolean chargeAreaGoesOverEdgeOfShield() {
		if (occurrences == 1) return false;
		return Math.abs(chargeAreaYMax - shieldYMax) < 0.00001;
	}
}
