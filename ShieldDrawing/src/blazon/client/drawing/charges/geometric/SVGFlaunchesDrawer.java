package blazon.client.drawing.charges.geometric;

import java.util.List;

import org.vectomatic.dom.svg.OMSVGDefsElement;
import org.vectomatic.dom.svg.OMSVGGElement;
import org.vectomatic.dom.svg.OMSVGPathElement;
import org.vectomatic.dom.svg.OMSVGPathSegList;

import blazon.client.drawing.shapes.CubicBezierCurve;
import blazon.shared.shield.charges.GeometricCharge;
import blazon.shared.shield.diagnostic.ShieldDiagnostic;
import blazon.shared.shield.tinctures.Tincture;

public class SVGFlaunchesDrawer extends SVGOrdinaryDrawer {

	protected SVGFlaunchesDrawer(GeometricCharge shield, OMSVGDefsElement defs, List<ShieldDiagnostic> diags, int shieldWidth, int shieldHeight) {
		super(shield, defs, diags, shieldWidth, shieldHeight);
	}

	@Override
	public OMSVGGElement drawOrdinary(CubicBezierCurve curve) {
		OMSVGGElement ordinaries = doc.createSVGGElement();
		Tincture tincture = charge.getTincture();
		final float yMid = yMax/2f;
		final float thirdX = xMax/3f;
		OMSVGPathElement path = doc.createSVGPathElement();
        OMSVGPathSegList segList = path.getPathSegList();
        segList.appendItem(path.createSVGPathSegMovetoAbs(xMin, yMin));
        segList.appendItem(path.createSVGPathSegCurvetoQuadraticAbs(xMin, yMax, thirdX, yMid));
        segList.appendItem(path.createSVGPathSegClosePath());
        addFillToElement(tincture, path);
        ordinaries.appendChild(path);
        path = doc.createSVGPathElement();
        segList = path.getPathSegList();
        segList.appendItem(path.createSVGPathSegMovetoAbs(xMax, yMin));
        segList.appendItem(path.createSVGPathSegCurvetoQuadraticAbs(xMax, yMax, 2*thirdX, yMid));
        segList.appendItem(path.createSVGPathSegClosePath());
        addFillToElement(tincture, path);
        ordinaries.appendChild(path);
        return ordinaries;
	}
}
