
import blazon.client.drawing.shapes.CubicBezierCurve;
import blazon.client.drawing.shapes.Point;


public class test {

	public static void main(String[] args) {
		CubicBezierCurve curve = new CubicBezierCurve(0, 0, 0, 400, 134, 200, 134, 200);
		Point findMidpointOnCurve = curve.findMidpointOnCurve();
		System.out.println("X=" + findMidpointOnCurve.getX() + ":Y=" + findMidpointOnCurve.getY());
	}
}
