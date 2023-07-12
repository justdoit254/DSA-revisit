package Array.Easy;

import java.util.Arrays;

public class MoveZerosToTheEnd {
    public static void main(String[] args) {
        int[] arr = {3,5,0,0,4};
        int n = arr.length;
        int i = 0;
//        for (int j = 1; j < n; j++) {
//            if (arr[i]!=0) {
//                i++;
//            }
//            if (arr[j]!=0 && arr[i]==0) {
//                swap(arr,i,j);
//            }
//        }

//        Method 2
//        int count = 0;
//        for (int j = 0; j < n; j++) {
//            if (arr[j]!=0) {
//                arr[count] = arr[j];
//                count++;
//            }
//        }
//        while (count<n) {
//            arr[count] = 0;
//            count++;
//        }

        System.out.println(Arrays.toString(arr));

    }
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
