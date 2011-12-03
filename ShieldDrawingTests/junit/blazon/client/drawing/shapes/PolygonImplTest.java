package blazon.client.drawing.shapes;

import java.util.Collection;
import java.util.Iterator;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class PolygonImplTest {

	@Test(expected=IllegalArgumentException.class)
	public void testThatCanNotConstructPolygonWithNullPoints() {
		new PolygonImpl((Point[])null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testThatCanNotConstructPolygonWith1NullPoint() {
		new PolygonImpl((Point)null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testThatCanNotConstructPolygonWithSecondPointNull() {
		new PolygonImpl(new Point(1,1), null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testThatCanNotConstructPolygonWith2EqualPoints() {
		new PolygonImpl(new Point(1,1), new Point(1,1));
	}
	
	@Test
	public void testThatCanGet3PointsFromPolygonInSameOrder() {
		Point point1 = new Point(1,1);
		Point point2 = new Point(2,2);
		Point point3 = new Point(3,3);
		PolygonImpl polygonImpl = new PolygonImpl(point1, point2, point3);
		Collection<Point> points = polygonImpl.getPoints();
		assertThat(points.size(), is(3));
		Iterator<Point> it = points.iterator();
		assertThat(it.next().equals(point1), is(true));
		assertThat(it.next().equals(point2), is(true));
		assertThat(it.next().equals(point3), is(true));
	}
	
	@Test
	public void testThatCanGet7PointsFromPolygonInSameOrder() {
		Point point1 = new Point(1,1);
		Point point2 = new Point(2,5);
		Point point3 = new Point(3,3);
		Point point4 = new Point(4,3);
		Point point5 = new Point(3,5);
		Point point6 = new Point(1,3);
		Point point7 = new Point(14,0);
		
		PolygonImpl polygonImpl = new PolygonImpl(point1, point2, point3, point4, point5, point6, point7);
		Collection<Point> points = polygonImpl.getPoints();
		assertThat(points.size(), is(7));
		Iterator<Point> it = points.iterator();
		assertThat(it.next().equals(point1), is(true));
		assertThat(it.next().equals(point2), is(true));
		assertThat(it.next().equals(point3), is(true));
		assertThat(it.next().equals(point4), is(true));
		assertThat(it.next().equals(point5), is(true));
		assertThat(it.next().equals(point6), is(true));
		assertThat(it.next().equals(point7), is(true));
	}
	
	@Test
	public void testThatToStringIsAsExpected() {
		Point point1 = new Point(1,1);
		Point point2 = new Point(2,2);
		Point point3 = new Point(3,3);
		PolygonImpl polygonImpl = new PolygonImpl(point1, point2, point3);
		assertThat(polygonImpl.toString(), is(equalTo("PolygonImpl{points=[Point{x=1.0:y=1.0}, Point{x=2.0:y=2.0}, Point{x=3.0:y=3.0}]")));
	}
	
}
