package blazon.client.ui;

import org.vectomatic.dom.svg.OMSVGDocument;
import org.vectomatic.dom.svg.OMSVGLength;
import org.vectomatic.dom.svg.OMSVGSVGElement;
import org.vectomatic.dom.svg.utils.OMSVGParser;

import blazon.client.drawing.SVGShieldDrawer;
import blazon.shared.shield.Shield;

import com.google.gwt.dom.client.Node;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.SimplePanel;

public class SVGPanelController {
	
	private static final int PANEL_WIDTH = 400;
	private static final int PANEL_HEIGHT = 400;
	private static final int PANEL_BORDER = 10;

	private final Panel svgPanel = new SimplePanel();
	private final OMSVGDocument doc = OMSVGParser.currentDocument();
	private final SVGShieldDrawer shieldDrawer = new SVGShieldDrawer(PANEL_WIDTH, PANEL_HEIGHT);
	
	public Panel initializePanel() {
		svgPanel.setSize(PANEL_WIDTH + "px", PANEL_HEIGHT + "px");
		svgPanel.addStyleName("svgPanel");
		OMSVGSVGElement svg = createAndInitializeSVGElement();
        shieldDrawer.drawInitialShield(svg);
        svgPanel.getElement().appendChild(svg.getElement());
        return svgPanel;
    }

	private OMSVGSVGElement createAndInitializeSVGElement() {
		OMSVGSVGElement svg = doc.createSVGSVGElement();
        svg.setAttribute("xmlns", "http://www.w3.org/2000/svg");
        svg.setWidth(OMSVGLength.SVG_LENGTHTYPE_PX, PANEL_WIDTH);
        svg.setHeight(OMSVGLength.SVG_LENGTHTYPE_PX, PANEL_HEIGHT);
        final int totalWidth = PANEL_WIDTH + 2 * PANEL_BORDER;
        final int totalHeight = PANEL_HEIGHT + 2 * PANEL_BORDER;
        svg.setViewBox(-PANEL_BORDER, -PANEL_BORDER, totalWidth, totalHeight);
		return svg;
	}

	public void displayShield(Shield shield) {
		Element element = svgPanel.getElement();
		Node cloneNode = element.cloneNode(false);
		svgPanel.getParent().getElement().replaceChild(cloneNode, element);
		OMSVGSVGElement svg = createAndInitializeSVGElement();
		shieldDrawer.draw(shield, svg);
		cloneNode.appendChild(svg.getElement());
	}
}
