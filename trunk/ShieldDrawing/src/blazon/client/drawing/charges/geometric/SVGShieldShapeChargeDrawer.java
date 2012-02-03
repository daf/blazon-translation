package blazon.client.drawing.charges.geometric;

import java.util.List;

import org.vectomatic.dom.svg.OMSVGDefsElement;
import org.vectomatic.dom.svg.OMSVGPathElement;
import org.vectomatic.dom.svg.OMSVGPathSegList;

import blazon.client.drawing.shapes.CubicBezierCurve;
import blazon.shared.shield.charges.GeometricCharge;
import blazon.shared.shield.diagnostic.ShieldDiagnostic;

public abstract class SVGShieldShapeChargeDrawer extends SVGGeometricChargeDrawer {

	protected SVGShieldShapeChargeDrawer(GeometricCharge charge, OMSVGDefsElement defs,	List<ShieldDiagnostic> diags, int shieldWidth, int shieldHeight) {
		super(charge, defs, diags, shieldWidth, shieldHeight);
	}

	protected void drawScaledAndOffsetShieldShape(CubicBezierCurve curve, OMSVGPathElement path, float chargeWidthDenomenator, float offset) {
		final float xSize = (offset * xMax) / chargeWidthDenomenator;
		final float ySize = (offset * yMax) / chargeWidthDenomenator;
		final float scale = (chargeWidthDenomenator - offset)/chargeWidthDenomenator;
		OMSVGPathSegList segList = path.getPathSegList();
		segList.appendItem(path.createSVGPathSegMovetoAbs(xSize, ySize));
		segList.appendItem(path.createSVGPathSegLinetoVerticalAbs(curve.getEndPoint1().getY()*scale));
		segList.appendItem(
				path.createSVGPathSegCurvetoCubicAbs(
						curve.getEndPoint2().getX(), curve.getEndPoint2().getY()*scale,
						curve.getControlPoint1().getX()+xSize, curve.getControlPoint1().getY()*scale, 
						curve.getControlPoint2().getX(), curve.getControlPoint2().getY()*scale));
		segList.appendItem(
				path.createSVGPathSegCurvetoCubicAbs(
						(xMax - curve.getEndPoint1().getX())*scale, curve.getEndPoint1().getY()*scale,
						xMax - curve.getControlPoint2().getX(), curve.getControlPoint2().getY()*scale,
						(xMax - curve.getControlPoint1().getX())*scale, curve.getControlPoint1().getY()*scale));
		segList.appendItem(path.createSVGPathSegLinetoVerticalAbs(ySize));
		segList.appendItem(path.createSVGPathSegClosePath());
	}
}
