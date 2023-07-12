package BinarySearch;

public class smallestDivisor {
    public static void main(String[] args) {
        int[] arr = {1,2,4,9};
        int n = arr.length;
        int H = 6;
        int l = 1;
        int h = Integer.MIN_VALUE;
        for (int j : arr) {
            if (j > h) h = j;
        }

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
            //  else {
            //     h = m-1;
            // }
        }
//        return l;
        System.out.println(l);
    }
}
