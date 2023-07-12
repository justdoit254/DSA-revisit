package DP.String;

import java.util.Arrays;

public class LongestPalindromeSequence {
    public static void main(String[] args) {
        String s = "bbabcbcab";
        StringBuilder sb = new StringBuilder(s);
        StringBuilder reversed_s = sb.reverse();
        String reverse_s = reversed_s.toString();

        int n = s.length();
        int m = n;
        int[][] dp = new int[n+1][m+1];
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < m+1; j++) {
                if (i==0 || j==0) {
                    dp[i][j] = 0;
                }
                else if (s.charAt(i-1) == reverse_s.charAt(j-1)) {
                    dp[i][j] = 1+dp[i-1][j-1];
                }
                else {
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        System.out.println(dp[n][m]);
        for (int i = 0; i < n+1; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
    }
}
