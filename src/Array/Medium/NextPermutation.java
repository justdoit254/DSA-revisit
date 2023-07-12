package Array.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NextPermutation {
    public static void main(String[] args) {
//        int[] arr = {4,5,2,6,7,3,1};
//        int[] arr = {1, 2, 3, 6, 5, 4};
//        int[] arr = {3,2,1};
        int[] arr = {5,1,1};
        int n = arr.length;
        int i = n-1;
        List<Integer> ls = new ArrayList<>();
        boolean bol = true;
        while (i>0) {
            if (arr[i-1] >= arr[i]) {
                i--;
            } else {
                bol = false;
               int idx = ceil(arr, i, arr[i-1]);
                swap(arr, i-1, idx);
                break;
            }
        }
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr, i,n);
        System.out.println(Arrays.toString(arr));
        for (int k : arr) {
            ls.add(k);
        }
        System.out.println(ls);
    }

    private static int ceil(int[] arr, int i, int num) {
        int ans = Integer.MAX_VALUE;
        int idx = -1;
        while (i< arr.length) {
            if (arr[i]>num && ans>arr[i]) {
                ans = arr[i];
                idx = i;
            }
            i++;
        }
        return idx;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
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

