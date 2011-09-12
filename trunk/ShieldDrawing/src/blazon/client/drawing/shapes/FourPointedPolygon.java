package blazon.client.drawing.shapes;

import java.util.ArrayList;
import java.util.Collection;

public class FourPointedPolygon implements Polygon {

	protected Point pointA;
	protected Point pointB;
	protected Point pointC;
	protected Point pointD;
	
	public FourPointedPolygon(Point pointA, Point pointB, Point pointC, Point pointD) {
		if (pointA == null || pointB == null || pointC == null || pointD == null) {
			throw new IllegalArgumentException("Can not construct a polygon with null points.");
		}
		if (pointA.equals(pointB) || pointA.equals(pointC) || pointA.equals(pointD) || pointB.equals(pointC) || pointB.equals(pointD) || pointC.equals(pointD)) {
			throw new IllegalArgumentException("Can not construct a polygon if some of the points are equal.");
		}
		this.pointA = pointA;
		this.pointB = pointB;
		this.pointC = pointC;
		this.pointD = pointD;
	}
	
	@Override
	public final Collection<Point> getPoints() {
		Collection<Point> points = new ArrayList<Point>();
		points.add(pointA);
		points.add(pointB);
		points.add(pointC);
		points.add(pointD);
		return points;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("FourPointedPolygon{pointA=");
		sb.append(pointA).append(":pointB=").append(pointB);
		sb.append(":pointC=").append(pointC).append(":pointD=");
		sb.append(pointD).append("}");
		return sb.toString();
	}

}
