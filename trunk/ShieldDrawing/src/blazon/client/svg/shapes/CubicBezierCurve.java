package blazon.client.svg.shapes;

public class CubicBezierCurve {
	private Point e1;
	private Point e2;
	private Point c1;
	private Point c2;
	
	private CubicBezierCurve() {}
	
	public final static CubicBezierCurve build(float e1x, float e1y, float e2x, float e2y, float c1x, float c1y, float c2x, float c2y) {
		return build(Point.build(e1x, e1y), Point.build(e2x, e2y), Point.build(c1x, c1y), Point.build(c2x, c2y));
	}
	
	public final static CubicBezierCurve build(Point e1, Point e2, Point c1, Point c2) {
		if (e1 == null || e2 == null || c1 == null || c2 == null) {
			throw new IllegalArgumentException("");
		}
		CubicBezierCurve curve = new CubicBezierCurve();
		curve.e1 = e1;
		curve.e2 = e2;
		curve.c1 = c1;
		curve.c2 = c2;
		return curve;
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
		return Point.build((float) xCoord, (float) yCoord);
	}
	
	public final StraightLine getTangentToCurveAtMidpoint() {
		Point m1 = StraightLine.build(e1, c1).getMidPointOfLine();
		Point m2 = StraightLine.build(c1, c2).getMidPointOfLine();
		Point m3 = StraightLine.build(c2, e2).getMidPointOfLine();
		
		Point m4 = StraightLine.build(m1, m2).getMidPointOfLine();
		Point m5 = StraightLine.build(m2, m3).getMidPointOfLine();
		
		return StraightLine.build(m4, m5);
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