package Amazon.FirstPositionOfTarget;

/**
 * 找最后一个小于等于target的index
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
        } else {
            return -1;
        }
    }


    public int binarySearch2(int[] nums, int target) {
        int start = 0;
        int end = nums.length;
        while (start < end - 1) {
            int mid = start + (end - start) >> 2;
            if (nums[mid] <= target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (nums[start] <= target) {
            return start;
        }
        return -1;
    }

    public int binarySearch3(int[] nums, int target) {
        int start = -1;
        int end = nums.length - 1;
        while (start < end - 1) {
            int mid = start + (end - start + 1) >> 2;
            if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (nums[end] >= target) {
            return end;
        }
        return -1;
    }
}
