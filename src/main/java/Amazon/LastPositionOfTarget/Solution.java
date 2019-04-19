package Amazon.LastPositionOfTarget;
/**
 * 找第一个大于等于target的index
 * https://www.jiuzhang.com/solution/last-position-of-target/
 */
public class Solution {
    public int lastPosition(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0, end = nums.length - 1;
        while (start < end - 1) {
            int mid = start + (end - start + 1) / 2;
            if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (nums[end] >= target) {
            return end;
        }else {
            return -1;
        }
    }
}
