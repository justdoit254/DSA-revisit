package DP;

public class TargetSum {
    public static void main(String[] args) {
        int[] arr = {1,1,1,1,1};
        int n = arr.length;
        int target = 3;
        int sum = 0;
        for (int el: arr) {
            sum += el;
        }
//        add - sub = target
//        add + sub = sum
//        add = reqSum = (target+sum)/2     also (sum-target) must be even.

        if (sum<target || (sum-target)%2 != 0) {
            System.out.println(0);
            return;
        }
        int reqSum = (sum+target) / 2;

//        Recursion
        System.out.println(targetSum(arr, n, reqSum));

//        Tabulation
        if (n==1) {
            if (Math.abs(target)==arr[0]) System.out.println(1);
            else System.out.println(0);
        }

       int[][] dp = new int[n+1][reqSum+1];
        dp[0][0] = 1;
        for (int j = 1; j < reqSum+1; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i < n+1; i++) {
            for (int j = 0; j < reqSum+1; j++) {
                if (arr[i-1] > j) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-arr[i-1]];
                }
            }
        }
        System.out.println(dp[n][reqSum]);
    }


    private static int targetSum(int[] arr, int n, int reqSum) {
         if (n==0) {
            return 0;
        }
        if (arr[n-1]>reqSum) {
           return targetSum(arr, n-1, reqSum);
        }
        return targetSum(arr, n-1, reqSum-arr[n-1])+targetSum(arr, n-1, reqSum);
    }

//    [100]
//-200


}
