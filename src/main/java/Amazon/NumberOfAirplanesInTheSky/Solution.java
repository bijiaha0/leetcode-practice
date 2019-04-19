package Amazon.NumberOfAirplanesInTheSky;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
//扫描线算法
//https://www.lintcode.com/problem/number-of-airplanes-in-the-sky/solution
class Interval {
       int start, end;
       Interval(int start, int end) {
            this.start = start;
            this.end = end;
       }
}
class Point{
    int time;
    int flag;
    Point(int t, int s) {
        this.time = t;
        this.flag = s;
    }
    public static Comparator<Point> PointComparator = new Comparator<Point>() {
        public int compare(Point p1, Point p2) {
            if(p1.time == p2.time)
                return p1.flag - p2.flag;//谁小谁在前面
            else
                return p1.time - p2.time;
        }
    };
}
class Solution {
    public int countOfAirplanes(List<Interval> airplanes) {
        List<Point> list = new ArrayList<>(airplanes.size() * 2);
        for (Interval i : airplanes) {
            list.add(new Point(i.start, 1));//1表示起飞
            list.add(new Point(i.end, 0));//2表示降落
        }
        Collections.sort(list, Point.PointComparator);
        int count = 0, ans = 1;
        for (Point p : list) {
            if(p.flag == 1)
                count++;
            else
                count--;
            ans = Math.max(ans, count);
        }
        return ans;
    }
}
