package blazon.client.svg.shapes;
import java.util.Collection;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.junit.internal.matchers.TypeSafeMatcher;

import blazon.client.svg.shapes.Point;
import blazon.client.svg.shapes.Triangle;


public class SameTriangleAs extends TypeSafeMatcher<Triangle> {

	private Triangle t1;
	
	private SameTriangleAs(Triangle t1) {
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
	  public static <T> Matcher<Triangle> sameTriangleAs(Triangle t1) {
	    return new SameTriangleAs(t1);
	  }

}
