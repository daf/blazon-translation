package blazon.client.drawing.field;

import java.util.Iterator;

import org.vectomatic.dom.svg.OMSVGDefsElement;
import org.vectomatic.dom.svg.OMSVGGElement;

import blazon.client.drawing.shapes.CubicBezierCurve;
import blazon.shared.shield.Field;
import blazon.shared.shield.ShieldDivision.ShieldDivisionType;
import blazon.shared.shield.tinctures.Tincture;
import blazon.shared.shield.tinctures.Tinctures;

class SVGChequyDrawer extends SVGFieldDrawer {

	protected SVGChequyDrawer(Field field, OMSVGDefsElement defs, int shieldWidth, int shieldHeight) {
		super(field, defs, shieldWidth, shieldHeight);
	}

	@Override
	public OMSVGGElement drawField(CubicBezierCurve curve) {
		final OMSVGGElement svgField = doc.createSVGGElement();
		final ShieldDivisionType division = field.getShieldDivision();
    	final int numberOfSections = division.getNumberOfSections();
		final Tinctures tinctures = field.getTinctures();
		final Iterator<Tincture> it = tinctures.getTincturesOnLayer().iterator();
		final Tincture firstTincture = it.next();
		final Tincture secondTincture = it.next();
		final double rootOfNumberOfSectionsRoundedToPerfectSquare = Math.ceil(Math.sqrt(numberOfSections));
		final int heightOfRect = (int) Math.ceil(yMax / rootOfNumberOfSectionsRoundedToPerfectSquare);
		final int widthOfRect = (int) Math.ceil(xMax / rootOfNumberOfSectionsRoundedToPerfectSquare);
		
		for (int i = 0; i < rootOfNumberOfSectionsRoundedToPerfectSquare; i++) {
			int xPos = i * widthOfRect;
			for (int j = 0; j < rootOfNumberOfSectionsRoundedToPerfectSquare; j++) {
				int yPos = j * heightOfRect;
				Tincture currentTincture = (i % 2 == j % 2) ? firstTincture : secondTincture;
				putNewRectElementOnGElement(svgField, xPos, yPos, widthOfRect, heightOfRect, currentTincture);
			}
		}
		return svgField;
	}

}
