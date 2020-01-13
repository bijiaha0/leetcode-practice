package Amazon.PowXN;
import java.util.ArrayList;
import java.util.List;
public class Solution {
    double powx(double x, int n) {
        if (n < 0) {
            if (x == 0) return 0;
            x = 1 / x;
            n = -n;
        }
        if (n == 0) return 1;
        double r = powx(x, n / 2);
        return (n & 1) == 1 ? x * r * r : r * r;
    }
    public double powx1(double x, int n) {
        //当n是负数的情况
        if (n < 0) {
            if (x == 0) return 0;
            x = 1 / x;
            n = -n;
        }
        double ans = 1, tmp = x;
        while (n != 0) {
            if ((n&1)==1) {
                ans *= tmp;
            }
            n >>>= 1;
            tmp *= tmp;
        }
        return ans;
    }
}