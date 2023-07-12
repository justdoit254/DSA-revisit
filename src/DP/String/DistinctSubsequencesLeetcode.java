package DP.String;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DistinctSubsequencesLeetcode {
    static List<String> list = new ArrayList<>();
    public static void main(String[] args) {
        String s = "rabbbit";
        String t = "rabbit";
        int n = s.length();
        int m = t.length();

//        String s = "b";
//        String t = "a";

//        By finding all subsequences
//        distinctSubseq(s,"");
//        int count = 0;
//        for (String el : list) {
//            if (Objects.equals(el, t)) {
//                count++;
//            }
//        }
//        list.clear();
//        System.out.println(count);

//        Recursion
        System.out.println(find(s,t,n,m));

//        Tabulation
        int[][] dp = new int[n+1][m+1];
        for (int i = 0; i < n+1; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                if (s.charAt(i-1)==t.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        System.out.println(dp[n][m]);

    }

    private static int find(String s, String t, int n, int m) {
          if (m==0) {
            return 1;
        }
        if (n==0) {
            return 0;
        }
        if (s.charAt(n-1)==t.charAt(m-1)) {
            return find(s,t,n-1,m-1) + find(s,t,n-1,m);
        }
        return find(s, t, n-1, m);
    }

    private static void distinctSubseq(String s, String s1) {
        if (s.length()==0) {
            list.add(s1);
            return;
        }
        distinctSubseq(s.substring(1), s1+s.charAt(0));
        distinctSubseq(s.substring(1), s1);
    }
}
