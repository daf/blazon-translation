package blazon.client.drawing.shapes;

import java.util.Collection;
import java.util.Iterator;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class FourPointedPolygonTest {
	@Test(expected=IllegalArgumentException.class)
	public void testThatCanNotConstructFourPointedPolygonWith4NullPoints() {
		new FourPointedPolygon(null, null, null, null);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testThatCanNotConstructFourPointedPolygonWithFirstPointNull() {
		Point a = new Point(0, 0);
		Point b = new Point(1, 1);
		Point c = new Point(2, 2);
		new FourPointedPolygon(null, a, b, c);

	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testThatCanNotConstructFourPointedPolygonWithSecondPointNull() {
		Point a = new Point(0, 0);
		Point b = new Point(1, 1);
		Point c = new Point(2, 2);
		new FourPointedPolygon(a, null, b, c);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testThatCanNotConstructFourPointedPolygonWithThirdPointNull() {
		Point a = new Point(0, 0);
		Point b = new Point(1, 1);
		Point c = new Point(2, 2);
		new FourPointedPolygon(a, b, null, c);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testThatCanNotConstructFourPointedPolygonWithFourthPointNull() {
		Point a = new Point(0, 0);
		Point b = new Point(1, 1);
		Point c = new Point(2, 2);
		new FourPointedPolygon(a, b, c, null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testThatCanNotConstructFourPointedPolygonWithAllPointsEqual() {
		Point a = new Point(0, 0);
		new FourPointedPolygon(a, a, a, a);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testThatCanNotConstructFourPointedPolygonWithFirstAndSecondPointsEqual() {
		Point a = new Point(0, 0);
		Point c = new Point(2, 2);
		Point d = new Point(3, 3);
		new FourPointedPolygon(a, a, c, d);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testThatCanNotConstructFourPointedPolygonWithFirstAndThirdPointsEqual() {
		Point a = new Point(0, 0);
		Point b = new Point(1, 1);
		Point d = new Point(3, 3);
		new FourPointedPolygon(a, b, a, d);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testThatCanNotConstructFourPointedPolygonWithFirstAndFourthPointsEqual() {
		Point a = new Point(0, 0);
		Point b = new Point(1, 1);
		Point c = new Point(2, 2);
		new FourPointedPolygon(a, b, c, a);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testThatCanNotConstructFourPointedPolygonWithSecondAndThirdPointsEqual() {
		Point a = new Point(0, 0);
		Point b = new Point(1, 1);
		Point d = new Point(3, 3);
		new FourPointedPolygon(a, b, b, d);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testThatCanNotConstructFourPointedPolygonWithSecondAndFourthPointsEqual() {
		Point a = new Point(0, 0);
		Point b = new Point(1, 1);
		Point c = new Point(2, 2);
		new FourPointedPolygon(a, b, c, b);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testThatCanNotConstructFourPointedPolygonWithThirdAndFourthPointsEqual() {
		Point a = new Point(0, 0);
		Point b = new Point(1, 1);
		Point c = new Point(2, 2);
		new FourPointedPolygon(a, b, c, c);
	}
	
	@Test
	public void testThatCanGetPointsBackFromFourPointedPolygonInSameOrderAsConstructed() {
		Point a = new Point(0, 0);
		Point b = new Point(1, 1);
		Point c = new Point(2, 2);
		Point d = new Point(3, 3);
		Polygon polygon = new FourPointedPolygon(a, b, c, d);
		Collection<Point> points = polygon.getPoints();
		assertThat(points.size(), is(equalTo(4)));
		Iterator<Point> it = points.iterator();
		assertThat(it.next(), is(equalTo(a)));
		assertThat(it.next(), is(equalTo(b)));
		assertThat(it.next(), is(equalTo(c)));
		assertThat(it.next(), is(equalTo(d)));
	}
	
	@Test
	public void testThatToStringOfFourPointedPolygonIsAsExpected() {
		Point a = new Point(0, 0);
		Point b = new Point(1, 1);
		Point c = new Point(2, 2);
		Point d = new Point(3, 3);
		Polygon polygon = new FourPointedPolygon(a, b, c, d);
		String expected = "FourPointedPolygon{pointA=Point{x=0.0:y=0.0}:pointB=Point{x=1.0:y=1.0}:pointC=Point{x=2.0:y=2.0}:pointD=Point{x=3.0:y=3.0}}";
		assertThat(polygon.toString(), is(equalTo(expected)));
	}
}
