package BinarySearch;

public class peakElement {
    public static void main(String[] args) {
//        int[] arr = {1,2,3};
        int[] arr = {15};
        int n = arr.length;
//        if (n==1) {
//            System.out.println(1);
//            return;
//        }
//        int peak = 0, idx = 0;
//        if (arr[0]>=arr[1]) {
//            peak = arr[0];
//        }
//        for (int i = 1; i < n-1; i++) {
//            if (arr[i]>=arr[i-1] && arr[i]>=arr[i+1]) {
//                peak = arr[i];
//                idx = i;
//            }
//        }
//
//        if (peak==0 && arr[n-1]>=arr[n-2]) {
//            peak = arr[n-1];
//            idx = n-1;
//        }
//        System.out.println(idx);

         if (n==1)  {
             System.out.println(0);
             return;
         }
       int start = 0, end = n - 1;

    while (start < end) {
      int m = (start + end) / 2;

      if ((m == 0 || arr[m]>=arr[m-1]) && (m==n-1 || arr[m]>=arr[m+1])) {
          System.out.println(m);
          return;
      }

    //   if (arr[mid] >= arr[mid - 1] && arr[mid] >= arr[mid + 1])
    //     return arr[mid];

      if (m>0 && arr[m] < arr[m - 1])
        end = m - 1;

      else
        start = m + 1;
    }

        System.out.println(start);
    }
}
