package DP.LIS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class PrintingLongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] arr = {0,8,4,12,2,10,6,14,1,9,5,
     13,3,11,7,15};
//        int[] arr= {5,8,3,7,9,1};
//        int[] arr = {6,3,7,4,6,9};
        int n = arr.length;

//         Space optimized approach but used to print the LIS
        int max = 1;
        int[] Dp = new int[n];
        int[] backTrack = new int[n];
        Arrays.fill(Dp,1);
        for (int i = 0; i < n; i++) {
            backTrack[i] = i;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j]<arr[i] && 1+Dp[j] > Dp[i]) {
                    Dp[i] = 1+Dp[j];
                    backTrack[i] = j;
                }
            }
            max = Math.max(max, Dp[i]);
        }
        System.out.println(max);    //int[] arr= {5,8,3,7,9,1};
        int ans = -1;
        int lastIndex =-1;

        for(int i=0; i<=n-1; i++){
            if(Dp[i] > ans){
                ans = Dp[i];
                lastIndex = i;
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        list.add(arr[lastIndex]);
         while(backTrack[lastIndex] != lastIndex){ // till not reach the initialization value
        lastIndex = backTrack[lastIndex];
        list.add(arr[lastIndex]);
    }
        System.out.println(Arrays.toString(backTrack));
        Collections.reverse(list);
        System.out.println(list);
    }
}
