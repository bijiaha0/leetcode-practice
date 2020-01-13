package LeetCode.QuickSort;

public class Solution2 {
    public void sort(int[] nums,int left, int right){
        if(left>=right){
            return;
        }
        int par = partation(nums,0,nums.length-1);
        sort(nums,left,par-1);
        sort(nums,par+1,right);
    }
    public int partation(int[] nums,int start,int end){
        int left = start;
        int right = end;
        int piort = nums[right];
        int slow = left;
        for(int i=0; i < end;i++){
            if(nums[i]<piort){
                swap(nums,i,slow);
                slow++;
            }
        }
        swap(nums,slow,right);
        return slow;
    }
    public void swap(int[] nums,int i,int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j]  =tmp;
    }
}
