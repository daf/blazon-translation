package blazon.client.svg.shapes;

public final class RightAngleTriangle extends Triangle {

	public final static RightAngleTriangle build(Point pointA, Point pointB, Point pointC) {
		if (pointA.equals(pointB) || pointA.equals(pointC) || pointB.equals(pointC)) {
			throw new IllegalArgumentException("Can not construct a right angle triangle if some of the points are equal.");
		}
		RightAngleTriangle t = new RightAngleTriangle();
		
		double aToB = StraightLine.build(pointA, pointB).getLength();
		double aToC = StraightLine.build(pointA, pointC).getLength();
		double bToC = StraightLine.build(pointB, pointC).getLength();
		
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
		}
		
		if (triangleIsNotRightAngled) {
			throw new IllegalArgumentException("The points given to not form a right angle triangle.");
		}
		
		t.pointA = pointA;
		t.pointB = pointB;
		t.pointC = pointC;
		return t;
	}
	
	public final double getLengthOfHypotenuse() {
		double aToB = StraightLine.build(pointA, pointB).getLength();
		double aToC = StraightLine.build(pointA, pointC).getLength();
		double bToC = StraightLine.build(pointB, pointC).getLength();
		return Math.max(aToB, Math.max(aToC, bToC));
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("{RightAngleTriangle:pointA=");
		sb.append(pointA).append(":pointB=").append(pointB);
		sb.append(":pointC=").append(pointC).append("}");
		return sb.toString();
	}
}
//FIXME add tests for triangle