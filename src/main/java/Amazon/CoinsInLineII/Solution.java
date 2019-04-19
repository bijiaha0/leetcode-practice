package Amazon.CoinsInLineII;
/*
https://www.jiuzhang.com/solution/coins-in-a-line-ii/
转换思想：这也就意味着 对手拿到的硬币总价值最低。（再次强调这点很重要！让对方难受）
玩家决策 (Function):
	因为硬币总价值一定，为了保证 先手最大，保证取完后对手能取到的最小即可。
	（死命想法办法坑对方即可）
	dp[i] = sum[i] - Math.min(dp[i - 1], dp[i - 2]);  (sum[i] 表示当前局面下硬币的总价值)
游戏终止 (Initialize)：
	前面也已经提过了，我们讨论的是还剩下 i 枚硬币的情况。
	所以是从右到左。
	因此初始化 dp[1] = values[values.length - 1];
* */
public class Solution {
    public boolean firstWillWin(int[] values) {
        int len = values.length;
        int[] sum = new int[len + 1];
        //从右往左求和
        for (int i = 1; i <= len; i++) {
            sum[i] = sum[i - 1] + values[len - i];
        }

        int[] dp = new int[len + 1];
        dp[1] = values[len - 1];
        for (int i = 2; i <= len; i++) {
            dp[i] = sum[i] - Math.min(dp[i - 1], dp[i - 2]);
        }

        return dp[len] > sum[len] / 2;
    }




}
