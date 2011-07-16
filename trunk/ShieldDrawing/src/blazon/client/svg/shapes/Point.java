package blazon.client.svg.shapes;

public final class Point {

	private float x;
	private float y;
	
	public final static Point build(float x, float y) {
		Point p = new Point();
		p.x = x;
		p.y = y;
		return p;
	}
	
	public final Point rotate(Point rPoint, double theta) {
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
		StringBuilder sb = new StringBuilder("{Point:x=");
		sb.append(x).append(":y=").append(y).append("}");
		return sb.toString();
	}
}
