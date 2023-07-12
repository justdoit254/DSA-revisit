package DP.LIS;

import java.util.Arrays;

public class NumberOfLIS {
    public static void main(String[] args) {
        int[] nums = {1,3,5,4,7};
        int n = nums.length;

         int max = 1;
        int[] Dp = new int[n];
        int[] count = new int[n];

        Arrays.fill(Dp,1);
        Arrays.fill(count,1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j]<nums[i] && 1+Dp[j] > Dp[i]) {
                    Dp[i] = 1+Dp[j];
                    count[i] = count[j];
                }
                else if (nums[j]<nums[i] && 1+Dp[j] == Dp[i]) {
                    count[i] = count[i] + count[j];
                }
            }
            max = Math.max(max, Dp[i]);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (Dp[i]==max) ans += count[i];
        }
        System.out.println(ans);
    }
}
