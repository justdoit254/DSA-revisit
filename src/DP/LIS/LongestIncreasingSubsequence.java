package DP.LIS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] arr = {0,8,4,12,2,10,6,14,1,9,5,
     13,3,11,7,15};
//        int[] arr= {5,8,3,7,9,1};
//        int[] arr = {6,3,7,4,6,9};
        int n = arr.length;

//        Recursion
        System.out.println(sub(arr,-1,0));
//        System.out.println(sub(arr,0));

//        Tabulation
        int[][] dp = new int[n+1][n+1];
        for (int i = n; i >=0 ; i--) {            // m
            for (int j = i-1; j >= -1 ; j--) {      //n
                if (i==n) {
                    dp[j+1][i] = 0;
                }
                else if (j==-1 || arr[i]>arr[j]) {
                 dp[j+1][i] = Math.max(1 + dp[i+1][i+1], dp[j+1][i+1]);
                }
                else {
                    dp[j+1][i] = dp[j+1][i+1];
                }
            }
        }
        System.out.println(dp[0][0]);
//        for (int i = 0; i < n+1; i++) {
//            System.out.println(Arrays.toString(dp[i]));
//        }

//        Space optimized approach but used to print the LIS
        int max = 1;
        int[] Dp = new int[n];

        Arrays.fill(Dp,1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j]<arr[i] && 1+Dp[j] > Dp[i]) {
                    Dp[i] = 1+Dp[j];

                }
            }
            max = Math.max(max, Dp[i]);
        }
        System.out.println(max);    //int[] arr= {5,8,3,7,9,1};

    }

//    private static int sub(int[] arr, int index) {
//        int n = arr.length;
//        if (index >= n) {
//            return 0;
//        }
//        int len = 0;
//        for (int i = index +1; i < n; i++) {
//            int temp = 0;
//            if (arr[index] < arr[i]) {
//                temp = 1 + sub(arr,i);
//            }
//            len = Math.max(len, temp);
//        }
//        return len;
//    }

    private static int sub(int[] arr, int n, int m) {
        if (m>= arr.length) {
            return 0;
        }
        if (n == -1 || arr[m]>arr[n]) {
            return Math.max(1 + sub(arr, m, m+1), sub(arr, n, m+1));
        } else {
            return sub(arr, n, m+1);
        }
    }
}
