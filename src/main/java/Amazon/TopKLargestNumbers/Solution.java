package Amazon.TopKLargestNumbers;
public class Solution {
    int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        int left = 0, right = n-1;
        while(left < right){
            int index = partation(nums,left,right);
            if(index < n-k){
                left = index+1;
            }else if(index > n-k){
                right = index-1;
            }else{
                break;
            }
        }
        return nums[n-k];
    }
    int partation(int[] nums, int start,int end){
        int piort = nums[start];
        while(start<end){
            while(start<end&&nums[end]>=piort) end--;
            nums[start] = nums[end];
            while(start < end && nums[start]<=piort) start++;
            nums[end] = nums[start];
        }
        nums[start] = piort;
        return start;
    }
}
