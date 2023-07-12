package DP;

public class PartitionMinSumSubsetLeet {
    public static void main(String[] args) {
         int[] arr = {1,5,11,5};
        int n = arr.length;
        // Find sum of all elements of given array
	    int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }

	    //        Target Sum Code
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

 //        Code for this problem
//        int i = sum/2;
        int s1 = 0;
        for (int i = sum/2; i >=0 ; i--) {
            if (dp[n][i]) {
                s1 = i;
                break;
            }
        }
        System.out.println(sum-(2*s1));
    }
}
