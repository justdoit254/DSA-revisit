package Sorting;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
//         int[] arr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        int[] arr = { 4, 1, 3, 9, 7};
        int n = arr.length;

//        for (int i = 1; i < n; i++) {
//            for (int j = i-1; j >=0 ; j--) {
//                if (arr[j]>arr[j+1]) {
//                    swap(arr,j,j+1);
//                }
//            }
//        }
//        System.out.println(Arrays.toString(arr));

//        Recursive Solution
        insertionSort(arr,n-1);
        System.out.println(Arrays.toString(arr));
    }

    private static void insertionSort(int[] arr, int n) {
        if (n<=0) return;
        insertionSort(arr,n-1);
        for (int i = n-1; i >=0 ; i--) {
            if (arr[i]>arr[i+1]) {
                swap(arr,i,i+1);
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
