package Amazon.RectangleOverlap;
/**
 * Email: clickgwas@gmail.com
 * 矩阵重叠
 * amazon
 */
class Point {
      public int x, y;
      public Point() { x = 0; y = 0; }
      public Point(int x, int y) { this.x = x; this.y = y; }
}
//反向思维，排除掉所有不可能的。
public class Solution {
    public boolean doOverlap(Point l1, Point r1, Point l2, Point r2) {
        //要么上下左右
        //要么左右
        if (l1.x > r2.x || l2.x > r1.x)
            return false;
        //要么上下
        if (l1.y < r2.y || l2.y < r1.y)
            return false;
        return true;
    }

    public boolean overlap(Point l1,Point r1,Point l2,Point r2){
        //排除掉左右上下
        //左右
        if(r1.x < l2.x || r2.x < l1.x)
            return false;
        //上下
        if(r1.y > l2.y || r2.y > l1.y)
            return false;
        return true;
    }
}
