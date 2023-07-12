package DP.Stocks;

public class BuyAndSell2 {
    public static void main(String[] args) {
        int[] arr = {7,1,5,3,6,4};
        int n = arr.length;

//        Iterative Solution
        int maxProfit = 0;
        int buy = 0;
        int sell = n-1;
        int t = 1;
        while (t<n) {
            while (t<n && arr[buy]>=arr[t]) {
                buy = t;
                t++;
            }
            if (buy == n-1) {
                break;
            }
            while (t<n && arr[t]>arr[t-1]) {
                sell = t;
                t++;
            }
            maxProfit += arr[sell]-arr[buy];
            buy = t;
        }
        System.out.println(maxProfit);


//        Recursion
        System.out.println(buyandsell(arr,1,0));

//        Tabulation
        int[][] dp = new int[2][n+1];
        dp[0][n] = 0;
        dp[1][n] = 0;

        for (int i = n-1; i >=0 ; i--) {
            for (int j = 0; j < 2; j++) {
                if (j==1) {             //Buy or not
                    dp[j][i] = Math.max(-arr[i]+dp[0][i+1], dp[1][i+1]);
                }
                if (j==0) {             //Sell or not
                    dp[j][i] = Math.max(arr[i]+dp[1][i+1], dp[0][i+1]);
                }
            }
        }
        System.out.println(dp[1][0]);
    }

    private static int buyandsell(int[] arr, int buy, int idx) {
        if (idx==arr.length) {
            return 0;
        }
        if (buy == 1) {         //No prev buy so can be buy
            int profit = Math.max(-arr[idx]+buyandsell(arr, 0, idx+1),  //buy
                    buyandsell(arr, 1, idx+1));                         //not buy
            return profit;
        }
        if (buy == 0) {
            int profit = Math.max(arr[idx]+buyandsell(arr, 1, idx+1),   //sell
                    buyandsell(arr, 0, idx+1));                         //not sell
            return profit;
        }
        return 0;
    }
}
