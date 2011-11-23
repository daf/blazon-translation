package blazon.client.drawing.charges.geometric;

import java.util.List;

import org.vectomatic.dom.svg.OMSVGDefsElement;
import org.vectomatic.dom.svg.OMSVGGElement;
import org.vectomatic.dom.svg.OMSVGPathElement;
import org.vectomatic.dom.svg.utils.SVGConstants;

import blazon.client.drawing.shapes.CubicBezierCurve;
import blazon.shared.shield.charges.GeometricCharge;
import blazon.shared.shield.diagnostic.ShieldDiagnostic;
import blazon.shared.shield.tinctures.Tincture;

public class SVGOrleDrawer extends SVGShieldShapeChargeDrawer {

	protected SVGOrleDrawer(GeometricCharge charge, OMSVGDefsElement defs, List<ShieldDiagnostic> diags, int shieldWidth, int shieldHeight) {
		super(charge, defs, diags, shieldWidth, shieldHeight);
	}

	@Override
	public OMSVGGElement drawOrdinary(CubicBezierCurve curve) {
		OMSVGGElement ordinaries = doc.createSVGGElement();
		Tincture tincture = charge.getTincture();
		OMSVGPathElement path = doc.createSVGPathElement();
		drawScaledAndOffsetShieldShape(curve, path, 6, 1);
		drawScaledAndOffsetShieldShape(curve, path, 12, 1);
		addFillToElement(tincture, path);
		path.setAttribute(SVGConstants.SVG_FILL_RULE_ATTRIBUTE,	SVGConstants.SVG_EVEN_ODD_VALUE);
		ordinaries.appendChild(path);
		return ordinaries;
	}
}
