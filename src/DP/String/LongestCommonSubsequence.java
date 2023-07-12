package DP.String;

import java.util.Arrays;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
//        String s1 = "abcdgh";
//        String s2 = "aedfhr";

//        String s1 = "abaaa";
//        String s2 = "baabaca";

        String s1 = "ecfbefdcfca";
        String s2 = "badfcbebbf";

        int n = s1.length();
        int m = s2.length();

//        Recursion
        System.out.println(lcs(n,m,s1,s2));

//        Tabulation
         int[][] dp = new int[n+1][m+1];
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < m+1; j++) {
                if (i==0 || j==0) {
                    dp[i][j] = 0;
                }
                else if (s1.charAt(i-1) == s2.charAt(j-1)) {
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

    private static int lcs(int n, int m, String s1, String s2) {
        if (n==0 || m==0) {
            return 0;
        }
        if (s1.charAt(n-1) == s2.charAt(m-1)) {
            return 1 + lcs(n-1, m-1, s1, s2);
        }
        return Math.max(lcs(n-1, m, s1, s2),lcs(n, m-1, s1, s2));
    }
}
