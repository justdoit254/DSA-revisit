package Array.Easy;

public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        int[] nums = {1,0,1,1,0,1};
        int n = nums.length;
        int count = 0;
        int max = 0;
        for (int num : nums) {
            if (num == 1) {
                count++;
            } else {
                count = 0;
            }
            max = Math.max(max, count);
        }
        System.out.println(max);
    }
}
