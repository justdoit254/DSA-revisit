package DP.Stocks;

public class BuyAndSell1 {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        int n = prices.length;

        int profit = 0;
        int min = prices[0];

        for (int i = 0; i < n; i++) {
            int potentialProfit = prices[i] - min;
            profit = Math.max(profit,potentialProfit);
            min = Math.min(min, prices[i]);
        }
        System.out.println(profit);
    }
}
