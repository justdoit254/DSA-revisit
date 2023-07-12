package DP.Stocks;

public class BuyAndSell4 {
    public static void main(String[] args) {
        int[] arr = {10, 22, 5, 75, 65, 80};
        int n = arr.length;
        int k = 2;

//        Just a slight modification in BuyAndSell3
         int[][][] dp = new int[2][n+1][k+1];



        for (int i = n-1; i >=0 ; i--) {
            for (int j = 0; j < 2; j++) {
                for (int m = 0; m < k; m++) {
                    if (j==1) {
                        dp[j][i][m] = Math.max(-arr[i]+dp[0][i+1][m], dp[1][i+1][m]);
                     }
                    if (j==0) {
                        dp[j][i][m] = Math.max(arr[i]+dp[1][i+1][m+1], dp[0][i+1][m]);
                    }
                }
            }
        }
        System.out.println(dp[1][0][0]);
    }
}
