package blazon.client.drawing.charges.geometric;

import org.vectomatic.dom.svg.OMSVGDefsElement;
import org.vectomatic.dom.svg.OMSVGGElement;

import blazon.client.drawing.shapes.CubicBezierCurve;
import blazon.shared.shield.charges.GeometricCharge;

public class SVGBarDrawer extends SVGOrdinaryDrawer {

	protected SVGBarDrawer(GeometricCharge charge, OMSVGDefsElement defs, int shieldWidth, int shieldHeight, int occurrences) {
		super(charge, defs, shieldWidth, shieldHeight, occurrences);
	}

	@Override
	public OMSVGGElement drawOrdinary(OMSVGGElement shieldContainer, CubicBezierCurve curve) {
		OMSVGGElement ordinaries = doc.createSVGGElement();
		final float fifthY = yMax/5f;
		final float offset = yMax/15f;

		switch(occurrences) {
		case 1:
			putNewRectElementOnGElement(ordinaries, xMin, 2*fifthY, xMax, fifthY, charge.getTincture());
			break;
		case 2:
			putNewRectElementOnGElement(ordinaries, xMin, fifthY + offset, xMax, fifthY, charge.getTincture());
			putNewRectElementOnGElement(ordinaries, xMin, 3*fifthY - offset, xMax, fifthY, charge.getTincture());
			break;
		case 3:
			{
				final float chargeHeight = fifthY - offset;
				putNewRectElementOnGElement(ordinaries, xMin, fifthY, xMax, chargeHeight, charge.getTincture());
				putNewRectElementOnGElement(ordinaries, xMin, 2*fifthY, xMax, chargeHeight, charge.getTincture());
				putNewRectElementOnGElement(ordinaries, xMin, 3*fifthY, xMax, chargeHeight, charge.getTincture());
				break;
			}
		case 4:
			{
				final float chargeHeight = fifthY - (1.5f * offset);
				putNewRectElementOnGElement(ordinaries, xMin, fifthY, xMax, chargeHeight, charge.getTincture());
				putNewRectElementOnGElement(ordinaries, xMin, 2*fifthY - offset, xMax, chargeHeight, charge.getTincture());
				putNewRectElementOnGElement(ordinaries, xMin, 2*fifthY + offset, xMax, chargeHeight, charge.getTincture());
				putNewRectElementOnGElement(ordinaries, xMin, 3*fifthY, xMax, chargeHeight, charge.getTincture());
				break;
			}
		default:
				//TODO give errors
		}
		return ordinaries;
	}

}
