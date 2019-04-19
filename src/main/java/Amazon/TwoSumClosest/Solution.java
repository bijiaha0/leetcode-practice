package Amazon.TwoSumClosest;
import java.util.Arrays;
/**
 * https://www.jiuzhang.com/solutions/two-sum-closest/
 * 给定整数数组num，从中找到两个数字使得他们和最接近target，返回两数和与 target 的差的 绝对值。
 */
public class Solution {
    public int twoSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return -1;
        }

        Arrays.sort(nums);

        int left = 0, right = nums.length - 1;
        int diff = Integer.MAX_VALUE;

        while (left < right) {
            if (nums[left] + nums[right] < target) {
                diff = Math.min(diff, target - nums[left] - nums[right]);
                left++;
            }
            if (nums[left] + nums[right] >= target) {
                diff = Math.min(diff, nums[left] + nums[right] - target);
                right--;
            }
        }

        return diff;
    }
}
