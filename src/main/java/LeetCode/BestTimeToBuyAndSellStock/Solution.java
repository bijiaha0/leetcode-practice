package LeetCode.BestTimeToBuyAndSellStock;
/**
 * Author: bijiaha0
 * Date: 2019-04-23
 * Time: 10:16
 * Email: clickgwas@gmail.com
 * https://segmentfault.com/a/1190000015715476
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        if (prices.length <= 1) {
            return maxProfit;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            min = Math.min(min,prices[i]);
            maxProfit = Math.max(maxProfit,prices[i]-min);
        }
        return maxProfit;
    }
}
