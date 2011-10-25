package blazon.client.drawing;

import org.vectomatic.dom.svg.OMSVGDefsElement;
import org.vectomatic.dom.svg.OMSVGDocument;
import org.vectomatic.dom.svg.OMSVGGElement;
import org.vectomatic.dom.svg.OMSVGLength;
import org.vectomatic.dom.svg.OMSVGMaskElement;
import org.vectomatic.dom.svg.OMSVGPathElement;
import org.vectomatic.dom.svg.OMSVGPathSegList;
import org.vectomatic.dom.svg.OMSVGSVGElement;
import org.vectomatic.dom.svg.OMSVGTextElement;
import org.vectomatic.dom.svg.utils.OMSVGParser;
import org.vectomatic.dom.svg.utils.SVGConstants;

import blazon.client.drawing.shapes.CubicBezierCurve;
import blazon.shared.shield.Shield;
import blazon.shared.shield.ShieldImpl;

public class SVGShieldDrawer {

	private final OMSVGDocument doc = OMSVGParser.currentDocument();
	
	private final int width;
	private final int height;
	private final CubicBezierCurve curve;
	
	public SVGShieldDrawer(int svgPanelWidth, int svgPanelHeight) {
		width = svgPanelWidth;
		height = svgPanelHeight;
        float topOfCurve = height * 0.375f;
        float curveMidpoint = height * 0.85f;
        float halfWidth = width/2f;
		curve = new CubicBezierCurve(0, topOfCurve, halfWidth, height, 0, curveMidpoint, halfWidth, height);
	}

	public void drawInitialShield(OMSVGSVGElement svg) {
		svg.appendChild(createShieldShapePath());
		addInitialTextToShield(svg);
	}

    public void draw(Shield shield, OMSVGSVGElement svg) {
    	if (shield instanceof ShieldImpl) {
    		svg.appendChild(createShieldShapePath());
    		svg.appendChild(createShieldShapeMask());
	    	addTitleAndDescriptionToSVG(shield.getBlazon(), svg);
	        
	    	OMSVGGElement shieldContainer = doc.createSVGGElement();
	    	svg.appendChild(shieldContainer);
	    	OMSVGDefsElement defs = doc.createSVGDefsElement();
	    	svg.appendChild(defs);
	    	shieldContainer.setAttribute(SVGConstants.SVG_MASK_ATTRIBUTE, "url(#ShieldMask)");
	        SVGFieldDrawer fieldDrawer = new SVGFieldDrawer((ShieldImpl)shield, defs, width, height);
	        fieldDrawer.drawField(shieldContainer, curve);
	        SVGOrdinaryDrawer ordinaryDrawer = new SVGOrdinaryDrawer((ShieldImpl)shield, defs, width, height);
	        ordinaryDrawer.drawOrdinaries(shieldContainer, curve);
    	}
    }
    
    private OMSVGPathElement createShieldShapePath() {
    	OMSVGPathElement path = doc.createSVGPathElement();
        path.setId("ShieldShape");
        OMSVGPathSegList segList = path.getPathSegList();
        segList.appendItem(path.createSVGPathSegMovetoAbs(0, 0));
        segList.appendItem(path.createSVGPathSegLinetoVerticalAbs(curve.getEndPoint1().getY()));
        segList.appendItem(
        		path.createSVGPathSegCurvetoCubicAbs(
        				curve.getEndPoint2().getX(), curve.getEndPoint2().getY(),
        				curve.getControlPoint1().getX(), curve.getControlPoint1().getY(), 
        				curve.getControlPoint2().getX(), curve.getControlPoint2().getY()));
        segList.appendItem(
        		path.createSVGPathSegCurvetoCubicAbs(
        				width - curve.getEndPoint1().getX(), curve.getEndPoint1().getY(),
        				width - curve.getControlPoint2().getX(), curve.getControlPoint2().getY(),
        				width - curve.getControlPoint1().getX(), curve.getControlPoint1().getY()));
        segList.appendItem(path.createSVGPathSegLinetoVerticalAbs(0));
        segList.appendItem(path.createSVGPathSegClosePath());
        path.setAttribute(SVGConstants.SVG_STROKE_ATTRIBUTE, SVGConstants.CSS_BLACK_VALUE);
        path.setAttribute(SVGConstants.SVG_STROKE_WIDTH_ATTRIBUTE, "1");
        path.setAttribute(SVGConstants.SVG_FILL_ATTRIBUTE, SVGConstants.CSS_WHITE_VALUE);
        return path;
    }
    
    private OMSVGMaskElement createShieldShapeMask() {
        OMSVGMaskElement mask = doc.createSVGMaskElement();
        mask.setId("ShieldMask");
        mask.appendChild(createShieldShapePath());
        return mask;
    }
    
	private void addTitleAndDescriptionToSVG(String blazon, OMSVGSVGElement svg) {
    	svg.appendChild(doc.createSVGTitleElement(blazon));
    	svg.appendChild(doc.createSVGDescElement("This is a shield described as '" + blazon + "'."));
    }
    
    private void addInitialTextToShield(OMSVGSVGElement svg) {
    	OMSVGTextElement initialText = doc.createSVGTextElement(20, 190, OMSVGLength.SVG_LENGTHTYPE_PX, "Please Enter Blazon");
    	initialText.setAttribute(SVGConstants.SVG_FILL_ATTRIBUTE, SVGConstants.CSS_BLACK_VALUE);
    	initialText.setAttribute(SVGConstants.SVG_FONT_SIZE_ATTRIBUTE, "40");
    	svg.appendChild(initialText);		
	}
}
