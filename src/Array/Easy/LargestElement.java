package Array.Easy;

import java.util.Arrays;

public class LargestElement {
    public static void main(String[] args) {
        int[] arr = {1, 8, 7, 56, 90};
        int n = arr.length;

//        Method 1
        Arrays.sort(arr);
        int ans = arr[n-1];
        System.out.println(ans);

//        Method 2
        int max = Integer.MIN_VALUE;
        for (int el : arr) {
            if (el>max) max = el;
        }
        System.out.println(max);
    }
}
