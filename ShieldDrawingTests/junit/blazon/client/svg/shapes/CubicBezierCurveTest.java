package blazon.client.svg.shapes;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.equalTo;

public class CubicBezierCurveTest {

	@Test(expected=IllegalArgumentException.class)
	public void testThatCurveConstructedWithAllNullArgumentsThrowsIllegalArgumentException() {
		CubicBezierCurve.build(null, null, null, null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testThatCurveConstructedWithNullEndPoint1ThrowsIllegalArgumentException() {
		Point a = Point.build(0, 0);
		Point b = Point.build(1, 1);
		Point c = Point.build(2, 2);
		CubicBezierCurve.build(null, a, b, c);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testThatCurveConstructedWithNullEndPoint2ThrowsIllegalArgumentException() {
		Point a = Point.build(0, 0);
		Point b = Point.build(1, 1);
		Point c = Point.build(2, 2);
		CubicBezierCurve.build(a, null, b, c);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testThatCurveConstructedWithNullControlPoint1ThrowsIllegalArgumentException() {
		Point a = Point.build(0, 0);
		Point b = Point.build(1, 1);
		Point c = Point.build(2, 2);
		CubicBezierCurve.build(a, b, null, c);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testThatCurveConstructedWithNullControlPoint2ThrowsIllegalArgumentException() {
		Point a = Point.build(0, 0);
		Point b = Point.build(1, 1);
		Point c = Point.build(2, 2);
		CubicBezierCurve.build(a, b, c, null);
	}
	
	@Test
	public void testThatGettingEndPoint1FromCurveReturnsTheSamePointUsedInConstruction() {
		Point a = Point.build(0, 0);
		Point b = Point.build(1, 1);
		Point c = Point.build(2, 2);
		Point d = Point.build(2, 2);
		CubicBezierCurve curve = CubicBezierCurve.build(a, b, c, d);
		assertThat(curve.getEndPoint1(), is(equalTo(a)));
	}
	
	@Test
	public void testThatGettingEndPoint2FromCurveReturnsTheSamePointUsedInConstruction() {
		Point a = Point.build(0, 0);
		Point b = Point.build(1, 1);
		Point c = Point.build(2, 2);
		Point d = Point.build(2, 2);
		CubicBezierCurve curve = CubicBezierCurve.build(a, b, c, d);
		assertThat(curve.getEndPoint2(), is(equalTo(b)));
	}
	
	@Test
	public void testThatGettinControlPoint1FromCurveReturnsTheSamePointUsedInConstruction() {
		Point a = Point.build(0, 0);
		Point b = Point.build(1, 1);
		Point c = Point.build(2, 2);
		Point d = Point.build(2, 2);
		CubicBezierCurve curve = CubicBezierCurve.build(a, b, c, d);
		assertThat(curve.getControlPoint1(), is(equalTo(c)));
	}
	
	@Test
	public void testThatGettingControlPoint2FromCurveReturnsTheSamePointUsedInConstruction() {
		Point a = Point.build(0, 0);
		Point b = Point.build(1, 1);
		Point c = Point.build(2, 2);
		Point d = Point.build(2, 2);
		CubicBezierCurve curve = CubicBezierCurve.build(a, b, c, d);
		assertThat(curve.getControlPoint2(), is(equalTo(d)));
	}
	
	@Test
	public void testThatGettingEndPoint1FromCurveReturnsPointEqualToCoordinatesUsedInConstruction() {
		Point a = Point.build(0, 0);
		CubicBezierCurve curve = CubicBezierCurve.build(a.getX(), a.getY(), 1, 1, 2, 2, 3, 3);
		assertThat(curve.getEndPoint1(), is(equalTo(a)));
	}
	
	@Test
	public void testThatGettingEndPoint2FromCurveReturnsPointEqualToCoordinatesUsedInConstruction() {
		Point b = Point.build(1, 1);
		CubicBezierCurve curve = CubicBezierCurve.build(0, 0, b.getX(), b.getY(), 2, 2, 3, 3);
		assertThat(curve.getEndPoint2(), is(equalTo(b)));
	}
	
	@Test
	public void testThatGettinControlPoint1FromCurveReturnsPointEqualToCoordinatesUUsedInConstruction() {
		Point c = Point.build(2, 2);
		CubicBezierCurve curve = CubicBezierCurve.build(0, 0 ,1, 1, c.getX(), c.getY(), 3, 3);
		assertThat(curve.getControlPoint1(), is(equalTo(c)));
	}
	
	@Test
	public void testThatGettingControlPoint2FromCurveReturnsPointEqualToCoordinatesUsedInConstruction() {
		Point d = Point.build(2, 2);
		CubicBezierCurve curve = CubicBezierCurve.build(0, 0, 1, 1, 2, 2, d.getX(), d.getY());
		assertThat(curve.getControlPoint2(), is(equalTo(d)));
	}
	
	@Test
	public void testThatCurveConstructedWithEqualEndAndControlPointsHasMidpointAlsoEqual() {
		Point p = Point.build(5, 2);
		CubicBezierCurve curve = CubicBezierCurve.build(p, p, p, p);
		assertThat(curve.findMidpointOnCurve(), is(equalTo(p)));
	}
	
	@Test
	public void testThatCurveConstructedHasMidpointX5Y4() {
		Point a = Point.build(-40, 30);
		Point b = Point.build(-16, -28);
		Point c = Point.build(0, 0);
		Point d = Point.build(32, 10);
		Point m = Point.build(5, 4);
		CubicBezierCurve curve = CubicBezierCurve.build(a, b, c, d);
		assertThat(curve.findMidpointOnCurve(), is(equalTo(m)));
	}
	
	@Test
	public void testThatTangentToMidPointHasMidpointOnIt() {
		Point a = Point.build(-40, 30);
		Point b = Point.build(-16, -28);
		Point c = Point.build(0, 0);
		Point d = Point.build(32, 10);
		CubicBezierCurve curve = CubicBezierCurve.build(a, b, c, d);
		Point m = curve.findMidpointOnCurve();
		StraightLine sl = curve.getTangentToCurveAtMidpoint();
		double errorBound = 0.000001;
		assertTrue(sl.getXCoordinateWhenYIsKnown(m.getY()) - m.getX() < errorBound);
		assertTrue(sl.getYCoordinateWhenXIsKnown(m.getX()) - m.getY() < errorBound);
	}
	
	@Test
	public void testThatTangentToMidPointHasFormulaYEqualsMinus12Over14XMinus8Point285714286() {
		Point a = Point.build(-40, 30);
		Point b = Point.build(-16, -28);
		Point c = Point.build(0, 0);
		Point d = Point.build(32, 10);
		CubicBezierCurve curve = CubicBezierCurve.build(a, b, c, d);
		StraightLine sl = curve.getTangentToCurveAtMidpoint();
		double errorBound = 0.000001;
		Point test1 = Point.build(-2, 10);
		Point test2 = Point.build(12, -2);
		assertTrue(sl.getXCoordinateWhenYIsKnown(test1.getY()) - test1.getX() < errorBound);
		assertTrue(sl.getYCoordinateWhenXIsKnown(test1.getX()) - test1.getY() < errorBound);
		assertTrue(sl.getXCoordinateWhenYIsKnown(test2.getY()) - test2.getX() < errorBound);
		assertTrue(sl.getYCoordinateWhenXIsKnown(test2.getX()) - test2.getY() < errorBound);
	}
}
