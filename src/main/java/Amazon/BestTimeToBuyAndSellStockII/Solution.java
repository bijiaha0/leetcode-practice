package Amazon.BestTimeToBuyAndSellStockII;

public class Solution {
    int maxProfit(int[] prices) {
        int n = prices.length;
        int i,profit=0;
        for(i=0;i<n-1;i++){
            if(prices[i+1]>prices[i]){
                profit+=(prices[i+1]-prices[i]);
            }
        }
        return profit;
    }
}
