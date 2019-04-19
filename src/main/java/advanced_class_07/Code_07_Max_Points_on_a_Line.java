package advanced_class_07;
import java.util.HashMap;
import java.util.Map;
//求在一根线上，最多的点
public class Code_07_Max_Points_on_a_Line {
	public static class Point {
		public int x;
		public int y;
		Point() {
			x = 0;
			y = 0;
		}
		Point(int a, int b) {
			x = a;
			y = b;
		}
	}
	public static int maxPoints(Point[] points) {
		if (points == null) {
			return 0;
		}
		if (points.length <= 2) {
			return points.length;
		}
		Map<String, Integer> map = new HashMap<>();
		int result = 0;
		for (int i = 0; i < points.length; i++) {
			map.clear();
			int samePosition = 1;//共位置的点
			int sameX = 0;//相同X的点
			int sameY = 0;//相同Y的点
			int line = 0;//全局最大值
			for (int j = i + 1; j < points.length; j++) {
				int x = points[j].x - points[i].x;
				int y = points[j].y - points[i].y;
				if (x == 0 && y == 0) {
					samePosition++;
				} else if (x == 0) {
					sameX++;
				} else if (y == 0) {
					sameY++;
				} else { // 都不共
					int gcd = gcd(x, y);//求最大公约数
					x /= gcd;
					y /= gcd;
					String  key = x + "_" + y;
					if(!map.containsKey(key)) {
						map.put(key, 0);
					}
					map.put(key, map.get(key)+1);
					line = Math.max(line, map.get(key));
				}
			}
			result = Math.max(result, Math.max(Math.max(sameX, sameY), line)
					+ samePosition);
		}
		return result;
	}
	//求最大公约数
	public static int gcd(int a, int b) {
		return b == 0 ? a : gcd(b, a % b);
	}
}