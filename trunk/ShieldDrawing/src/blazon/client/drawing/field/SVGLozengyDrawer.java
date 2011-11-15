package blazon.client.drawing.field;

import java.util.Iterator;

import org.vectomatic.dom.svg.OMSVGDefsElement;
import org.vectomatic.dom.svg.OMSVGGElement;

import blazon.client.drawing.shapes.CubicBezierCurve;
import blazon.client.drawing.shapes.FourPointedPolygon;
import blazon.client.drawing.shapes.Point;
import blazon.client.drawing.shapes.Polygon;
import blazon.shared.shield.Field;
import blazon.shared.shield.ShieldDivision.ShieldDivisionType;
import blazon.shared.shield.tinctures.Tincture;
import blazon.shared.shield.tinctures.Tinctures;

class SVGLozengyDrawer extends SVGFieldDrawer {

	protected SVGLozengyDrawer(Field field, OMSVGDefsElement defs, int shieldWidth, int shieldHeight) {
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
		final int heightOfLozenge = (int) Math.ceil(yMax / rootOfNumberOfSectionsRoundedToPerfectSquare);
		final int widthOfLozenge = (int) Math.ceil(xMax / rootOfNumberOfSectionsRoundedToPerfectSquare);
		final float halfWidthOfLozenge = widthOfLozenge / 2f;
		final float halfHeightOfLozenge = heightOfLozenge / 2f;
		
		for (int i = 0; i <= rootOfNumberOfSectionsRoundedToPerfectSquare; i++) {
			for (int j = 0; j <= rootOfNumberOfSectionsRoundedToPerfectSquare; j++) {
				float xPos = (i * widthOfLozenge) - halfWidthOfLozenge;
				float yPos = (j * heightOfLozenge) - halfHeightOfLozenge;
				Polygon polygon = new FourPointedPolygon(new Point(xPos, yPos), new Point(xPos + widthOfLozenge, yPos), new Point(xPos, yPos + heightOfLozenge), new Point(xPos + widthOfLozenge, yPos + heightOfLozenge));
				putNewPolygonElementOnGElement(svgField, firstTincture, polygon);
				xPos += halfWidthOfLozenge;
				yPos += halfHeightOfLozenge;
				polygon = new FourPointedPolygon(new Point(xPos, yPos), new Point(xPos + widthOfLozenge, yPos), new Point(xPos, yPos + heightOfLozenge), new Point(xPos + widthOfLozenge, yPos + heightOfLozenge));
				putNewPolygonElementOnGElement(svgField, secondTincture, polygon);
			}
		}
		return svgField;
	}

}
