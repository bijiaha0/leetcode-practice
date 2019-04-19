package Amazon.TwoSumGreaterThanTarget;
import java.util.Arrays;
/**
 * https://www.jiuzhang.com/solutions/two-sum-greater-than-target/
 * 给一组整数，问能找出多少对整数，他们的和大于一个给定的目标值。
 *
 * 总共有n*(n-1)/2这么多的可能性
 */
public class Solution {
    public int twoSum2(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return 0;
        }

        Arrays.sort(nums);

        int left = 0, right = nums.length - 1;
        int count = 0;
        while (left < right) {
            if (nums[left] + nums[right] <= target) {
                left++;
            } else {
                count += right - left;
                right--;
            }
        }

        return count;
    }
}
