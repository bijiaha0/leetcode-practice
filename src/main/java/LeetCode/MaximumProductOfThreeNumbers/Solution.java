package LeetCode.MaximumProductOfThreeNumbers;

import java.util.Arrays;

/**
 * Author: bijiaha0
 * Date: 2019-04-02
 * Time: 22:32
 * Email: clickgwas@gmail.com
 * https://leetcode.com/problems/maximum-product-of-three-numbers/solution/
 */
public class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        return Math.max(nums[0] * nums[1] * nums[nums.length - 1],
                nums[nums.length - 3] * nums[nums.length - 2] * nums[nums.length - 1]);
    }
}
