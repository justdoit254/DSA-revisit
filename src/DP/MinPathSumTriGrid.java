package DP;

import java.util.ArrayList;
import java.util.List;

public class MinPathSumTriGrid {
    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        List<Integer> l1 = new ArrayList<>();
        l1.add(4);
        list.add(l1);
        List<Integer> l2 = new ArrayList<>();
        l2.add(3);
        l2.add(4);
        list.add(l2);
        List<Integer> l3 = new ArrayList<>();
        l3.add(6);
        l3.add(5);
        l3.add(7);
        list.add(l3);
        List<Integer> l4 = new ArrayList<>();
        l4.add(4);
        l4.add(1);
        l4.add(8);
        l4.add(3);
        list.add(l4);

        int size = list.size();
        int maxLen = list.get(size-1).size();

//        Recursive solution
        System.out.println(find(0,0,size-1,list));

//        Tabulation solution
        int[][] dp = new int[size][maxLen];
        for (int i = 0; i < maxLen; i++) {
            dp[size-1][i] = list.get(size-1).get(i);
        }
        for (int i = size-2; i >=0 ; i--) {
            for (int j = list.get(i).size()-1; j >=0 ; j--) {
                int path1 = list.get(i).get(j) + dp[i+1][j];
                int path2 = list.get(i).get(j) + dp[i+1][j+1];
                dp[i][j] = Math.min(path1,path2);
            }
        }
    }

    private static int find(int m, int n, int size, List<List<Integer>> list) {
        if (m==size) {
            return list.get(m).get(n);
        }
        if (m>size) {
            return Integer.MAX_VALUE;
        }

        int path1 = find(m+1, n, size, list);
        int path2 = find(m+1, n+1, size, list);
        return Math.min(path1,path2)+list.get(m).get(n);
    }
}
