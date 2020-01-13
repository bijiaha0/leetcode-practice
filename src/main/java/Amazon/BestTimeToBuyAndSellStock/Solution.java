package Amazon.BestTimeToBuyAndSellStock;

public class Solution {
    int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE,profit = 0;
        for(int value:prices){
            if(value<min) min = value;
            int derta = value-min;
            if(derta>profit) profit = derta;
        }
        return profit;
    }
}
