package Amazon.HouseRobberII;
import java.util.Arrays;
public class Solution3 {
    int houseRobber2(int[] nums) {
        int n = nums.length;
        if(n==0){
            return 0;
        }
        if(n==1){
            return nums[0];
        }
        int[] nums1 = Arrays.copyOfRange(nums,0,n-1);
        int[] nums2 = Arrays.copyOfRange(nums,1,n);
        return Math.max(houseRobber(nums1),houseRobber(nums2));
    }
    int houseRobber(int[] A) {
        // f[i] = max{f[i-1],f[i-2]+A[i-1];
        int n = A.length;
        if(n==0){
            return 0;
        }
        int[] f = new int[n+1];
        f[0] = 0;
        f[1] = A[0];
        int i;
        for(i=2;i <=n;i++){
            f[i] = Math.max(f[i-1],f[i-2]+A[i-1]);
        }
        return f[n];
    }
}
