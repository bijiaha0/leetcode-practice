package tju.basic_class_08;
/**
 * Author: bijiaha0
 * Date: 2019-02-08
 * Time: 5:00 PM
 * Email: clickgwas@gmail.com
 */
public class Money {
    //入口
    public static int ways(int[] coins, int aim){
        return process(coins,0,aim);
    }
    //可以自由使用coins[index..]，搞定rest钱数有多少种方法
    public static int process(int[] coins, int index, int rest){
        if(index == coins.length){//已经不剩任何面值了
            return rest == 0 ? 1 : 0;
        }
        //当前的index面值的货币我要用多少张
        int ways = 0;
        for(int zhang = 0; zhang * coins[index] <= rest; zhang++){
            ways += process(coins,index+1,rest - (zhang * coins[index]));
        }
        return ways;
    }

    public static int dpWays(int[] coins, int aim){
        int[][] dp = new int[coins.length+1][aim+1];
        dp[coins.length][0]=1;
        for(int row = coins.length-1; row >= 0; row--){
            for(int col =0; col <= aim; col++){
                //dp[row][col] = dp[row][col-1]+dp[row+1][col];
                /*//枚举
                for(int zhang = 0; zhang * coins[row] <= col; zhang++ ){
                    dp[row][col] += dp[row+1][col-zhang*coins[row]];
                }*/
                dp[row][col] = dp[row+1][col];
                if(col-coins[row] > 0){
                    dp[row][col] += dp[row][col-coins[row]];
                }
            }
        }
        return dp[0][aim];
    }
}
