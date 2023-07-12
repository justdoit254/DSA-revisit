package Array.Easy;

public class CheckIfArrayIsSorted {
    public static void main(String[] args) {
//        int[] arr = {5,6,7,8,9,10};
//        int n = arr.length;
//        boolean bol = true;
//        for (int i = 0; i < n-1; i++) {
//            if (arr[i+1]<arr[i]) {
//                bol = false;
//                break;
//            }
//        }
//        System.out.println(bol);

//        Leetcode problem
//        int[] nums = {3,4,5,1,2};
        int[] nums = {6,10,6};
//        int[] nums = {2,7,4,1,2,6,2};
        int len = nums.length;
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] > nums[(i+1)%len]) count++;
        }
        System.out.println(count<=1);
    }
}
