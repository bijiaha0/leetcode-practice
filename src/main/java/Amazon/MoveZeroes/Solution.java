package Amazon.MoveZeroes;
/**
 * https://www.lintcode.com/problem/move-zeroes/description
 * 同向双指针，left代表新数组，right代表老数组
 */
public class Solution {
    public void moveZeroes(int[] nums) {
        int left = 0, right = 0;
        while (right < nums.length) {
            if (nums[right] != 0) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
            }
            right++;
        }
    }
}
