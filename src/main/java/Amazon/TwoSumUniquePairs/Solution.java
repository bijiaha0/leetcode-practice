package Amazon.TwoSumUniquePairs;
import java.util.Arrays;
/**
 * https://www.jiuzhang.com/solutions/two-sum-unique-pairs/
 * 给一整数数组, 找到数组中有多少组 不同的元素对 有相同的和,
 * 且和为给出的 target 值, 返回对数.
 */
public class Solution {
    /**
     * @param nums an array of integer
     * @param target an integer
     * @return an integer
     */
    public int twoSum6(int[] nums, int target) {

        if (nums == null || nums.length < 2)
            return 0;

        Arrays.sort(nums);
        int cnt = 0;
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int v = nums[left] + nums[right];
            if (v == target) {
                cnt ++;
                left ++;
                right --;
                while (left < right && nums[right] == nums[right + 1])//组合问题
                    right --;
                while (left < right && nums[left] == nums[left - 1])
                    left ++;
            } else if (v > target) {
                right --;
            } else {
                left ++;
            }
        }
        return cnt;
    }
}
