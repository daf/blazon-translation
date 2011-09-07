package blazon.client.drawing.shapes;
import java.util.Collection;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.junit.internal.matchers.TypeSafeMatcher;

import blazon.client.drawing.shapes.Point;
import blazon.client.drawing.shapes.Polygon;
import blazon.client.drawing.shapes.Triangle;


public class SameTriangleAs extends TypeSafeMatcher<Triangle> {

	private Polygon t1;
	
	private SameTriangleAs(Polygon t1) {
		this.t1 = t1;
	}
	
	@Override
	public void describeTo(Description description) {
		description.appendText("same triangle as");
		
	}

	@Override
	public boolean matchesSafely(Triangle t2) {
		Collection<Point> points1 = t1.getPoints();
		Collection<Point> points2 = t2.getPoints();
		return points1.equals(points2);
	}
	
	  @Factory
	  public static <T> Matcher<Triangle> sameTriangleAs(Polygon t1) {
	    return new SameTriangleAs(t1);
	  }

}
