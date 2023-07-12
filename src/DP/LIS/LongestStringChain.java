package DP.LIS;

import java.util.Arrays;
import java.util.Comparator;

public class LongestStringChain {
    public static void main(String[] args) {
        String[] words = {"xbc", "pcxbcf", "xb", "cxbc", "pcxbc"};
//        String[] words = {"a","b","ba","bca","bda","bdca"};
        int  n = words.length;
//        Arrays.sort(words);
        Arrays.sort(words, Comparator.comparing(s->s.length()));
        System.out.println(Arrays.toString(words));


//          Recursion
        System.out.println(longestChain(words,-1,0));

        //        Tabulation
        int[][] dp = new int[n+1][n+1];
        for (int i = n; i >=0 ; i--) {            // m
            for (int j = i-1; j >= -1 ; j--) {      //n
                if (i==n) {
                    dp[j+1][i] = 0;
                }
                else if (j==-1 ||ispredecessor(words,i,j)) {
                 dp[j+1][i] = Math.max(1 + dp[i+1][i+1], dp[j+1][i+1]);
                }
                else {
                    dp[j+1][i] = dp[j+1][i+1];
                }
            }
        }
        System.out.println(dp[0][0]);

        //        Space optimized approach but used to print the LIS
        int max = 1;
        int[] Dp = new int[n];

        Arrays.fill(Dp,1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (ispredecessor(words,i,j) && 1+Dp[j] > Dp[i]) {
                    Dp[i] = 1+Dp[j];

                }
            }
            max = Math.max(max, Dp[i]);
        }
        System.out.println(max);

    }

    private static int longestChain(String[] arr, int n, int m) {
        if (m>= arr.length) {
            return 0;
        }
        if (n == -1 || ispredecessor(arr,m,n)) {
            return Math.max(1 + longestChain(arr, m, m+1), longestChain(arr, n, m+1));
        } else {
            return longestChain(arr, n, m+1);
        }
    }

    private static boolean ispredecessor(String[] arr, int n, int m) {
        int count = 0;
        int i = 0;
        int j = 0;
        String a = arr[n];
        String b = arr[m];
        if (a.length()-b.length() != 1) {
            return false;
        }
        while (i<a.length() && j<b.length()) {
            if (a.charAt(i)==b.charAt(j)) {
                i++;
                j++;
            } else {
                count++;
                i++;
            }
        }
        return count < 2;

//        OR
//        int first = 0, second = 0;
//        String s1 = arr[n];
//        String s2 = arr[m];
//        if (s1.length()-s2.length() != 1) {
//            return false;
//        }
//         while(first < s1.length()){
//        if(second < s2.length() && s1.charAt(first) == s2.charAt(second)){
//            first ++;
//            second ++;
//        }
//        else first ++;
//    }
//        if(first == s1.length() && second == s2.length()) return true;
//        else return false;
        }
}
