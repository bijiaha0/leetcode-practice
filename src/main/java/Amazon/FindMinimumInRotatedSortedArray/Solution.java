package Amazon.FindMinimumInRotatedSortedArray;

/**
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 */
public class Solution {

    public static int findMinFromStart(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length;
        int target = nums[0];
        while (start < end - 1) {
            int mid = start + (end - start) / 2;
            if (target >= nums[mid]) {
                end = mid;
            } else {
                start = mid;
            }
        }
        return Math.min(nums[start], nums[end]);
    }

}
