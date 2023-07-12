package Array.Easy;

public class SecondLargestElement {
    public static void main(String[] args) {
        int[] arr = {12, 35, 1, 10, 34, 1};
        int n = arr.length;

        if (n<2) {
            System.out.println(-1);
        }
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;

        for (int el : arr) {
            if (el>max1) {
                max2 = max1;
                max1 = el;
            }
            else if (el>max2 && el != max1) {
                max2 = el;
            }
        }
        if (max2==Integer.MIN_VALUE) max2 = -1;
        System.out.println(max2);
    }
}
