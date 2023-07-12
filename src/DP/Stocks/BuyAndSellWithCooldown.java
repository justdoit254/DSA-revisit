package DP.Stocks;

public class BuyAndSellWithCooldown {
    public static void main(String[] args) {

//        Two changes in BuyAndSell2 ; 1st in the call of sell and 2nd in base case
        int[] prices = {1, 2, 3, 0, 2};
        int n = prices.length;

//        Recursive approach
        System.out.println(buyandsell(prices,1,0));

//        Tabulation
         int[][] dp = new int[2][n+2];


        for (int i = n-1; i >=0 ; i--) {
            for (int j = 0; j < 2; j++) {
                if (j==1) {             //Buy or not
                    dp[j][i] = Math.max(-prices[i]+dp[0][i+1], dp[1][i+1]);
                }
                if (j==0) {             //Sell or not
                    dp[j][i] =  Math.max(prices[i]+dp[1][i+2], dp[0][i+1]);
                }
            }
        }
        System.out.println(dp[1][0]);
    }

     private static int buyandsell(int[] arr, int buy, int idx) {
        if (idx>=arr.length) {
            return 0;
        }
        if (buy == 1) {         //No prev buy so can be buy
            int profit = Math.max(-arr[idx]+buyandsell(arr, 0, idx+1),  //buy
                    buyandsell(arr, 1, idx+1));                         //not buy
            return profit;
        }
        if (buy == 0) {

            int profit = Math.max(arr[idx]+buyandsell(arr, 1, idx+2),   //sell
                    buyandsell(arr, 0, idx+1));                         //not sell
            return profit;
        }
        return 0;
    }
}
