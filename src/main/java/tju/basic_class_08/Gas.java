package tju.basic_class_08;
/*
* 戳气球
* 有 n 个气球，编号为0 到 n-1，每个气球上都标有一个数字，这些数字存在数组 nums 中。
* 现在要求你戳破所有的气球。每当你戳破一个气球 i 时，
* 你可以获得 nums[left] * nums[i] * nums[right] 个硬币。
* 这里的 left 和 right 代表和 i 相邻的两个气球的序号。
* 注意当你戳破了气球 i 后，气球 left 和气球 right 就变成了相邻的气球。
* 求所能获得硬币的最大数量。
* */
/*
* 说明：你可以假设 nums[-1] = nums[n] = 1，但注意它们不是真实存在的所以并不能被戳破。
* 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
* */
public class Gas {
    public static int getMax(int[] balls){
        int[] help = new int[balls.length+2];
        // balls [3,2,5]
        // help [1,3,2,5,1]
        for(int i = 0; i < balls.length;i++){
            help[i+1] = balls[i];
        }
        help[0]=1;
        help[balls.length+1]=1;
        return process(help,1,help.length-2);
    }
    //在balls[L-1]和balls[R+1]的气球一定没有被打爆的情况下，
    //要打爆balls[L..R]范围上所有的气球，请返回获得的最大分数
    public static int process(int[] balls, int L, int R){
        if(L == R){
            return balls[L-1]*balls[L]*balls[R+1];
        }
        /*
        * 不仅一个气球，常识方法是：常识每一个气球都最后打爆的情况
        * */
        //先尝试最后打爆balls[L]
        int max = process(balls,L+1,R) + balls[L-1] * balls[L] * balls[R+1];
        //尝试最后打爆balls[R]
        max = Math.max(max, process(balls,L,R-1)+balls[L-1] * balls[R]*balls[R+1]);
        //接下来尝试中间每一个气球都被最后打爆的情况
        //L+1,R-1
        for(int i = L+1; i <= R-1; i++){
            int left = process(balls,L,i-1);
            int right = process(balls,i+1,R);
            int mid = balls[L-1]*balls[i]*balls[R+1];
            max = Math.max(max,left+right+mid);
        }
        return max;
    }
    //这道题提出了一种打气球的游戏，每个气球都对应着一个数字，
    // 得到的金币是被打爆的气球的数字和其两边的气球上的数字相乘，如果旁边没有气球了，
    // 则按1算，以此类推，求能得到的最多金币数。像这种求极值的问题，我们一般都要考虑用动态规划dp来做，
    // 我们维护一个二维数组dp，其中dp[i][j]表示打爆区间[i,j]中的所有气球能够得到的最多金币，
    // 题目中说明了边界情况，当气球周围没有气球的时候，旁边的数字按1算，这样我们可以再原数组两边各填充一个1，
    // 这样方便于计算。这道题的难点就是找递归式。
    //dp[i][j]=max(dp[i][j],nums[i-1]*nums[k]*nums[j+1]+dp[i][k-1]+dp[k+1][j]) ( i ≤ k ≤ j )
    public static int getMaxDP(int[] balls){
        int[] help = new int[balls.length+2];
        // balls [3,2,5]
        // help [1,3,2,5,1]
        for(int i = 0; i < balls.length;i++){
            help[i+1] = balls[i];
        }
        help[0]=1;
        help[balls.length+1]=1;

        int[][] dp = new int[help.length][help.length];
        for(int i = 1; i < dp.length-1; i++){
            dp[i][i]=help[i-1]*help[i]*help[i+1];
        }
        for(int row = help.length-3; row >= 1; row--){
            for(int col = row+1; col < help.length-1; col++){
                dp[row][col] = dp[row+1][col]+help[row-1]*help[row]*help[col+1];
                dp[row][col] =Math.max(dp[row][col],dp[row][col-1]+help[row-1]*help[col]*help[col+1]);
                for(int mid= row+1; mid < col;mid++){
                    int left = dp[row][mid-1];
                    int right = dp[mid+1][col];
                    int m = help[row-1]*help[mid]*help[col+1];
                    dp[row][col] = Math.max(dp[row][col],left+right+m);
                }
            }
        }
        return dp[1][help.length-2];
    }
}
