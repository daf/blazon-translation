package blazon.client.drawing.charges.geometric;

import java.util.ArrayList;
import java.util.Iterator;
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

import blazon.client.drawing.shapes.CubicBezierCurve;
import blazon.client.drawing.shapes.Point;
import blazon.client.drawing.shapes.Polygon;
import blazon.client.drawing.shield.fur.AbstractFurSVGBuilder;
import blazon.client.drawing.shield.fur.FurSVGBuilder;
import blazon.shared.shield.ShieldImpl;
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
	//LATER could use some manager type pattern
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
	
	public static List<SVGOrdinaryDrawer> createDrawers(ShieldImpl shield, OMSVGDefsElement defs, int shieldWidth, int shieldHeight) {
		List<GeometricCharge> charges = shield.getCharges();
		List<SVGOrdinaryDrawer> ordinaryDrawers = new ArrayList<SVGOrdinaryDrawer>();
		if (charges == null) {
			return ordinaryDrawers;
		}
		Iterator<GeometricCharge> iterator = charges.iterator();
		GeometricCharge currentCharge = iterator.next();
		boolean hasUnprocessedItems = true;
		int sameChargeCounter = 1;
		while (hasUnprocessedItems || iterator.hasNext()) {
			GeometricCharge nextCharge = null;
			if (iterator.hasNext()) {
				nextCharge = iterator.next();
			}
			if (currentCharge.equals(nextCharge)) {
				sameChargeCounter++;
				continue;
			}
			switch(currentCharge.getName()) {
			case BASE:
				ordinaryDrawers.add(new SVGBaseDrawer(currentCharge, defs, shieldWidth, shieldHeight));
				break;
			case BEND:
				ordinaryDrawers.add(new SVGBendDrawer(currentCharge, defs, shieldWidth, shieldHeight));
				break;
			case BEND_SINISTER:
				ordinaryDrawers.add(new SVGBendSinisterDrawer(currentCharge, defs, shieldWidth, shieldHeight));
				break;
			case BORDURE:
				ordinaryDrawers.add(new SVGBordureDrawer(currentCharge, defs, shieldWidth, shieldHeight));
				break;
			case CANTON:
				ordinaryDrawers.add(new SVGCantonDrawer(currentCharge, defs, shieldWidth, shieldHeight));
				break;
			case CHEVRON:
				ordinaryDrawers.add(new SVGChevronDrawer(currentCharge, defs, shieldWidth, shieldHeight));
				break;
			case CHEVRON_REVERSED:
				ordinaryDrawers.add(new SVGChevronReversedDrawer(currentCharge, defs, shieldWidth, shieldHeight));
				break;
			case CHIEF:
				ordinaryDrawers.add(new SVGChiefDrawer(currentCharge, defs, shieldWidth, shieldHeight));
				break;
			case CROSS:
				ordinaryDrawers.add(new SVGCrossDrawer(currentCharge, defs, shieldWidth, shieldHeight));
				break;
			case FESS:
				ordinaryDrawers.add(new SVGFessDrawer(currentCharge, defs, shieldWidth, shieldHeight));
				break;
			case FLAUNCHES:
				ordinaryDrawers.add(new SVGFlaunchesDrawer(currentCharge, defs, shieldWidth, shieldHeight));
				break;
			case FRET:
				ordinaryDrawers.add(new SVGFretDrawer(currentCharge, defs, shieldWidth, shieldHeight));
				break;
			case GYRON:
				ordinaryDrawers.add(new SVGGyronDrawer(currentCharge, defs, shieldWidth, shieldHeight));
				break;
			case ORLE:
				ordinaryDrawers.add(new SVGOrleDrawer(currentCharge, defs, shieldWidth, shieldHeight));
				break;
			case PALE:
				ordinaryDrawers.add(new SVGPaleDrawer(currentCharge, defs, shieldWidth, shieldHeight));
				break;
			case PALL:
				ordinaryDrawers.add(new SVGPallDrawer(currentCharge, defs, shieldWidth, shieldHeight));
				break;
			case PALL_REVERSED:
				ordinaryDrawers.add(new SVGPallReversedDrawer(currentCharge, defs, shieldWidth, shieldHeight));
				break;
			case PILE:
				ordinaryDrawers.add(new SVGPileDrawer(currentCharge, defs, shieldWidth, shieldHeight));
				break;
			case PILE_REVERSED:
				ordinaryDrawers.add(new SVGPileReversedDrawer(currentCharge, defs, shieldWidth, shieldHeight));
				break;
			case QUARTER:
				ordinaryDrawers.add(new SVGQuarterDrawer(currentCharge, defs, shieldWidth, shieldHeight));
				break;
			case SALTIRE:
				ordinaryDrawers.add(new SVGSaltireDrawer(currentCharge, defs, shieldWidth, shieldHeight));
				break;
			case TRESSURE:
				ordinaryDrawers.add(new SVGTressureDrawer(currentCharge, defs, shieldWidth, shieldHeight));
				break;
			case BAR:
				ordinaryDrawers.add(new SVGBarDrawer(currentCharge, defs, shieldWidth, shieldHeight, sameChargeCounter));
				break;
			default:
				//return null;
				//TODO draw label of X
				
			}
			sameChargeCounter = 0;
			currentCharge = nextCharge;
			hasUnprocessedItems = false;
		}
		return ordinaryDrawers;
	}

	public abstract OMSVGGElement drawOrdinary(OMSVGGElement shieldContainer, CubicBezierCurve curve);

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
