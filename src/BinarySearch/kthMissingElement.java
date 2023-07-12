package BinarySearch;

public class kthMissingElement {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 5, 7};
        int n = arr.length;
        int k = 2, ans=-1;
        for (int i = 0; i < n-1; i++) {
            if (arr[i]+1!=arr[i+1]) {
                int diff = arr[i+1] - arr[i] - 1;
                if (diff<k) {
                    k = k-diff;
                } else {
                    ans = arr[i];
                    while (k>0) {
                        ans = ans + 1;
                        k--;
                    }
                    System.out.println(ans);
                    break;
                }
            }
        }
        if (ans==-1) System.out.println(-1);
    }
}
