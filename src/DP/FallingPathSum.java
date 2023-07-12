package DP;

public class FallingPathSum {
    public static void main(String[] args) {
        int[][] matrix = {{2, 2},
          {2, 2}};

        int n = matrix.length;          //NO. of rows
        int m = matrix[0].length;       //No. of columns
        int ans = Integer.MIN_VALUE;        //For max falling sum

        for (int i = 0; i < m; i++) {
//            Recursion
            int path = findSum(n-1,i,matrix);
            ans = Math.max(ans,path);
        }
        System.out.println(ans);

//        Tabulation
        int[][] dp = new int[n][m];
        int anst = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            dp[0][i] = matrix[0][i];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int up = dp[i-1][j] + matrix[i][j];
                int left = 0;
                if (j>0) {
                    left = dp[i-1][j-1] + matrix[i][j];
                } else {
                    left += Integer.MIN_VALUE;
                }
                int right = 0;
                if (j<matrix[0].length-1) {
                    right = dp[i-1][j+1] + matrix[i][j];
                } else {
                    right += Integer.MIN_VALUE;
                }
                dp[i][j] = Math.max(up,Math.max(left,right));
            }
        }
        for (int i = 0; i < m; i++) {
            anst = Math.max(anst,dp[n-1][i]);
        }
        System.out.println(anst);
    }

    private static int findSum(int i, int j, int[][] grid) {
         if (j<0 || i<0 || j>=grid[0].length) {
            return Integer.MIN_VALUE;
        }
         if (i==0) {
            return grid[i][j];
        }
             int path1 = findSum(i-1, j-1, grid)+grid[i][j];      //Left diagonal
             int path2 = findSum(i-1, j, grid)+grid[i][j];          //Bottom
             int path3 = findSum(i-1, j+1, grid)+grid[i][j];     //Right diagonal

        return Math.max(path1,Math.max(path2,path3));
    }
}
