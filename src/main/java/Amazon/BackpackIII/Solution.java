package Amazon.BackpackIII;
/*
* https://www.lintcode.com/problem/backpack-iv/description
* */
public class Solution {
    public int backPackIV(int[] nums, int target) {
        // Write your code here
        int m = target;
        int []A = nums;
        int f[][] = new int[A.length + 1][m + 1];

        f[0][0] = 1;
        for (int i = 1; i <= A.length; i++) {
            for (int j = 0; j <= m; j++) {
                int k = 0;
                while(k * A[i-1] <= j) {//枚举第i个物品的个数
                    f[i][j] += f[i-1][j-A[i-1]*k];
                    k+=1;
                }
            }
        }
        return f[A.length][target];
    }
}
