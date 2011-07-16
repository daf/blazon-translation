package blazon.client.svg.fur;

import org.vectomatic.dom.svg.OMSVGPathElement;
import org.vectomatic.dom.svg.OMSVGPathSegList;
import org.vectomatic.dom.svg.utils.SVGConstants;

public class PotentSVGBuilder extends AbstractSquirrelFurBuilder {
	protected static final int HEIGHT = 24;
	protected static final int WIDTH = 48;
	
	protected OMSVGPathElement createFurShapePath(String colour) {
		int w = WIDTH/8;
		OMSVGPathElement path = doc.createSVGPathElement();
		path.setAttribute(SVGConstants.CSS_FILL_PROPERTY, colour);
		OMSVGPathSegList segList = path.getPathSegList();
		segList.appendItem(path.createSVGPathSegMovetoAbs(w, HEIGHT));
		segList.appendItem(path.createSVGPathSegLinetoAbs(w, HEIGHT/2));
		segList.appendItem(path.createSVGPathSegLinetoAbs(3*w, HEIGHT/2));
		segList.appendItem(path.createSVGPathSegLinetoAbs(3*w, 0));
		segList.appendItem(path.createSVGPathSegLinetoAbs(5*w, 0));
		segList.appendItem(path.createSVGPathSegLinetoAbs(5*w, HEIGHT/2));
		segList.appendItem(path.createSVGPathSegLinetoAbs(7*w, HEIGHT/2));
		segList.appendItem(path.createSVGPathSegLinetoAbs(7*w, HEIGHT));
		segList.appendItem(path.createSVGPathSegClosePath());
		return path;
	}
	
	@Override
	protected int getWidth() {
		return WIDTH;
	}
	@Override
	protected int getHeight() {
		return HEIGHT;
	}
}
