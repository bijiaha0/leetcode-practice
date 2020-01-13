package Amazon.MaximumAverageSubarray;
public class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        int[] sum = new int[n+1];
        int i,ans=Integer.MIN_VALUE;
        for(i=1; i<=n;i++){
            sum[i] = sum[i-1]+nums[i-1];
        }
        for(i = k;i <=n;i++){
            ans = Math.max(ans,sum[i]-sum[i-k]);
        }
        return ans*1.0/k;
    }
}
