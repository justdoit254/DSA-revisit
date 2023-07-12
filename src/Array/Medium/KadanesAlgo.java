package Array.Medium;

public class KadanesAlgo {
    public static void main(String[] args) {
        int[] arr = {1,2,3,-2,5};
        int n = arr.length;
        long sum = arr[0], ans = arr[0];

        for (int i = 1; i < n; i++) {
            if (sum + arr[i] >= arr[i]) {
                sum += arr[i];
            } else {
                sum = arr[i];
            }
            ans = Math.max(sum, ans);
        }
        System.out.println(ans);
    }
}
