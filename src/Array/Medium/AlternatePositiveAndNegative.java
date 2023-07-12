package Array.Medium;

import java.util.Arrays;

public class AlternatePositiveAndNegative {
    public static void main(String[] args) {
//        int[] arr = {9, 4, -2, -1, 5, 0, -5, -3, 2};
        int[] arr = {-5, -2, 5, 2, 4, 7, 1, 8, 0, -8};
        int n = arr.length;
        int[] temp = new int[n];
        int l = 0, r = n-1;
        for (int i = 0; i < n; i++) {
            if (arr[i]>=0) {
                temp[l] = arr[i];
                l++;        //storing positive number in front
            } else {
                temp[r] = arr[i];
                r--;       //storing negative number in back
            }
        }
        System.out.println(Arrays.toString(temp));
        l = 0; r = n-1;
        for (int i = 0; i < n; i++) {
            if (i%2 == 0) {
                if (temp[l] >= 0) {
                     arr[i] = temp[l];
                     l++;
                } else {
                    arr[i] = temp[r];
                    r--;
                }
            }
            if (i%2 == 1) {
                if (temp[r]<0) {
                    arr[i] = temp[r];
                    r--;
                } else {
                    arr[i] = temp[l];
                    l++;
                }
            }
        }
        System.out.println(Arrays.toString(arr));

    }
}
