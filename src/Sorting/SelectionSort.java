package Sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            int min = arr[i];
            int index = i;
            for (int j = i; j < n; j++) {
                if (min>arr[j]){
                    min = arr[j];
                    index = j;
                }
            }
            swap(arr,i,index);
        }
        System.out.println(Arrays.toString(arr));
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
