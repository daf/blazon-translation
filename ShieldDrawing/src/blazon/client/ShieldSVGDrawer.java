package blazon.client;

import java.util.Iterator;

import org.vectomatic.dom.svg.OMSVGDefsElement;
import org.vectomatic.dom.svg.OMSVGDocument;
import org.vectomatic.dom.svg.OMSVGGElement;
import org.vectomatic.dom.svg.OMSVGRectElement;
import org.vectomatic.dom.svg.utils.SVGConstants;

import blazon.client.svg.fur.FurSVGBuilder;
import blazon.client.svg.fur.AbstractFurSVGBuilder;
import blazon.shared.shield.Shield;
import blazon.shared.shield.ShieldLayer;
import blazon.shared.shield.tinctures.Colour;
import blazon.shared.shield.tinctures.Fur;
import blazon.shared.shield.tinctures.Metal;
import blazon.shared.shield.tinctures.Tincture;

public class ShieldSVGDrawer {
	
	private OMSVGDocument doc;
	private Shield shield;
	private OMSVGDefsElement defs;

	public static ShieldSVGDrawer build(Shield shield, OMSVGDocument doc, OMSVGDefsElement defs) {
		ShieldSVGDrawer drawer = new ShieldSVGDrawer();
		drawer.doc = doc;
		drawer.shield = shield;
		drawer.defs = defs;
		return drawer;
	}

	private OMSVGGElement buildSVGField() {
		OMSVGGElement field = doc.createSVGGElement();
		
        ShieldLayer base = shield.getField();
        Iterator<Tincture> tinctures = base.getTinctures().getTincturesOnLayerIterator();
        Tincture t = tinctures.next();
        OMSVGRectElement rect = doc.createSVGRectElement(10, 10, 390, 390, 0, 0);
        if (t instanceof Metal || t instanceof Colour) {
        	rect.setAttribute(SVGConstants.CSS_FILL_VALUE, t.getPatternReference());
        } else if (t instanceof Fur) {
        	FurSVGBuilder furBuilder = AbstractFurSVGBuilder.build(doc, defs, (Fur)t);
        	furBuilder.createPatternDefinition();
        	rect.setAttribute(SVGConstants.CSS_FILL_VALUE, t.getPatternReference());
        }
        field.appendChild(rect);
        return field; 
	}

	public void drawSVGShield(OMSVGGElement shieldContainer) {
		OMSVGGElement field = buildSVGField();
		shieldContainer.appendChild(field);
		
	}

}
