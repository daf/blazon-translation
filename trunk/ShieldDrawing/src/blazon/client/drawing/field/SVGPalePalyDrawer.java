package blazon.client.drawing.field;

import org.vectomatic.dom.svg.OMSVGDefsElement;
import org.vectomatic.dom.svg.OMSVGGElement;

import blazon.client.drawing.shapes.CubicBezierCurve;
import blazon.shared.shield.Field;
import blazon.shared.shield.ShieldDivision.ShieldDivisionType;
import blazon.shared.shield.tinctures.Tincture;
import blazon.shared.shield.tinctures.Tinctures;

class SVGPalePalyDrawer extends SVGFieldDrawer {

	protected SVGPalePalyDrawer(Field field, OMSVGDefsElement defs, int shieldWidth, int shieldHeight) {
		super(field, defs, shieldWidth, shieldHeight);
	}

	@Override
	public OMSVGGElement drawField(CubicBezierCurve curve) {
		final OMSVGGElement svgField = doc.createSVGGElement();
		final ShieldDivisionType division = field.getShieldDivision();
    	final int numberOfSections = division.getNumberOfSections();
		final Tinctures tinctures = field.getTinctures();
		final int widthOfBar = (int) Math.ceil(xMax / (double) numberOfSections);
		final Tincture[] tincturesOnLayer = tinctures.getTincturesOnLayer().toArray(new Tincture[0]);
		final int numberOfTinctures = division.getNumberOfTinctures();
			
		for (int i = 0; i < numberOfSections; i++) {
			int xPos = i * widthOfBar;
			Tincture currentTincture = tincturesOnLayer[i % numberOfTinctures];
			putNewRectElementOnGElement(svgField, xPos, yMin, widthOfBar, yMax, currentTincture);
		}
		return svgField;
	}

}
