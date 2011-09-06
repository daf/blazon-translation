package blazon.client.svg.shapes;

import static blazon.client.svg.shapes.SameTriangleAs.sameTriangleAs;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Collection;
import java.util.Iterator;

import org.junit.Test;

public class RightAngleTriangleTest {

	@Test(expected=IllegalArgumentException.class)
	public void testThatCanNotConstructRightAngleTriangleWith3NullPoints() {
		RightAngleTriangle.build(null, null, null);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testThatCanNotConstructRightAngleTriangleWithFirstPointNull() {
		Point b = Point.build(1, 1);
		Point c = Point.build(2, 2);
		RightAngleTriangle.build(null, b, c);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testThatCanNotConstructRightAngleTriangleWithSecondPointNull() {
		Point a = Point.build(0, 0);
		Point c = Point.build(2, 2);
		RightAngleTriangle.build(a, null, c);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testThatCanNotConstructRightAngleTriangleWithThirdPointNull() {
		Point a = Point.build(0, 0);
		Point b = Point.build(1, 1);
		RightAngleTriangle.build(a, b, null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testThatCanNotConstructRightAngleTriangleUsingEqualPoints() {
		Point a = Point.build(0, 0);
		RightAngleTriangle.build(a, a, a);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testThatCanNotConstructRightAngleTriangleWhenFirstAndSecondPointsAreEqual() {
		Point a = Point.build(0, 0);
		Point b = Point.build(1, 1);
		RightAngleTriangle.build(a, a, b);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testThatCanNotConstructRightAngleTriangleWhenFirstAndThirdPointsAreEqual() {
		Point a = Point.build(0, 0);
		Point b = Point.build(1, 1);
		RightAngleTriangle.build(a, b, a);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testThatCanNotConstructRightAngleTriangleWhenSecondAndThirdPointsAreEqual() {
		Point a = Point.build(0, 0);
		Point b = Point.build(1, 1);
		RightAngleTriangle.build(a, b, b);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testThatCanNotConstructRightAngleTriangleWhenLongestSideIsAToBButDoesNotFormRightAngleTriangle() {
		Point a = Point.build(0, 5);
		Point b = Point.build(0, 0);
		Point c = Point.build(3, 1.5f);
		RightAngleTriangle.build(a, b, c);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testThatCanNotConstructRightAngleTriangleWhenLongestSideIsAToCButDoesNotFormRightAngleTriangle() {
		Point a = Point.build(0, 0);
		Point b = Point.build(3, 1.5f);
		Point c = Point.build(0, 5);
		RightAngleTriangle.build(a, b, c);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testThatCanNotConstructRightAngleTriangleWhenLongestSideIsBToCButDoesNotFormRightAngleTriangle() {
		Point a = Point.build(3, 1.5f);
		Point b = Point.build(0, 0);
		Point c = Point.build(0, 5);
		RightAngleTriangle.build(a, b, c);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testThatCanNotConstructRightAngleTriangleWhen2SidesAreSameLengthButDoesNotFormRightAngleTriangle() {
		Point a = Point.build(0, 0);
		Point b = Point.build(3, 1);
		Point c = Point.build(0, 5);
		RightAngleTriangle.build(a, b, c);
	}
	
	@Test
	public void testThatGetPointsReturnsThePointsUsedToConstructTheTriangleInTheSameOrder() {
		Point a = Point.build(0, 0);
		Point b = Point.build(3, 0);
		Point c = Point.build(0, 4);
		Triangle t = RightAngleTriangle.build(a, b, c);
		Collection<Point> points = t.getPoints();
		assertThat(points.size(), is(equalTo(3)));
		Iterator<Point> iterator = points.iterator();
		assertThat(iterator.next(), is(equalTo(a)));
		assertThat(iterator.next(), is(equalTo(b)));
		assertThat(iterator.next(), is(equalTo(c)));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testThatRotatingTriangleAroundNullThrowsIllegalArgumentException() {
		Point a = Point.build(0, 0);
		Point b = Point.build(3, 0);
		Point c = Point.build(0, 4);
		Triangle t = RightAngleTriangle.build(a, b, c);
		t.rotate(null, Math.PI);
	}
	
	@Test
	public void testThatRotatingTriangleAboutOriginBy0RadiansGivesItself() {
		Point a = Point.build(0, 0);
		Point b = Point.build(3, 0);
		Point c = Point.build(0, 4);
		Triangle t = RightAngleTriangle.build(a, b, c);
		Point origin = Point.build(0, 0);
		assertThat(t.rotate(origin, 0), is(sameTriangleAs(t)));
	}
	
	@Test
	public void testThatRotatingTriangleAboutOriginBy2PiRadiansGivesItself() {
		Point a = Point.build(0, 0);
		Point b = Point.build(3, 0);
		Point c = Point.build(0, 4);
		Triangle t = RightAngleTriangle.build(a, b, c);
		Point origin = Point.build(0, 0);
		assertThat(t.rotate(origin, 2 * Math.PI), is(sameTriangleAs(t)));
	}
	
	@Test
	public void testThatRotatingTriangleAboutXMinus1Y3By2PiRadiansGivesItself() {
		Point a = Point.build(0, 0);
		Point b = Point.build(3, 0);
		Point c = Point.build(0, 4);
		Triangle t = RightAngleTriangle.build(a, b, c);
		Point rPoint = Point.build(-1, 3);
		assertThat(t.rotate(rPoint, 2 * Math.PI), is(sameTriangleAs(t)));
	}
	
	@Test
	public void testThatRotatingTriangleAboutXMinus1Y3ByPiRadiansGivesSameResultAsRotatingEachPointByPiRadiansAndConstructingNewTriangle() {
		Point a = Point.build(0, 0);
		Point b = Point.build(3, 0);
		Point c = Point.build(0, 4);
		Triangle t = RightAngleTriangle.build(a, b, c);
		Point rPoint = Point.build(-1, 3);
		double theta = Math.PI;
		Triangle rt = RightAngleTriangle.build(a.rotate(rPoint, theta), b.rotate(rPoint, theta), c.rotate(rPoint, theta));
		assertThat(t.rotate(rPoint, theta), is(sameTriangleAs(rt)));
	}
	
	@Test
	public void testThatRotatingTriangleAboutXMinus1Y3ByPiOver3RadiansGives() {
		Point a = Point.build(0, 0);
		Point b = Point.build(3, 0);
		Point c = Point.build(0, 4);
		Triangle t = RightAngleTriangle.build(a, b, c);
		Point rPoint = Point.build(-1, 3);
		double theta = Math.PI / 3;
		Triangle rt = RightAngleTriangle.build(a.rotate(rPoint, theta), b.rotate(rPoint, theta), c.rotate(rPoint, theta));
		assertThat(t.rotate(rPoint, theta), is(sameTriangleAs(rt)));
	}
	
	@Test
	public void testThatTriangleToStringIsAsExpected() {
		Point a = Point.build(0, 0);
		Point b = Point.build(3, 0);
		Point c = Point.build(0, 4);
		Triangle t = RightAngleTriangle.build(a, b, c);
		String expected = "RightAngleTriangle{pointA=Point{x=0.0:y=0.0}:pointB=Point{x=3.0:y=0.0}:pointC=Point{x=0.0:y=4.0}}";
		assertThat(t.toString(), is(equalTo(expected)));
	}
	
	@Test
	public void testThatTriangleWithLengths3And4HasHypotenuseOf5() {
		Point a = Point.build(0, 0);
		Point b = Point.build(3, 0);
		Point c = Point.build(0, 4);
		RightAngleTriangle t = RightAngleTriangle.build(a, b, c);
		assertThat(t.getLengthOfHypotenuse(), is(equalTo(5d)));
	}
	
	@Test
	public void testThatTriangleWithLengths3And5HasHypotenuseOf5Point8() {
		Point a = Point.build(0, 0);
		Point b = Point.build(3, 0);
		Point c = Point.build(0, 5);
		double errorAllowance = 0.000001;
		RightAngleTriangle t = RightAngleTriangle.build(a, b, c);
		assertTrue(t.getLengthOfHypotenuse() - 5.830951895 < errorAllowance);
	}
}
