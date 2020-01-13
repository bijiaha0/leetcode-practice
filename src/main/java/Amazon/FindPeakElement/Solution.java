package Amazon.FindPeakElement;

public class Solution {
    public int findPeakElement(int[] num) {
        int n = num.length;
        if (n == 1) {
            return 0;
        }
        int start = 0;
        int end = n - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if ((mid == 0 || num[mid] >= num[mid - 1]) && (mid == n - 1 || num[mid] >= num[mid + 1])) {
                return mid;
            } else if (mid > 0 && num[mid - 1] > num[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
    //dfs
    public int findPeakElement0(int[] nums) {
        int n = nums.length;
        return dfs(nums, 0, n - 1);
    }
    int dfs(int[] nums, int left, int right) {
        if (left == right) return left;
        int mid = left + (right - left) / 2;
        if (nums[mid] > nums[mid + 1]) {
            return dfs(nums, left, mid);
        } else {
            return dfs(nums, mid + 1, right);
        }
    }
}
