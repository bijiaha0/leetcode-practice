package Amazon.FirstPositionOfTarget;
/**
 * 找第一个小于等于target的index
 * https://www.jiuzhang.com/solution/first-position-of-target/
 */
public class Solution {
    public int binarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0, end = nums.length;
        while (start < end - 1) {
            int mid = start + (end - start) / 2;
            if (nums[mid] <= target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (nums[start] == target) {
            return start;
        }else {
            return -1;
        }
    }
}
