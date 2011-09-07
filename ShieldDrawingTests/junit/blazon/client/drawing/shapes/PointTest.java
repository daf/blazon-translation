package blazon.client.drawing.shapes;

import org.junit.Test;

import blazon.client.drawing.shapes.Point;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class PointTest {

	@Test
	public void testThatTheConstructorSetsXTo5AndYTo3() {
		Point point = Point.build(5f, 3f);
		assertThat(point.getX(), is(equalTo(5f)));
		assertThat(point.getY(), is(equalTo(3f)));
	}
	
	@Test
	public void testThatTheConstructorSetsXToMinus2Point5AndYTo200() {
		Point point = Point.build(2.4f, 200);
		assertThat(point.getX(), is(equalTo(2.4f)));
		assertThat(point.getY(), is(equalTo(200f)));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testThatRotatingPointAroundNullThrowsIllegalArgumentException() {
		Point p = Point.build(0, 0);
		p.rotate(null, Math.PI);
	}
	
	@Test
	public void testThatRotatingOriginAboutItselfByPiRadiansGivesItself() {
		Point origin = Point.build(0, 0);
		assertThat(origin.rotate(origin, Math.PI), is(equalTo(origin)));
	}
	
	@Test
	public void testThatRotatingX5Y2AboutOriginBy0RadiansGivesItself() {
		Point point = Point.build(5, 2);
		Point origin = Point.build(0, 0);
		assertThat(point.rotate(origin, 0), is(equalTo(point)));
	}
	
	@Test
	public void testThatRotatingX5Y2AboutOriginBy2PiRadiansGivesItself() {
		Point point = Point.build(5, 2);
		Point origin = Point.build(0, 0);
		assertThat(point.rotate(origin, 2 * Math.PI), is(equalTo(point)));
	}
	
	@Test
	public void testThatRotatingX5Y2AboutXMinus1Y3By2PiRadiansGivesItself() {
		Point point = Point.build(5, 2);
		Point rPoint = Point.build(-1, 3);
		assertThat(point.rotate(rPoint, 2 * Math.PI), is(equalTo(point)));
	}
	
	@Test
	public void testThatRotatingX5Y2AboutXMinus1Y3ByPiRadiansGivesXMinus7Y4() {
		Point point = Point.build(5, 2);
		Point rPoint = Point.build(-1, 3);
		Point expected = Point.build(-7, 4);
		assertThat(point.rotate(rPoint, Math.PI), is(equalTo(expected)));
	}
	
	@Test
	public void testThatRotatingX5Y2AboutXMinus1Y3ByPiOver3RadiansGivesX2Point866Y7Point676() {
		Point point = Point.build(5, 2);
		Point rPoint = Point.build(-1, 3);
		Point expected = Point.build(2.8660254f, 7.696152f);
		assertThat(point.rotate(rPoint, Math.PI / 3), is(equalTo(expected)));
	}
	
	@Test
	public void testThatAPointIsEqualToItself() {
		Point point = Point.build(5, 2);
		assertThat(point.equals(point), is(true));
		assertThat(point.hashCode(), is(equalTo(point.hashCode())));
	}
	
	@Test
	public void testThatAPointIsEqualToAnotherPointWithSameXandY() {
		Point point1 = Point.build(5, 2);
		Point point2 = Point.build(5, 2);
		assertThat(point1.equals(point2), is(true));
		assertThat(point1.hashCode(), is(equalTo(point2.hashCode())));
	}
	
	@Test
	public void testThatAPointIsEqualToAnotherPointWithSameXandYConsistently() {
		Point point1 = Point.build(5, 2);
		Point point2 = Point.build(5, 2);
		assertThat(point1.equals(point2), is(true));
		assertThat(point1.hashCode(), is(equalTo(point2.hashCode())));
		assertThat(point1.equals(point2), is(true));
		assertThat(point1.hashCode(), is(equalTo(point2.hashCode())));
	}
	
	@Test
	public void testThatAPointIsEqualToAnotherPointWithSameXandYSymmetrically() {
		Point point1 = Point.build(5, 2);
		Point point2 = Point.build(5, 2);
		assertThat(point1.equals(point2), is(true));
		assertThat(point1.hashCode(), is(equalTo(point2.hashCode())));
		assertThat(point2.equals(point1), is(true));
		assertThat(point2.hashCode(), is(equalTo(point1.hashCode())));
	}
	
	@Test
	public void testThatA3PointsWithSameXandYAreEqualTransitively() {
		Point point1 = Point.build(5, 2);
		Point point2 = Point.build(5, 2);
		Point point3 = Point.build(5, 2);
		assertThat(point1.equals(point2), is(true));
		assertThat(point1.hashCode(), is(equalTo(point2.hashCode())));
		assertThat(point2.equals(point3), is(true));
		assertThat(point2.hashCode(), is(equalTo(point3.hashCode())));
		assertThat(point1.equals(point3), is(true));
		assertThat(point1.hashCode(), is(equalTo(point3.hashCode())));
	}
	
	@Test
	public void testThat2PointsWithDifferentXValuesAreNotEqual() {
		Point point1 = Point.build(5, 2);
		Point point2 = Point.build(4, 2);
		assertThat(point1.equals(point2), is(false));
	}
	
	@Test
	public void testThat2PointsWithDifferentYValuesAreNotEqual() {
		Point point1 = Point.build(5, 2);
		Point point2 = Point.build(5, 3);
		assertThat(point1.equals(point2), is(false));
	}
	
	@Test
	public void testThatAPointIsNotEqualToAnObject() {
		Point point = Point.build(5, 2);
		assertThat(point.equals(new Object()), is(false));
	}
	
	@Test
	public void testThatAPointWithX2AndY3ToStringIsAsExpected() {
		Point point = Point.build(2, 3);
		String expected = "Point{x=2.0:y=3.0}";
		assertThat(point.toString(), is(equalTo(expected)));
	}
	
	@Test
	public void testThatAPointWithX2Point45AndYMinus3ToStringIsAsExpected() {
		Point point = Point.build(2.45f, -3);
		String expected = "Point{x=2.45:y=-3.0}";
		assertThat(point.toString(), is(equalTo(expected)));
	}
}
