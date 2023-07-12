package DP.String;

import java.util.Arrays;

public class MinInsertionsToMakeStringPalindrome {
    public static void main(String[] args) {
        String str = "abcd";
        int n = str.length();

//        Finding Longest Palindrome Sequence
        StringBuilder sb = new StringBuilder(str);
        StringBuilder reversed_s = sb.reverse();
        String reverse_s = reversed_s.toString();

        int[][] dp = new int[n+1][n +1];
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < n +1; j++) {
                if (i==0 || j==0) {
                    dp[i][j] = 0;
                }
                else if (str.charAt(i-1) == reverse_s.charAt(j-1)) {
                    dp[i][j] = 1+dp[i-1][j-1];
                }
                else {
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        int len = (dp[n][n]);
        System.out.println(len);

//        Answer = n - len
        System.out.println(n-len);

//        Recursive Proper Concept
        char[] arr = str.toCharArray();
        System.out.println(minInsertion(arr,0,n-1));

//        Tabulation
//        (0,1) (1,2) (2,3)
//        (0,2) (1,3)
//        (0,3)
        int[][] dpT = new int[n][n];
        for (int i = 0; i < n-1; i++) {
            for (int l = 0, h=i+1; h < n; l++, h++) {
                if (l>h) dpT[l][h] = Integer.MAX_VALUE;
                if (l==h) dpT[l][h] = 0;
                if (l==h-1) dpT[l][h] = (arr[l]==arr[h] ? 0 : 1);
                else {
                    if (arr[l]==arr[h]) dpT[l][h] = dpT[l+1][h-1];
                    else dpT[l][h] = Math.min(dpT[l+1][h], dpT[l][h-1]) + 1;
                }
            }
        }
        System.out.println(dpT[0][n-1]);
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(dpT[i]));
        }
    }

    private static int minInsertion(char[] arr, int l, int h) {
        if (l>h) return Integer.MAX_VALUE;          //Not necessary
        if (l==h) return 0;
        if (l==h-1) return (arr[l]==arr[h] ? 0 : 1);

        return (arr[l]==arr[h]) ?
                minInsertion(arr, l+1, h-1) :
                (Math.min(minInsertion(arr, l+1, h),minInsertion(arr, l, h-1))+1);
    }
}
