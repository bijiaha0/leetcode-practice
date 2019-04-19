package Amazon.WiggleSortII;

public class Solution {

    public static void wiggleSort(int[] nums) {
        final int n = nums.length;
        int[] tem = new int[n];
        for (int i = 0; i < n; i++) {
            tem[i] = nums[i];
        }
        int mid = partition(tem, 0, n-1, n/2);
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = mid;
        }

        int l = 1, r = (n % 2 == 0) ? n-2 : n-1;
        for (int i = 0; i < n; i++) {
            if (nums[i] < mid) {//负责偶数
                ans[r] = nums[i];
                r -= 2;
            } else if (nums[i] > mid) {//负责奇数
                ans[l] = nums[i];
                l += 2;
            }
        }
        for (int i = 0; i < n; i++) {
            nums[i] = ans[i];
        }
    }

    public static int partition(int[] nums, int l, int r, int rank) {
        int left = l, right = r;
        int now = nums[left];
        while (left < right) {
            while (left < right && nums[right] >= now) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] <= now) {
                left++;
            }
            nums[right] = nums[left];
        }
        if (left - l == rank) {
            return now;
        } else if (left - l < rank) {
            return partition(nums, left + 1, r, rank - (left - l + 1));
        } else {
            return partition(nums, l, right - 1, rank);
        }
    }
}
