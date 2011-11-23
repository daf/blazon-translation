package blazon.client.drawing.charges.geometric;

import java.util.List;

import org.vectomatic.dom.svg.OMSVGDefsElement;
import org.vectomatic.dom.svg.OMSVGGElement;

import blazon.client.drawing.shapes.CubicBezierCurve;
import blazon.shared.shield.charges.GeometricCharge;
import blazon.shared.shield.diagnostic.ShieldDiagnostic;
import blazon.shared.shield.diagnostic.ShieldDiagnostic.LogLevel;
import blazon.shared.shield.tinctures.Tincture;

public class SVGBarDrawer extends SVGOrdinaryDrawer {

	protected SVGBarDrawer(GeometricCharge charge, OMSVGDefsElement defs, List<ShieldDiagnostic> diags, int shieldWidth, int shieldHeight, int occurrences) {
		super(charge, defs, diags, shieldWidth, shieldHeight, occurrences);
	}

	@Override
	public OMSVGGElement drawOrdinary(CubicBezierCurve curve) {
		OMSVGGElement ordinaries = doc.createSVGGElement();
		final float fifthY = yMax/5f;
		final float offset = yMax/15f;
		Tincture tincture = charge.getTincture();
		switch(occurrences) {
		case 1:
			putNewRectElementOnGElement(ordinaries, xMin, 2*fifthY, xMax, fifthY, tincture);
			break;
		case 2:
			putNewRectElementOnGElement(ordinaries, xMin, fifthY + offset, xMax, fifthY, tincture);
			putNewRectElementOnGElement(ordinaries, xMin, 3*fifthY - offset, xMax, fifthY, tincture);
			break;
		case 3:
			{
				final float chargeHeight = fifthY - offset;
				putNewRectElementOnGElement(ordinaries, xMin, fifthY, xMax, chargeHeight, tincture);
				putNewRectElementOnGElement(ordinaries, xMin, 2*fifthY, xMax, chargeHeight, tincture);
				putNewRectElementOnGElement(ordinaries, xMin, 3*fifthY, xMax, chargeHeight, tincture);
				break;
			}
		case 4:
			{
				final float chargeHeight = fifthY - (1.5f * offset);
				putNewRectElementOnGElement(ordinaries, xMin, fifthY, xMax, chargeHeight, tincture);
				putNewRectElementOnGElement(ordinaries, xMin, 2*fifthY - offset, xMax, chargeHeight, tincture);
				putNewRectElementOnGElement(ordinaries, xMin, 2*fifthY + offset, xMax, chargeHeight, tincture);
				putNewRectElementOnGElement(ordinaries, xMin, 3*fifthY, xMax, chargeHeight, tincture);
				break;
			}
		default:
			diags.add(ShieldDiagnostic.build(LogLevel.ERROR, "SVGBarDrawer only knows how to draw 1 to 4 bars."));
		}
		return ordinaries;
	}

}
