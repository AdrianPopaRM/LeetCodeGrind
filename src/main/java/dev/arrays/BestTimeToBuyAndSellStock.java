package java.dev.arrays;

public class BestTimeToBuyAndSellStock {
    public int maxProfitInefficient(int[] prices) {
        int profit=0;
        for(int i=0;i<prices.length;i++){
            for(int j=i;j<prices.length;j++){
                if(prices[j]-prices[i]>profit){
                    profit=prices[j]-prices[i];
                }
            }
        }
        return profit;
    }

    public int maxProfit(int[] prices) {
        int profit=0,buy=prices[0];
        for(int i=1;i<prices.length;i++){
            if(prices[i]-buy>profit){
                profit=prices[i]-buy;
            }
            else if(prices[i]-buy<0){
                buy=prices[i];
            }
        }
        return profit;
    }

//    public int maxProfitBest(int[] prices){
//        int indexMin=0,indexMax=0;
//        for(int i=1;i<prices.length;i++){
//            if(prices[indexMin]>prices[i]){
//                indexMin=i;
//            }
//            if(prices[indexMax]<prices[i]){
//                indexMax=i;
//            }
//        }
//        if(indexMax<indexMin){
//            return 0;
//        }
//        else{
//            return prices[indexMax]-prices[indexMin];
//        }
//    }
}
