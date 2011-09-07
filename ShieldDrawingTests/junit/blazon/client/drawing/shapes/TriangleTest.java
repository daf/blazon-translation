package blazon.client.drawing.shapes;

import java.util.Collection;
import java.util.Iterator;

import org.junit.Test;

import blazon.client.drawing.shapes.Point;
import blazon.client.drawing.shapes.Polygon;
import blazon.client.drawing.shapes.Triangle;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static blazon.client.drawing.shapes.SameTriangleAs.sameTriangleAs;

public class TriangleTest {
	
	@Test(expected=IllegalArgumentException.class)
	public void testThatCanNotConstructTriangleWith3NullPoints() {
		Triangle.build(null, null, null);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testThatCanNotConstructTriangleWithFirstPointNull() {
		Point b = Point.build(1, 1);
		Point c = Point.build(2, 2);
		Triangle.build(null, b, c);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testThatCanNotConstructTriangleWithSecondPointNull() {
		Point a = Point.build(0, 0);
		Point c = Point.build(2, 2);
		Triangle.build(a, null, c);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testThatCanNotConstructTriangleWithThirdPointNull() {
		Point a = Point.build(0, 0);
		Point b = Point.build(1, 1);
		Triangle.build(a, b, null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testThatCanNotConstructTriangleUsingEqualPoints() {
		Point a = Point.build(0, 0);
		Triangle.build(a, a, a);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testThatCanNotConstructTriangleWhenFirstAndSecondPointsAreEqual() {
		Point a = Point.build(0, 0);
		Point b = Point.build(1, 1);
		Triangle.build(a, a, b);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testThatCanNotConstructTriangleWhenFirstAndThirdPointsAreEqual() {
		Point a = Point.build(0, 0);
		Point b = Point.build(1, 1);
		Triangle.build(a, b, a);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testThatCanNotConstructTriangleWhenSecondAndThirdPointsAreEqual() {
		Point a = Point.build(0, 0);
		Point b = Point.build(1, 1);
		Triangle.build(a, b, b);
	}
	
	@Test
	public void testThatGetPointsReturnsThePointsUsedToConstructTheTriangleInTheSameOrder() {
		Point a = Point.build(10, -1);
		Point b = Point.build(1, 5);
		Point c = Point.build(2, 2.5f);
		Polygon t = Triangle.build(a, b, c);
		Collection<Point> points = t.getPoints();
		assertThat(points.size(), is(equalTo(3)));
		Iterator<Point> iterator = points.iterator();
		assertThat(iterator.next(), is(equalTo(a)));
		assertThat(iterator.next(), is(equalTo(b)));
		assertThat(iterator.next(), is(equalTo(c)));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testThatRotatingTriangleAroundNullThrowsIllegalArgumentException() {
		Point a = Point.build(10, -1);
		Point b = Point.build(1, 5);
		Point c = Point.build(2, 2.5f);
		Triangle t = Triangle.build(a, b, c);
		t.rotate(null, Math.PI);
	}
	
	@Test
	public void testThatRotatingTriangleAboutOriginBy0RadiansGivesItself() {
		Point a = Point.build(10, -1);
		Point b = Point.build(1, 5);
		Point c = Point.build(2, 2.5f);
		Triangle t = Triangle.build(a, b, c);
		Point origin = Point.build(0, 0);
		assertThat(t.rotate(origin, 0), is(sameTriangleAs(t)));
	}
	
	@Test
	public void testThatRotatingTriangleAboutOriginBy2PiRadiansGivesItself() {
		Point a = Point.build(10, -1);
		Point b = Point.build(1, 5);
		Point c = Point.build(2, 2.5f);
		Triangle t = Triangle.build(a, b, c);
		Point origin = Point.build(0, 0);
		assertThat(t.rotate(origin, 2 * Math.PI), is(sameTriangleAs(t)));
	}
	
	@Test
	public void testThatRotatingTriangleAboutXMinus1Y3By2PiRadiansGivesItself() {
		Point a = Point.build(10, -1);
		Point b = Point.build(1, 5);
		Point c = Point.build(2, 2.5f);
		Triangle t = Triangle.build(a, b, c);
		Point rPoint = Point.build(-1, 3);
		assertThat(t.rotate(rPoint, 2 * Math.PI), is(sameTriangleAs(t)));
	}
	
	@Test
	public void testThatRotatingTriangleAboutXMinus1Y3ByPiRadiansGivesSameResultAsRotatingEachPointByPiRadiansAndConstructingNewTriangle() {
		Point a = Point.build(10, -1);
		Point b = Point.build(1, 5);
		Point c = Point.build(2, 2.5f);
		Triangle t = Triangle.build(a, b, c);
		Point rPoint = Point.build(-1, 3);
		double theta = Math.PI;
		Polygon rt = Triangle.build(a.rotate(rPoint, theta), b.rotate(rPoint, theta), c.rotate(rPoint, theta));
		assertThat(t.rotate(rPoint, theta), is(sameTriangleAs(rt)));
	}
	
	@Test
	public void testThatRotatingTriangleAboutXMinus1Y3ByPiOver3RadiansGives() {
		Point a = Point.build(10, -1);
		Point b = Point.build(1, 5);
		Point c = Point.build(2, 2.5f);
		Triangle t = Triangle.build(a, b, c);
		Point rPoint = Point.build(-1, 3);
		double theta = Math.PI / 3;
		Polygon rt = Triangle.build(a.rotate(rPoint, theta), b.rotate(rPoint, theta), c.rotate(rPoint, theta));

		assertThat(t.rotate(rPoint, theta), is(sameTriangleAs(rt)));
	}
	
	@Test
	public void testThatTriangleToStringIsAsExpected() {
		Point a = Point.build(10, -1);
		Point b = Point.build(1, 5);
		Point c = Point.build(2, 2.5f);
		Polygon t = Triangle.build(a, b, c);
		String expected = "Triangle{pointA=Point{x=10.0:y=-1.0}:pointB=Point{x=1.0:y=5.0}:pointC=Point{x=2.0:y=2.5}}";
		assertThat(t.toString(), is(equalTo(expected)));
	}
}
