package Amazon.WindowSum;
/**
 * Email: clickgwas@gmail.com
 * amazon
 * https://www.lintcode.com/problem/window-sum/solution
 * 顺势而为
 */
/*
Input：array = [1,2,7,8,5], k = 3 Output：[10,17,20]
Explanation：
1 + 2 + 7 = 10
2 + 7 + 8 = 17
7 + 8 + 5 = 20
* */
public class Solution {
    public int[] winSum(int[] nums, int k) {
        if (nums == null || nums.length < k || k <= 0)
            return new int[0];
        int[] sums = new int[nums.length - k + 1];
        for (int i = 0; i < k; i++)
            sums[0] += nums[i];
        for (int i = 1; i < sums.length; i++) {
            sums[i] = sums[i - 1] - nums[i - 1] + nums[i + k-1];
        }
        return sums;
    }

    //sum[i] = sum[i-1]+arr[i]
    //sum.length = arr.length-k+1
    //
    public static int[] windowSum(int[] arr, int k){
        int[] sum = new int[arr.length-k+1];
        //0---k-1
        for(int i = 0; i < k; i++){
            sum[0] += arr[i];
        }
        //k-----arr.length-1
        for(int j = 1; j < sum.length ; j++){
            sum[j] = sum[j-1]-arr[j-1]+arr[j+k-1];
        }
        return sum;
    }
}