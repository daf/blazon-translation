package blazon.client.drawing.field;

import java.util.Iterator;

import org.vectomatic.dom.svg.OMSVGDefsElement;
import org.vectomatic.dom.svg.OMSVGGElement;

import blazon.client.drawing.shapes.CubicBezierCurve;
import blazon.shared.shield.Field;
import blazon.shared.shield.tinctures.Tincture;
import blazon.shared.shield.tinctures.Tinctures;

class SVGCrossDrawer extends SVGFieldDrawer {

	protected SVGCrossDrawer(Field field, OMSVGDefsElement defs, int shieldWidth, int shieldHeight) {
		super(field, defs, shieldWidth, shieldHeight);
	}

	@Override
	public OMSVGGElement drawField(CubicBezierCurve curve) {
		final OMSVGGElement svgField = doc.createSVGGElement();
		final int xMid = xMax/2;
		final int yMid = yMax/2;
		final Tinctures tinctures = field.getTinctures();
		final Iterator<Tincture> it = tinctures.getTincturesOnLayer().iterator();
		Tincture firstTincture = it.next();
		Tincture secondTincture = it.next();
		putNewRectElementOnGElement(svgField, xMin, yMin, xMid, xMid, firstTincture);
		putNewRectElementOnGElement(svgField, xMid, yMid, xMid, yMid, firstTincture);
		putNewRectElementOnGElement(svgField, xMin, yMid, xMid, yMid, secondTincture);
		putNewRectElementOnGElement(svgField, xMid, yMin, xMid, yMid, secondTincture);			
		return svgField;
	}
}
