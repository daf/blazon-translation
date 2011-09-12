package blazon.client.drawing.shapes;

import org.junit.Test;

import blazon.client.drawing.shapes.CubicBezierCurve;
import blazon.client.drawing.shapes.Point;
import blazon.client.drawing.shapes.StraightLine;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.equalTo;

public class CubicBezierCurveTest {

	@Test(expected=IllegalArgumentException.class)
	public void testThatCurveConstructedWithAllNullArgumentsThrowsIllegalArgumentException() {
		new CubicBezierCurve(null, null, null, null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testThatCurveConstructedWithNullEndPoint1ThrowsIllegalArgumentException() {
		Point a = new Point(0, 0);
		Point b = new Point(1, 1);
		Point c = new Point(2, 2);
		new CubicBezierCurve(null, a, b, c);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testThatCurveConstructedWithNullEndPoint2ThrowsIllegalArgumentException() {
		Point a = new Point(0, 0);
		Point b = new Point(1, 1);
		Point c = new Point(2, 2);
		new CubicBezierCurve(a, null, b, c);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testThatCurveConstructedWithNullControlPoint1ThrowsIllegalArgumentException() {
		Point a = new Point(0, 0);
		Point b = new Point(1, 1);
		Point c = new Point(2, 2);
		new CubicBezierCurve(a, b, null, c);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testThatCurveConstructedWithNullControlPoint2ThrowsIllegalArgumentException() {
		Point a = new Point(0, 0);
		Point b = new Point(1, 1);
		Point c = new Point(2, 2);
		new CubicBezierCurve(a, b, c, null);
	}
	
	@Test
	public void testThatGettingEndPoint1FromCurveReturnsTheSamePointUsedInConstruction() {
		Point a = new Point(0, 0);
		Point b = new Point(1, 1);
		Point c = new Point(2, 2);
		Point d = new Point(2, 2);
		CubicBezierCurve curve = new CubicBezierCurve(a, b, c, d);
		assertThat(curve.getEndPoint1(), is(equalTo(a)));
	}
	
	@Test
	public void testThatGettingEndPoint2FromCurveReturnsTheSamePointUsedInConstruction() {
		Point a = new Point(0, 0);
		Point b = new Point(1, 1);
		Point c = new Point(2, 2);
		Point d = new Point(2, 2);
		CubicBezierCurve curve = new CubicBezierCurve(a, b, c, d);
		assertThat(curve.getEndPoint2(), is(equalTo(b)));
	}
	
	@Test
	public void testThatGettinControlPoint1FromCurveReturnsTheSamePointUsedInConstruction() {
		Point a = new Point(0, 0);
		Point b = new Point(1, 1);
		Point c = new Point(2, 2);
		Point d = new Point(2, 2);
		CubicBezierCurve curve = new CubicBezierCurve(a, b, c, d);
		assertThat(curve.getControlPoint1(), is(equalTo(c)));
	}
	
	@Test
	public void testThatGettingControlPoint2FromCurveReturnsTheSamePointUsedInConstruction() {
		Point a = new Point(0, 0);
		Point b = new Point(1, 1);
		Point c = new Point(2, 2);
		Point d = new Point(2, 2);
		CubicBezierCurve curve = new CubicBezierCurve(a, b, c, d);
		assertThat(curve.getControlPoint2(), is(equalTo(d)));
	}
	
	@Test
	public void testThatGettingEndPoint1FromCurveReturnsPointEqualToCoordinatesUsedInConstruction() {
		Point a = new Point(0, 0);
		CubicBezierCurve curve = new CubicBezierCurve(a.getX(), a.getY(), 1, 1, 2, 2, 3, 3);
		assertThat(curve.getEndPoint1(), is(equalTo(a)));
	}
	
	@Test
	public void testThatGettingEndPoint2FromCurveReturnsPointEqualToCoordinatesUsedInConstruction() {
		Point b = new Point(1, 1);
		CubicBezierCurve curve = new CubicBezierCurve(0, 0, b.getX(), b.getY(), 2, 2, 3, 3);
		assertThat(curve.getEndPoint2(), is(equalTo(b)));
	}
	
	@Test
	public void testThatGettinControlPoint1FromCurveReturnsPointEqualToCoordinatesUUsedInConstruction() {
		Point c = new Point(2, 2);
		CubicBezierCurve curve = new CubicBezierCurve(0, 0 ,1, 1, c.getX(), c.getY(), 3, 3);
		assertThat(curve.getControlPoint1(), is(equalTo(c)));
	}
	
	@Test
	public void testThatGettingControlPoint2FromCurveReturnsPointEqualToCoordinatesUsedInConstruction() {
		Point d = new Point(2, 2);
		CubicBezierCurve curve = new CubicBezierCurve(0, 0, 1, 1, 2, 2, d.getX(), d.getY());
		assertThat(curve.getControlPoint2(), is(equalTo(d)));
	}
	
	@Test
	public void testThatCurveConstructedWithEqualEndAndControlPointsHasMidpointAlsoEqual() {
		Point p = new Point(5, 2);
		CubicBezierCurve curve = new CubicBezierCurve(p, p, p, p);
		assertThat(curve.findMidpointOnCurve(), is(equalTo(p)));
	}
	
	@Test
	public void testThatCurveConstructedHasMidpointX5Y4() {
		Point a = new Point(-40, 30);
		Point b = new Point(-16, -28);
		Point c = new Point(0, 0);
		Point d = new Point(32, 10);
		Point m = new Point(5, 4);
		CubicBezierCurve curve = new CubicBezierCurve(a, b, c, d);
		assertThat(curve.findMidpointOnCurve(), is(equalTo(m)));
	}
	
	@Test
	public void testThatTangentToMidPointHasMidpointOnIt() {
		Point a = new Point(-40, 30);
		Point b = new Point(-16, -28);
		Point c = new Point(0, 0);
		Point d = new Point(32, 10);
		CubicBezierCurve curve = new CubicBezierCurve(a, b, c, d);
		Point m = curve.findMidpointOnCurve();
		StraightLine sl = curve.getTangentToCurveAtMidpoint();
		double errorBound = 0.000001;
		assertTrue(sl.getXCoordinateWhenYIsKnown(m.getY()) - m.getX() < errorBound);
		assertTrue(sl.getYCoordinateWhenXIsKnown(m.getX()) - m.getY() < errorBound);
	}
	
	@Test
	public void testThatTangentToMidPointHasFormulaYEqualsMinus12Over14XMinus8Point285714286() {
		Point a = new Point(-40, 30);
		Point b = new Point(-16, -28);
		Point c = new Point(0, 0);
		Point d = new Point(32, 10);
		CubicBezierCurve curve = new CubicBezierCurve(a, b, c, d);
		StraightLine sl = curve.getTangentToCurveAtMidpoint();
		double errorBound = 0.000001;
		Point test1 = new Point(-2, 10);
		Point test2 = new Point(12, -2);
		assertTrue(sl.getXCoordinateWhenYIsKnown(test1.getY()) - test1.getX() < errorBound);
		assertTrue(sl.getYCoordinateWhenXIsKnown(test1.getX()) - test1.getY() < errorBound);
		assertTrue(sl.getXCoordinateWhenYIsKnown(test2.getY()) - test2.getX() < errorBound);
		assertTrue(sl.getYCoordinateWhenXIsKnown(test2.getX()) - test2.getY() < errorBound);
	}
}
