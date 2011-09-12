package blazon.client.drawing.shapes;

public final class RightAngleTriangle extends Triangle {

	public RightAngleTriangle(Point pointA, Point pointB, Point pointC) {
		super(pointA, pointB, pointC);
		double aToB = new StraightLine(this.pointA, this.pointB).getLength();
		double aToC = new StraightLine(this.pointA, this.pointC).getLength();
		double bToC = new StraightLine(this.pointB, this.pointC).getLength();
		
		boolean triangleIsNotRightAngled = false;
		double errorAllowance = 0.000001;
		if (aToB > aToC && aToB > bToC) {
			double otherSidesSquared = Math.pow(aToC, 2) + Math.pow(bToC, 2);
			double longestSideSquared = Math.pow(aToB, 2);
			if (Math.abs(longestSideSquared - otherSidesSquared) > errorAllowance) {
				triangleIsNotRightAngled = true;
			}
		} else if (aToC > aToB && aToC > bToC) {
			double otherSidesSquared = Math.pow(aToB, 2) + Math.pow(bToC, 2);
			double longestSideSquared = Math.pow(aToC, 2);
			if (Math.abs(longestSideSquared - otherSidesSquared) > errorAllowance) {
				triangleIsNotRightAngled = true;
			}
		} else if (bToC > aToB && bToC > aToC) {
			double otherSidesSquared = Math.pow(aToB, 2) + Math.pow(aToC, 2);
			double longestSideSquared = Math.pow(bToC, 2);
			if (Math.abs(longestSideSquared - otherSidesSquared) > errorAllowance) {
				triangleIsNotRightAngled = true;
			}
		} else {
			triangleIsNotRightAngled = true;
		}
		
		if (triangleIsNotRightAngled) {
			throw new IllegalArgumentException("The points given to not form a right angle triangle.");
		}
	}
	
	public final double getLengthOfHypotenuse() {
		double aToB = new StraightLine(pointA, pointB).getLength();
		double aToC = new StraightLine(pointA, pointC).getLength();
		double bToC = new StraightLine(pointB, pointC).getLength();
		return Math.max(aToB, Math.max(aToC, bToC));
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("RightAngleTriangle{pointA=");
		sb.append(pointA).append(":pointB=").append(pointB);
		sb.append(":pointC=").append(pointC).append("}");
		return sb.toString();
	}
}