package blazon.client.drawing.charges.geometric;

import org.vectomatic.dom.svg.OMSVGDefsElement;
import org.vectomatic.dom.svg.OMSVGGElement;
import org.vectomatic.dom.svg.OMSVGPathElement;
import org.vectomatic.dom.svg.OMSVGPathSegList;

import blazon.client.drawing.shapes.CubicBezierCurve;
import blazon.shared.shield.charges.GeometricCharge;

public class SVGFlaunchesDrawer extends SVGOrdinaryDrawer {

	public SVGFlaunchesDrawer(GeometricCharge shield, OMSVGDefsElement defs, int shieldWidth, int shieldHeight) {
		super(shield, defs, shieldWidth, shieldHeight);
	}

	@Override
	public OMSVGGElement drawOrdinary(OMSVGGElement shieldContainer,
			CubicBezierCurve curve) {
		OMSVGGElement ordinaries = doc.createSVGGElement();
		final float yMid = yMax/2f;
		final float thirdX = xMax/3f;
		OMSVGPathElement path = doc.createSVGPathElement();
        OMSVGPathSegList segList = path.getPathSegList();
        segList.appendItem(path.createSVGPathSegMovetoAbs(xMin, yMin));
        segList.appendItem(path.createSVGPathSegCurvetoQuadraticAbs(xMin, yMax, thirdX, yMid));
        segList.appendItem(path.createSVGPathSegClosePath());
        addFillToElement(charge.getTincture(), path);
        ordinaries.appendChild(path);
        path = doc.createSVGPathElement();
        segList = path.getPathSegList();
        segList.appendItem(path.createSVGPathSegMovetoAbs(xMax, yMin));
        segList.appendItem(path.createSVGPathSegCurvetoQuadraticAbs(xMax, yMax, 2*thirdX, yMid));
        segList.appendItem(path.createSVGPathSegClosePath());
        addFillToElement(charge.getTincture(), path);
        ordinaries.appendChild(path);
        return ordinaries;
	}
}
