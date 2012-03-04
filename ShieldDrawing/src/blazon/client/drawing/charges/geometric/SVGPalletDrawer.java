package blazon.client.drawing.charges.geometric;

import org.vectomatic.dom.svg.OMSVGDefsElement;
import org.vectomatic.dom.svg.OMSVGGElement;

import blazon.client.drawing.shapes.CubicBezierCurve;
import blazon.shared.shield.charges.GeometricCharge;
import blazon.shared.shield.diagnostic.ShieldDiagnostic;
import blazon.shared.shield.diagnostic.ShieldDiagnostic.LogLevel;
import blazon.shared.shield.tinctures.Tincture;

public class SVGPalletDrawer extends SVGGeometricChargeDrawer {

	protected SVGPalletDrawer(GeometricCharge charge, OMSVGDefsElement defs, int shieldWidth, int shieldHeight, int occurrences) {
		super(charge, defs, shieldWidth, shieldHeight, occurrences);
	}

	@Override
	public OMSVGGElement drawCharge(CubicBezierCurve curve) {
		OMSVGGElement ordinaries = doc.createSVGGElement();
		Tincture tincture = charge.getTincture();
		final float fifthX = chargeAreaXMax/5f;
		float offset = chargeAreaXMax/15f;

		switch(occurrences) {
		case 1:
			putNewRectElementOnGElement(ordinaries, 2*fifthX, chargeAreaYMin, fifthX, chargeAreaYMax, tincture);
			break;
		case 2:
			putNewRectElementOnGElement(ordinaries, fifthX + offset, chargeAreaYMin, fifthX, chargeAreaYMax, tincture);
			putNewRectElementOnGElement(ordinaries, 3*fifthX - offset, chargeAreaYMin, fifthX, chargeAreaYMax, tincture);
			break;
		case 3:
			final float chargeHeight = fifthX - offset;
			offset *= 0.5f;
			putNewRectElementOnGElement(ordinaries, fifthX+offset, chargeAreaYMin, chargeHeight, chargeAreaYMax, tincture);
			putNewRectElementOnGElement(ordinaries, 2*fifthX+offset, chargeAreaYMin, chargeHeight, chargeAreaYMax, tincture);
			putNewRectElementOnGElement(ordinaries, 3*fifthX+offset, chargeAreaYMin, chargeHeight, chargeAreaYMax, tincture);
			break;
		case 4:
			final float chargeWidth = fifthX - (1.5f * offset);
			putNewRectElementOnGElement(ordinaries, fifthX, chargeAreaYMin, chargeWidth, chargeAreaYMax, tincture);
			putNewRectElementOnGElement(ordinaries, 2*fifthX-chargeWidth+offset, chargeAreaYMin, chargeWidth, chargeAreaYMax, tincture);
			putNewRectElementOnGElement(ordinaries, 3*fifthX-offset, chargeAreaYMin, chargeWidth, chargeAreaYMax, tincture);
			putNewRectElementOnGElement(ordinaries, 4*fifthX-1.5f*offset, chargeAreaYMin, chargeWidth, chargeAreaYMax, tincture);
			break;
		default:
			diags.add(ShieldDiagnostic.build(LogLevel.ERROR, "SVGPalletDrawer only knows how to draw 1 to 4 pallets."));

		}
		return ordinaries;
	}
}
