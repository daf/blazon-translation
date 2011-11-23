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

public class SVGAnnuletDrawer extends SVGMobileChargeDrawer {

	public SVGAnnuletDrawer(GeometricCharge charge, OMSVGDefsElement defs, List<ShieldDiagnostic> diags, int shieldWidth, int shieldHeight, int occurrences) {
		super(charge, defs, diags, shieldWidth, shieldHeight, occurrences);
	}

	@Override
	public OMSVGGElement drawOrdinary(CubicBezierCurve curve) {
		OMSVGGElement charges = doc.createSVGGElement();
		Tincture tincture = charge.getTincture();
		final float chargeHeight = 1.1f*yMax/(2+occurrences);
		final float chargeWidth = chargeHeight;
		return drawMobileCharges(chargeHeight, chargeWidth, charges, tincture, curve);
	}
	
	@Override
	protected float rowOffset(int multiplier, float chargeHeight) {
		int rowDivisor = (occurrences+1)/2*2; // convert to next even number
		float rowMidPoint = yMax/rowDivisor;
		return multiplier*rowMidPoint;
	}
	
	@Override
	protected float columnOffset(int multiplier, int numberOfColumns, float chargeWidth) {
		return multiplier*xMax/numberOfColumns;
	}
	
	@Override
	protected void drawMobileCharge(OMSVGGElement charges, float column, float row, float chargeWidth, float chargeHeight, Tincture tincture, CubicBezierCurve curve) {
		OMSVGPathElement path = doc.createSVGPathElement();
		OMSVGPathSegList segList = path.getPathSegList();
		segList.appendItem(path.createSVGPathSegMovetoAbs(column, row-chargeHeight/2));
		segList.appendItem(path.createSVGPathSegArcRel(0.001f, 0, chargeWidth/2, chargeHeight/2, 0, true, false));
		segList.appendItem(path.createSVGPathSegClosePath());
		segList.appendItem(path.createSVGPathSegMovetoRel(0, chargeHeight/4));
		segList.appendItem(path.createSVGPathSegArcRel(0.001f, 0, chargeWidth/4, chargeHeight/4, 0, true, false));
		segList.appendItem(path.createSVGPathSegClosePath());
		addFillToElement(tincture, path);
		path.setAttribute(SVGConstants.SVG_FILL_RULE_ATTRIBUTE,	SVGConstants.SVG_EVEN_ODD_VALUE);
		charges.appendChild(path);
	}
}
