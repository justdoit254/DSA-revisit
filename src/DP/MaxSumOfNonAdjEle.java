package DP;

public class MaxSumOfNonAdjEle {
    public static void main(String[] args) {
        int[] arr = {5, 5, 10, 100, 10, 5};
        int n = arr.length;

//        Solution 1 (recursion)
        System.out.println(maxSum(arr,n));

//        Solution 2 (Tabulation)
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = arr[0];
        for (int i = 2; i < n+1; i++) {
            int pick = arr[i-1] + dp[i-2];
            int notPick = dp[i-1];
            dp[i] = Math.max(pick,notPick);
        }
        System.out.println(dp[n]);
    }

    private static int maxSum(int[] arr, int n) {
        if (n<1) {
            return 0;
        }
        if (n==1) {
            return arr[0];
        }
        int pick = arr[n-1] + maxSum(arr, n-2);
        int notPick = maxSum(arr, n - 1);
        return Math.max(pick,notPick);
    }
}
