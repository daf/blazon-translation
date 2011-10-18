package blazon.client.drawing;

import org.vectomatic.dom.svg.OMSVGDefsElement;
import org.vectomatic.dom.svg.OMSVGDocument;
import org.vectomatic.dom.svg.OMSVGElement;
import org.vectomatic.dom.svg.OMSVGGElement;
import org.vectomatic.dom.svg.OMSVGPathElement;
import org.vectomatic.dom.svg.OMSVGPathSegList;
import org.vectomatic.dom.svg.OMSVGPointList;
import org.vectomatic.dom.svg.OMSVGPolygonElement;
import org.vectomatic.dom.svg.OMSVGSVGElement;
import org.vectomatic.dom.svg.utils.OMSVGParser;
import org.vectomatic.dom.svg.utils.SVGConstants;

import blazon.client.drawing.shapes.FourPointedPolygon;
import blazon.client.drawing.shapes.Point;
import blazon.client.drawing.shapes.Polygon;
import blazon.client.drawing.shapes.PolygonImpl;
import blazon.client.drawing.shapes.Triangle;
import blazon.client.drawing.shield.fur.AbstractFurSVGBuilder;
import blazon.client.drawing.shield.fur.FurSVGBuilder;
import blazon.shared.shield.ChargedShieldLayer;
import blazon.shared.shield.ShieldImpl;
import blazon.shared.shield.ShieldLayer;
import blazon.shared.shield.charges.GeometricCharge;
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
		GeometricCharge ordinary = layer.getOrdinary();
		switch(ordinary.getName()) {
			case CROSS: {
				Polygon polygon = new PolygonImpl(
						new Point(xMid-k, yMin), new Point(xMid+k, yMin), new Point(xMid+k, yMid-k), 
						new Point(xMax, yMid-k), new Point(xMax, yMid+k), new Point(xMid+k, yMid+k),
						new Point(xMid+k, yMax), new Point(xMid-k, yMax), new Point(xMid-k, yMid+k),
						new Point(xMin, yMid+k), new Point(xMin, yMid-k), new Point(xMid-k, yMid-k));
				putNewPolygonElementOnGElement(ordinaries, ordinary.getTincture(), polygon);
				break;
			}
			case PALE: {
				Polygon polygon = new FourPointedPolygon(new Point(xMid-k, yMin), new Point(xMid+k, yMin),
						new Point(xMid+k, yMax), new Point(xMid-k, yMax));
				putNewPolygonElementOnGElement(ordinaries, ordinary.getTincture(), polygon);
				break;
			}
			case FESS: {
				Polygon polygon = new FourPointedPolygon(new Point(xMin, yMid-k), new Point(xMax, yMid-k),
						new Point(xMax, yMid+k), new Point(xMin, yMid+k));
				putNewPolygonElementOnGElement(ordinaries, ordinary.getTincture(), polygon);
				break;
			}
			case BEND: {
				Polygon polygon = new PolygonImpl(
						new Point(xMin, yMin+k), new Point(xMin, yMin), new Point(xMin+k, yMin), 
						new Point(xMax, yMax-k), new Point(xMax, yMax), new Point(xMax-k, yMax));
				putNewPolygonElementOnGElement(ordinaries, ordinary.getTincture(), polygon);
				break;
			}
			case BEND_SINISTER: {
				Polygon polygon = new PolygonImpl(
						new Point(xMax-k, yMin), new Point(xMax, yMin), new Point(xMax, yMin+k),
						new Point(xMin+k, yMax), new Point(xMin, yMax), new Point(xMin, yMax-k));
				putNewPolygonElementOnGElement(ordinaries, ordinary.getTincture(), polygon);
				break;
			}
			case SALTIRE: {
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
				break;
			}
			case CHIEF: {
				Polygon polygon = new FourPointedPolygon(
						new Point(xMin, yMin), new Point(xMax, yMin), 
						new Point(xMax, k), new Point(xMin, k));
				putNewPolygonElementOnGElement(ordinaries, ordinary.getTincture(), polygon);
				break;
			}
			case BASE: {
				Polygon polygon = new FourPointedPolygon(
						new Point(xMin, yMax), new Point(xMax, yMax), 
						new Point(xMax, yMax-k), new Point(xMin, yMax-k));
				putNewPolygonElementOnGElement(ordinaries, ordinary.getTincture(), polygon);
				break;
			}
			case CHEVRON: {
				Polygon polygon = new PolygonImpl(
						new Point(xMax, yMax-k), new Point(xMax, yMax), new Point(xMax-k, yMax),
						new Point(xMid, yMid+k),
						new Point(xMin+k, yMax), new Point(xMin, yMax),	new Point(xMin, yMax-k),
						new Point(xMid, yMid-k));
				putNewPolygonElementOnGElement(ordinaries, ordinary.getTincture(), polygon);
				break;
			}
			case CHEVRON_REVERSED: {
				Polygon polygon = new PolygonImpl(
						new Point(xMin, yMin+k), new Point(xMin, yMin), new Point(xMin+k, yMin), 
						new Point(xMid, yMid-k),
						new Point(xMax-k, yMin), new Point(xMax, yMin), new Point(xMax, yMin+k),
						new Point(xMid, yMid+k));
				putNewPolygonElementOnGElement(ordinaries, ordinary.getTincture(), polygon);
				break;
			}
			
			case PALL: {
				Polygon polygon = new PolygonImpl(
						new Point(xMin, yMin+k), new Point(xMin, yMin), new Point(xMin+k, yMin), 
						new Point(xMid, yMid-k),
						new Point(xMax-k, yMin), new Point(xMax, yMin), new Point(xMax, yMin+k),
						new Point(xMid+k, yMid),
						new Point(xMid+k, yMax), new Point(xMid-k, yMax),
						new Point(xMid-k, yMid));
				putNewPolygonElementOnGElement(ordinaries, ordinary.getTincture(), polygon);
				break;
			}
			case PALL_REVERSED: {
				Polygon polygon = new PolygonImpl(
						new Point(xMin, yMax-k), new Point(xMin, yMax), new Point(xMin+k, yMax), 
						new Point(xMid, yMid+k),
						new Point(xMax-k, yMax), new Point(xMax, yMax), new Point(xMax, yMax-k),
						new Point(xMid+k, yMid),
						new Point(xMid+k, yMin), new Point(xMid-k, yMin),
						new Point(xMid-k, yMid));
				putNewPolygonElementOnGElement(ordinaries, ordinary.getTincture(), polygon);
				break;
			}
			case PILE: {
				Polygon polygon = new Triangle(new Point(xMid-k, yMin), new Point(xMid+k, yMin), new Point(xMid, yMax));
				putNewPolygonElementOnGElement(ordinaries, ordinary.getTincture(), polygon);
				break;
			}
			case PILE_REVERSED: {
				Polygon polygon = new Triangle(new Point(xMid-k, yMax), new Point(xMid+k, yMax), new Point(xMid, yMin));
				putNewPolygonElementOnGElement(ordinaries, ordinary.getTincture(), polygon);
				break;
			}
			case QUARTER: {
				putNewRectElementOnGElement(ordinaries, 0, 0, xMid, yMid, ordinary.getTincture());
				break;
			}
			case CANTON: {
				putNewRectElementOnGElement(ordinaries, 0, 0, xMax/3, yMax/3, ordinary.getTincture());
				break;
			}
			case GYRON: {
				Polygon polygon = new Triangle(new Point(xMin, yMin), new Point(xMid, yMid), new Point(xMin, yMid));
				putNewPolygonElementOnGElement(ordinaries, ordinary.getTincture(), polygon);
				break;
			}
			case FLAUNCHES: {
				OMSVGPathElement path = doc.createSVGPathElement();
		        OMSVGPathSegList segList = path.getPathSegList();
		        segList.appendItem(path.createSVGPathSegMovetoAbs(xMin, yMin));
		        segList.appendItem(path.createSVGPathSegCurvetoQuadraticAbs(xMin, yMax, xMid-k, yMid));
		        segList.appendItem(path.createSVGPathSegClosePath());
		        addFillToElement(ordinary.getTincture(), path);
		        ordinaries.appendChild(path);
		        path = doc.createSVGPathElement();
		        segList = path.getPathSegList();
		        segList.appendItem(path.createSVGPathSegMovetoAbs(xMax, yMin));
		        segList.appendItem(path.createSVGPathSegCurvetoQuadraticAbs(xMax, yMax, xMid+k, yMid));
		        segList.appendItem(path.createSVGPathSegClosePath());
		        addFillToElement(ordinary.getTincture(), path);
		        ordinaries.appendChild(path);
				break;
			}
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
	
	private void putNewRectElementOnGElement(OMSVGGElement gElement, int xMin, int yMin, int width, int height, Tincture t) {
		OMSVGElement element = doc.createSVGRectElement(xMin, yMin, width, height, 0, 0);
		addFillToElement(t, element);
		gElement.appendChild(element);
	}
	
	private void addFillToElement(Tincture t, OMSVGElement element) {
		if (t instanceof Fur) {
			FurSVGBuilder furBuilder = AbstractFurSVGBuilder.build(defs, (Fur)t);
			furBuilder.createPatternDefinition();
		}
		element.setAttribute(SVGConstants.CSS_FILL_VALUE, t.getFillText());
	}
}
