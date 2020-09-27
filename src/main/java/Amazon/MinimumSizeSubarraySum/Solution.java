package Amazon.MinimumSizeSubarraySum;

/**
 * Minimum Size Subarray Sum
 * Given an array of n positive integers and a positive integer s,
 * find the minimal length of a subarray of which the sum ≥ s.
 * If there isn't one, return 0 instead.
 * <p>
 * For example, given the array [2,3,1,2,4,3] and s = 7,
 * the subarray [4,3] has the minimal length of 2 under the problem constraint.
 * <p>
 * https://www.jiuzhang.com/solutions/minimum-size-subarray-sum/
 */
public class Solution {
    // 时间复杂度是O(n)
    public static Integer solve(int[] arr, int k) {
        int i, j = 0, sum = 0, n = arr.length, ans = Integer.MAX_VALUE;
        for (i = 0; i < n; i++) {
            while (j < n && sum < k) {
                sum += arr[j];
                j++;
            }
            if (sum >= k) {
                ans = Math.min(ans, j - i);
            }
            sum -= arr[i];
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    /**
     * 滑动窗口算法模板 推荐！！！
     */
    public static Integer solve2(int[] arr, int k) {
        int left = 0, ans = Integer.MAX_VALUE, sum = 0;
        for (int right = 0; right < arr.length; right++) {
            sum += arr[right];
            while (sum >= k) {
                ans = Math.min(ans, right - left + 1);
                sum -= arr[left++];
            }
        }
        return ans;
    }
}
