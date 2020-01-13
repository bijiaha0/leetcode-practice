package Amazon.SearchInsertPosition;

public class Solution {
    public int searchInsert(int[] A, int target) {
        if(A.length == 0)return 0;
        int left = 0, right = A.length - 1;
        int mid;
        while(left <= right){
            if(target<A[left])return left;
            if(target>A[right])return right+1;
            mid = (left+right)/2;
            if(A[mid]==target)return mid;
            else if(target < A[mid]){
                right = mid-1;
            }else{
                left = mid +1;
            }
        }
        return -1;
    }
    public int searchInsert0(int[] nums, int target) {
        int n = nums.length, left = 0, right = n;
        while(left < right){
            int  mid = left+(right-left)/2;
            if(nums[mid]<target){
                left = mid+1;
            }else{
                right = mid;
            }
        }
        return right;
    }
}
