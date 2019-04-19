package Amazon.HouseRobberII;

public class Solution1 {
    public int houseRobber2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(take(nums, 0, nums.length - 2), take(nums, 1, nums.length - 1));
    }

    public int take(int[] a, int start, int end) {
        if (a == null || a.length == 0) return 0;
        int n = a.length;
        int[] f = new int[n];
        if (start == end) {
            return a[start];
        }
        if (start+1 == end) {
            return Math.max(a[start], a[end]);
        }
        f[start] = a[start];
        f[start+1] = Math.max(a[start], a[start+1]);

        for (int i = start + 2; i <= end; i++) {
            f[i] = Math.max(f[i-2]+a[i], f[i-1]);
        }

        return f[end];
    }
}
