package Amazon.WindowSum;
/**
 * Author: bijiaha0
 * Date: 2019-03-04
 * Time: 00:10
 * Email: clickgwas@gmail.com
 */
public class Solution1 {
    public int[] winSum(int[] nums, int k) {
        // write your code here
        if (nums == null || nums.length < k || k <= 0)
            return new int[0];

        int[] sums = new int[nums.length - k + 1];
        // 计算nums的前k个数之和，赋值给sum[0]
        for (int i = 0; i < k; i++)
            sums[0] += nums[i];
        for (int i = 1; i < sums.length; i++) {
            // 减去头部元素，加上尾部元素
            sums[i] = sums[i - 1] - nums[i - 1] + nums[i + k-1];
        }
        return sums;
    }
}
