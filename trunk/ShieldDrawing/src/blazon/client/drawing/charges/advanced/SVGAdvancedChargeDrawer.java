package blazon.client.drawing.charges.advanced;

import java.util.List;

import org.vectomatic.dom.svg.OMSVGDefsElement;
import org.vectomatic.dom.svg.OMSVGGElement;
import org.vectomatic.dom.svg.OMSVGImageElement;

import com.google.gwt.user.client.ui.Image;

import blazon.client.drawing.charges.geometric.SVGChargeDrawer;
import blazon.client.drawing.shapes.CubicBezierCurve;
import blazon.shared.shield.charges.AdvancedCharge;
import blazon.shared.shield.diagnostic.ShieldDiagnostic;
import blazon.shared.shield.diagnostic.ShieldDiagnostic.LogLevel;

public class SVGAdvancedChargeDrawer extends SVGChargeDrawer {

	private AdvancedCharge charge;
	
	public SVGAdvancedChargeDrawer(AdvancedCharge charge, OMSVGDefsElement defs, List<ShieldDiagnostic> diags, int shieldWidth, int shieldHeight) {
		super(defs, diags, shieldWidth, shieldHeight);
		this.charge = charge;
	}

	@Override
	public OMSVGGElement drawCharge(CubicBezierCurve curve) {
		OMSVGGElement ordinaries = doc.createSVGGElement();
		String imageSource = charge.getSource();
		int retryCount = 0;
		int currentWidth;
		int currentHeight;
		do {
			Image image = new Image(imageSource);
			currentWidth = image.getWidth();
			currentHeight = image.getHeight();
		}
		while (currentHeight == 0 && currentWidth == 0 && retryCount++ < 5);

		if (retryCount == 5) {
			diags.add(ShieldDiagnostic.build(LogLevel.ERROR, "Could not load the image for the charge " + charge.getTextDescription() + " at URL '" + imageSource + "'"));
			return ordinaries;
		}
		float wToHRatio = currentWidth / (float) currentHeight;
		int width = 300;
		int height = Math.round(width * wToHRatio);
		OMSVGImageElement imageElement = doc.createSVGImageElement(xMax/2 - width/2, yMax/2 - height/2, width, height, imageSource);
		ordinaries.appendChild(imageElement);
		return ordinaries;
	}
}
