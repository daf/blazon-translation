package blazon.client.drawing.charges.geometric.mobile;

import org.vectomatic.dom.svg.OMSVGDefsElement;
import org.vectomatic.dom.svg.OMSVGGElement;
import org.vectomatic.dom.svg.OMSVGPathElement;
import org.vectomatic.dom.svg.OMSVGPathSegList;
import org.vectomatic.dom.svg.utils.SVGConstants;

import blazon.client.drawing.shapes.CubicBezierCurve;
import blazon.shared.shield.charges.GeometricCharge;
import blazon.shared.shield.tinctures.Tincture;

public class SVGRustreDrawer extends SVGMobileChargeDrawer {

	public SVGRustreDrawer(GeometricCharge charge, OMSVGDefsElement defs, int shieldWidth, int shieldHeight, int occurrences) {
		super(charge, defs, shieldWidth, shieldHeight, occurrences);
	}
	
	@Override
	public OMSVGGElement drawCharge(CubicBezierCurve curve) {
		OMSVGGElement charges = doc.createSVGGElement();
		Tincture tincture = charge.getTincture();
		final float chargeHeight = 1.5f*getYDiff()/(float)(2+occurrences);
		final float chargeWidth = chargeHeight/2;
		return drawMobileCharges(chargeHeight, chargeWidth, charges, tincture, curve);
	}
	
	@Override
	protected float rowOffset(int multiplier, float chargeHeight) {
		int rowDivisor = (occurrences+1)/2*2; // convert to next even number
		float edgeOverlapOffset = chargeAreaGoesOverEdgeOfShield() ? 0.8f : 1;
		float rowMidPoint = edgeOverlapOffset*getYDiff()/(float)rowDivisor;
		return chargeAreaYMin + multiplier*rowMidPoint - chargeHeight/2;
	}
	
	@Override
	protected float columnOffset(int multiplier, int numberOfColumns, float chargeWidth) {
		return chargeAreaXMin + multiplier*getXDiff()/numberOfColumns;
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
		segList.appendItem(path.createSVGPathSegMovetoRel(0, 3*chargeHeight/8));
		segList.appendItem(path.createSVGPathSegArcRel(0.001f, 0, chargeWidth/4, chargeWidth/4, 0, true, false));
		segList.appendItem(path.createSVGPathSegClosePath());
		addFillToElement(tincture, path);
		path.setAttribute(SVGConstants.SVG_FILL_RULE_ATTRIBUTE,	SVGConstants.SVG_EVEN_ODD_VALUE);
		charges.appendChild(path);
	}
}
