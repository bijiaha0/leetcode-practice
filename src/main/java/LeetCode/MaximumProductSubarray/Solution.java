package LeetCode.MaximumProductSubarray;
public class Solution {
    public int maxProduct(int[] nums) {
        int i,n = nums.length;
        int max = Integer.MIN_VALUE;
        int cur = 1;
        for(i = 0; i < n;i++){
            cur*=nums[i];
            if( max<cur) max = cur;
            if( cur==0) cur =1;
        }
        cur = 1;
        for(i = n-1; i>=0;i--){
            cur*=nums[i];
            if( max<cur) max = cur;
            if( cur==0) cur =1;
        }
        return max;
    }
}
