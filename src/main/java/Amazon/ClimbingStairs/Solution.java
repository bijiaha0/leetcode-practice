package Amazon.ClimbingStairs;
/**
 * Email: clickgwas@gmail.com
 * https://www.jiuzhang.com/solutions/climbing-stairs/
 */
// 记忆化搜索
// 九章硅谷求职算法集训营版本
public class Solution {
    /**
     * @param n: An integer
     * @return: An integer
     */
    int[] result = null;

    void f(int X) {
        if (result[X] != -1) return;
        if (X == 0 || X == 1) {
            result[X] = 1;
            return;
        }

        f(X - 1);
        f(X - 2);
        result[X] = result[X - 1] + result[X - 2];
    }

    public int climbStairs(int n) {
        if (n == 0) {
            return 0;
        }

        result  = new int[n + 1];
        for (int i = 0; i <= n; ++i) {
            result[i] = -1;
        }

        f(n);
        return result[n];
    }
}
