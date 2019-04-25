package LeetCode.RemoveDuplicatesFromSortedArrayII;
/**
 * Time: 11:22
 * Email: clickgwas@gmail.com
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int j = 0, i =1, count = 0;
        for(;i < nums.length;i++){
            if(nums[j]!=nums[i]){
                nums[++j] = nums[i];
                count = 0;
            }
            else{
                count++;
                if(count < 2){
                    nums[++j] = nums[i];
                }
            }
        }
        return j+1;
    }
}
