package DP;

public class SubsetSum {
    public static void main(String[] args) {
        int[] arr = {3,34,4,12,5,2};
        int n = arr.length;
        int sum = 9;

//        Recursion
        System.out.println(isSumPossible(arr,n,sum));

//        Tabulation
         boolean[][] dp = new boolean[n+1][sum+1];
        for (int j = 0; j < sum+1; j++) {
            dp[0][j] = false;
        }
        for (int i = 0; i < n+1; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < sum+1; j++) {
                if (arr[i-1] > j) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-arr[i-1]];
                }
            }
        }
        System.out.println(dp[n][sum]);
    }

    private static boolean isSumPossible(int[] arr, int n, int sum) {
        if (sum==0) {
            return true;
        }
        if (n==0) {
            return false;
        }
        if (arr[n-1]>sum) {
            return isSumPossible(arr, n-1, sum);
        }
        return isSumPossible(arr, n-1, sum) || isSumPossible(arr, n-1, sum-arr[n-1]);
    }
}
