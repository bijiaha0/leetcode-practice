package Amazon.TwoSumInputArrayIsSorted;
/**
 * https://www.jiuzhang.com/solutions/two-sum-input-array-is-sorted/
 *
 * 给定一个已经 按升序排列 的数组，找到两个数使他们加起来的和等于特定数。
 * 函数应该返回这两个数的下标，index1必须小于index2。注意返回的值不是 0-based。
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return null;
        }

        int start = 0, end = nums.length - 1;
        while (start < end) {
            if (nums[start] + nums[end] == target) {
                int[] pair = new int[2];
                pair[0] = start + 1;
                pair[1] = end + 1;
                return pair;
            }
            if (nums[start] + nums[end] < target) {
                start++;
            } else {
                end--;
            }
        }

        return null;
    }
}
