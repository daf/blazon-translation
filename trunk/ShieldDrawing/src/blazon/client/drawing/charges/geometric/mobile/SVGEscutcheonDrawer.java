package blazon.client.drawing.charges.geometric.mobile;

import java.util.List;

import org.vectomatic.dom.svg.OMSVGDefsElement;
import org.vectomatic.dom.svg.OMSVGGElement;
import org.vectomatic.dom.svg.OMSVGPathElement;
import org.vectomatic.dom.svg.OMSVGPathSegList;

import blazon.client.drawing.shapes.CubicBezierCurve;
import blazon.shared.shield.charges.GeometricCharge;
import blazon.shared.shield.diagnostic.ShieldDiagnostic;
import blazon.shared.shield.tinctures.Tincture;

public class SVGEscutcheonDrawer extends SVGMobileChargeDrawer {

	public SVGEscutcheonDrawer(GeometricCharge charge, OMSVGDefsElement defs, List<ShieldDiagnostic> diags, int shieldWidth, int shieldHeight, int occurrences) {
		super(charge, defs, diags, shieldWidth, shieldHeight, occurrences);
	}

	@Override
	public OMSVGGElement drawOrdinary(CubicBezierCurve curve) {
		OMSVGGElement charges = doc.createSVGGElement();
		Tincture tincture = charge.getTincture();
		final float chargeHeight = yMax/(3+occurrences);
		final float chargeWidth = 1.3f*chargeHeight;
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
		return multiplier*xMax/numberOfColumns - chargeWidth/2;
	}
	
	@Override
	protected void drawMobileCharge(OMSVGGElement charges, float column, float row, float chargeWidth, float chargeHeight, Tincture tincture, CubicBezierCurve curve) {
		OMSVGPathElement path = doc.createSVGPathElement();
		drawScaledAndOffsetShieldShape(curve, path, row, column, chargeWidth, chargeHeight);
		addFillToElement(tincture, path);
		charges.appendChild(path);
	}
	
	private void drawScaledAndOffsetShieldShape(CubicBezierCurve curve, OMSVGPathElement path, float row, float column, float chargeWidth, float chargeHeight) {
		final float xScale = chargeWidth/xMax;
		final float yScale = chargeHeight/yMax;
		final float curveStart = curve.getEndPoint1().getY()*yScale;
		OMSVGPathSegList segList = path.getPathSegList();
		segList.appendItem(path.createSVGPathSegMovetoAbs(column, row));
		segList.appendItem(path.createSVGPathSegLinetoVerticalRel(curveStart));
		segList.appendItem(
				path.createSVGPathSegCurvetoCubicRel(
						curve.getEndPoint2().getX()*xScale, curve.getEndPoint2().getY()*yScale,
						curve.getControlPoint1().getX()*xScale, curve.getControlPoint1().getY()*yScale, 
						curve.getControlPoint2().getX()*xScale, curve.getControlPoint2().getY()*yScale));
		segList.appendItem(
				path.createSVGPathSegCurvetoCubicSmoothRel(
						chargeWidth-curve.getEndPoint2().getX()*xScale,	-curve.getEndPoint2().getY()*yScale,
						curve.getControlPoint2().getX()*xScale, -curve.getControlPoint2().getY()*yScale/4));
		segList.appendItem(path.createSVGPathSegLinetoVerticalRel(-curveStart));
		segList.appendItem(path.createSVGPathSegLinetoHorizontalRel(-chargeWidth));
		segList.appendItem(path.createSVGPathSegClosePath());
	}
}
