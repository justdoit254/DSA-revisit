package DP;

public class UniquePaths2 {
    public static void main(String[] args) {
        int[][] obstaclesGrid = {{0,1},{0,0}};
        int a = obstaclesGrid.length;
        int b = obstaclesGrid[0].length;

//        Recursive Solution
//        System.out.println(paths(a-1,b-1,obstaclesGrid));

//        Tabulation
        int[][] dp = new int[a][b];
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                if (obstaclesGrid[i][j]==1) {
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

     private static int paths(int a, int b, int[][]obstaclesGrid) {
        if (a>=0 && b>=0 && obstaclesGrid[a][b]==1) {
            return 0;
        }
        if (a==0 && b==0) {     //assuming 1-indexing, if considering 0 indexing then it would be a==0 && b==0
            return 1;
        }
        if (a<0 || b<0) {
            return 0;
        }
        int path1 = 0;
        int path2 = 0;
        if (a-1 >= 0) {       //1 is obstacle
             path1 = paths(a-1,b,obstaclesGrid);
        }
         if (b-1 >= 0) {
             path2 = paths(a,b-1, obstaclesGrid);
        }
        return (path1+path2);
    }
}
