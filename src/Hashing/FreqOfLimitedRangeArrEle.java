package Hashing;

import java.util.Arrays;

public class FreqOfLimitedRangeArrEle {
    public static void main(String[] args) {
//        Can be done same as CountingFreqOfElementsOfArr

//        Other Solution
        int[] arr = {2,3,2,3,5};
        int n = arr.length;
        int p = 5;

        int i = 0;
        while (i<n) {
            if (arr[i]<=0) {
                i++;
            } else if (arr[i]>n) {
                arr[i] = 0;
                i++;
            } else {
                int idx = arr[i]-1;
                if (arr[idx]>=0) {
                    arr[i] = arr[idx];
                    arr[idx] = -1;
                } else {
                    arr[i] = 0;
                    arr[idx] = -(Math.abs(arr[idx])+1);
                }
            }
        }
        for (int j = 0; j < n; j++) {
            arr[j] = Math.abs(arr[j]);
        }
        System.out.println(Arrays.toString(arr));
    }
}
