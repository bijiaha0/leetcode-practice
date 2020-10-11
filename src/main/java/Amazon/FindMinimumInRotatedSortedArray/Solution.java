package Amazon.FindMinimumInRotatedSortedArray;

/**
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 */
public class Solution {
    /**
     * @param nums: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        // 二分法
        while (left < right){
            // 最小值在left
            if (nums[left] < nums[right]){
                return nums[left];
            }
            int mid = left + (right - left) / 2;
            // 最小值在[left, mid]
            if (nums[left] > nums[mid]){
                right = mid;
            }
            // 最小值在(mid, right]
            else{
                left = mid + 1;
            }
        }
        return nums[left];
    }
}
