package Amazon.WoodCut;

/**
 * https://www.lintcode.com/problem/wood-cut/description
 * 二分法
 */
public class Solution {

    public static int woodCut(int[] L, int k) {

        int l = 1, res = 0;
        int r = 0;
        for (int item : L) {
            r = Math.max(r, item);
        }

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (count(L, mid) >= k) {
                res = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return res;
    }

    private static int count(int[] L, int len) {
        int sum = 0;
        for (int item : L) {
            sum += item / len;
        }
        return sum;
    }

}
