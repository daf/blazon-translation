package blazon.client.drawing.shapes;

public final class Point {

	private float x;
	private float y;
	
	public final static Point build(final float x, final float y) {
		Point p = new Point();
		p.x = x;
		p.y = y;
		return p;
	}
	
	final Point rotate(final Point rPoint, final double theta) {
		if (rPoint == null) {
			throw new IllegalArgumentException("Can not rotate a point about null");
		}
		float newX = x - rPoint.getX();
		float newY = y - rPoint.getY();
		final double sinTheta = Math.sin(theta);
		final double cosTheta = Math.cos(theta);
		double xTemp = newX * cosTheta - newY * sinTheta;
		double yTemp = newX * sinTheta + newY * cosTheta;
		newX = (float) xTemp + rPoint.getX();
		newY = (float) yTemp + rPoint.getY();
		return build(newX, newY);
	}
	
	public final float getX() {
		return x;
	}
	
	public final float getY() {
		return y;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Point{x=");
		sb.append(x).append(":y=").append(y).append("}");
		return sb.toString();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Point)) {
			return false;
		}
		Point other = (Point)obj;
		double errorAllowance = 0.000001;
		boolean xMatch = (Math.abs(x - other.x) < errorAllowance);
		boolean yMatch = (Math.abs(y - other.y) < errorAllowance);
		return xMatch && yMatch;
	}
	
	@Override
	public int hashCode() {
		int result = 17;
		result = 31 * result + Float.valueOf(x).hashCode();
		result = 31 * result + Float.valueOf(y).hashCode();
		return result;
	}
}