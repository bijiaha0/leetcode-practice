package LeetCode.SubarrayProductLessThanK;
/**
 * https://leetcode.com/problems/subarray-product-less-than-k/solution/
 * 窗口移动
 */
public class Solution {
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
        int prod = 1, ans = 0, left = 0;
        for (int right = 0; right < nums.length; right++) {
            prod *= nums[right];
            while (prod >= k) prod /= nums[left++];
            ans += right - left + 1;
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] nums = {10, 5, 2, 6};
        int k = 10000000;
        System.out.println(numSubarrayProductLessThanK(nums, k));
    }
}
