package Array.Medium;

import java.util.Arrays;

public class LongestConsecutiveSubsequence {
    public static void main(String[] args) {
        int[] arr = {2,6,1,9,4,5,3};
        int n = arr.length;
//        int max = 1, count = 1;
//        Arrays.sort(arr);
//
//        for (int i = 0; i < n-1; i++) {
//            if (arr[i+1] == arr[i]+1) {
//                count++;
//                max = Math.max(max, count);
//            } else if (arr[i] == arr[i+1]) {
//                continue;
//            } else {
//                count = 1;
//            }
//        }
//        System.out.println(max);

//        Second approach
        int[] temp = new int[1000001];
        int maxNum = 0;
        int ans = 0, count = 0;
        for (int j : arr) {
            temp[j] = temp[j] + 1;
            maxNum = Math.max(j, maxNum);
        }
        for (int i = 0; i <= maxNum; i++) {
            if (temp[i] > 0) {
                count++;
            } else {
                ans = Math.max(ans, count);
                count = 0;
            }
        }
        ans = Math.max(ans, count);
        System.out.println(ans);
    }
}
