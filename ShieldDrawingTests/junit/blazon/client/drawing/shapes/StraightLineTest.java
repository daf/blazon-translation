package blazon.client.drawing.shapes;

import org.junit.Test;

import blazon.client.drawing.shapes.Point;
import blazon.client.drawing.shapes.StraightLine;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class StraightLineTest {

	@Test
	public void testThatAStraightLineWith2PointsWithSameXCoordinatesHaveALengthOfDifferenceInY() {
		Point p1 = Point.build(0, 5);
		Point p2 = Point.build(0, 10);
		StraightLine sl = StraightLine.build(p1, p2);
		assertThat(sl.getLength(), is(equalTo(5d)));
	}
	
	@Test
	public void testThatAStraightLineWith2PointsWithSameYCoordinatesHaveALengthOfDifferenceInX() {
		Point p1 = Point.build(5.5f, 0);
		Point p2 = Point.build(13, 0);
		StraightLine sl = StraightLine.build(p1, p2);
		assertThat(sl.getLength(), is(equalTo(7.5d)));
	}
	
	@Test
	public void testThatAStraightLineWith2PointsWithSameXCoordinatesHaveAMidPointOfXAndHalfTheDifferenceInY() {
		Point p1 = Point.build(0, 5);
		Point p2 = Point.build(0, 10);
		StraightLine sl = StraightLine.build(p1, p2);
		Point midpoint = Point.build(0, 7.5f);
		assertThat(sl.getMidPointOfLine(), is(equalTo(midpoint)));
	}
	
	@Test
	public void testThatAStraightLineWith2PointsWithSameYCooordinatesHaveAMidPointOfYAndHalfTheDifferenceInX() {
		Point p1 = Point.build(5.5f, 0);
		Point p2 = Point.build(13, 0);
		StraightLine sl = StraightLine.build(p1, p2);
		Point midpoint = Point.build(9.25f, 0);
		assertThat(sl.getMidPointOfLine(), is(equalTo(midpoint)));
	}
	
	@Test
	public void testThatAStraightLineWithPointXIs5YIs10AndPointXIsMinus3YIs4HasLength10() {
		Point p1 = Point.build(5, 10);
		Point p2 = Point.build(-3, 4);
		StraightLine sl = StraightLine.build(p1, p2);
		assertThat(sl.getLength(), is(equalTo(10d)));
	}
	
	@Test
	public void testThatAStraightLineWithPointXIs5YIs10AndPointXIsMinus3YIs4HasMidPointXIs1YIs7() {
		Point p1 = Point.build(5, 10);
		Point p2 = Point.build(-3, 4);
		StraightLine sl = StraightLine.build(p1, p2);
		Point midPoint = Point.build(1, 7);
		assertThat(sl.getMidPointOfLine(), is(equalTo(midPoint)));
	}
	
	@Test(expected=ArithmeticException.class)
	public void testThatWhenGettingXPointFromHorizontalLineAnArithmeticExceptionIsThrown() {
		Point p1 = Point.build(0, 0);
		Point p2 = Point.build(10, 0);
		StraightLine sl = StraightLine.build(p1, p2);
		sl.getXCoordinateWhenYIsKnown(0);
	}
	
	@Test
	public void testThatWhenGettingYPointFromHorizontalLineTheResultingValueIsTheYValueOfThePoints() {
		Point p1 = Point.build(0, 5);
		Point p2 = Point.build(10, 5);
		StraightLine sl = StraightLine.build(p1, p2);
		assertThat(sl.getYCoordinateWhenXIsKnown(0), is(equalTo(5d)));
	}
	
	@Test
	public void testThatWhenGettingXPointFromVerticalLineTheResultingValueIsTheXValueOfThePoints() {
		Point p1 = Point.build(1, 0);
		Point p2 = Point.build(1, 10);
		StraightLine sl = StraightLine.build(p1, p2);
		assertThat(sl.getXCoordinateWhenYIsKnown(5), is(equalTo(1d)));
	}
	
	@Test(expected=ArithmeticException.class)
	public void testThatWhenGettingYPointFromVerticalLineAnArithmeticExceptionIsThrown() {
		Point p1 = Point.build(1, 0);
		Point p2 = Point.build(1, 10);
		StraightLine sl = StraightLine.build(p1, p2);
		sl.getYCoordinateWhenXIsKnown(0);
	}
	
	@Test
	public void testThatGettingXPointFromXEqualsYLineGivesSameValueAsY() {
		Point p1 = Point.build(0, 0);
		Point p2 = Point.build(10, 10);
		StraightLine sl = StraightLine.build(p1, p2);
		assertThat(sl.getXCoordinateWhenYIsKnown(5), is(equalTo(5d)));
	}
	
	@Test
	public void testThatGettingYPointFromXEqualsYLineGivesSameValueAsX() {
		Point p1 = Point.build(0, 0);
		Point p2 = Point.build(10, 10);
		StraightLine sl = StraightLine.build(p1, p2);
		assertThat(sl.getYCoordinateWhenXIsKnown(5), is(equalTo(5d)));
	}
	
	@Test
	public void testThatGettingXPointFromXEquals2YPlus5LineGivesSameValueAsY() {
		Point p1 = Point.build(0, 5);
		Point p2 = Point.build(10, 25);
		StraightLine sl = StraightLine.build(p1, p2);
		assertThat(sl.getXCoordinateWhenYIsKnown(8), is(equalTo(1.5d)));
	}
	
	@Test
	public void testThatGettingYPointFromXEquals2YPlus5LineGivesSameValueAsX() {
		Point p1 = Point.build(0, 5);
		Point p2 = Point.build(10, 25);
		StraightLine sl = StraightLine.build(p1, p2);
		assertThat(sl.getYCoordinateWhenXIsKnown(8), is(equalTo(21d)));
	}
}
