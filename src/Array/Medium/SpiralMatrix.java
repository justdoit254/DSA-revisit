package Array.Medium;

public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] m = {{1, 2, 3},
       {4, 5, 6},
       {7, 8, 9}};
        int row = m.length;
        int col = m[0].length;
        int k = 4;
        int minr = 0, minc = 0;
        int maxr = row-1, maxc = col-1;

        while (k > 0) {
            for (int i = minr, j = minc; j <= maxc && k>0; j++) {
                k--;
                System.out.println(m[i][j]);
                if (k==0) System.out.println(m[i][j]);
            }
            minr ++;
            for (int i = minr, j = maxc; i <= maxr && k>0; i++) {
                k--;
                System.out.println(m[i][j]);
                if (k==0) System.out.println(m[i][j]);
            }
            maxc --;
            for (int i = maxr, j = maxc; j >= minc && k>0; j--) {
                k--;
                System.out.println(m[i][j]);
                if (k==0) System.out.println(m[i][j]);
            }
            maxr --;
            for (int i = maxr, j = minc; i >= minr && k>0; i--) {
                k--;
                System.out.println(m[i][j]);
                if (k==0) System.out.println(m[i][j]);
            }
            minc ++;
        }
    }
}
