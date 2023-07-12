import java.util.*;

public class Rough {
    public static void main(String[] args) {
//        int[] val = {1,1};
//        int[] wt = {2,1};
//        int n = 2;
//        int w = 3;
//
//         int[][] dp = new int[n+1][w+1];
//        for (int i = 0; i < n+1; i++) {
//            Arrays.fill(dp[i],-1);
//        }
//        System.out.println(knapsack(n,w,val,wt,dp));
//        long n = 50000;
//        System.out.println(Math.pow((n * ((double)n + 1)) / 2,2));

//        String s = "bbaaaaabb";
//        int n = s.length();
//        int[] bBefore = new int[n];
//        int[] aAfter = new int[n];          //Reverse the string then find 'a' before then reverse the array to get 'a' after
//        int b = 0; int a = 0;
//        for (int i = 0; i < n; i++) {
//            bBefore[i] = b;
//            if (s.charAt(i)=='b') b++;
//        }
//        StringBuilder sb = new StringBuilder(s);
//        sb.reverse();
//        for (int i = 0; i < n; i++) {
//            aAfter[i] = a;
//            if (sb.charAt(i)=='a') a++;
//        }
//        System.out.println(Arrays.toString(bBefore));
//        System.out.println(Arrays.toString(aAfter));
//        int max_bBefore = 0;
//        for (int i = 0; i < n; i++) {
//            if (s.charAt(i)=='a' && bBefore[i]>max_bBefore) {
//                max_bBefore = bBefore[i];
//            }
//        }
//         int max_aAfter = 0;
//        for (int i = 0; i < n; i++) {
//            if (sb.charAt(i)=='b' && aAfter[i]>max_aAfter) {
//                max_aAfter = aAfter[i];
//            }
//        }
//        int ans = Math.min(max_bBefore, max_aAfter);
//        System.out.println(ans);

//        System.out.println(Math.ceil(17/3));



        ArrayList<ArrayList<Integer>> bigList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            ArrayList<Integer> list1 = new ArrayList<>();
            list1.add(2);
            list1.add(4);
            bigList.add(list1);
        }
//        ArrayList<Integer> list1 = new ArrayList<>();
//        list1.add(2);
//        list1.add(4);
//        ArrayList<Integer> list2 = new ArrayList<>();
//        list2.add(7);
//        list2.add(1);
//        bigList.add(list1);
//        bigList.add(list2);
        System.out.println(bigList);

      
    }
    private static int knapsack(int n, int w, int[] values, int[] weights, int[][] dp) {
        if (n==0) {
            return 0;
        }
        if (dp[n][w]!=-1) {
            return dp[n][w];
        }
        if (weights[n-1]>w) {
            dp[n][w] = knapsack(n-1, w, values, weights, dp);
            return dp[n][w];
        }
        dp[n][w] = Math.max(values[n-1]+knapsack(n, w-weights[n-1], values, weights,dp), knapsack(n-1, w, values, weights,dp));
        return dp[n][w];
    }
}
