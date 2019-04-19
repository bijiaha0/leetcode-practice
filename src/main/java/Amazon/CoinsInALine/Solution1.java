package Amazon.CoinsInALine;
/*
经典的博弈问题
    使用 DP 方法解决。
	重点在于：需要学会转换思想来思考问题。
	即：我想要必胜，那么对手就是必败！这点十分重要！那么我们只要做出让对手必败的选择即可
	因为 DP 就是根据之前的 小状态 来推得现在的 大状态（当前状态）。
游戏局面 (State)：
	dp[i] 表示当局面时有 i 个 coins 时，是否先手必胜
玩家决策 (Function):
	对于有 i 个conis局面的先手，不管他怎么取。取完后都是 对手 必胜的状态，那么他就必败。
	反之，如果 存在 一种取法，使得他取完后的状态是 对手 必败的状态，那么他就必胜。
	用数学的语言总结：
	先手必胜状态的条件（N）：当且仅当它的子状态中 存在 一个 对手 必败的状态（P）
	先手必败状态的条件（P）：当且仅当它的子状态 全部都是 对手 必胜的状态（N）
	在该问题中，可以一次取 1 or 2 枚。
	故 dp[i] = !(dp[i - 1] && dp[i - 2]);
游戏终止 (Initialize)：
	当 coins 为 1 时，先手必胜（N）；
	当 conis 为 2 时，先手必胜（N）；
	当 conis 为 3 时，先手必败（P）；

当然该题还存在着一个巧妙的解法：
	当 n % 3 == 0 时，先手必败（P）；
	否则 先手必胜（N）；
	这是根据规律总结出来的，并不具有泛用性。故还是推荐使用 DP 方法。
* */
public class Solution1 {
    public boolean firstWillWin(int n) {
        int []dp = new int[n + 1];
        return MemorySearch(n,dp);
    }
    boolean MemorySearch(int n, int []dp) {//0 is empty, 1 is false, 2 is true.
        if(dp[n]!=0){
            if(dp[n]==1){
                return false;
            }else {
                return true;
            }
        }
        if(n <= 0){
            dp[n] = 1;
        }else if(n == 1){
            dp[n] = 2;
        }else if(n == 2){
            dp[n] = 2;
        }else if(n == 3){
            dp[n] =1;
        }else {
            if((MemorySearch(n-2,dp) && MemorySearch(n-3,dp)) ||
                (MemorySearch(n-3,dp)&&MemorySearch(n-4,dp))){
                dp[n] = 2;
            }else {
                dp[n] = 1;
            }
        }
        if(dp[n] == 2){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

    }
}