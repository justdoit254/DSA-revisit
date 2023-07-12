package DP;

public class TotalNumberOfCoinChange {
    public static void main(String[] args) {
        int[] arr = {2,5,3,6};
        int n = arr.length;
        int amount = 10;

//        Recursion
        int ans = moneyChange(n,arr,amount);
        System.out.println(ans);

//        Tabulation
        int[][] dp = new int[n+1][amount+1];

        for (int j = 0; j < amount+1; j++) {       //(n==0) With zero elements the sum will always be zero
            dp[0][j] = 0;
        }
        for (int i = 0; i < n+1; i++) {         //(sum==0) Any number of elements can generate zero sum
            dp[i][0] = 1;
        }
        // dp[0][0] = 1;

        for (int i = 1; i < n+1; i++) {         //Using i number of elements
            for (int j = 1; j < amount+1; j++) {   //Generating the sum j
                if (arr[i-1] <= j) {
                    dp[i][j] = dp[i-1][j] + dp[i][j-arr[i-1]];
                }
                else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        System.out.println(dp[n][amount]);

    }

    private static int moneyChange(int n, int[] val, int money) {
        if (money==0) {
            return 1;
        }
        if (n==0) {
            return 0;
        }
        if (val[n-1]>money) {
            return moneyChange(n-1, val, money);
        }
        return moneyChange(n, val, money-val[n-1])+moneyChange(n-1, val, money);
    }

}
