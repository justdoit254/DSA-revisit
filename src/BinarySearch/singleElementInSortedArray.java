package BinarySearch;

public class singleElementInSortedArray {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 3, 3, 4, 50, 50, 65, 65};
        int n = arr.length;
        int l=0, h=n-1,  m=0;
        while(l<=h ) {
            m = (l + h) / 2;
            if (m==0) {
                System.out.println(arr[m]);
                return;
                // return;
            }
            if (m==n-1) {
                System.out.println(arr[m]);
                return;
                // return;
            }
            if (arr[m]!=arr[m+1] && arr[m]!=arr[m-1]) {
                System.out.println(arr[m]);
               return;
                // return;
            } else if (arr[m]==arr[m-1]) {
                if ((m+1) % 2 == 0) l=m+1;
                else h = m-1;
            } else {
                if ((n+m) % 2 == 0) h = m-1;
                else l = m+1;
            }
        }
    }
}
