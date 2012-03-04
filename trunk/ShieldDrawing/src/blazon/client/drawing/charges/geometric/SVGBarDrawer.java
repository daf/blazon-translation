package blazon.client.drawing.charges.geometric;

import org.vectomatic.dom.svg.OMSVGDefsElement;
import org.vectomatic.dom.svg.OMSVGGElement;

import blazon.client.drawing.shapes.CubicBezierCurve;
import blazon.shared.shield.charges.GeometricCharge;
import blazon.shared.shield.diagnostic.ShieldDiagnostic;
import blazon.shared.shield.diagnostic.ShieldDiagnostic.LogLevel;
import blazon.shared.shield.tinctures.Tincture;

public class SVGBarDrawer extends SVGGeometricChargeDrawer {

	protected SVGBarDrawer(GeometricCharge charge, OMSVGDefsElement defs, int shieldWidth, int shieldHeight, int occurrences) {
		super(charge, defs, shieldWidth, shieldHeight, occurrences);
	}

	@Override
	public OMSVGGElement drawCharge(CubicBezierCurve curve) {
		OMSVGGElement ordinaries = doc.createSVGGElement();
		final float yDiff = getYDiff();
		final float fifthY = yDiff/5f;
		final float offset = fifthY/3f;
		Tincture tincture = charge.getTincture();
		switch(occurrences) {
		case 1:
			putNewRectElementOnGElement(ordinaries, chargeAreaXMin, chargeAreaYMin + 2*fifthY, chargeAreaXMax, fifthY, tincture);
			break;
		case 2:
			putNewRectElementOnGElement(ordinaries, chargeAreaXMin, chargeAreaYMin + fifthY + offset, chargeAreaXMax, fifthY, tincture);
			putNewRectElementOnGElement(ordinaries, chargeAreaXMin, chargeAreaYMin + 3*fifthY - offset, chargeAreaXMax, fifthY, tincture);
			break;
		case 3:
			{
				final float chargeHeight = fifthY - offset;
				putNewRectElementOnGElement(ordinaries, chargeAreaXMin, chargeAreaYMin + fifthY, chargeAreaXMax, chargeHeight, tincture);
				putNewRectElementOnGElement(ordinaries, chargeAreaXMin, chargeAreaYMin + 2*fifthY, chargeAreaXMax, chargeHeight, tincture);
				putNewRectElementOnGElement(ordinaries, chargeAreaXMin, chargeAreaYMin + 3*fifthY, chargeAreaXMax, chargeHeight, tincture);
				break;
			}
		case 4:
			{
				final float chargeHeight = fifthY - (1.5f * offset);
				putNewRectElementOnGElement(ordinaries, chargeAreaXMin, chargeAreaYMin + fifthY, chargeAreaXMax, chargeHeight, tincture);
				putNewRectElementOnGElement(ordinaries, chargeAreaXMin, chargeAreaYMin + 2*fifthY - offset, chargeAreaXMax, chargeHeight, tincture);
				putNewRectElementOnGElement(ordinaries, chargeAreaXMin, chargeAreaYMin + 2*fifthY + offset, chargeAreaXMax, chargeHeight, tincture);
				putNewRectElementOnGElement(ordinaries, chargeAreaXMin, chargeAreaYMin + 3*fifthY, chargeAreaXMax, chargeHeight, tincture);
				break;
			}
		default:
			diags.add(ShieldDiagnostic.build(LogLevel.ERROR, "SVGBarDrawer only knows how to draw 1 to 4 bars."));
		}
		return ordinaries;
	}

}
