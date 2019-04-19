package Amazon.TwoSumLessThanOrEqualToTarget;
import java.util.Arrays;
/**
 * https://www.jiuzhang.com/solutions/two-sum-less-than-or-equal-to-target/
 * 两数和-小于或等于目标值
 * 给定一个整数数组，找出这个数组中有多少对的和是小于或等于目标值。返回对数。
 */
public class Solution {
    public int twoSum5(int[] nums, int target) {
        // Write your code here
        if (nums == null || nums.length < 2)
            return 0;

        Arrays.sort(nums);
        int cnt = 0;
        int left = 0, right = nums.length - 1;
        while (left < right) {
            if (nums[left] + nums[right] > target) {
                right --;
            } else {
                cnt += right - left;
                left ++;
            }
        }
        return cnt;
    }
}
