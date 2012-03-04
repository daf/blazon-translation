package blazon.client.drawing.charges.geometric;

import java.util.EnumSet;
import java.util.List;

import org.vectomatic.dom.svg.OMSVGDefsElement;
import org.vectomatic.dom.svg.OMSVGDocument;
import org.vectomatic.dom.svg.OMSVGElement;
import org.vectomatic.dom.svg.OMSVGGElement;
import org.vectomatic.dom.svg.OMSVGPointList;
import org.vectomatic.dom.svg.OMSVGPolygonElement;
import org.vectomatic.dom.svg.OMSVGSVGElement;
import org.vectomatic.dom.svg.utils.OMSVGParser;
import org.vectomatic.dom.svg.utils.SVGConstants;

import blazon.client.drawing.charges.ChargeOffset;
import blazon.client.drawing.shapes.CubicBezierCurve;
import blazon.client.drawing.shapes.Point;
import blazon.client.drawing.shapes.Polygon;
import blazon.client.drawing.shield.fur.AbstractFurSVGBuilder;
import blazon.client.drawing.shield.fur.FurSVGBuilder;
import blazon.shared.shield.diagnostic.ShieldDiagnostic;
import blazon.shared.shield.tinctures.Fur;
import blazon.shared.shield.tinctures.Tincture;

public abstract class SVGChargeDrawer {

	protected final OMSVGDocument doc = OMSVGParser.currentDocument();
	protected final OMSVGDefsElement defs;
	protected final float shieldXMax;
	protected final float shieldXMin;
	protected final float shieldYMax;
	protected final float shieldYMin;
	protected final int occurrences;
	protected List<ShieldDiagnostic> diags;
	protected float chargeAreaYMax;
	protected float chargeAreaXMax;
	protected float chargeAreaXMin;
	protected float chargeAreaYMin;

	protected SVGChargeDrawer(OMSVGDefsElement defs, float shieldWidth, float shieldHeight, int occurrences) {
		this.defs = defs;
		this.shieldXMax = this.chargeAreaXMax = shieldWidth;
		this.shieldYMax = this.chargeAreaYMax = shieldHeight;
		this.shieldXMin = this.chargeAreaXMin = 0;
		this.shieldYMin = this.chargeAreaYMin = 0;
		this.occurrences = occurrences;
	}
	
	protected SVGChargeDrawer(OMSVGDefsElement defs, float shieldWidth, float shieldHeight) {
		this(defs, shieldWidth, shieldHeight, 1);
	}
	
	public abstract OMSVGGElement drawCharge(CubicBezierCurve curve);

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

	public void setChargeOffset(EnumSet<ChargeOffset> chargeOffsetFlag) {
		if (chargeOffsetFlag.contains(ChargeOffset.CHIEFPRESENT)) {
			chargeAreaYMin = shieldYMax/3f;
		}
		if (chargeOffsetFlag.contains(ChargeOffset.BASEPRESENT)) {
			chargeAreaYMax = shieldYMax - shieldYMax/3f;
		}
	}

	public void setDiagnostics(List<ShieldDiagnostic> shieldDiagnostics) {
		diags = shieldDiagnostics;
	}
	
	protected float getXDiff() {
		return chargeAreaXMax - chargeAreaXMin;
	}
	
	protected float getYDiff() {
		return chargeAreaYMax - chargeAreaYMin;
	}
}
