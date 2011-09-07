package blazon.client.drawing.shield.fur;

import org.vectomatic.dom.svg.OMSVGPathElement;
import org.vectomatic.dom.svg.OMSVGPatternElement;
import org.vectomatic.dom.svg.OMSVGRectElement;
import org.vectomatic.dom.svg.utils.SVGConstants;

import blazon.shared.shield.tinctures.Fur;
import blazon.shared.shield.tinctures.Fur.FurType;

public abstract class AbstractSquirrelFurBuilder extends AbstractFurSVGBuilder {
	protected static final String COUNTER = "counter-";
	protected static final String EN_PALE = "-en-pale";
	protected static final String INVERTED = "-inverted";
	protected static final String EN_POINT = "-en-point";
	
	protected abstract OMSVGPathElement createFurShapePath(String colour);
	protected abstract int getWidth();
	protected abstract int getHeight();
	
	public void createPatternDefinition() {
		FurType furType = fur.getFurType();
		String furShape = furType + SHAPE;
		String furName = fur.getName();
		int width = getWidth();
		int height = getHeight();
		createDefinitions(furShape, width, height, fur);
		OMSVGPatternElement pattern = doc.createSVGPatternElement();
		OMSVGRectElement rect = doc.createSVGRectElement(0, 0, width, height, 0, 0);
		rect.setAttribute(SVGConstants.CSS_FILL_PROPERTY, "url(#" + furShape + ")");
		setAttributesOnPattern(pattern, furName, width, height*2);
		pattern.appendChild(rect);
		
		if (furName.equals(furType.toString().toLowerCase())) {
			String translate = "translate(-" + Integer.toString(width/2) + ")";
			int w = (int) (width * 1.5);
			createGElementForFur(pattern, translate, furShape, height, w, height);
		} else if (furName.equals(furType + EN_POINT)) {
			createGElementForFur(pattern, null, furShape + INVERTED, height, width, height);
		} else if (furName.equals(COUNTER + furType)) {
			String rotate = "rotate(180," + Integer.toString(width/2) + "," + height + ")";
			createGElementForFur(pattern, rotate, furShape, 0, width, height);
		} else if (furName.equals(furType + EN_PALE)) {
			pattern.setAttribute(SVGConstants.SVG_HEIGHT_ATTRIBUTE, Integer.toString(height));
		}
		defs.appendChild(pattern);
	}

	private void createDefinitions(String furShape, int width, int height, Fur fur) {
		String colour1 = fur.getColour1();
		String colour2 = fur.getColour2();
		OMSVGPatternElement pattern = createFurShapeDefinition(width, height, furShape, colour1, colour2);
		defs.appendChild(pattern);
		pattern = createFurShapeDefinition(width, height, furShape + INVERTED, colour2, colour1);
		defs.appendChild(pattern);
	}
	
	private OMSVGPatternElement createFurShapeDefinition(int width, int height, String name, String colour1, String colour2) {
		OMSVGPatternElement pattern = doc.createSVGPatternElement();
		setAttributesOnPattern(pattern, name, width, height);
		OMSVGRectElement rect = doc.createSVGRectElement(0, 0, width, height, 0, 0);
		rect.setAttribute(SVGConstants.CSS_FILL_PROPERTY, colour1);
		pattern.appendChild(rect);
		OMSVGPathElement path = createFurShapePath(colour2);
		pattern.appendChild(path);
		return pattern;
	}
}
