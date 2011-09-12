package blazon.client.drawing.shapes;

public class CubicBezierCurve {
	private Point e1;
	private Point e2;
	private Point c1;
	private Point c2;
	
	public CubicBezierCurve (float e1x, float e1y, float e2x, float e2y, float c1x, float c1y, float c2x, float c2y) {
		this(new Point(e1x, e1y), new Point(e2x, e2y), new Point(c1x, c1y), new Point(c2x, c2y));
	}
	
	public CubicBezierCurve(Point e1, Point e2, Point c1, Point c2) {
		if (e1 == null || e2 == null || c1 == null || c2 == null) {
			throw new IllegalArgumentException("");
		}
		this.e1 = e1;
		this.e2 = e2;
		this.c1 = c1;
		this.c2 = c2;
	}
	
	public final Point findMidpointOnCurve() {
		return findPointAtTDistanceOnCurve(0.5);
	}
	
	private final Point findPointAtTDistanceOnCurve(double t) {
		double d = 1 - t;
		double xCoord = (Math.pow(d, 3) * e1.getX())
				+ (3 * t * Math.pow(d, 2) * c1.getX())
				+ (3 * Math.pow(t, 2) * d * c2.getX())
				+ (Math.pow(t, 3) * e2.getX());
		double yCoord = (Math.pow(d, 3) * e1.getY())
				+ (3 * t * Math.pow(d, 2) * c1.getY())
				+ (3 * Math.pow(t, 2) * d * c2.getY())
				+ (Math.pow(t, 3) * e2.getY());
		return new Point((float) xCoord, (float) yCoord);
	}
	
	public final StraightLine getTangentToCurveAtMidpoint() {
		Point m1 = new StraightLine(e1, c1).getMidPointOfLine();
		Point m2 = new StraightLine(c1, c2).getMidPointOfLine();
		Point m3 = new StraightLine(c2, e2).getMidPointOfLine();
		
		Point m4 = new StraightLine(m1, m2).getMidPointOfLine();
		Point m5 = new StraightLine(m2, m3).getMidPointOfLine();
		
		return new StraightLine(m4, m5);
	}

	public Point getEndPoint1() {
		return e1;
	}

	public Point getEndPoint2() {
		return e2;
	}

	public Point getControlPoint1() {
		return c1;
	}

	public Point getControlPoint2() {
		return c2;
	}

}