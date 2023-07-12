package Sorting;

import java.util.Arrays;
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        int n = arr.length;

//        To sort from the beginning
//         for (int i = 0; i < n; i++) {
//            for (int j = i+1; j < n; j++) {
//                if (arr[i]>arr[j]) {
//                    swap(arr,i,j);
//                }
//            }
//        }

//         To sort from the end
//         for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n-i-1; j++) {
//                if (arr[j]>arr[j+1]) {
//                    swap(arr,j,j+1);
//                }
//            }
//        }
//        System.out.println(Arrays.toString(arr));

//         Recursive Solution
        bubbleSort(arr,n);
        System.out.println(Arrays.toString(arr));
    }

    private static void bubbleSort(int[] arr, int n) {
        if (n==1) return;
        int count = 0;
        for (int i = 0; i < n-1; i++) {
            if (arr[i]>arr[i+1]) {
                swap(arr,i,i+1);
                count += 1;
            }
        }
        if (count==0) return;
        bubbleSort(arr,n-1);
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
