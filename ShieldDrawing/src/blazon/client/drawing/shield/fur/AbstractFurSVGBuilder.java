package blazon.client.drawing.shield.fur;

import org.vectomatic.dom.svg.OMSVGDefsElement;
import org.vectomatic.dom.svg.OMSVGDocument;
import org.vectomatic.dom.svg.OMSVGGElement;
import org.vectomatic.dom.svg.OMSVGPatternElement;
import org.vectomatic.dom.svg.OMSVGRectElement;
import org.vectomatic.dom.svg.utils.SVGConstants;

import blazon.shared.shield.tinctures.Fur;
import blazon.shared.shield.tinctures.Fur.FurType;

public abstract class AbstractFurSVGBuilder implements FurSVGBuilder {
	protected static final String SHAPE = "-shape";
	protected OMSVGDocument doc;
	protected OMSVGDefsElement defs;
	protected Fur fur;
	
	public static FurSVGBuilder build(OMSVGDocument doc, OMSVGDefsElement defs, Fur fur) {
		if (doc == null || defs == null || fur == null) {
			throw new IllegalArgumentException("Could not create FurSVGBuilder due to null argument");
		}
		
		AbstractFurSVGBuilder furBuilder;
		FurType furType = fur.getFurType();
		if (furType == FurType.VAIR) {
			furBuilder = new VairSVGBuilder();
		} else if (furType == FurType.POTENT) {
			furBuilder = new PotentSVGBuilder();
		} else if (furType == FurType.ERMINE) {
			furBuilder = new ErmineSVGBuilder();
		} else {
			throw new IllegalArgumentException("Could not create FurSVGBuilder due to unrecognised furType: " + furType);
		}
		
		furBuilder.setDoc(doc);
		furBuilder.setDefs(defs);
		furBuilder.setFur(fur);
		return furBuilder;
	}
	
	protected void createGElementForFur(OMSVGPatternElement pattern, String transform, String fill, int y, int width, int height) {
		OMSVGRectElement rect;
		OMSVGGElement g = doc.createSVGGElement();
		if (transform != null) {
			g.setAttribute(SVGConstants.SVG_TRANSFORM_ATTRIBUTE, transform);
		}
		rect = doc.createSVGRectElement(0, y, width, height, 0, 0);
		fill = "url(#" + fill + ")";
		rect.setAttribute(SVGConstants.CSS_FILL_PROPERTY, fill);
		g.appendChild(rect);
		pattern.appendChild(g);
	}
	
	protected void setAttributesOnPattern(OMSVGPatternElement pattern, String id, int width, int height) {
		pattern.setAttribute(SVGConstants.SVG_ID_ATTRIBUTE, id);
		pattern.setAttribute(SVGConstants.SVG_WIDTH_ATTRIBUTE, Integer.toString(width));
		pattern.setAttribute(SVGConstants.SVG_HEIGHT_ATTRIBUTE, Integer.toString(height));
		pattern.setAttribute(SVGConstants.SVG_PATTERN_UNITS_ATTRIBUTE, SVGConstants.SVG_USER_SPACE_ON_USE_VALUE);
	}
	
	private void setFur(Fur fur) {
		this.fur = fur;
	}

	private void setDefs(OMSVGDefsElement defs) {
		this.defs = defs;
	}

	private void setDoc(OMSVGDocument doc) {
		this.doc = doc;
	}
}
