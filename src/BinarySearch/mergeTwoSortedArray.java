package BinarySearch;

public class mergeTwoSortedArray {
    public static void main(String[] args) {
        int[] a = {1,5,9};
        int[] b = {2,3,6,7};
        int n = a.length;
        int m = b.length;
        int k = n+m;
        int[] arr = new int[k];
        int el1 = 0, el2 = 0;
        double ans = 0;
        int count = 0, i=0, j=0, l=0;
        while (i<n && j<m) {
            if (a[i]<b[j]) {
                arr[l] = a[i];
                l++; i++;
            } else {
                arr[l] = b[j];
                l++; j++;
            }
        }
        while (i<n) {
            arr[l] = a[i];
            l++; i++;
        }
        while (j<m) {
            arr[l] = b[j];
            l++; j++;
        }
        if (k%2 != 0) {
            ans = arr[k/2];
        } else {
            ans = (double)((double)arr[k/2] + arr[(k/2)-1])/2;
        }
        System.out.println(ans);

    }
}
