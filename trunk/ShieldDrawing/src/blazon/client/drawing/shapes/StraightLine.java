package blazon.client.drawing.shapes;

public class StraightLine {

	private Point a;
	private Point b;
	private double gradient;
	private double offset;
	
	private StraightLine() {}
	
	public static final StraightLine build(Point a, Point b) {
		StraightLine line = new StraightLine();
		line.a = a;
		line.b = b;
		double diffX = a.getX() - b.getX();
		double diffY = a.getY() - b.getY();
		
		line.gradient = (diffX == 0) ? Double.NaN : diffY / diffX;
		line.offset = (Double.isNaN(line.gradient)) ? -a.getX() : -((line.gradient * a.getX()) - a.getY());
		return line;
	}

	public final Point getMidPointOfLine() {
		float newX = (a.getX() + b.getX()) / 2;
		float newY = (a.getY() + b.getY()) / 2;
		return Point.build(newX, newY);
	}
	
	public final double getXCoordinateWhenYIsKnown(double y) {
		if (Double.isNaN(gradient)) {
			return a.getX();
		}
		if (gradient == 0) {
			throw new ArithmeticException("Can not find X coordinate as gradient is 0.");
		}
		return (y - offset) / gradient;
	}
	
	public final double getYCoordinateWhenXIsKnown(double x) {
		if (Double.isNaN(gradient)) {
			throw new ArithmeticException("Can not find Y coordinate as gradient is undefined.");
		}
		return (x * gradient) + offset;
	}

	public final double getLength() {
		double diffX = a.getX() - b.getX();
		double diffY = a.getY() - b.getY();
		return Math.sqrt(Math.pow(diffX, 2) + Math.pow(diffY, 2));
	}
}
