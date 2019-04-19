package Amazon.SqrtXII;
//Solution2 : 牛顿法
public class Solution2 {
    /**
     * @param x a double
     * @return the square root of x
     */
    public double sqrt(double x) {
        // Write your code here
        double res = 1.0;
        double eps = 1e-12;

        while(Math.abs(res * res - x) > eps) {
            res = (res + x / res) / 2;
        }

        return res;
    }
}
