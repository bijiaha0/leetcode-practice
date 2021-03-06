package Amazon.Sqrt;
/*
* https://www.lintcode.com/problem/sqrtx/description
* 二分
* */
public class Solution {
    public int sqrt(int x) {
        // find the last number which square of it <= x
        long start = 1, end = x;
        while (start + 1 < end) {
            long mid = (start + end) >>> 1;
            if (mid * mid <= x) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (end * end <= x) {
            return (int) end;
        }
        return (int) start;
    }
}
