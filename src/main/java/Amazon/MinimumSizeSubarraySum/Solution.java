package Amazon.MinimumSizeSubarraySum;

/**
 * https://www.jiuzhang.com/solutions/minimum-size-subarray-sum/
 */
/*
Input: s = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: the subarray [4,3] has the minimal length under the problem constraint.
* */
public class Solution {
    public static Integer solve(int[] arr, int k) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int sum = 0;
                for (int kk = i; kk <= j; kk++) {
                    sum += arr[kk];
                    if (sum >= k) {
                        min = Math.min(min, j - i + 1);
                    }
                }
            }
        }
        if (min == Integer.MAX_VALUE) {
            min = -1;
        }
        return min;
    }

    public static Integer solve1(int[] arr, int k) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if (sum >= k) {
                    min = Math.min(min, j - i + 1);
                }
            }
        }
        if (min == Integer.MAX_VALUE) {
            min = -1;
        }
        return min;
    }

    /*
     * preSum的时间复杂度是0(n^2)。
     * */
    //2,3,1,4,4,3
    /*
     * 时间复杂度是O(n)
     * */
    public static Integer solve2(int[] arr, int k) {
        int j = 0, i = 0;
        int ans = Integer.MAX_VALUE;
        int sum = 0;
        for (i = 0; i < arr.length; i++) {
            while (j < arr.length && sum < k) {
                sum += arr[j];
                j++;
            }
            if (sum >= k) {
                ans = Math.min(ans, j - i);
            }
            sum -= arr[i];
        }
        if (ans == Integer.MAX_VALUE) {
            ans = -1;
        }
        return ans;
    }
    //滑动窗口算法模板 推荐！！！
    public static Integer solve3(int[] arr, int k) {
        int left = 0;
        int ans = Integer.MAX_VALUE;
        int sum = 0;
        for (int right = 0; right < arr.length; right++) {
            sum += arr[right];
            while (sum >= k) {
                ans = Math.min(ans, right - left + 1);
                sum -= arr[left++];
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {2, 3, 0, 0, 1, 3, 0, 1, 1};
        System.out.println(solve3(arr, 6));
        System.out.println(solve2(arr, 6));
    }
}
