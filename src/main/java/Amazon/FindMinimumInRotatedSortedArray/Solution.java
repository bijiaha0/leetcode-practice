package Amazon.FindMinimumInRotatedSortedArray;
/**
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 */
public class Solution {
    public static int findMinFromEnd(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0, end = nums.length;
        int target = nums[nums.length - 1];
        while (start < end - 1) {
            int mid = start + (end - start) / 2;
            if (nums[mid] <= target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        return Math.min(nums[start], nums[end]);
    }

    public static void main(String[] args) {
        int min = findMinFromStart(new int[]{5, 6, 7, 1});
        System.out.println(min);
    }

    public static int findMinFromStart(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length;
        int target = nums[0];
        while (start < end - 1) {
            int mid = start + (end - start) /2;
            if (target >= nums[mid]) {
                end = mid;
            } else {
                start = mid;
            }
        }
        return Math.min(nums[start], nums[end]);
    }


}
