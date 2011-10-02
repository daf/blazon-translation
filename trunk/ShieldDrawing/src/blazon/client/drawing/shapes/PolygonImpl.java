package blazon.client.drawing.shapes;

import java.util.ArrayList;
import java.util.Collection;

public class PolygonImpl implements Polygon {
	protected Collection<Point> points;	
	
	public PolygonImpl (Point ... points) {
		this.points = new ArrayList<Point>();
		if (points == null || points.length == 0) {
			throw new IllegalArgumentException("Can not construct a polygon with no points.");
		}
		for (Point p : points) {
			if (p == null) {
				throw new IllegalArgumentException("Can not construct a polygon with null points.");
			}
			if (this.points.contains(p)) {
				throw new IllegalArgumentException("Can not construct a polygon if some of the points are equal.");
			}
			this.points.add(p);
		}
	}
	
	@Override
	public final Collection<Point> getPoints() {
		return new ArrayList<Point>(points);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("PolygonImpl{points=");
		sb.append(points);
		return sb.toString();
	}
}
