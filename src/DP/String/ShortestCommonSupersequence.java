package DP.String;

import java.util.Arrays;

public class ShortestCommonSupersequence {
    public static void main(String[] args) {

//        Slightly different from MinNoOfInsertionDeletion
//        String str1 = "abcd";
//        String str2 = "xycd";

        String str1 = "bbababbb";
        String str2 = "bbababbb";

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

//        Answer = n+m-ans
        System.out.println(n+m-(ans));

//        Recursive Proper Concept
        System.out.println(scs(str1,str2,n,m));

//        Tabulation
        int[][] dpT = new int[n+1][m+1];
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < m+1; j++) {
                if (i==0) dpT[i][j] = j;
                else if (j==0) dpT[i][j] = i;
                else if (str1.charAt(i-1)==str2.charAt(j-1)) dpT[i][j] = dpT[i-1][j-1] + 1;
                else {
                    dpT[i][j] = Math.min(dpT[i-1][j],dpT[i][j-1]) + 1;
                }
            }
        }
        System.out.println(dpT[n][m]);
        for (int i = 0; i < n+1; i++) {
            System.out.println(Arrays.toString(dpT[i]));
        }

//        To print the supersequence
        int i = n, j = m;
        StringBuilder superSub = new StringBuilder();
        while (i>0 && j>0) {
            if (str1.charAt(i-1)==str2.charAt(j-1)) {
                superSub.append(str1.charAt(i - 1));
                i--;
                j--;
            } else {
                if (dpT[i][j-1]>dpT[i-1][j]) {
                    superSub.append(str1.charAt(i-1));
                    i--;
                } else {
                    superSub.append(str2.charAt(j-1));
                    j--;
                }
            }
        }
        while (i>0) {
            superSub.append(str1.charAt(i-1));
            i--;
        }
        while (j>0) {
            superSub.append(str2.charAt(j-1));
            j--;
        }
        System.out.println(superSub.reverse().toString());
    }

    private static int scs(String str1, String str2, int n, int m) {
        if (n==0) {
            return m;
        }
        if (m==0) {
            return n;
        }
        return 1 + ((str1.charAt(n-1)==str2.charAt(m-1)) ?
                   scs(str1, str2, n-1, m-1) :
        Math.min(scs(str1, str2, n-1, m),scs(str1, str2, n, m-1)));
    }
}
