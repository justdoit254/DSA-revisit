package DP.Partition;

import java.util.*;

public class MinCostToCutStick {
    public static void main(String[] args) {
        int[] cuts = {3,5,1,4};
        int n = 7;
        int len = cuts.length;
       ArrayList<Integer> list = new ArrayList<>();
       list.add(0);
        for (int el : cuts) {
            list.add(el);
        }
        list.add(n);
        Collections.sort(list);
        System.out.println(list);

        System.out.println(minCost(1,len,list));

//        Tabulation (Bottom-Up)
        int[][] dp = new int[len+2][len+2];
         for (int i = len; i > 0 ; i--) {
            for (int j = 1; j <= len ; j++) {
                if (i>j) continue;
                int min = Integer.MAX_VALUE;
               for (int idx = i; idx <= j ; idx++) {
                    int temp = list.get(j+1) - list.get(i-1) + dp[i][idx-1] + dp[idx+1][j];
                    min = Math.min(min,temp);
               }
            dp[i][j] = min;
            }
        }
        System.out.println(dp[1][len]);

    }

    private static int minCost(int s, int e, ArrayList<Integer> list) {
        if (s>e) return 0;
        int min = Integer.MAX_VALUE;
        for (int idx = s; idx <= e ; idx++) {
            int temp = list.get(e+1) - list.get(s-1) + minCost(s,idx-1,list) + minCost(idx+1,e,list);
            min = Math.min(min,temp);
        }
        return min;
    }
}
