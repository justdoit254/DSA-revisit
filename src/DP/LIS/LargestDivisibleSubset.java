package DP.LIS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class LargestDivisibleSubset {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        Arrays.sort(arr);
         int n = arr.length;


        int[] Dp = new int[n];
        int[] backTrack = new int[n];
        Arrays.fill(Dp,1);
        for (int i = 0; i < n; i++) {
            backTrack[i] = i;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i]%arr[j]==0 && 1+Dp[j] > Dp[i]) {
                    Dp[i] = 1+Dp[j];
                    backTrack[i] = j;
                }
            }
        }
        int lastVal = -1;
        int lastIndex =-1;

        for(int i=0; i<=n-1; i++){
            if(Dp[i] > lastVal){
                lastVal = Dp[i];
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
