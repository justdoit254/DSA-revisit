package DP.Stocks;

import java.util.Arrays;
import java.util.Collections;

public class BuyAndSell3 {
    public static void main(String[] args) {
        int[] prices = {10,22,5,75,65,80};
        int n = prices.length;

//        Recursion 1 using BuyAndSell1
        System.out.println(buyandsell1(prices,0,n,0));
//        A 3d dp can be used in this recursion also

//        Recursion 2 using BuyAndSell2
        int[][][] dpR = new int[2][n+1][3];
         for (int i = 0; i < 2; i++) {
             for (int j = 0; j < n+1; j++) {
                Arrays.fill(dpR[i][j],-1);
             }
        }
        System.out.println (buyandsell(prices,1,0,0,dpR));

//         Tabulation
         int[][][] dp = new int[2][n+1][3];


        for (int i = n-1; i >=0 ; i--) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    if (j==1) {
                        dp[j][i][k] = Math.max(-prices[i]+dp[0][i+1][k], dp[1][i+1][k]);
                     }
                    if (j==0) {
                        dp[j][i][k] = Math.max(prices[i]+dp[1][i+1][k+1], dp[0][i+1][k]);
                    }
                }
            }
        }
        System.out.println(dp[1][0][0]);
         for (int i = 0; i < 2; i++) {
             for (int j = 0; j < n+1; j++) {
                 System.out.println(Arrays.toString(dp[i][j]));
             }
        }
    }

    private static int buyandsell1(int[] prices, int s, int e, int count) {
        int profit = 0;
        if (s == e) return 0;
        if (count == 2) return 0;
        int min = prices[s];

        for (int i = s; i < e; i++) {
            int potentialProfit = prices[i] - min;
            potentialProfit += buyandsell1(prices,i+1,e, count+1);
            profit = Math.max(profit,potentialProfit);
            min = Math.min(min, prices[i]);
        }
        return profit;
    }

    private static int buyandsell(int[] arr, int buy, int idx, int cap, int[][][] dp) {
        if (idx==arr.length) {
            return 0;
        }
        if (cap==2) {
            return 0;
        }
        if (dp[buy][idx][cap]!=-1) {
            return dp[buy][idx][cap];
        }
        if (buy == 1) {         //No prev buy so can be buy
            int profit = Math.max(-arr[idx]+buyandsell(arr, 0, idx+1, cap, dp),  //buy
                    buyandsell(arr, 1, idx+1, cap, dp));                         //not buy
            dp[buy][idx][cap] = profit;
            return profit;
        }
        if (buy == 0) {
            int profit = Math.max(arr[idx]+buyandsell(arr, 1, idx+1,cap+1, dp),   //sell
                    buyandsell(arr, 0, idx+1,cap,dp));                         //not sell
                   dp[buy][idx][cap] = profit;
            return profit;
        }
        return 0;
    }
}
