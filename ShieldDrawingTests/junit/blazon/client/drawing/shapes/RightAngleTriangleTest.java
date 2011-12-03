package blazon.client.drawing.shapes;

import static blazon.client.drawing.shapes.SameTriangleAs.sameTriangleAs;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Collection;
import java.util.Iterator;

import org.junit.Test;

import blazon.client.drawing.shapes.Point;
import blazon.client.drawing.shapes.Polygon;
import blazon.client.drawing.shapes.RightAngleTriangle;
import blazon.client.drawing.shapes.Triangle;

public class RightAngleTriangleTest {

	@Test(expected=IllegalArgumentException.class)
	public void testThatCanNotConstructRightAngleTriangleWith3NullPoints() {
		new RightAngleTriangle(null, null, null);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testThatCanNotConstructRightAngleTriangleWithFirstPointNull() {
		Point b = new Point(1, 1);
		Point c = new Point(2, 2);
		new RightAngleTriangle(null, b, c);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testThatCanNotConstructRightAngleTriangleWithSecondPointNull() {
		Point a = new Point(0, 0);
		Point c = new Point(2, 2);
		new RightAngleTriangle(a, null, c);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testThatCanNotConstructRightAngleTriangleWithThirdPointNull() {
		Point a = new Point(0, 0);
		Point b = new Point(1, 1);
		new RightAngleTriangle(a, b, null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testThatCanNotConstructRightAngleTriangleUsingEqualPoints() {
		Point a = new Point(0, 0);
		new RightAngleTriangle(a, a, a);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testThatCanNotConstructRightAngleTriangleWhenFirstAndSecondPointsAreEqual() {
		Point a = new Point(0, 0);
		Point b = new Point(1, 1);
		new RightAngleTriangle(a, a, b);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testThatCanNotConstructRightAngleTriangleWhenFirstAndThirdPointsAreEqual() {
		Point a = new Point(0, 0);
		Point b = new Point(1, 1);
		new RightAngleTriangle(a, b, a);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testThatCanNotConstructRightAngleTriangleWhenSecondAndThirdPointsAreEqual() {
		Point a = new Point(0, 0);
		Point b = new Point(1, 1);
		new RightAngleTriangle(a, b, b);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testThatCanNotConstructRightAngleTriangleWhenLongestSideIsAToBButDoesNotFormRightAngleTriangle() {
		Point a = new Point(0, 5);
		Point b = new Point(0, 0);
		Point c = new Point(3, 1.5f);
		new RightAngleTriangle(a, b, c);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testThatCanNotConstructRightAngleTriangleWhenLongestSideIsAToCButDoesNotFormRightAngleTriangle() {
		Point a = new Point(0, 0);
		Point b = new Point(3, 1.5f);
		Point c = new Point(0, 5);
		new RightAngleTriangle(a, b, c);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testThatCanNotConstructRightAngleTriangleWhenLongestSideIsBToCButDoesNotFormRightAngleTriangle() {
		Point a = new Point(3, 1.5f);
		Point b = new Point(0, 0);
		Point c = new Point(0, 5);
		new RightAngleTriangle(a, b, c);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testThatCanNotConstructRightAngleTriangleWhen2SidesAreSameLengthButDoesNotFormRightAngleTriangle() {
		Point a = new Point(0, 0);
		Point b = new Point(3, 1);
		Point c = new Point(0, 5);
		new RightAngleTriangle(a, b, c);
	}
	
	@Test
	public void testThatGetPointsReturnsThePointsUsedToConstructTheTriangleInTheSameOrder() {
		Point a = new Point(0, 0);
		Point b = new Point(3, 0);
		Point c = new Point(0, 4);
		Polygon t = new RightAngleTriangle(a, b, c);
		Collection<Point> points = t.getPoints();
		assertThat(points.size(), is(equalTo(3)));
		Iterator<Point> iterator = points.iterator();
		assertThat(iterator.next(), is(equalTo(a)));
		assertThat(iterator.next(), is(equalTo(b)));
		assertThat(iterator.next(), is(equalTo(c)));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testThatRotatingTriangleAroundNullThrowsIllegalArgumentException() {
		Point a = new Point(0, 0);
		Point b = new Point(3, 0);
		Point c = new Point(0, 4);
		Triangle t = new RightAngleTriangle(a, b, c);
		t.rotate(null, Math.PI);
	}
	
	@Test
	public void testThatRotatingTriangleAboutOriginBy0RadiansGivesItself() {
		Point a = new Point(0, 0);
		Point b = new Point(3, 0);
		Point c = new Point(0, 4);
		Triangle t = new RightAngleTriangle(a, b, c);
		Point origin = new Point(0, 0);
		assertThat(t.rotate(origin, 0), is(sameTriangleAs(t)));
	}
	
	@Test
	public void testThatRotatingTriangleAboutOriginBy2PiRadiansGivesItself() {
		Point a = new Point(0, 0);
		Point b = new Point(3, 0);
		Point c = new Point(0, 4);
		Triangle t = new RightAngleTriangle(a, b, c);
		Point origin = new Point(0, 0);
		assertThat(t.rotate(origin, 2 * Math.PI), is(sameTriangleAs(t)));
	}
	
	@Test
	public void testThatRotatingTriangleAboutXMinus1Y3By2PiRadiansGivesItself() {
		Point a = new Point(0, 0);
		Point b = new Point(3, 0);
		Point c = new Point(0, 4);
		Triangle t = new RightAngleTriangle(a, b, c);
		Point rPoint = new Point(-1, 3);
		assertThat(t.rotate(rPoint, 2 * Math.PI), is(sameTriangleAs(t)));
	}
	
	@Test
	public void testThatRotatingTriangleAboutXMinus1Y3ByPiRadiansGivesSameResultAsRotatingEachPointByPiRadiansAndConstructingNewTriangle() {
		Point a = new Point(0, 0);
		Point b = new Point(3, 0);
		Point c = new Point(0, 4);
		Triangle t = new RightAngleTriangle(a, b, c);
		Point rPoint = new Point(-1, 3);
		double theta = Math.PI;
		Polygon rt = new RightAngleTriangle(a.rotate(rPoint, theta), b.rotate(rPoint, theta), c.rotate(rPoint, theta));
		assertThat(t.rotate(rPoint, theta), is(sameTriangleAs(rt)));
	}
	
	@Test
	public void testThatRotatingTriangleAboutXMinus1Y3ByPiOver3RadiansGives() {
		Point a = new Point(0, 0);
		Point b = new Point(3, 0);
		Point c = new Point(0, 4);
		Triangle t = new RightAngleTriangle(a, b, c);
		Point rPoint = new Point(-1, 3);
		double theta = Math.PI / 3;
		Polygon rt = new RightAngleTriangle(a.rotate(rPoint, theta), b.rotate(rPoint, theta), c.rotate(rPoint, theta));
		assertThat(t.rotate(rPoint, theta), is(sameTriangleAs(rt)));
	}
	
	@Test
	public void testThatTriangleToStringIsAsExpected() {
		Point a = new Point(0, 0);
		Point b = new Point(3, 0);
		Point c = new Point(0, 4);
		Polygon t = new RightAngleTriangle(a, b, c);
		String expected = "RightAngleTriangle{pointA=Point{x=0.0:y=0.0}:pointB=Point{x=3.0:y=0.0}:pointC=Point{x=0.0:y=4.0}}";
		assertThat(t.toString(), is(equalTo(expected)));
	}
	
	@Test
	public void testThatTriangleWithLengths3And4HasHypotenuseOf5() {
		Point a = new Point(0, 0);
		Point b = new Point(3, 0);
		Point c = new Point(0, 4);
		RightAngleTriangle t = new RightAngleTriangle(a, b, c);
		assertThat(t.getLengthOfHypotenuse(), is(equalTo(5d)));
	}
	
	@Test
	public void testThatTriangleWithLengths3And5HasHypotenuseOf5Point8() {
		Point a = new Point(0, 0);
		Point b = new Point(3, 0);
		Point c = new Point(0, 5);
		double errorAllowance = 0.000001;
		RightAngleTriangle t = new RightAngleTriangle(a, b, c);
		assertTrue(t.getLengthOfHypotenuse() - 5.830951895 < errorAllowance);
	}
}
