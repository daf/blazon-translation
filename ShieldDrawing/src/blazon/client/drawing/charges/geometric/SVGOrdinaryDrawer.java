package blazon.client.drawing.charges.geometric;

import org.vectomatic.dom.svg.OMSVGDefsElement;
import org.vectomatic.dom.svg.OMSVGDocument;
import org.vectomatic.dom.svg.OMSVGElement;
import org.vectomatic.dom.svg.OMSVGGElement;
import org.vectomatic.dom.svg.OMSVGPointList;
import org.vectomatic.dom.svg.OMSVGPolygonElement;
import org.vectomatic.dom.svg.OMSVGSVGElement;
import org.vectomatic.dom.svg.utils.OMSVGParser;
import org.vectomatic.dom.svg.utils.SVGConstants;

import blazon.client.drawing.shapes.CubicBezierCurve;
import blazon.client.drawing.shapes.Point;
import blazon.client.drawing.shapes.Polygon;
import blazon.client.drawing.shield.fur.AbstractFurSVGBuilder;
import blazon.client.drawing.shield.fur.FurSVGBuilder;
import blazon.shared.shield.charges.GeometricCharge;
import blazon.shared.shield.tinctures.Fur;
import blazon.shared.shield.tinctures.Tincture;

public abstract class SVGOrdinaryDrawer {

	protected final OMSVGDocument doc = OMSVGParser.currentDocument();
	protected final GeometricCharge charge;
	private final OMSVGDefsElement defs;
	protected final int xMax;
	protected final int xMin;
	protected final int yMax;
	protected final int yMin;
	protected final int occurrences;

	protected SVGOrdinaryDrawer(GeometricCharge charge, OMSVGDefsElement defs, int shieldWidth, int shieldHeight, int occurrences) {
		this.charge = charge;
		this.defs = defs;
		this.xMax = shieldWidth;
		this.yMax = shieldHeight;
		this.xMin = 0;
		this.yMin = 0;
		this.occurrences = occurrences;
	}
	
	protected SVGOrdinaryDrawer(GeometricCharge charge, OMSVGDefsElement defs, int shieldWidth, int shieldHeight) {
		this(charge, defs, shieldWidth, shieldHeight, 1);
	}
	
	public abstract OMSVGGElement drawOrdinary(CubicBezierCurve curve);

	protected void putNewPolygonElementOnGElement(OMSVGGElement layer, Tincture t, Polygon polygon) {
		OMSVGSVGElement svgElement = doc.createSVGSVGElement();
		OMSVGPolygonElement polygonElement = doc.createSVGPolygonElement();
		OMSVGPointList points = polygonElement.getPoints();
		for (Point point : polygon.getPoints()) {
			points.appendItem(svgElement.createSVGPoint(point.getX(), point.getY()));
		}
		Point first = polygon.getPoints().iterator().next();
		points.appendItem(svgElement.createSVGPoint(first.getX(), first.getY()));
		addFillToElement(t, polygonElement);
		layer.appendChild(polygonElement);
	}
	
	protected void putNewRectElementOnGElement(OMSVGGElement gElement, float xMin, float yMin, float width, float height, Tincture t) {
		OMSVGElement element = doc.createSVGRectElement(xMin, yMin, width, height, 0, 0);
		addFillToElement(t, element);
		gElement.appendChild(element);
	}
	
	protected void addFillToElement(Tincture t, OMSVGElement element) {
		if (t instanceof Fur) {
			FurSVGBuilder furBuilder = AbstractFurSVGBuilder.build(defs, (Fur)t);
			furBuilder.createPatternDefinition();
		}
		element.setAttribute(SVGConstants.CSS_FILL_VALUE, t.getFillText());
        element.setAttribute(SVGConstants.SVG_STROKE_ATTRIBUTE, SVGConstants.CSS_BLACK_VALUE);
        element.setAttribute(SVGConstants.SVG_STROKE_WIDTH_ATTRIBUTE, "1");
	}
}
