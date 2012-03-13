package blazon.client.drawing.charges.advanced;

import java.util.List;

import org.vectomatic.dom.svg.OMSVGDefsElement;
import org.vectomatic.dom.svg.OMSVGGElement;
import org.vectomatic.dom.svg.OMSVGImageElement;

import com.google.gwt.user.client.ui.Image;

import blazon.client.drawing.charges.geometric.mobile.SVGMobileChargeDrawer;
import blazon.client.drawing.shapes.CubicBezierCurve;
import blazon.shared.shield.charges.AdvancedCharge;
import blazon.shared.shield.diagnostic.ShieldDiagnostic;
import blazon.shared.shield.tinctures.Tincture;

public class SVGAdvancedChargeDrawer extends SVGMobileChargeDrawer {

	public SVGAdvancedChargeDrawer(AdvancedCharge charge, OMSVGDefsElement defs, List<ShieldDiagnostic> diags, int shieldWidth, int shieldHeight, int occurrences) {
		super(charge, defs, shieldWidth, shieldHeight, occurrences);
	}

	@Override
	protected float rowOffset(int multiplier, float chargeHeight) {
		int rowDivisor = (occurrences+1)/2*2; // convert to next even number
		float edgeOverlapOffset = chargeAreaGoesOverEdgeOfShield() ? 0.8f : 1;
		float rowMidPoint = edgeOverlapOffset*getYDiff()/(float)rowDivisor;
		return chargeAreaYMin + multiplier*rowMidPoint;
	}
	
	@Override
	protected float columnOffset(int multiplier, int numberOfColumns, float chargeWidth) {
		return chargeAreaXMin + multiplier*getXDiff()/(float)numberOfColumns;
	}
	
	@Override
	public OMSVGGElement drawCharge(CubicBezierCurve curve) {
		OMSVGGElement charges = doc.createSVGGElement();
		Image image = new Image(charge.getSource());
		int currentWidth = image.getWidth();
		int currentHeight = image.getHeight();
		if (currentWidth == 0 && currentHeight == 0) {
			currentWidth = 400;
			currentHeight = 400;
		}
		float hToWRatio = currentHeight / (float) currentWidth;
		final float chargeHeight = getYDiff()*0.8f / (float)(occurrences);
		final float chargeWidth = hToWRatio * chargeHeight;
		final Tincture tincture = charge.getTincture();
		return drawMobileCharges(chargeHeight, chargeWidth, charges, tincture, curve);
	}
	
	@Override
	protected void drawMobileCharge(OMSVGGElement charges, float column, float row, float chargeWidth, float chargeHeight, Tincture tincture, CubicBezierCurve curve) {
		OMSVGImageElement imageElement = doc.createSVGImageElement(column - chargeWidth/2, row - chargeHeight/2, chargeWidth, chargeHeight, charge.getSource());
		charges.appendChild(imageElement);
	}
}
