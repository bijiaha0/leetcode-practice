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
        int end = nums.length-1;
        int target = nums[0];
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (target >= nums[mid]) {
                end = mid;
            } else {
                start = mid;
            }
        }
        return nums[end];
    }

}
