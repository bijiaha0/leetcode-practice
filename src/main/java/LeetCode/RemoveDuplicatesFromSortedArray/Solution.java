package LeetCode.RemoveDuplicatesFromSortedArray;
/**
 * Time: 10:50
 * Email: clickgwas@gmail.com
 */
public class Solution {
    public int removeDuplicates(int[] nums){
        int i = 1, j = 0;
        for(;i < nums.length;i ++){
            if(nums[j]!=nums[i]){
                nums[++j]=nums[i];
            }
        }
        return j+1;
    }
}
