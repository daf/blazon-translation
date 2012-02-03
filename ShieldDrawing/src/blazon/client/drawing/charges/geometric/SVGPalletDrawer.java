package blazon.client.drawing.charges.geometric;

import java.util.List;

import org.vectomatic.dom.svg.OMSVGDefsElement;
import org.vectomatic.dom.svg.OMSVGGElement;

import blazon.client.drawing.shapes.CubicBezierCurve;
import blazon.shared.shield.charges.GeometricCharge;
import blazon.shared.shield.diagnostic.ShieldDiagnostic;
import blazon.shared.shield.diagnostic.ShieldDiagnostic.LogLevel;
import blazon.shared.shield.tinctures.Tincture;

public class SVGPalletDrawer extends SVGGeometricChargeDrawer {

	protected SVGPalletDrawer(GeometricCharge charge, OMSVGDefsElement defs, List<ShieldDiagnostic> diags, int shieldWidth, int shieldHeight, int occurrences) {
		super(charge, defs, diags, shieldWidth, shieldHeight, occurrences);
	}

	@Override
	public OMSVGGElement drawCharge(CubicBezierCurve curve) {
		OMSVGGElement ordinaries = doc.createSVGGElement();
		Tincture tincture = charge.getTincture();
		final float fifthX = xMax/5f;
		float offset = xMax/15f;

		switch(occurrences) {
		case 1:
			putNewRectElementOnGElement(ordinaries, 2*fifthX, yMin, fifthX, yMax, tincture);
			break;
		case 2:
			putNewRectElementOnGElement(ordinaries, fifthX + offset, yMin, fifthX, yMax, tincture);
			putNewRectElementOnGElement(ordinaries, 3*fifthX - offset, yMin, fifthX, yMax, tincture);
			break;
		case 3:
			final float chargeHeight = fifthX - offset;
			offset *= 0.5f;
			putNewRectElementOnGElement(ordinaries, fifthX+offset, yMin, chargeHeight, yMax, tincture);
			putNewRectElementOnGElement(ordinaries, 2*fifthX+offset, yMin, chargeHeight, yMax, tincture);
			putNewRectElementOnGElement(ordinaries, 3*fifthX+offset, yMin, chargeHeight, yMax, tincture);
			break;
		case 4:
			final float chargeWidth = fifthX - (1.5f * offset);
			putNewRectElementOnGElement(ordinaries, fifthX, yMin, chargeWidth, yMax, tincture);
			putNewRectElementOnGElement(ordinaries, 2*fifthX-chargeWidth+offset, yMin, chargeWidth, yMax, tincture);
			putNewRectElementOnGElement(ordinaries, 3*fifthX-offset, yMin, chargeWidth, yMax, tincture);
			putNewRectElementOnGElement(ordinaries, 4*fifthX-1.5f*offset, yMin, chargeWidth, yMax, tincture);
			break;
		default:
			diags.add(ShieldDiagnostic.build(LogLevel.ERROR, "SVGPalletDrawer only knows how to draw 1 to 4 pallets."));

		}
		return ordinaries;
	}
}
