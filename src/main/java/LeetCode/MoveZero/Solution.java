package LeetCode.MoveZero;

public class Solution {
    public void moveZeros(int[] nums){
        if(nums==null||nums.length==0){
            return;
        }
        int slow=0;
        for(int fast=0;fast<nums.length;fast++){
            if(nums[fast]!=0){
                swap(nums,slow,fast);
                slow++;
            }
        }
    }
    public void swap(int[] nums,int slow,int fast){
        int tmp = nums[fast];
        nums[fast] = nums[slow];
        nums[slow] = tmp;
    }
}
