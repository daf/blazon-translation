package blazon.client.svg.fur;

import org.vectomatic.dom.svg.OMSVGPathElement;
import org.vectomatic.dom.svg.OMSVGPathSegList;
import org.vectomatic.dom.svg.utils.SVGConstants;

public class VairSVGBuilder extends AbstractSquirrelFurBuilder {
	protected static final int HEIGHT = 21;
	protected static final int WIDTH = 24;
	
	protected OMSVGPathElement createFurShapePath(String colour) {
		OMSVGPathElement path = doc.createSVGPathElement();
		path.setAttribute(SVGConstants.CSS_FILL_PROPERTY, colour);
		OMSVGPathSegList segList = path.getPathSegList();
		segList.appendItem(path.createSVGPathSegMovetoAbs(0, HEIGHT));
		segList.appendItem(path.createSVGPathSegLinetoAbs(WIDTH/4, HEIGHT-(WIDTH/4)));
		segList.appendItem(path.createSVGPathSegLinetoAbs(WIDTH/4, WIDTH/4));
		segList.appendItem(path.createSVGPathSegLinetoAbs(WIDTH/2, 0));
		segList.appendItem(path.createSVGPathSegLinetoAbs(WIDTH-(WIDTH/4), WIDTH/4));
		segList.appendItem(path.createSVGPathSegLinetoAbs(WIDTH-(WIDTH/4), HEIGHT-(WIDTH/4)));
		segList.appendItem(path.createSVGPathSegLinetoAbs(WIDTH, HEIGHT));
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
