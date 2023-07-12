package DP;

public class PartitionMinSumSubset {
    public static void main(String[] args) {
        int[] arr = {1,5,11,5};
        int n = arr.length;
        // Find sum of all elements of given array
	    int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Math.abs(arr[i]);
        }
        int rangeSum = (2*sum) + 1;

	    //        Target Sum Code
        boolean[][] dp = new boolean[n+1][rangeSum+1];
        for (int j = 0; j < rangeSum+1; j++) {
            dp[0][j] = false;
        }
        for (int i = 0; i < n+1; i++) {
            dp[i][sum] = true;
        }

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < rangeSum+1; j++) {
                int newj = j-sum;
                if (arr[i-1] > newj) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-arr[i-1]];
                }
            }
        }

 //        Code for this problem
        int origSum = 0;
         for (int i = 0; i < n; i++) {
            origSum += (arr[i]);
        }
        int s1 = 0;
         int i = origSum/2;
        for ( i = sum/2; i >=0 ; i--) {
            if (dp[n][i]) {
                s1 = i;
                break;
            }
        }
        System.out.println(sum-(2*s1));
    }
}
