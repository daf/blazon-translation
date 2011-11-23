package blazon.client.drawing.charges.geometric.mobile;

import java.util.List;

import org.vectomatic.dom.svg.OMSVGDefsElement;
import org.vectomatic.dom.svg.OMSVGGElement;
import org.vectomatic.dom.svg.OMSVGPathElement;
import org.vectomatic.dom.svg.OMSVGPathSegList;
import org.vectomatic.dom.svg.utils.SVGConstants;

import blazon.client.drawing.shapes.CubicBezierCurve;
import blazon.shared.shield.charges.GeometricCharge;
import blazon.shared.shield.diagnostic.ShieldDiagnostic;
import blazon.shared.shield.tinctures.Tincture;

public class SVGMascleDrawer extends SVGMobileChargeDrawer {

	public SVGMascleDrawer(GeometricCharge charge, OMSVGDefsElement defs, List<ShieldDiagnostic> diags, int shieldWidth, int shieldHeight, int occurrences) {
		super(charge, defs, diags, shieldWidth, shieldHeight, occurrences);
	}
	
	public OMSVGGElement drawOrdinary(CubicBezierCurve curve, boolean sameWidthAndHeight) {
		OMSVGGElement charges = doc.createSVGGElement();
		Tincture tincture = charge.getTincture();
		final float chargeHeight = 2*yMax/(2+occurrences);
		final float chargeWidth = (sameWidthAndHeight) ? chargeHeight : chargeHeight/2;
		return drawMobileCharges(chargeHeight, chargeWidth, charges, tincture, curve);
	}
	
	@Override
	public OMSVGGElement drawOrdinary(CubicBezierCurve curve) {
		return drawOrdinary(curve, false);
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
		OMSVGPathElement path = doc.createSVGPathElement();
		OMSVGPathSegList segList = path.getPathSegList();
		segList.appendItem(path.createSVGPathSegMovetoAbs(column, row));
		segList.appendItem(path.createSVGPathSegLinetoRel(chargeWidth/2, chargeHeight/2));
		segList.appendItem(path.createSVGPathSegLinetoRel(-chargeWidth/2, chargeHeight/2));
		segList.appendItem(path.createSVGPathSegLinetoRel(-chargeWidth/2, -chargeHeight/2));
		segList.appendItem(path.createSVGPathSegClosePath());
		segList.appendItem(path.createSVGPathSegMovetoRel(0, chargeHeight/4));
		segList.appendItem(path.createSVGPathSegLinetoRel(chargeWidth/4, chargeHeight/4));
		segList.appendItem(path.createSVGPathSegLinetoRel(-chargeWidth/4, chargeHeight/4));
		segList.appendItem(path.createSVGPathSegLinetoRel(-chargeWidth/4, -chargeHeight/4));
		segList.appendItem(path.createSVGPathSegClosePath());
		addFillToElement(tincture, path);
		path.setAttribute(SVGConstants.SVG_FILL_RULE_ATTRIBUTE,	SVGConstants.SVG_EVEN_ODD_VALUE);
		charges.appendChild(path);
	}
}
