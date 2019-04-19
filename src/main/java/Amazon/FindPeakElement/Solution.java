package Amazon.FindPeakElement;
/*
* https://www.lintcode.com/problem/find-peak-element/description
* */
public class Solution {
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int start = 0;
        int end = n - 1;
        while (start + 1 < end) {
            int mid = (start + end) >> 1;
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) { // match
                return mid;
            } else if (nums[mid] > nums[mid - 1]) { // ascending slope
                start = mid;
            } else { // descending slope
                end = mid;
            }
        }
        return nums[start] > nums[end] ? start : end;
    }
}
