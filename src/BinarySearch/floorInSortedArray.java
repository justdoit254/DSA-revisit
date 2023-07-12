package BinarySearch;

public class floorInSortedArray {
    public static void main(String[] args) {
        int[] arr = {1,2,8,10,11,12,19};
        int n = arr.length;
        int k = 0;
        int ans = Integer.MIN_VALUE;
        int idx = -1;
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
                if (arr[m]>ans) {
                    ans = arr[m];
                    idx = m;
                }
                l = m+1;
            }
        }
        System.out.println(idx);
    }
}
