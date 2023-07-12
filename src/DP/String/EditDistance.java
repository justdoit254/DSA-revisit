package DP.String;

public class EditDistance {
//    Same as MinNoOfInsertionDeletion except the fact that here replacement is also allowed, os one extra case is added in recursion.
    public static void main(String[] args) {
        String s = "ecfbefdcfca";
        String t = "badfcbebbf";
        
        int n = s.length();
        int m = t.length();
        
//        Recursion
        System.out.println(minDist(s,t,n,m));

//        Tabulation
        int[][] dp = new int[n+1][m+1];
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < m+1; j++) {
                if (i==0) dp[i][j] = j;
                else if (j==0) dp[i][j] = i;
                else if (s.charAt(i-1)==t.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1])) + 1;
                }
            }
        }
        System.out.println(dp[n][m]);
    }

    private static int minDist(String s, String t, int n, int m) {
        if (n==0) return m;
        if (m==0) return n;

        if (s.charAt(n-1)==t.charAt(m-1)) {
            return minDist(s, t, n-1, m-1);
        }
        return 1 + Math.min(minDist(s, t, n-1, m-1),Math.min(minDist(s, t, n-1, m),minDist(s, t, n, m-1)));
    }
}
