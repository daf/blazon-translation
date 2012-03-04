package blazon.client.drawing.charges.geometric.mobile;

import org.vectomatic.dom.svg.OMSVGDefsElement;
import org.vectomatic.dom.svg.OMSVGGElement;
import org.vectomatic.dom.svg.OMSVGPathElement;
import org.vectomatic.dom.svg.OMSVGPathSegList;
import org.vectomatic.dom.svg.utils.SVGConstants;

import blazon.client.drawing.shapes.CubicBezierCurve;
import blazon.shared.shield.charges.GeometricCharge;
import blazon.shared.shield.tinctures.Tincture;

public class SVGAnnuletDrawer extends SVGMobileChargeDrawer {

	public SVGAnnuletDrawer(GeometricCharge charge, OMSVGDefsElement defs, int shieldWidth, int shieldHeight, int occurrences) {
		super(charge, defs, shieldWidth, shieldHeight, occurrences);
	}

	@Override
	public OMSVGGElement drawCharge(CubicBezierCurve curve) {
		OMSVGGElement charges = doc.createSVGGElement();
		Tincture tincture = charge.getTincture();
		final float chargeHeight = 1.1f*getYDiff()/(float)(2+occurrences);
		final float chargeWidth = chargeHeight;
		return drawMobileCharges(chargeHeight, chargeWidth, charges, tincture, curve);
	}
	
	@Override
	protected float rowOffset(int multiplier, float chargeHeight) {
		int rowDivisor = (occurrences+1)/2*2; // convert to next even number
		float edgeOverlapOffset = chargeAreaGoesOverEdgeOfShield() ? 0.8f : 1;
		float rowMidPoint = edgeOverlapOffset*getYDiff()/(float)rowDivisor;
		return chargeAreaYMin + multiplier*rowMidPoint;
	}
	
	@Override
	protected float columnOffset(int multiplier, int numberOfColumns, float chargeWidth) {
		return chargeAreaXMin + multiplier*getXDiff()/(float)numberOfColumns;
	}
	
	@Override
	protected void drawMobileCharge(OMSVGGElement charges, float column, float row, float chargeWidth, float chargeHeight, Tincture tincture, CubicBezierCurve curve) {
		OMSVGPathElement path = doc.createSVGPathElement();
		OMSVGPathSegList segList = path.getPathSegList();
		segList.appendItem(path.createSVGPathSegMovetoAbs(column, row-chargeHeight/2f));
		segList.appendItem(path.createSVGPathSegArcRel(0.001f, 0, chargeWidth/2f, chargeHeight/2f, 0, true, false));
		segList.appendItem(path.createSVGPathSegClosePath());
		segList.appendItem(path.createSVGPathSegMovetoRel(0, chargeHeight/4f));
		segList.appendItem(path.createSVGPathSegArcRel(0.001f, 0, chargeWidth/4f, chargeHeight/4f, 0, true, false));
		segList.appendItem(path.createSVGPathSegClosePath());
		addFillToElement(tincture, path);
		path.setAttribute(SVGConstants.SVG_FILL_RULE_ATTRIBUTE,	SVGConstants.SVG_EVEN_ODD_VALUE);
		charges.appendChild(path);
	}
}
