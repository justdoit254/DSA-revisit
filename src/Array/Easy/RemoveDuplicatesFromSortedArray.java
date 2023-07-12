package Array.Easy;

import java.util.ArrayList;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] arr = {1,2,2,2,3};
        int n = arr.length;
        int j = 0;
        for (int i = 0; i < n-1; i++) {
            if (arr[i]!=arr[i+1]) {
                arr[j] = arr[i];
                j++;
            }
        }
        arr[j] = arr[n-1];
        System.out.println(j+1);

    }
}
