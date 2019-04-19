package Amazon.KClosestPoints;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
/**
 * Email: clickgwas@gmail.com
 * amazon
 * https://www.lintcode.com/problem/k-closest-points/solution
 * 给定一些 points 和一个 origin，
 * 从 points 中找到 k 个离 origin 最近的点。
 * 按照距离由小到大返回。
 * 如果两个点有相同距离，则按照x值来排序；
 * 若x值也相同，就再按照y值排序。
 */
class Point {
    public int x, y;
    public Point() { x = 0; y = 0; }
    public Point(int a, int b) { x = a; y = b; }
}
class PointDecorater{
    int x,y;
    int distance;
    PointDecorater(int x,int y,int distance){
        this.x = x;
        this.y = y;
        this.distance = distance;
    }
}
public class Solution {
    public static List<Point> solve(Point[] Points,Point origin,int k){
        //定义最小堆
        PriorityQueue<PointDecorater> pq = new PriorityQueue<>(k,new Comparator<PointDecorater>() {
            @Override
            public int compare(PointDecorater o1, PointDecorater o2) {
                if(o1.distance!=o2.distance){
                    return o1.distance-o2.distance;
                }
                else if(o1.x!=o2.x){
                    return o1.x - o2.x;
                }else {
                    return o1.y-o2.y;
                }
            }
        });
        for(int i =0; i < Points.length; i++){
            int distance = distanceSquare(Points[i], origin);
            pq.offer(new PointDecorater(Points[i].x,Points[i].y,distance));
        }
        List<Point> res = new ArrayList<>();
        while(!pq.isEmpty()){
            res.add(new Point(pq.poll().x,pq.poll().y));
        }
        return res;
    }
    //计算两点间的距离
    private static int distanceSquare(Point a, Point b) {
        return (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y);
    }
}
