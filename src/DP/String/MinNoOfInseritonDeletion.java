package DP.String;

import java.util.Arrays;

public class MinNoOfInseritonDeletion {
    public static void main(String[] args) {
        String str1 = "heap";
        String str2 = "pea";

        int n = str1.length();
        int m = str2.length();

//        Finding Longest Common subsequence
       int[][] dp = new int[n+1][m+1];
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < m+1; j++) {
                if (i==0 || j==0) {
                    dp[i][j] = 0;
                }
                else if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = 1+dp[i-1][j-1];
                }
                else {
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        int ans = (dp[n][m]);

//        Answer = n+m-2*ans
        System.out.println(n+m-(2*ans));
    }
}
