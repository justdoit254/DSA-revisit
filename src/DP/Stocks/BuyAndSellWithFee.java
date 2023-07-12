package DP.Stocks;

public class BuyAndSellWithFee {
    public static void main(String[] args) {
//        Same as BuyAndSell2, just subtract fee during sell operation
        int[] prices = {1,3,2,8,4,9};
        int n = prices.length;
        int fee = 2;

//        Recursive Approach
        System.out.println(buyandsell(prices,1,0, fee));

//        Tabulation
        int[][] dp = new int[2][n+1];
        dp[0][n] = 0;
        dp[1][n] = 0;

        for (int i = n-1; i >=0 ; i--) {
            for (int j = 0; j < 2; j++) {
                if (j==1) {             //Buy or not
                    dp[j][i] = Math.max(-prices[i]+dp[0][i+1], dp[1][i+1]);
                }
                if (j==0) {             //Sell or not
                    dp[j][i] = Math.max(prices[i]-fee+dp[1][i+1], dp[0][i+1]);
                }
            }
        }
        System.out.println(dp[1][0]);


    }
    private static int buyandsell(int[] arr, int buy, int idx, int fee) {
        if (idx==arr.length) {
            return 0;
        }
        if (buy == 1) {         //No prev buy so can be buy
            int profit = Math.max(-arr[idx]+buyandsell(arr, 0, idx+1, fee),  //buy
                    buyandsell(arr, 1, idx+1, fee));                         //not buy
            return profit;
        }
        if (buy == 0) {
            int profit = Math.max(arr[idx]-fee+buyandsell(arr, 1, idx+1, fee),   //sell
                    buyandsell(arr, 0, idx+1, fee));                         //not sell
            return profit;
        }
        return 0;
    }
}
