package Array.Medium;

import java.lang.reflect.Array;
import java.util.Arrays;

public class SortAnArrayOf012 {
    public static void main(String[] args) {
        int[] a = {0, 2, 1, 2, 0};
        int n = a.length;
//        int  zeros = 0, ones = 0;
//        for (int el : a) {
//            if (el==1) ones++;
//            if (el==0) zeros++;
//        }
//        for (int i = 0; i < zeros; i++) {
//            a[i] = 0;
//        }
//        for (int i = zeros; i < ones+zeros; i++) {
//            a[i] = 1;
//        }
//        for (int i = ones+zeros; i < n; i++) {
//            a[i] = 2;
//        }
//        System.out.println(Arrays.toString(a));

//        Dutch National FLag Algo
        int l = 0, m = 0, h = n-1;
        while (m<=h) {
            if (a[m] == 0) {
                int temp = a[m];
                a[m] = a[l];
                a[l] = temp;
                l++;
                m++;
            } else if (a[m] == 1) {
                m++;
            } else {
                int temp = a[h];
                a[h] = a[m];
                a[m] = temp;
                h--;
            }
        }
        System.out.println(Arrays.toString(a));
    }
}
