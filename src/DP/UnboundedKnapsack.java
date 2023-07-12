package DP;

public class UnboundedKnapsack {
    public static void main(String[] args) {
        int[] values = {1,4,5,7};
        int[] weights = {1,3,4,5};
        int n = 4;
        int w = 8;

//        Recursive Solution
        System.out.println(knapsack(n,w,values,weights));

//        Tabulation
        int[][] dp = new int[n+1][w+1];

        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < w+1; j++) {
                if (i==0||j==0) {
                    dp[i][j] = 0;
                }
                else if (weights[i-1]>j) {
                    dp[i][j] =  dp[i-1][j];
                }
                else {
                    dp[i][j] = Math.max(values[i-1]+dp[i][j-weights[i-1]], dp[i-1][j]);
                 }
            }
        }
        System.out.println(dp[n][w]);
    }
    private static int knapsack(int n, int w, int[] values, int[] weights) {
        if (n==0) {
            return 0;
        }
        if (weights[n-1]>w) {
            return knapsack(n-1, w, values, weights);
        }
        return Math.max(values[n-1]+knapsack(n, w-weights[n-1], values, weights), knapsack(n-1, w, values, weights)); //Only change in this line
    }
}
