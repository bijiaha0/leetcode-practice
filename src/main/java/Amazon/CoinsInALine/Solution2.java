package Amazon.CoinsInALine;
/*
* 我想要必胜，那么对手就是必败！
* 故 dp[i] = !(dp[i - 1] && dp[i - 2]);
* */
/*
游戏局面 (State)：
	dp[i] 表示当局面时有 i 个 coins 时，是否先手必胜
玩家决策 (Function):
	对于有 i 个conis局面的先手，不管他怎么取。取完后都是 先手（对手） 必胜的状态，那么他就必败。
	反之，如果 存在 一种取法，使得他取完后的状态是 先手（对手） 必败的状态，那么他就必胜。
	用数学的语言总结：
	先手必胜状态的条件（N）：当且仅当它的子状态中 存在 一个 先手必败的状态（P）
	先手必败状态的条件（P）：当且仅当它的子状态 全部都是 先手必胜的状态（N）
	在该问题中，可以一次取 1 or 2 枚。
	故 dp[i] = !(dp[i - 1] && dp[i - 2]);
游戏终止 (Initialize)：
	当 coins 为 1 时，先手必胜（N）；
	当 conis 为 2 时，先手必胜（N）；
	当 conis 为 3 时，先手必败（P）；
* */
public class Solution2 {
    public boolean firstWillWin(int n) {
        if (n == 0) {
            return false;
        } else if (n == 1) {
            return true;
        } else if (n == 2) {
            return true;
        }

        // State
        boolean[] rst = new boolean[n + 1];

        // Initialize
        rst[0] = false;
        rst[1] = true;
        rst[2] = true;

        // Function
        for (int i = 3; i <= n; i++) {
            rst[i] = !(rst[i - 1] && rst[i - 2]);
        }

        // Answer
        return rst[n];
    }
}
