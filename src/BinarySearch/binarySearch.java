package BinarySearch;

public class binarySearch {
    public static void main(String[] args) {
        int[] arr = {11, 22, 33, 44, 55};
        int n = arr.length;
        int k = 44;
        int l = 0, h = n-1, m = 0;
        while (l<=h) {
            m = (l+h)/2;
            if (arr[m]==k) {
                System.out.println(m);
                return;
            }
            else if (arr[m] > k) {
                h = m-1;
            } else {
                l = m+1;
            }
        }
        System.out.println(-1);

    }
}
