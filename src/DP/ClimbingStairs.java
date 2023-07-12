package DP;

import java.util.ArrayList;
import java.util.List;

public class ClimbingStairs {
    public static void main(String[] args) {
        int n = 4;

//        Solution 1 (Recursion)
        System.out.println(countWays(n));

//        Solution 2 (Tabulation)
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n+1; i++) {
            dp[i] = dp[i-1]+dp[i-2];
        }
        System.out.println(dp[n+1]);
    }

    private static int countWays(int n) {
        if (n<2) {
            return 1;
        }
        return countWays(n-1)+countWays(n-2);
    }
}
