package Sorting;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
            int n = arr.length;

            quickSort(arr,0,n-1);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int s, int e) {
        if (s>=e) return;
        int partition = partition(arr,s,e);
        quickSort(arr, 0, partition-2);
        quickSort(arr, partition, e);
    }

    private static int partition(int[] arr, int s, int e) {
        int pivot = arr[e];
        int i = s, j = s;
        while (i<=e) {
            if (arr[i]>pivot) i++;
            else {
                swap(arr,i,j);
                i++; j++;
            }
        }
        return j;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
