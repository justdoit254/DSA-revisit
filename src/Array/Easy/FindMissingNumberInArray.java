package Array.Easy;

public class FindMissingNumberInArray {
    public static void main(String[] args) {
        int[] arr = {2, 5, 3, 1};
        int n = 5;
        int sum = n*(n+1) / 2;
        int temp = 0;
        for (int el : arr) {
            temp += el;
        }
        System.out.println(sum-temp);
    }
}
