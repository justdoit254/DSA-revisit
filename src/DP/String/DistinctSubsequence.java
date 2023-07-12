package DP.String;

import java.util.Arrays;

public class DistinctSubsequence {
    public static void main(String[] args) {
//        String str = "gfg";
        String str = "jzeye";
        int[] ch = new int[256];
        Arrays.fill(ch,-1);
        int n = str.length();
        int[] dp = new int[n+1];
        dp[0] = 1;
        for (int i = 1; i < n+1; i++) {
            dp[i] = dp[i-1] * 2;
            if (ch[(int)str.charAt(i-1)] != -1) {
                dp[i] = dp[i] - dp[ch[(int) str.charAt(i-1)]];
            }
            ch[(int)str.charAt(i-1)] = i-1;
        }
        System.out.println(dp[n]);
    }
}
