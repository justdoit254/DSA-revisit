package DP.String;

import java.util.Arrays;

public class LongestCommonSubstring {
    public static void main(String[] args) {
        String s1 = "abcdgh";
        String s2 = "acdghr";

//        String s1 = "cba";
//        String s2 = "aba";

        int n = s1.length();
        int m = s2.length();
        int count = 0;

//        Recursion
          int[][] dp = new int[n+1][m+1];
//        for (int i = 0; i < n+1; i++) {
//            Arrays.fill(dp[i],-1);
//        }
//        int ans = lcs(n,m,s1,s2,count,dp);
//        Above approach was memoization which is not resulting correct answer and I want to find why so.

        int ans = lcs(n,m,s1,s2,count);
        System.out.println(ans);

//        Tabulation
         int ansT = 0;
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < m+1; j++) {
                if (i==0 || j==0) {
                    dp[i][j] = 0;
                }
                else if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = 1+dp[i-1][j-1];
                    ansT = Math.max(ansT, dp[i][j]);
                }
                else {
                    dp[i][j] = 0;
                }
            }
        }
        System.out.println(ansT);
    }

    private static int lcs(int n, int m, String s1, String s2, int count) {
        if (n==0 || m==0) {
            return count;
        }
        if (s1.charAt(n-1)==s2.charAt(m-1)) {
            count = lcs(n-1, m-1, s1, s2, count+1);
//            return count;
        }
        count = Math.max(count,Math.max(lcs(n-1, m, s1, s2, 0),lcs(n, m-1, s1, s2, 0)));
        return count;
    }

//      private static int lcs(int n, int m, String s1, String s2, int count, int[][]dp) {
//        if (n==0 || m==0) {
//            return count;
//        }
//        if (dp[n][m]!=-1) {
//            count = Math.max(count,dp[n][m]);
//            // count = dp[n][m];
//            return count;
//        }
//        if (s1.charAt(n-1)==s2.charAt(m-1)) {
//            count = lcs(n-1, m-1, s1, s2, count+1,dp);
//            dp[n][m] = count;
//            return count;
//        }
//        count = Math.max(count,Math.max(lcs(n-1, m, s1, s2, 0,dp),lcs(n, m-1, s1, s2, 0,dp)));
//        dp[n][m] = count;
//        return count;
//    }
}
