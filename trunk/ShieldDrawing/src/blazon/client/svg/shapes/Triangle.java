package blazon.client.svg.shapes;

import java.util.ArrayList;
import java.util.Collection;

public class Triangle {
	
	protected Point pointA;
	protected Point pointB;
	protected Point pointC;
	
	public static Triangle build(Point pointA, Point pointB, Point pointC) {
		if (pointA == null || pointB == null || pointC == null) {
			throw new IllegalArgumentException("Can not construct a triangle with null points");
		}
		if (pointA.equals(pointB) || pointA.equals(pointC) || pointB.equals(pointC)) {
			throw new IllegalArgumentException("Can not construct a triangle if some of the points are equal.");
		}
		Triangle t = new Triangle();
		t.pointA = pointA;
		t.pointB = pointB;
		t.pointC = pointC;
		return t;
	}
	
	public final Triangle rotate(Point rPoint, double theta) {
		if (rPoint == null) {
			throw new IllegalArgumentException("Can not rotate a triangle about a null point");
		}
		Point newA = pointA.rotate(rPoint, theta);
		Point newB = pointB.rotate(rPoint, theta);
		Point newC = pointC.rotate(rPoint, theta);
		return build(newA, newB, newC);
	}
	
	public final Collection<Point> getPoints() {
		Collection<Point> points = new ArrayList<Point>();
		points.add(pointA);
		points.add(pointB);
		points.add(pointC);
		return points;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Triangle{pointA=");
		sb.append(pointA).append(":pointB=").append(pointB);
		sb.append(":pointC=").append(pointC).append("}");
		return sb.toString();
	}
}
//FIXME add tests for Triangle