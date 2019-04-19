package Amazon.Triangle;
/**
 * Email: clickgwas@gmail.com
 * https://www.lintcode.com/problem/triangle/solution
 * 分治法
 */
public class Solution1 {
    public final static int  n  = 5;
    public static int[][] A = {{},{},{}};

    public static int divideConquer(int x, int y){
        if(x == n){
            return 0;
        }
        return A[x][y] + Math.min(divideConquer(x+1,y),divideConquer(x+1,y+1));
    }

    public static void main(String[] args) {
        divideConquer(0, 0);
    }

}

