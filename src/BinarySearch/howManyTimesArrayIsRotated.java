package BinarySearch;

public class howManyTimesArrayIsRotated {
    public static void main(String[] args) {
        int[] arr = {5,1,2,3,4};
        int n = arr.length;
        int k = 0;
        int l = 0, h = n-1, m = 0;
        while (l<=h) {
            m = (l+h)/2;
            if (m>=1 &&arr[m-1]>arr[m]) {
                k = m;
                System.out.println(k);
                return;
            }
            if (m<n-1 && arr[m]>arr[m+1]) {
                k = m+1;
                System.out.println(k);
                return;
            }
            else if (arr[l] > arr[m]) {
                if (arr[l] > arr[h]) h = m-1;
                else l = m+1;
            } else {
                if (arr[l] < arr[h]) h = m-1;
                else l = m+1;
            }
        }
        System.out.println(k);
    }
}
