package BinarySearch;

import java.sql.Array;

public class kokoEatingBanana {
    public static void main(String[] args) {
        int[] arr = {3, 6, 7, 11};
        int n = arr.length;
        int H = 8;

       int sum = 0;
         for (int k : arr) {
           sum += k;
        }
        int l = sum/H;
         int h = Integer.MIN_VALUE;
        for (int j : arr) {
            if (j > h) h = j;
        }

        int ans = h;


        while (l<h) {
            int m = l+(h-l)/2;
            int time = 0;
            for (int i = 0; i < n; i++) {
                if (arr[i]%m ==0) time += arr[i]/m;
                else time += arr[i]/m + 1;
            }
            if (time<=H) {
                h = m;
            } else if (time>H) {
                l = m+1;
            }
        }
        System.out.println(l);
//        System.out.println(Integer.MAX_VALUE);

    }
}
