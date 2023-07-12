package DP.Partition;

public class MCM {
    public static void main(String[] args) {
        int[] arr = {40, 20, 30, 10, 30};
        int n = arr.length;

//      Recursion
//        System.out.println(mcm(arr,1,n-1));

//        Tabulation
//        i = n-1 -> 1 ; j = i+1 --> n-1
        int[][] dp = new int[n][n];
        for (int i = n-1; i >=1 ; i--) {
            for (int j = i+1; j < n ; j++) {
                int min = Integer.MAX_VALUE;
               for (int k = i; k < j; k++) {
                   int temp = (arr[i-1]*arr[k]*arr[j]) + dp[i][k] + dp[k+1][j];
                   min = Math.min(temp, min);
               }
            dp[i][j] = min;
            }
        }
        System.out.println(dp[1][n-1]);

    }

    private static int mcm(int[] arr, int i, int j) {       //f(1,n-1)
        int min = Integer.MAX_VALUE;
        if (i==j) return 0;
        for (int k = i; k < j; k++) {
            int temp = (arr[i-1]*arr[k]*arr[j]) + mcm(arr,i,k) + mcm(arr,k+1,j);
            min = Math.min(temp, min);
        }
        return min;
    }
}
