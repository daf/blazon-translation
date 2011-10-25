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

import blazon.client.drawing.shapes.CubicBezierCurve;
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

	public void drawOrdinaries(OMSVGGElement shieldContainer, CubicBezierCurve curve) {
		OMSVGGElement ordinaries = doc.createSVGGElement();
		final float xMid = xMax/2f;
		final float yMid = yMax/2f;
		final float thirdX = xMax/3f;
		final float thirdY = yMax/3f;
		final float tenthX = xMax/10f;
		final float tenthY = yMax/10f;
		ShieldLayer field = shield.getField();
		ChargedShieldLayer layer = (ChargedShieldLayer) field.getNextLayer();
		
		if (layer == null) return;
		GeometricCharge ordinary = layer.getOrdinary();
		switch(ordinary.getName()) {
			case CROSS: {
				Polygon polygon = new PolygonImpl(
						new Point(xMid-tenthX, yMin), new Point(xMid+tenthX, yMin), new Point(xMid+tenthX, xMid-tenthY), 
						new Point(xMax, xMid-tenthY), new Point(xMax, xMid+tenthY), new Point(xMid+tenthX, xMid+tenthY),
						new Point(xMid+tenthX, yMax), new Point(xMid-tenthX, yMax), new Point(xMid-tenthX, xMid+tenthY),
						new Point(xMin, xMid+tenthY), new Point(xMin, xMid-tenthY), new Point(xMid-tenthX, xMid-tenthY));
				putNewPolygonElementOnGElement(ordinaries, ordinary.getTincture(), polygon);
				break;
			}
			case PALE: {
				Polygon polygon = new FourPointedPolygon(new Point(thirdX, yMin), new Point(2*thirdX, yMin),
						new Point(2*thirdX, yMax), new Point(thirdX, yMax));
				putNewPolygonElementOnGElement(ordinaries, ordinary.getTincture(), polygon);
				break;
			}
			case FESS: {
				Polygon polygon = new FourPointedPolygon(new Point(xMin, thirdY), new Point(xMax, thirdY),
						new Point(xMax, 2*thirdY), new Point(xMin, 2*thirdY));
				putNewPolygonElementOnGElement(ordinaries, ordinary.getTincture(), polygon);
				break;
			}
			case BEND: {
				Polygon polygon = new PolygonImpl(
						new Point(xMin, yMin+tenthY), new Point(xMin, yMin), new Point(xMin+tenthX, yMin), 
						new Point(xMax, yMax-tenthY), new Point(xMax, yMax), new Point(xMax-tenthX, yMax));
				putNewPolygonElementOnGElement(ordinaries, ordinary.getTincture(), polygon);
				break;
			}
			case BEND_SINISTER: {
				Polygon polygon = new PolygonImpl(
						new Point(xMax-tenthX, yMin), new Point(xMax, yMin), new Point(xMax, yMin+tenthY),
						new Point(xMin+tenthX, yMax), new Point(xMin, yMax), new Point(xMin, yMax-tenthY));
				putNewPolygonElementOnGElement(ordinaries, ordinary.getTincture(), polygon);
				break;
			}
			case SALTIRE: {
				Polygon polygon = new PolygonImpl(
						new Point(xMin, yMin+tenthY), new Point(xMin, yMin), new Point(xMin+tenthX, yMin), 
						new Point(xMid, yMid-tenthY),
						new Point(xMax-tenthX, yMin), new Point(xMax, yMin), new Point(xMax, yMin+tenthY),
						new Point(xMid+tenthX, yMid),
						new Point(xMax, yMax-tenthY), new Point(xMax, yMax), new Point(xMax-tenthX, yMax),
						new Point(xMid, yMid+tenthY),
						new Point(xMin+tenthX, yMax), new Point(xMin, yMax),	new Point(xMin, yMax-tenthY),
						new Point(xMid-tenthX, yMid));
				putNewPolygonElementOnGElement(ordinaries, ordinary.getTincture(), polygon);
				break;
			}
			case CHIEF: {
				Polygon polygon = new FourPointedPolygon(
						new Point(xMin, yMin), new Point(xMax, yMin), 
						new Point(xMax, thirdY), new Point(xMin, thirdY));
				putNewPolygonElementOnGElement(ordinaries, ordinary.getTincture(), polygon);
				break;
			}
			case BASE: {
				Polygon polygon = new FourPointedPolygon(
						new Point(xMin, yMax), new Point(xMax, yMax), 
						new Point(xMax, yMax-thirdY), new Point(xMin, yMax-thirdY));
				putNewPolygonElementOnGElement(ordinaries, ordinary.getTincture(), polygon);
				break;
			}
			case CHEVRON: {
				Polygon polygon = new PolygonImpl(
						new Point(xMax, yMax-tenthY), new Point(xMax, yMax), new Point(xMax-tenthX, yMax),
						new Point(xMid, yMid+tenthY),
						new Point(xMin+tenthX, yMax), new Point(xMin, yMax),	new Point(xMin, yMax-tenthY),
						new Point(xMid, yMid-tenthY));
				putNewPolygonElementOnGElement(ordinaries, ordinary.getTincture(), polygon);
				break;
			}
			case CHEVRON_REVERSED: {
				Polygon polygon = new PolygonImpl(
						new Point(xMin, yMin+tenthY), new Point(xMin, yMin), new Point(xMin+tenthX, yMin), 
						new Point(xMid, yMid-tenthY),
						new Point(xMax-tenthX, yMin), new Point(xMax, yMin), new Point(xMax, yMin+tenthY),
						new Point(xMid, yMid+tenthY));
				putNewPolygonElementOnGElement(ordinaries, ordinary.getTincture(), polygon);
				break;
			}
			
			case PALL: {
				float root2 = (float) Math.sqrt(2);
				Polygon polygon = new PolygonImpl(
						new Point(xMin, yMin+tenthY*root2), new Point(xMin, yMin), new Point(xMin+tenthX*root2, yMin), 
						new Point(xMid, yMid-tenthY*root2),
						new Point(xMax-tenthX*root2, yMin), new Point(xMax, yMin), new Point(xMax, yMin+tenthY*root2),
						new Point(xMid+tenthX, yMid),
						new Point(xMid+tenthX, yMax), new Point(xMid-tenthX, yMax),
						new Point(xMid-tenthX, yMid));
				putNewPolygonElementOnGElement(ordinaries, ordinary.getTincture(), polygon);
				break;
			}
			case PALL_REVERSED: {
				float root2 = (float) Math.sqrt(2);
				Polygon polygon = new PolygonImpl(
						new Point(xMin, yMax-tenthY*root2), new Point(xMin, yMax), new Point(xMin+tenthX*root2, yMax), 
						new Point(xMid, yMid+tenthY*root2),
						new Point(xMax-tenthX*root2, yMax), new Point(xMax, yMax), new Point(xMax, yMax-tenthY*root2),
						new Point(xMid+tenthX, yMid),
						new Point(xMid+tenthX, yMin), new Point(xMid-tenthX, yMin),
						new Point(xMid-tenthX, yMid));
				putNewPolygonElementOnGElement(ordinaries, ordinary.getTincture(), polygon);
				break;
			}
			case PILE: {
				Polygon polygon = new Triangle(new Point(xMid-thirdX/2, yMin), new Point(xMid+thirdX/2, yMin), new Point(xMid, yMax));
				putNewPolygonElementOnGElement(ordinaries, ordinary.getTincture(), polygon);
				break;
			}
			case PILE_REVERSED: {
				Polygon polygon = new Triangle(new Point(xMid-thirdX/2, yMax), new Point(xMid+thirdX/2, yMax), new Point(xMid, yMin));
				putNewPolygonElementOnGElement(ordinaries, ordinary.getTincture(), polygon);
				break;
			}
			case QUARTER: {
				putNewRectElementOnGElement(ordinaries, 0, 0, xMid, yMid, ordinary.getTincture());
				break;
			}
			case CANTON: {
				putNewRectElementOnGElement(ordinaries, 0, 0, thirdX, thirdY, ordinary.getTincture());
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
		        segList.appendItem(path.createSVGPathSegCurvetoQuadraticAbs(xMin, yMax, thirdX, yMid));
		        segList.appendItem(path.createSVGPathSegClosePath());
		        addFillToElement(ordinary.getTincture(), path);
		        ordinaries.appendChild(path);
		        path = doc.createSVGPathElement();
		        segList = path.getPathSegList();
		        segList.appendItem(path.createSVGPathSegMovetoAbs(xMax, yMin));
		        segList.appendItem(path.createSVGPathSegCurvetoQuadraticAbs(xMax, yMax, 2*thirdX, yMid));
		        segList.appendItem(path.createSVGPathSegClosePath());
		        addFillToElement(ordinary.getTincture(), path);
		        ordinaries.appendChild(path);
				break;
			}
			case BORDURE: {
				OMSVGPathElement path = createShieldShapePath(curve);
		        OMSVGPathSegList segList = path.getPathSegList();
		        final float xSixth = xMax / 6;
		        final float ySixth = yMax / 6;
		        final float scale = 5/(float)6;
		        segList.appendItem(path.createSVGPathSegMovetoAbs(xSixth, ySixth));
		        segList.appendItem(path.createSVGPathSegLinetoVerticalAbs(curve.getEndPoint1().getY()*scale));
		        segList.appendItem(
		        		path.createSVGPathSegCurvetoCubicAbs(
		        				curve.getEndPoint2().getX(), curve.getEndPoint2().getY()*scale,
		        				curve.getControlPoint1().getX()+xSixth, curve.getControlPoint1().getY()*scale, 
		        				curve.getControlPoint2().getX(), curve.getControlPoint2().getY()*scale));
		        segList.appendItem(
		        		path.createSVGPathSegCurvetoCubicAbs(
		        				(xMax - curve.getEndPoint1().getX())*scale, curve.getEndPoint1().getY()*scale,
		        				xMax - curve.getControlPoint2().getX(), curve.getControlPoint2().getY()*scale,
		        				(xMax - curve.getControlPoint1().getX())*scale, curve.getControlPoint1().getY()*scale));
		        segList.appendItem(path.createSVGPathSegLinetoVerticalAbs(ySixth));
		        segList.appendItem(path.createSVGPathSegClosePath());
		        addFillToElement(ordinary.getTincture(), path);
		        path.setAttribute(SVGConstants.SVG_FILL_RULE_ATTRIBUTE, SVGConstants.SVG_EVEN_ODD_VALUE);
		        ordinaries.appendChild(path);
				break;
			}
			case ORLE: {
				{
					OMSVGPathElement path = doc.createSVGPathElement();
			        OMSVGPathSegList segList = path.getPathSegList();
			        {
			        	final float xSixth = xMax / 6;
				        final float ySixth = yMax / 6;
				        final float scale = 5/(float)6;
				        segList.appendItem(path.createSVGPathSegMovetoAbs(xSixth, ySixth));
				        segList.appendItem(path.createSVGPathSegLinetoVerticalAbs(curve.getEndPoint1().getY()*scale));
				        segList.appendItem(
				        		path.createSVGPathSegCurvetoCubicAbs(
				        				curve.getEndPoint2().getX(), curve.getEndPoint2().getY()*scale,
				        				curve.getControlPoint1().getX()+xSixth, curve.getControlPoint1().getY()*scale, 
				        				curve.getControlPoint2().getX(), curve.getControlPoint2().getY()*scale));
				        segList.appendItem(
				        		path.createSVGPathSegCurvetoCubicAbs(
				        				(xMax - curve.getEndPoint1().getX())*scale, curve.getEndPoint1().getY()*scale,
				        				xMax - curve.getControlPoint2().getX(), curve.getControlPoint2().getY()*scale,
				        				(xMax - curve.getControlPoint1().getX())*scale, curve.getControlPoint1().getY()*scale));
				        segList.appendItem(path.createSVGPathSegLinetoVerticalAbs(ySixth));
				        segList.appendItem(path.createSVGPathSegClosePath());
				        
			        }
			        final float xSixth = xMax / 12;
			        final float ySixth = yMax / 12;
			        final float scale = 11/(float)12;
			        segList.appendItem(path.createSVGPathSegMovetoAbs(xSixth, ySixth));
			        segList.appendItem(path.createSVGPathSegLinetoVerticalAbs(curve.getEndPoint1().getY()*scale));
			        segList.appendItem(
			        		path.createSVGPathSegCurvetoCubicAbs(
			        				curve.getEndPoint2().getX(), curve.getEndPoint2().getY()*scale,
			        				curve.getControlPoint1().getX()+xSixth, curve.getControlPoint1().getY()*scale, 
			        				curve.getControlPoint2().getX(), curve.getControlPoint2().getY()*scale));
			        segList.appendItem(
			        		path.createSVGPathSegCurvetoCubicAbs(
			        				(xMax - curve.getEndPoint1().getX())*scale, curve.getEndPoint1().getY()*scale,
			        				xMax - curve.getControlPoint2().getX(), curve.getControlPoint2().getY()*scale,
			        				(xMax - curve.getControlPoint1().getX())*scale, curve.getControlPoint1().getY()*scale));
			        segList.appendItem(path.createSVGPathSegLinetoVerticalAbs(ySixth));
			        segList.appendItem(path.createSVGPathSegClosePath());
					addFillToElement(ordinary.getTincture(), path);		
			        path.setAttribute(SVGConstants.SVG_FILL_RULE_ATTRIBUTE, SVGConstants.SVG_EVEN_ODD_VALUE);
			        ordinaries.appendChild(path);
				}
				break;
			}
			
			case TRESSURE: {
				{
					OMSVGPathElement path = doc.createSVGPathElement();
			        OMSVGPathSegList segList = path.getPathSegList();
			        {
			        	final float xSixth = xMax / 6;
				        final float ySixth = yMax / 6;
				        final float scale = 5/(float)6;
				        segList.appendItem(path.createSVGPathSegMovetoAbs(xSixth, ySixth));
				        segList.appendItem(path.createSVGPathSegLinetoVerticalAbs(curve.getEndPoint1().getY()*scale));
				        segList.appendItem(
				        		path.createSVGPathSegCurvetoCubicAbs(
				        				curve.getEndPoint2().getX(), curve.getEndPoint2().getY()*scale,
				        				curve.getControlPoint1().getX()+xSixth, curve.getControlPoint1().getY()*scale, 
				        				curve.getControlPoint2().getX(), curve.getControlPoint2().getY()*scale));
				        segList.appendItem(
				        		path.createSVGPathSegCurvetoCubicAbs(
				        				(xMax - curve.getEndPoint1().getX())*scale, curve.getEndPoint1().getY()*scale,
				        				xMax - curve.getControlPoint2().getX(), curve.getControlPoint2().getY()*scale,
				        				(xMax - curve.getControlPoint1().getX())*scale, curve.getControlPoint1().getY()*scale));
				        segList.appendItem(path.createSVGPathSegLinetoVerticalAbs(ySixth));
				        segList.appendItem(path.createSVGPathSegClosePath());
				        
			        }
			        final float xSixth = 3*xMax / 24;
			        final float ySixth = 3*yMax / 24;
			        final float scale = 21/(float)24;
			        segList.appendItem(path.createSVGPathSegMovetoAbs(xSixth, ySixth));
			        segList.appendItem(path.createSVGPathSegLinetoVerticalAbs(curve.getEndPoint1().getY()*scale));
			        segList.appendItem(
			        		path.createSVGPathSegCurvetoCubicAbs(
			        				curve.getEndPoint2().getX(), curve.getEndPoint2().getY()*scale,
			        				curve.getControlPoint1().getX()+xSixth, curve.getControlPoint1().getY()*scale, 
			        				curve.getControlPoint2().getX(), curve.getControlPoint2().getY()*scale));
			        segList.appendItem(
			        		path.createSVGPathSegCurvetoCubicAbs(
			        				(xMax - curve.getEndPoint1().getX())*scale, curve.getEndPoint1().getY()*scale,
			        				xMax - curve.getControlPoint2().getX(), curve.getControlPoint2().getY()*scale,
			        				(xMax - curve.getControlPoint1().getX())*scale, curve.getControlPoint1().getY()*scale));
			        segList.appendItem(path.createSVGPathSegLinetoVerticalAbs(ySixth));
			        segList.appendItem(path.createSVGPathSegClosePath());
					addFillToElement(ordinary.getTincture(), path);		
			        path.setAttribute(SVGConstants.SVG_FILL_RULE_ATTRIBUTE, SVGConstants.SVG_EVEN_ODD_VALUE);
			        ordinaries.appendChild(path);
				}
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
	
	private void putNewRectElementOnGElement(OMSVGGElement gElement, float xMin, float yMin, float width, float height, Tincture t) {
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
        element.setAttribute(SVGConstants.SVG_STROKE_ATTRIBUTE, SVGConstants.CSS_BLACK_VALUE);
        element.setAttribute(SVGConstants.SVG_STROKE_WIDTH_ATTRIBUTE, "1");
	}
	
	
	//TODO refactor bordure!!!
	private OMSVGPathElement createShieldShapePath(CubicBezierCurve curve) {
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
        				xMax - curve.getEndPoint1().getX(), curve.getEndPoint1().getY(),
        				xMax - curve.getControlPoint2().getX(), curve.getControlPoint2().getY(),
        				xMax - curve.getControlPoint1().getX(), curve.getControlPoint1().getY()));
        segList.appendItem(path.createSVGPathSegLinetoVerticalAbs(0));
        segList.appendItem(path.createSVGPathSegClosePath());
        path.setAttribute(SVGConstants.SVG_STROKE_ATTRIBUTE, SVGConstants.CSS_BLACK_VALUE);
        path.setAttribute(SVGConstants.SVG_STROKE_WIDTH_ATTRIBUTE, "1");
        path.setAttribute(SVGConstants.SVG_FILL_ATTRIBUTE, SVGConstants.CSS_WHITE_VALUE);
        return path;
    }
}
