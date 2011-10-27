package blazon.client.drawing.charges.geometric;

import org.vectomatic.dom.svg.OMSVGDefsElement;
import org.vectomatic.dom.svg.OMSVGGElement;
import org.vectomatic.dom.svg.OMSVGPathElement;
import org.vectomatic.dom.svg.utils.SVGConstants;

import blazon.client.drawing.shapes.CubicBezierCurve;
import blazon.shared.shield.charges.GeometricCharge;

public class SVGBordureDrawer extends SVGShieldShapeChargeDrawer {

	public SVGBordureDrawer(GeometricCharge charge, OMSVGDefsElement defs, int shieldWidth, int shieldHeight) {
		super(charge, defs, shieldWidth, shieldHeight);
	}

	@Override
	public OMSVGGElement drawOrdinary(OMSVGGElement shieldContainer, CubicBezierCurve curve) {
		OMSVGGElement ordinaries = doc.createSVGGElement();
		OMSVGPathElement path = doc.createSVGPathElement();
		drawScaledAndOffsetShieldShape(curve, path, 6, 0);
		drawScaledAndOffsetShieldShape(curve, path, 6, 1);
		addFillToElement(charge.getTincture(), path);
		path.setAttribute(SVGConstants.SVG_FILL_RULE_ATTRIBUTE,	SVGConstants.SVG_EVEN_ODD_VALUE);
		ordinaries.appendChild(path);
		return ordinaries;
	}
}
