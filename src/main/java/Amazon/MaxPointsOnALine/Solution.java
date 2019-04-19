package Amazon.MaxPointsOnALine;
import java.util.HashMap;
import java.util.Map;
/**
 * Email: clickgwas@gmail.com
 * https://www.lintcode.com/problem/max-points-on-a-line/description
 * Map集合中put和putIfAbsent的区别
 * 使用put方法添加键值对时，如果map集合中没有该key对应的值，则直接添加，并返回null，如果已经存在对应的值，则会覆盖旧值，value为新的值。
 * 使用putIfAbsent方法添加键值对时，如果map集合中没有该key对应的值，则直接添加，并返回null，如果已经存在对应的值，则依旧为原来的值。
 * Map.getOrDefault()-----> 当map集合中有这个key时，就返回这个key的value值，如果没有这个key,就添加，返回defaultValue。
 */
class Point{
    int x;
    int y;
    Point(int x,int y){
        this.x =x;
        this.y = y;
    }
}
public class Solution {
    public int maxPoints(Point[] points) {
        if (points == null) {
            return 0;
        }
        int ans = 0;
        for (int i = 0; i < points.length; i++) {
            Map<String, Integer> slope = new HashMap<>();
            int maxPoints = 0, overlap = 0, vertical = 0;
            for (int j = i + 1; j < points.length; j++) {
                if (points[i].x == points[j].x) {
                    if (points[i].y == points[j].y) {
                        overlap++;//跟它重叠的点，有多少个，不算它
                    } else {
                        vertical++;//跟它垂直的点，有多少个，不算它
                    }
                    continue;
                }
                int dx = points[i].x - points[j].x;//这个dx肯定不为0
                int dy = points[i].y - points[j].y;//这里dy肯定为0
                int tmp = gcd(dx, dy);//求最大公约数
                dx /= tmp;
                dy /= tmp;
                String k = dy + "/" + dx;
                /*if (!slope.containsKey(k)) {
                    slope.put(k, 0);
                }*/
                slope.putIfAbsent(k,0);
                slope.put(k, slope.get(k) + 1);
                maxPoints = Math.max(maxPoints, slope.get(k));//取出map中value最大的值
            }
            maxPoints = Math.max(maxPoints, vertical);//和垂直的点，相比较。
            ans = Math.max(ans, maxPoints + overlap + 1);//最大的点+覆盖的点+自己
        }
        return ans;
    }
    /*
    * 计算两个非负数p和q的最大公约数，若q是0，则最大的公约数是p，
    * 否则p除以q，得到的余数r,
    * p和q的最大公约数为q和r的最大公约数。
    * */
    int gcd(int p, int q) {
        if (q == 0) {
            return p;
        }
        int r = p % q;
        return gcd(q, r);
    }
}
