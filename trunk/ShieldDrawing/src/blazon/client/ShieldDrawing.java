package blazon.client;


import org.vectomatic.dom.svg.OMSVGDefsElement;
import org.vectomatic.dom.svg.OMSVGDescElement;
import org.vectomatic.dom.svg.OMSVGDocument;
import org.vectomatic.dom.svg.OMSVGGElement;
import org.vectomatic.dom.svg.OMSVGLength;
import org.vectomatic.dom.svg.OMSVGMaskElement;
import org.vectomatic.dom.svg.OMSVGPathElement;
import org.vectomatic.dom.svg.OMSVGPathSegList;
import org.vectomatic.dom.svg.OMSVGSVGElement;
import org.vectomatic.dom.svg.OMSVGTextElement;
import org.vectomatic.dom.svg.OMSVGTitleElement;
import org.vectomatic.dom.svg.utils.OMSVGParser;
import org.vectomatic.dom.svg.utils.SVGConstants;

import blazon.shared.shield.Shield;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.TextBox;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class ShieldDrawing implements EntryPoint {
	
	public static final int SHIELD_MAX_X = 400;
	public static final int SHIELD_MAX_Y = 400;
	public static final int SHIELD_MIN_X = 0;
	public static final int SHIELD_MIN_Y = 0;
	
	private static final int OFFSET = 10;
	public static final int WIDTH = SHIELD_MAX_X + 2 * OFFSET;
	public static final int HEIGHT = SHIELD_MAX_Y + 2 * OFFSET;
	
	private final ShieldDrawingServiceAsync service = GWT.create(ShieldDrawingService.class);
	private final OMSVGDocument doc = OMSVGParser.currentDocument();
    private final OMSVGSVGElement svg = doc.createSVGSVGElement();
    
    
	private TextBox textBox;
	private OMSVGGElement shieldContainer;
	private OMSVGTextElement initialText;
	private OMSVGTitleElement title;
	private OMSVGDescElement desc;
	private OMSVGDefsElement defs;
    private Element currentSVGElement;

    
    public void onModuleLoad() {
    	final Panel rootPanel = RootPanel.get();
    	final Panel svgPanel = createAndInitializeSVGPanel();
        rootPanel.add(svgPanel);
        addTextBoxAndButtonToUI(rootPanel, svgPanel);
    }

    private Panel createAndInitializeSVGPanel() {
    	Panel svgPanel = new SimplePanel();
    	svgPanel.setSize(SHIELD_MAX_X + "px", SHIELD_MAX_Y + "px");
    	svgPanel.addStyleName("svgPanel");
        svg.setAttribute("xmlns", "http://www.w3.org/2000/svg");
        svg.setWidth(OMSVGLength.SVG_LENGTHTYPE_PX, SHIELD_MAX_X);
        svg.setHeight(OMSVGLength.SVG_LENGTHTYPE_PX, SHIELD_MAX_Y);
        svg.setViewBox(-OFFSET, -OFFSET, WIDTH, HEIGHT);
        createShieldShapeMask();
        drawShieldOutline();
        addInitialTextToShield();
        svgPanel.getElement().appendChild(svg.getElement());
        return svgPanel;
    }
    
    private void drawShieldOutline() {
        OMSVGPathElement shieldOutlinePath = doc.createSVGPathElement();
        shieldOutlinePath.setAttribute(SVGConstants.CSS_FILL_VALUE, SVGConstants.CSS_NONE_VALUE);
        shieldOutlinePath.setAttribute(SVGConstants.CSS_STROKE_VALUE, SVGConstants.CSS_BLACK_VALUE);
        shieldOutlinePath.setAttribute(SVGConstants.CSS_STROKE_WIDTH_PROPERTY, "1");
        createShieldShapeSegList(shieldOutlinePath);
        svg.appendChild(shieldOutlinePath);
    }

    private void createShieldShapeMask() {
        OMSVGMaskElement shieldShapeMask = doc.createSVGMaskElement();
        shieldShapeMask.setId("shieldShape");
        OMSVGGElement shieldShapeG = doc.createSVGGElement();
        shieldShapeG.setAttribute(SVGConstants.CSS_FILL_VALUE, SVGConstants.CSS_WHITE_VALUE);
        OMSVGPathElement shieldMaskPath = doc.createSVGPathElement();
        shieldMaskPath.setId("shieldMaskPath");
        createShieldShapeSegList(shieldMaskPath);
        shieldShapeG.appendChild(shieldMaskPath);
        shieldShapeMask.appendChild(shieldShapeG);
        svg.appendChild(shieldShapeMask);
    }

    private void createShieldShapeSegList(OMSVGPathElement path) {
        OMSVGPathSegList pathSegList = path.getPathSegList();
        pathSegList.appendItem(path.createSVGPathSegMovetoAbs(SHIELD_MIN_X, SHIELD_MIN_Y));
        pathSegList.appendItem(path.createSVGPathSegLinetoVerticalAbs(150));
        pathSegList.appendItem(path.createSVGPathSegCurvetoCubicAbs(
        		200, SHIELD_MAX_Y, SHIELD_MIN_X, 340, 200, SHIELD_MAX_Y));
        pathSegList.appendItem(path.createSVGPathSegCurvetoCubicAbs(
        		SHIELD_MAX_X, 150, 200, SHIELD_MAX_Y, SHIELD_MAX_X, 340));
        pathSegList.appendItem(path.createSVGPathSegLinetoVerticalAbs(SHIELD_MIN_Y));
        pathSegList.appendItem(path.createSVGPathSegClosePath());
    }
    
    private void addInitialTextToShield() {
    	initialText = doc.createSVGTextElement(20, 190, OMSVGLength.SVG_LENGTHTYPE_PX, "Please Enter Blazon");
    	initialText.setAttribute(SVGConstants.SVG_FILL_ATTRIBUTE, SVGConstants.CSS_BLACK_VALUE);
    	initialText.setAttribute(SVGConstants.SVG_FONT_SIZE_ATTRIBUTE, "40");
    	svg.appendChild(initialText);		
	}
    
	private void addTextBoxAndButtonToUI(final Panel rootPanel, final Panel svgPanel) {
		textBox = new TextBox();
        rootPanel.add(textBox);
        
        Button button = new Button("Draw Shield");
        rootPanel.add(button);
        button.addClickHandler(new ClickHandler() {
            
            @Override
            public void onClick(ClickEvent event) {
            	processInput(svgPanel);
            }
        });
	}
    
	protected void processInput(final Panel svgPanel) {
        String enteredText = textBox.getText();
        addTitleAndDescriptionToSVG(enteredText);
        service.createShieldRepresentation(enteredText, new AsyncCallback<Shield>() {

            @Override
            public void onFailure(Throwable caught) {
                caught.printStackTrace();
            }

            @Override
            public void onSuccess(Shield shield) {
            	removeInitialTextFromSVG();
                drawShield(shield);
                displayShield(svgPanel);
            }
            
        });
    }
    
    private void addTitleAndDescriptionToSVG(String blazon) {
    	if (title != null) {
    		svg.removeChild(title);
    	}
        title = doc.createSVGTitleElement(blazon);
        svg.appendChild(title);
    	
        if (desc != null) {
    		svg.removeChild(desc);
    	}
        desc = doc.createSVGDescElement("This is a shield described as '" + blazon + "'.");
        svg.appendChild(desc);

    }
    
    private void drawShield(Shield shield) {
    	if (shieldContainer != null) {
    		svg.removeChild(shieldContainer);
    	}
        shieldContainer = doc.createSVGGElement();
        shieldContainer.setAttribute(SVGConstants.SVG_MASK_ATTRIBUTE, "url(#shieldShape)");
        if (defs != null) {
        	svg.removeChild(defs);
        }
        defs = doc.createSVGDefsElement();
        ShieldSVGDrawer drawer = ShieldSVGDrawer.build(shield, doc, defs);
        svg.appendChild(defs);
        drawer.drawSVGShield(shieldContainer);
        svg.appendChild(shieldContainer);
    }

    private void displayShield(Panel svgPanel) {
        if (currentSVGElement != null) {
            svgPanel.getElement().removeChild(currentSVGElement);
        }
        currentSVGElement = svg.getElement();
        svgPanel.getElement().appendChild(currentSVGElement);
    }
    
	private void removeInitialTextFromSVG() {
		if (initialText != null) {
			svg.removeChild(initialText);
			initialText = null;
    	}
	}

}
