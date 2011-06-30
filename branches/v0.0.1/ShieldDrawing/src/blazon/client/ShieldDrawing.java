package blazon.client;

import java.util.Iterator;

import org.vectomatic.dom.svg.OMSVGDescElement;
import org.vectomatic.dom.svg.OMSVGDocument;
import org.vectomatic.dom.svg.OMSVGGElement;
import org.vectomatic.dom.svg.OMSVGLength;
import org.vectomatic.dom.svg.OMSVGMaskElement;
import org.vectomatic.dom.svg.OMSVGPathElement;
import org.vectomatic.dom.svg.OMSVGPathSegList;
import org.vectomatic.dom.svg.OMSVGRectElement;
import org.vectomatic.dom.svg.OMSVGSVGElement;
import org.vectomatic.dom.svg.OMSVGTitleElement;
import org.vectomatic.dom.svg.utils.OMSVGParser;
import org.vectomatic.dom.svg.utils.SVGConstants;

import blazon.shared.shield.Shield;
import blazon.shared.shield.ShieldLayer;
import blazon.shared.shield.tinctures.Tincture;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class ShieldDrawing implements EntryPoint {
	
	private OMSVGDocument doc;
    private OMSVGSVGElement svg;
    private TextBox textBox;
    private Button button;
    private ShieldDrawingServiceAsync service = GWT.create(ShieldDrawingService.class);
    private Element currentSVGElement;
    /**
     * This is the entry point method.
     */
    public void onModuleLoad() {
        textBox = new TextBox();
        
        RootPanel.get().add(textBox);
        button = new Button("DrawShield");
        button.addClickHandler(new ClickHandler() {
            
            @Override
            public void onClick(ClickEvent event) {
                drawShield();
            }
        });
        RootPanel.get().add(button);
    }
    
    protected void drawShield() {
        initializeSVG();
        addTitleAndDesc();
        createShieldOutlineMask();
        drawShieldOutline();
        String enteredText = textBox.getText();
        service.drawShield(enteredText, new AsyncCallback<Shield>() {

            @Override
            public void onFailure(Throwable caught) {
                caught.printStackTrace();
            }

            @Override
            public void onSuccess(Shield shield) {
                fillField(shield);
                addSVGToRootPanel();
            }
            
        });
    }

    private void fillField(Shield shield) {
        OMSVGGElement gElement = doc.createSVGGElement();
        gElement.setAttribute(SVGConstants.SVG_MASK_ATTRIBUTE, "url(#shieldOutline)");
        OMSVGRectElement field = doc.createSVGRectElement(-50, -50, 100, 110, 0, 0);
        ShieldLayer base = shield.getField();
        Iterator<Tincture> tinctures = base.getTinctures().getTincturesOnLayerIterator();
        Tincture t = tinctures.next();
        field.setAttribute(SVGConstants.CSS_FILL_VALUE, t.getColour());
        gElement.appendChild(field);
        svg.appendChild(gElement);
    }
    
    private void initializeSVG() {
        doc = OMSVGParser.currentDocument();
        svg = doc.createSVGSVGElement();
        svg.setAttribute("xmlns", "http://www.w3.org/2000/svg");
        svg.setWidth(OMSVGLength.SVG_LENGTHTYPE_CM, 10);
        svg.setHeight(OMSVGLength.SVG_LENGTHTYPE_CM, 11);
        svg.setViewBox(-53, -53, 106, 116);
    }

    private void drawShieldOutline() {
        OMSVGPathElement shieldOutlinePath = doc.createSVGPathElement();
        shieldOutlinePath.setAttribute(SVGConstants.CSS_FILL_VALUE, SVGConstants.CSS_NONE_VALUE);
        shieldOutlinePath.setAttribute(SVGConstants.CSS_STROKE_VALUE, SVGConstants.CSS_BLACK_VALUE);
        shieldOutlinePath.setAttribute(SVGConstants.CSS_STROKE_WIDTH_PROPERTY, "1");
        createShieldOutlineSegList(shieldOutlinePath);
        svg.appendChild(shieldOutlinePath);
    }

    private void createShieldOutlineMask() {
        OMSVGMaskElement shieldOutlineMask = doc.createSVGMaskElement();
        shieldOutlineMask.setId("shieldOutline");
        OMSVGGElement shieldOutlineG = doc.createSVGGElement();
        shieldOutlineG.setAttribute(SVGConstants.CSS_FILL_VALUE, SVGConstants.CSS_WHITE_VALUE);
        OMSVGPathElement shieldMaskPath = doc.createSVGPathElement();
        shieldMaskPath.setId("shieldMaskPath");
        createShieldOutlineSegList(shieldMaskPath);
        shieldOutlineG.appendChild(shieldMaskPath);
        shieldOutlineMask.appendChild(shieldOutlineG);
        svg.appendChild(shieldOutlineMask);
    }

    private void createShieldOutlineSegList(OMSVGPathElement path) {
        OMSVGPathSegList pathSegList = path.getPathSegList();
        pathSegList.appendItem(path.createSVGPathSegMovetoAbs(-50, -50));
        pathSegList.appendItem(path.createSVGPathSegLinetoVerticalAbs(-14));
        pathSegList.appendItem(path.createSVGPathSegCurvetoCubicAbs(0, 60, -50, 46, 0, 60));
        pathSegList.appendItem(path.createSVGPathSegCurvetoCubicAbs(50, -14, 0, 60, 50, 46));
        pathSegList.appendItem(path.createSVGPathSegLinetoVerticalAbs(-50));
        pathSegList.appendItem(path.createSVGPathSegClosePath());
    }

    private void addSVGToRootPanel() {
        RootPanel rootPanel = RootPanel.get();
        if (currentSVGElement != null) {
            rootPanel.getElement().removeChild(currentSVGElement);
        }
        currentSVGElement = svg.getElement();
        rootPanel.getElement().appendChild(currentSVGElement);
        
    }

    private void addTitleAndDesc() {
        OMSVGTitleElement title = doc.createSVGTitleElement("my shield");
        svg.appendChild(title);
        OMSVGDescElement desc = doc.createSVGDescElement("This is a shield");
        svg.appendChild(desc);
    }
}
