package LeetCode.SingleNumber;

/**
 * @author bijh@tsingyun.net
 * @date 2020/4/4 6:57 PM
 * https://leetcode.com/problems/single-number/discuss/42997/My-O(n)-solution-using-XOR
 *
 * id = 136
 */
public class Solution {

    /**
     * 时间复杂度 O(n)
     */
    public int singleNumber(int[] nums) {
        int res =0,n = nums.length;
        for(int i = 0; i < n; i++){
            res^=nums[i];
        }
        return res;
    }
}
