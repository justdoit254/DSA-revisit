package DP;

import java.util.ArrayList;
import java.util.List;

public class MinNoOfCoins {
    public static void main(String[] args) {
        int[] val = {1,2,5,10,20,50,100,200,500,2000};
        int money = 43;
        int n = val.length;
        
//        Recursion
        int ans = (moneyChange(n,val,money));
        if (ans == Integer.MAX_VALUE-1) {
            ans = -1;
        }
        System.out.println(ans);

//        Tabulation
        int[][] dp = new int[n+1][money+1];
        for (int i = 0; i < money+1; i++) {
            dp[0][i] = Integer.MAX_VALUE - 1;
        }
        for (int i = 0; i < n+1; i++) {
            dp[i][0] = 0;
        }
        for (int i = 1; i < n+1; i++) {             // what value of note or coin
            for (int j = 1; j < money+1; j++) {    // what amount of money
                if (val[i-1]>j) {
                    dp[i][j] = dp[i-1][j];
                }
                else {
                    dp[i][j] = Math.min(1+dp[i][j-val[i-1]],dp[i-1][j]);
                }
            }
        }
        int ans1 = dp[n][money];
        if (ans1 == Integer.MAX_VALUE-1) {
            ans1 = -1;
        }
        System.out.println(ans1);


    }

    private static int moneyChange(int n, int[] val, int money) {
        if (money==0) {
            return 0;
        }
        if (n==0) {
            return Integer.MAX_VALUE - 1;
        }
        if (val[n-1]>money) {
            return moneyChange(n-1, val, money);
        }
        return Math.min(1+moneyChange(n, val, money-val[n-1]),moneyChange(n-1, val, money));
    }
}
