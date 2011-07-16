package blazon.client.svg.shapes;

import java.util.ArrayList;
import java.util.Collection;

public final class Triangle {

	private Point pointA;
	private Point pointB;
	private Point pointC;
	
	public final static Triangle build(Point pointA, Point pointB, Point pointC) {
		Triangle t = new Triangle();
		t.pointA = pointA;
		t.pointB = pointB;
		t.pointC = pointC;
		return t;
	}
	
	public final Triangle rotate(Point rPoint, double theta) {
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
		StringBuilder sb = new StringBuilder("{Triangle:pointA=");
		sb.append(pointA).append(":pointB=").append(pointB);
		sb.append(":pointC=").append(pointC).append("}");
		return sb.toString();
	}
}
