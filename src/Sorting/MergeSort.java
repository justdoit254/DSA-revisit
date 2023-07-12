package Sorting;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
           int[] arr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
            int n = arr.length;

            mergeSort(arr,0,n-1);
        System.out.println(Arrays.toString(arr));
    }

    private static void mergeSort(int[] arr, int l, int r) {
        if (l==r) {
            return;
        }
        int mid = (l+r)/2;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid+1, r);
        merge(arr,l,mid,r);
    }

    private static void merge(int[] arr, int l, int m, int r) {
        int i = l;
        int j = m+1;
        int idx = 0;
        int[] temp = new int[r+1-l];
        while (i<m+1 && j<r+1) {
           if (arr[i]<arr[j]) {
               temp[idx] = arr[i];
               i++;
           } else {
               temp[idx] = arr[j];
               j++;
           }
           idx++;
        }
        while (i<m+1) {
            temp[idx] = arr[i];
            i++; idx++;
        }
        while (j<r+1) {
            temp[idx] = arr[j];
            j++; idx++;
        }
        System.arraycopy(temp,0,arr,l,r-l+1);
    }

}
