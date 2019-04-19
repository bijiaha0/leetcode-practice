package Amazon.BinarySearch;
/**
 * 二分法模板
 * https://www.jiuzhang.com/solutions/binary-search/
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
