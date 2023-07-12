package Array.Easy;

import java.util.Arrays;

public class LeftRotation {
    public static void main(String[] args) {
        int k = 3;
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int n = arr.length;
        k = k%n;
        int[] ans = new int[n];

//        Traversing old array and filling new array with random indexes
//        for (int i = 0; i < n; i++) {
//            int el = arr[i];
//            if (i<k) ans[n-k+i] = el;
//            else ans[i-k] = el;
//        }

//        Traversing new array and filling it with starting index
//        for (int i = 0; i < n; i++) {
//            ans[i] = arr[(i+k)%n];
//        }
//        arr = Arrays.copyOf(ans, n);
//        System.out.println(Arrays.toString(arr));

//        Method 2 by reversing the array 3 times
//        1. Reverse 0 to k-1
//        2. Reverse k to n-1
//        3. Reverse 0 to n-1

        reverse(arr,0,k-1);
        System.out.println(Arrays.toString(arr));
        reverse(arr,k,n-1);
        System.out.println(Arrays.toString(arr));
        reverse(arr,0,n-1);
        System.out.println(Arrays.toString(arr));

    }

    private static void reverse(int[] arr, int start, int end) {
        while (start<end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
