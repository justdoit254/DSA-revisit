package DP;

import java.util.Arrays;

public class MinPathSumInGrid {
    public static void main(String[] args) {
        int[][] grid = {{9,4,9,9},{6,7,6,4},
{8,3,3,7},{7,4,9,10}};

        int m = grid.length;
        int n = grid[0].length;
//        int[][] flag = new int[m][n];
//        for (int i = 0; i < m; i++) {
//            Arrays.fill(flag[i],-1);
//        }
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                System.out.print(flag[i][j] + " ");
//            }
//            System.out.println();
//        }

//        Recursive solution
        System.out.println(findMin(m-1,n-1,grid));

//        Tabulation
         int a = grid.length;
        int b = grid[0].length;
         int[][] dp = new int[a][b];
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                if (grid[i][j]==1) {
                    dp[i][j] = 0;
                    continue;
                }

                if (i==0 && j==0) {
                    dp[i][j] = 1;
                    continue;
                }
                int path1 = 0;
                int path2 = 0;
                if (i>0) {
                    path1 = dp[i-1][j];
                }
                if (j>0) {
                    path2 = dp[i][j-1];
                }
                dp[i][j] = path1 + path2;
            }
        }
        System.out.println(dp[a-1][b-1]);
    }

    private static int findMin(int m, int n, int[][] grid) {
        if (m==0 && n==0) {
            return grid[m][n];
        }
        if (m<0 || n<0) {
            return Integer.MAX_VALUE;
        }
        int path1 = 0;
        int path2 = 0;

             path1 = findMin(m-1, n, grid)+grid[m][n];


              path2 = findMin(m, n-1, grid)+grid[m][n];


        return Math.min(path1,path2);

    }
}
