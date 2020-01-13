package LeetCode.RemoveElement;
/**
 * Time: 14:43
 * Email: clickgwas@gmail.com
 * https://leetcode.com/problems/remove-element/
 */
public class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0, j = 0;
        for(;i < nums.length;i++){
            if(nums[i]!=val){
                nums[j++]=nums[i];
            }
        }
        return j;
    }
    public int removeElement1(int[] nums, int val) {
        int slow= 1, fast= 0;
        for(;fast < nums.length;fast++){
            if(nums[fast]!=val){
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }
}
