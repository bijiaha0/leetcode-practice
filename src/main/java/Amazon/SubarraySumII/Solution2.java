package Amazon.SubarraySumII;
public class Solution2 {
    public int subarraySumII(int[] A, int start, int end){
        int n = A.length;
        if (n == 0) {
            return 0;
        }

        int[] sum = new int[n + 1];
        int i, l, r, res = 0;
        sum[0] = 0;
        for (i = 1; i <= n; ++i) {
            sum[i] = sum[i - 1] + A[i - 1];
        }

        l = r = 0;
        for (i = 1; i <= n; ++i) {
            while (l < i && sum[i] - sum[l] > end) {
                ++l;
            }

            while (r < i && sum[i] - sum[r] >= start) {
                ++r;
            }

            res += r - l;
        }

        return res;
    }
}
