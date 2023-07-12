package DP;

public class UniquePaths {
    public static void main(String[] args) {
        int a = 2;
        int b = 2;

//        Recursive Solution
        System.out.println(paths(a,b));

//        Tabulation
        int[][] dp = new int[a][b];
//        for (int i = 0; i < a; i++) {
//            dp[i][0] = 1;
//        }
//        for (int i = 0; i < b; i++) {
//            dp[0][i] = 1;
//        }
//        for (int i = 1; i < a; i++) {
//            for (int j = 1; j < b; j++) {
//                dp[i][j] = dp[i-1][j] + dp[i][j-1];
//            }
//        }
//        System.out.println(dp[a-1][b-1]);

//        Much Cleaner Tabulation
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
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

    private static int paths(int a, int b) {
        if (a==1 && b==1) {     //assuming 1-indexing, if considering 0 indexing then it would be a==0 && b==0
            return 1;
        }
        int path1 = 0;
        int path2 = 0;
        if (a>1) {
             path1 = paths(a-1,b);
        }
         if (b>1) {
             path2 = paths(a,b-1);
        }
        return (path1+path2);
    }
}
