package LeetCode.TwoSumII;

/**
 * @author bijh@tsingyun.net
 * @date 2020/4/4 3:35 PM
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 * id = 167
 */
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            if (numbers[i] + numbers[j] < target) {
                i++;
            } else if (numbers[i] + numbers[j] > target) {
                j--;
            } else {
                return new int[]{i + 1, j + 1};
            }
        }
        return new int[]{-1, -1};
    }
}
