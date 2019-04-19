package Amazon.LongestIncreasingSubsequence;
/**
 * Email: clickgwas@gmail.com
 * https://www.lintcode.com/problem/longest-increasing-subsequence/solution
 */
public class Solution2 {
    public int longestIncreasingSubsequence(int[] nums) {
        //state
        int[] f = new int[nums.length];
        //initialize
        f[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            f[i] = 1;
        }
        //function
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[j] < nums[i]){
                    f[i] = Math.max(f[i],f[j]+1);
                }
            }
        }
        //answer
        int max = 0;
        for(int i = 0; i < nums.length; i++){
            max = Math.max(max,f[i]);
        }
        return max;
    }
}
