package blazon.client.drawing;

import org.vectomatic.dom.svg.OMSVGDefsElement;
import org.vectomatic.dom.svg.OMSVGDocument;
import org.vectomatic.dom.svg.OMSVGElement;
import org.vectomatic.dom.svg.OMSVGGElement;
import org.vectomatic.dom.svg.OMSVGPointList;
import org.vectomatic.dom.svg.OMSVGPolygonElement;
import org.vectomatic.dom.svg.OMSVGSVGElement;
import org.vectomatic.dom.svg.utils.OMSVGParser;
import org.vectomatic.dom.svg.utils.SVGConstants;

import blazon.client.drawing.shapes.FourPointedPolygon;
import blazon.client.drawing.shapes.Point;
import blazon.client.drawing.shapes.Polygon;
import blazon.client.drawing.shapes.PolygonImpl;
import blazon.client.drawing.shield.fur.AbstractFurSVGBuilder;
import blazon.client.drawing.shield.fur.FurSVGBuilder;
import blazon.shared.shield.ChargedShieldLayer;
import blazon.shared.shield.ShieldImpl;
import blazon.shared.shield.ShieldLayer;
import blazon.shared.shield.charges.Ordinary;
import blazon.shared.shield.charges.Ordinary.OrdinaryType;
import blazon.shared.shield.tinctures.Fur;
import blazon.shared.shield.tinctures.Tincture;

public class SVGOrdinaryDrawer {

	private final OMSVGDocument doc = OMSVGParser.currentDocument();
	private final ShieldImpl shield;
	private final OMSVGDefsElement defs;
	private final int xMax;
	private final int xMin;
	private final int yMax;
	private final int yMin;
	
	public SVGOrdinaryDrawer(ShieldImpl shield, OMSVGDefsElement defs, int shieldWidth, int shieldHeight) {
		this.shield = shield;
		this.defs = defs;
		this.xMax = shieldWidth;
		this.yMax = shieldHeight;
		this.xMin = 0;
		this.yMin = 0;
	}

