package DP.LIS;

import java.util.Arrays;
import java.util.Collections;

public class LongestBitonicSubsequence {
    public static void main(String[] args) {
        int[] nums = {20, 7, 9, 6, 9, 21, 12, 3, 12, 16, 1, 27};
        int n = nums.length;

//        Finding arr of the longest increasing subsequence
        int[] Dp = new int[n];

        Arrays.fill(Dp,1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j]<nums[i] && 1+Dp[j] > Dp[i]) {
                    Dp[i] = 1+Dp[j];

                }
            }
        }
        System.out.println(Arrays.toString(Dp));

//        Finding arr of the longest decreasing subsequence
        int[] DpReverse = new int[n];

        Arrays.fill(DpReverse,1);

        for (int i = n-1; i >= 0; i--) {
            for (int j = n-1; j > i; j--) {
                if (nums[j]<nums[i] && 1+DpReverse[j] > DpReverse[i]) {
                    DpReverse[i] = 1+DpReverse[j];
                }
            }
        }
        System.out.println(Arrays.toString(DpReverse));

        int max = 0;
        for (int i = 0; i < n; i++) {
            int longest = Dp[i] + DpReverse[i] - 1;
            max = Math.max(longest,max);
        }
        System.out.println(max);
    }
}
