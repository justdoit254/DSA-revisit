package DP.String;

public class WildcardPatternMatching {
    public static void main(String[] args) {
        String pattern = "ba*a?";
        String str = "baaabab";

        int n = pattern.length();
        int m = str.length();

//        Recursion
        System.out.println(isMatching(pattern,str,n,m));

//        Tabulation
        int[][] dp = new int[n+1][m+1];
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < m+1; j++) {
                if (i==0 && j==0) dp[i][j] = 1;
                else if (i==0) dp[i][j] = 0;
                else if (j==0) dp[i][j] = isAllStars(pattern,i);
                else if (pattern.charAt(i-1)=='?' || pattern.charAt(i-1)==str.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                }
                else if (pattern.charAt(i-1)=='*') {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
                else dp[i][j] = 0;
            }
        }
        System.out.println(dp[n][m]);
    }

    private static int isMatching(String pattern, String str, int n, int m) {
        if ((n==0 && m!=0)) return 0;
        if (n==0 && m==0) return 1;
        if (m==0) {
            return isAllStars(pattern,n);
        }
        if (pattern.charAt(n-1)=='?' || pattern.charAt(n-1)== str.charAt(m-1)) {
            return isMatching(pattern, str, n-1, m-1);
        }
        if (pattern.charAt(n-1)=='*') {
            return Math.max(isMatching(pattern, str, n-1, m),isMatching(pattern, str, n, m-1));
        }
        return 0;
     }
      private static int isAllStars(String pattern, int n) {
         if (n==0) {
             return 1;
         }
         if (pattern.charAt(n-1)=='*') {
             return isAllStars(pattern,n-1);
         } else {
             return 0;
         }
     }
}
