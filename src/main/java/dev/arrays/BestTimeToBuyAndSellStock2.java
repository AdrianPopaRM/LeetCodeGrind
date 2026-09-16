package main.java.dev.arrays;

public class BestTimeToBuyAndSellStock2 {
    public int maxProfit(int[] prices) {
        int profit=0,buy=prices[0],alternateProfit=0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]-buy>0){
                profit+=prices[i]-buy;
                buy=prices[i];
            }
            else if(prices[i]-buy<0){
                buy=prices[i];
            }
        }
        return profit;
    }


}