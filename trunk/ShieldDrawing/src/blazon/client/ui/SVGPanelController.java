package blazon.client.ui;

import org.vectomatic.dom.svg.OMSVGDocument;
import org.vectomatic.dom.svg.OMSVGLength;
import org.vectomatic.dom.svg.OMSVGSVGElement;
import org.vectomatic.dom.svg.utils.OMSVGParser;
import org.vectomatic.dom.svg.utils.SVGConstants;

import blazon.client.drawing.SVGShieldDrawer;
import blazon.shared.shield.Shield;
import blazon.client.ui.PanelController;

import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.Panel;

public class SVGPanelController extends PanelController {
	
	private static final long serialVersionUID = 2472113631682661546L;

	public SVGPanelController(final Panel panel) {
		super(panel);
	}

	private static final int PANEL_WIDTH = 400;
	private static final int PANEL_HEIGHT = 400;
	private static final int PANEL_BORDER = 10;

	private final OMSVGDocument doc = OMSVGParser.currentDocument();
	private final SVGShieldDrawer shieldDrawer = new SVGShieldDrawer(PANEL_WIDTH, PANEL_HEIGHT);
	
	public void createShieldSVGElement() {
		OMSVGSVGElement svg = createAndInitializeSVGElement();
		svg.setAttribute(SVGConstants.SVG_STYLE_ATTRIBUTE, "margin: 5px 0px;");
        shieldDrawer.drawInitialShield(svg);
        this.panel.getElement().appendChild(svg.getElement());
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
		Element element = this.panel.getElement();
		element.removeChild(element.getLastChild());
		OMSVGSVGElement svg = createAndInitializeSVGElement();
		shieldDrawer.draw(shield, svg);
		element.appendChild(svg.getElement());
	}
}
