package blazon.client.drawing.charges.geometric;

import org.vectomatic.dom.svg.OMSVGDefsElement;
import org.vectomatic.dom.svg.OMSVGGElement;

import blazon.client.drawing.shapes.CubicBezierCurve;
import blazon.shared.shield.charges.GeometricCharge;

public class SVGPalletDrawer extends SVGOrdinaryDrawer {

	protected SVGPalletDrawer(GeometricCharge charge, OMSVGDefsElement defs, int shieldWidth, int shieldHeight, int occurrences) {
		super(charge, defs, shieldWidth, shieldHeight, occurrences);
	}

	@Override
	public OMSVGGElement drawOrdinary(CubicBezierCurve curve) {
		OMSVGGElement ordinaries = doc.createSVGGElement();
		final float fifthX = xMax/5f;
		float offset = xMax/15f;

		switch(occurrences) {
		case 1:
			putNewRectElementOnGElement(ordinaries, 2*fifthX, yMin, fifthX, yMax, charge.getTincture());
			break;
		case 2:
			putNewRectElementOnGElement(ordinaries, fifthX + offset, yMin, fifthX, yMax, charge.getTincture());
			putNewRectElementOnGElement(ordinaries, 3*fifthX - offset, yMin, fifthX, yMax, charge.getTincture());
			break;
		case 3:
			{
				final float chargeHeight = fifthX - offset;
				offset *= 0.5f;
				putNewRectElementOnGElement(ordinaries, fifthX+offset, yMin, chargeHeight, yMax, charge.getTincture());
				putNewRectElementOnGElement(ordinaries, 2*fifthX+offset, yMin, chargeHeight, yMax, charge.getTincture());
				putNewRectElementOnGElement(ordinaries, 3*fifthX+offset, yMin, chargeHeight, yMax, charge.getTincture());
				break;
			}
		case 4:
			{
				//offset *= 0.5f;
				final float chargeWidth = fifthX - (1.5f * offset);
				putNewRectElementOnGElement(ordinaries, fifthX, yMin, chargeWidth, yMax, charge.getTincture());
				putNewRectElementOnGElement(ordinaries, 2*fifthX-chargeWidth+offset, yMin, chargeWidth, yMax, charge.getTincture());
				putNewRectElementOnGElement(ordinaries, 3*fifthX-offset, yMin, chargeWidth, yMax, charge.getTincture());
				putNewRectElementOnGElement(ordinaries, 4*fifthX-1.5f*offset, yMin, chargeWidth, yMax, charge.getTincture());
				break;
			}
		default:
				//TODO give errors
		}
		return ordinaries;
	}
}
