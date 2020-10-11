package LeetCode.BinarySearch;

public class Solution {

    int search(int[] nums, int target) {

        int n = nums.length;

        if (nums == null || n == 0) {
            return -1;
        }

        return dfs(nums, 0, n - 1, target);

    }

    int dfs(int[] nums, int left, int right, int target) {

        if (left > right) {
            return -1;
        }

        int mid = left + (right - left) / 2;

        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] > target) {
            return dfs(nums, left, mid - 1, target);
        } else {
            return dfs(nums, mid + 1, right, target);
        }

    }

    int binarySearch(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return -1;
        }

        int n = nums.length;
        int left = 0, right = n - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

    //查找第一个大于等于给定值的元素
    int binarySearchFirst(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                if (mid == 0 || nums[mid - 1] < target) {
                    return mid;
                } else {
                    right = mid - 1;
                }
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    //查找最后一个小于等于给定值的元素
    int binarySearchLast(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                if (mid == n - 1 || nums[mid + 1] > target) {
                    return mid;
                } else {
                    left = mid + 1;
                }
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
