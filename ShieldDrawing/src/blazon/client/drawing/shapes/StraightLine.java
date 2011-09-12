package blazon.client.drawing.shapes;

public class StraightLine {

	private Point a;
	private Point b;
	private double gradient;
	private double offset;
	
	public StraightLine(Point a, Point b) {
		this.a = a;
		this.b = b;
		double diffX = a.getX() - b.getX();
		double diffY = a.getY() - b.getY();
		
		this.gradient = (diffX == 0) ? Double.NaN : diffY / diffX;
		this.offset = (Double.isNaN(this.gradient)) ? -a.getX() : -((this.gradient * a.getX()) - a.getY());
	}

	public final Point getMidPointOfLine() {
		float newX = (a.getX() + b.getX()) / 2;
		float newY = (a.getY() + b.getY()) / 2;
		return new Point(newX, newY);
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
