package blazon.client.drawing.shield.fur;

import org.vectomatic.dom.svg.OMSVGCircleElement;
import org.vectomatic.dom.svg.OMSVGGElement;
import org.vectomatic.dom.svg.OMSVGPathElement;
import org.vectomatic.dom.svg.OMSVGPathSegList;
import org.vectomatic.dom.svg.OMSVGPatternElement;
import org.vectomatic.dom.svg.OMSVGRectElement;
import org.vectomatic.dom.svg.utils.SVGConstants;

import blazon.shared.shield.tinctures.Fur;


public class ErmineSVGBuilder extends AbstractFurSVGBuilder  {
	private static final int HEIGHT = 60;
	private static final int WIDTH = 60;
	
	public void createPatternDefinition() {
		String furName = fur.getName();
		OMSVGPatternElement furShapePattern;
		String furShape = furName + SHAPE;
		furShapePattern = createFurShapeDefinition(furShape, fur);
		defs.appendChild(furShapePattern);
		
		OMSVGPatternElement furPattern = doc.createSVGPatternElement();
		OMSVGRectElement rect = doc.createSVGRectElement(0, 0, WIDTH, HEIGHT, 0, 0);
		rect.setAttribute(SVGConstants.CSS_FILL_PROPERTY, "url(#" + furShape + ")");
		furPattern.appendChild(rect);
		setAttributesOnPattern(furPattern, furName, WIDTH, HEIGHT*2);
		String translate = "translate(-" + Integer.toString(WIDTH/2) + ")";
		int w = (int) (WIDTH * 1.5);
		createGElementForFur(furPattern, translate, furShape, HEIGHT, w, HEIGHT);
		defs.appendChild(furPattern);
	}


	
	private OMSVGPatternElement createFurShapeDefinition(String name, Fur fur) {
		String colour1 = fur.getColour1();
		String colour2 = fur.getColour2();
		OMSVGPatternElement pattern = doc.createSVGPatternElement();
		setAttributesOnPattern(pattern, name, WIDTH, HEIGHT);
		
		OMSVGRectElement rect = doc.createSVGRectElement(0, 0, WIDTH, HEIGHT, 0, 0);
		rect.setAttribute(SVGConstants.CSS_FILL_PROPERTY, colour1);
		pattern.appendChild(rect);
		
		OMSVGGElement gElement = doc.createSVGGElement();
		gElement.setAttribute(SVGConstants.SVG_TRANSFORM_ATTRIBUTE, "translate(15,2)");
		OMSVGPathElement path = doc.createSVGPathElement();
		path.setAttribute(SVGConstants.CSS_FILL_PROPERTY, colour2);
		OMSVGPathSegList segList = path.getPathSegList();
		segList.appendItem(path.createSVGPathSegMovetoAbs(0, 54));
		segList.appendItem(path.createSVGPathSegCurvetoQuadraticAbs(14, 15, 14, 30));
		segList.appendItem(path.createSVGPathSegLinetoAbs(18, 16));
		segList.appendItem(path.createSVGPathSegCurvetoQuadraticAbs(30, 54, 18, 30));
		segList.appendItem(path.createSVGPathSegLinetoAbs(20, 46));
		segList.appendItem(path.createSVGPathSegLinetoAbs(16, 54));
		segList.appendItem(path.createSVGPathSegLinetoAbs(10, 46));
		segList.appendItem(path.createSVGPathSegClosePath());
		gElement.appendChild(path);
		OMSVGCircleElement circle = doc.createSVGCircleElement(8,16,5);
		circle.setAttribute(SVGConstants.SVG_FILL_ATTRIBUTE, colour2);
		gElement.appendChild(circle);
		circle = doc.createSVGCircleElement(16,8,5);
		circle.setAttribute(SVGConstants.SVG_FILL_ATTRIBUTE, colour2);
		gElement.appendChild(circle);
		circle = doc.createSVGCircleElement(24,16,5);
		circle.setAttribute(SVGConstants.SVG_FILL_ATTRIBUTE, colour2);
		gElement.appendChild(circle);
		pattern.appendChild(gElement);
		return pattern;
	}
}
