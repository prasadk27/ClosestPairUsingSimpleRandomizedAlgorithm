import java.util.ArrayList;
import java.util.List;

public class InputPoints {

	public static List<Point> inputpoints() {

		List<Point> points = null;
		points = new ArrayList<Point>();

		for (int i = 1; i <= 100; i++ ){
			Point point = new Point();
			point.setX((int)(Math.random()*100));
			point.setY((int)(Math.random()*100));
			points.add(point);
		}

		return points;
	}
}