	public void drawOrdinaries(OMSVGGElement shieldContainer) {
		OMSVGGElement ordinaries = doc.createSVGGElement();
		final int xMid = xMax/2;
		final int yMid = yMax/2;
		final int k = 30;
		ShieldLayer field = shield.getField();
		ChargedShieldLayer layer = (ChargedShieldLayer) field.getNextLayer();
		
		if (layer == null) return;
		OrdinaryType ordinary = layer.getOrdinary();
		if (ordinary.getName().equalsIgnoreCase(Ordinary.CROSS)) {
			Polygon polygon = new PolygonImpl(
					new Point(xMid-k, yMin), new Point(xMid+k, yMin), new Point(xMid+k, yMid-k), 
					new Point(xMax, yMid-k), new Point(xMax, yMid+k), new Point(xMid+k, yMid+k),
					new Point(xMid+k, yMax), new Point(xMid-k, yMax), new Point(xMid-k, yMid+k),
					new Point(xMin, yMid+k), new Point(xMin, yMid-k), new Point(xMid-k, yMid-k));
			putNewPolygonElementOnGElement(ordinaries, ordinary.getTincture(), polygon);
		}
		else if (ordinary.getName().equalsIgnoreCase(Ordinary.PALE)) {
			Polygon polygon = new FourPointedPolygon(new Point(xMid-k, yMin), new Point(xMid+k, yMin),
					new Point(xMid+k, yMax), new Point(xMid-k, yMax));
			putNewPolygonElementOnGElement(ordinaries, ordinary.getTincture(), polygon);
		}
		else if (ordinary.getName().equalsIgnoreCase(Ordinary.FESS)) {
			Polygon polygon = new FourPointedPolygon(new Point(xMin, yMid-k), new Point(xMax, yMid-k),
					new Point(xMax, yMid+k), new Point(xMin, yMid+k));
			putNewPolygonElementOnGElement(ordinaries, ordinary.getTincture(), polygon);
		}
		else if (ordinary.getName().equalsIgnoreCase(Ordinary.BEND)) {
			Polygon polygon = new PolygonImpl(
					new Point(xMin, yMin+k), new Point(xMin, yMin), new Point(xMin+k, yMin), 
					new Point(xMax, yMax-k), new Point(xMax, yMax), new Point(xMax-k, yMax));
			putNewPolygonElementOnGElement(ordinaries, ordinary.getTincture(), polygon);
		}
		else if (ordinary.getName().equalsIgnoreCase(Ordinary.BEND_SINISTER)) {
			Polygon polygon = new PolygonImpl(
					new Point(xMax-k, yMin), new Point(xMax, yMin), new Point(xMax, yMin+k),
					new Point(xMin+k, yMax), new Point(xMin, yMax), new Point(xMin, yMax-k));
			putNewPolygonElementOnGElement(ordinaries, ordinary.getTincture(), polygon);
		}
		else if (ordinary.getName().equalsIgnoreCase(Ordinary.SALTIRE)) {
			Polygon polygon = new PolygonImpl(
					new Point(xMin, yMin+k), new Point(xMin, yMin), new Point(xMin+k, yMin), 
					new Point(xMid, yMid-k),
					new Point(xMax-k, yMin), new Point(xMax, yMin), new Point(xMax, yMin+k),
					new Point(xMid+k, yMid),
					new Point(xMax, yMax-k), new Point(xMax, yMax), new Point(xMax-k, yMax),
					new Point(xMid, yMid+k),
					new Point(xMin+k, yMax), new Point(xMin, yMax),	new Point(xMin, yMax-k),
					new Point(xMid-k, yMid));
			putNewPolygonElementOnGElement(ordinaries, ordinary.getTincture(), polygon);
		}
		else if (ordinary.getName().equalsIgnoreCase(Ordinary.CHIEF)) {
			Polygon polygon = new FourPointedPolygon(
					new Point(xMin, yMin), new Point(xMax, yMin), 
					new Point(xMax, k), new Point(xMin, k));
			putNewPolygonElementOnGElement(ordinaries, ordinary.getTincture(), polygon);
		}
		else if (ordinary.getName().equalsIgnoreCase(Ordinary.BASE)) {
			Polygon polygon = new FourPointedPolygon(
					new Point(xMin, yMax), new Point(xMax, yMax), 
					new Point(xMax, yMax-k), new Point(xMin, yMax-k));
			putNewPolygonElementOnGElement(ordinaries, ordinary.getTincture(), polygon);
		}
		else if (ordinary.getName().equalsIgnoreCase(Ordinary.CHEVRON)) {
			Polygon polygon = new PolygonImpl(
					new Point(xMax, yMax-k), new Point(xMax, yMax), new Point(xMax-k, yMax),
					new Point(xMid, yMid+k),
					new Point(xMin+k, yMax), new Point(xMin, yMax),	new Point(xMin, yMax-k),
					new Point(xMid, yMid-k));
			putNewPolygonElementOnGElement(ordinaries, ordinary.getTincture(), polygon);
		}
		else if (ordinary.getName().equalsIgnoreCase(Ordinary.CHEVRON_REVERSED)) {
			Polygon polygon = new PolygonImpl(
					new Point(xMin, yMin+k), new Point(xMin, yMin), new Point(xMin+k, yMin), 
					new Point(xMid, yMid-k),
					new Point(xMax-k, yMin), new Point(xMax, yMin), new Point(xMax, yMin+k),
					new Point(xMid, yMid+k));
			putNewPolygonElementOnGElement(ordinaries, ordinary.getTincture(), polygon);
		}
		
		
		shieldContainer.appendChild(ordinaries);
	}

	private void putNewPolygonElementOnGElement(OMSVGGElement layer, Tincture t, Polygon polygon) {
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
	
	private void addFillToElement(Tincture t, OMSVGElement element) {
		if (t instanceof Fur) {
			FurSVGBuilder furBuilder = AbstractFurSVGBuilder.build(defs, (Fur)t);
			furBuilder.createPatternDefinition();
		}
		element.setAttribute(SVGConstants.CSS_FILL_VALUE, t.getFillText());
	}
}
