package blazon.client.drawing.charges.geometric;

import org.vectomatic.dom.svg.OMSVGDefsElement;
import org.vectomatic.dom.svg.OMSVGGElement;
import org.vectomatic.dom.svg.OMSVGPathElement;
import org.vectomatic.dom.svg.OMSVGPathSegList;

import blazon.client.drawing.shapes.CubicBezierCurve;
import blazon.shared.shield.charges.GeometricCharge;
import blazon.shared.shield.tinctures.Tincture;

public class SVGFlaunchesDrawer extends SVGGeometricChargeDrawer {

	protected SVGFlaunchesDrawer(GeometricCharge shield, OMSVGDefsElement defs, int shieldWidth, int shieldHeight) {
		super(shield, defs, shieldWidth, shieldHeight);
	}

	@Override
	public OMSVGGElement drawCharge(CubicBezierCurve curve) {
		OMSVGGElement ordinaries = doc.createSVGGElement();
		Tincture tincture = charge.getTincture();
		final float yMid = shieldYMax/2f;
		final float thirdX = shieldXMax/3f;
		OMSVGPathElement path = doc.createSVGPathElement();
        OMSVGPathSegList segList = path.getPathSegList();
        segList.appendItem(path.createSVGPathSegMovetoAbs(shieldXMin, shieldYMin));
        segList.appendItem(path.createSVGPathSegCurvetoQuadraticAbs(shieldXMin, shieldYMax, thirdX, yMid));
        segList.appendItem(path.createSVGPathSegClosePath());
        addFillToElement(tincture, path);
        ordinaries.appendChild(path);
        path = doc.createSVGPathElement();
        segList = path.getPathSegList();
        segList.appendItem(path.createSVGPathSegMovetoAbs(shieldXMax, shieldYMin));
        segList.appendItem(path.createSVGPathSegCurvetoQuadraticAbs(shieldXMax, shieldYMax, 2*thirdX, yMid));
        segList.appendItem(path.createSVGPathSegClosePath());
        addFillToElement(tincture, path);
        ordinaries.appendChild(path);
        return ordinaries;
	}
}
