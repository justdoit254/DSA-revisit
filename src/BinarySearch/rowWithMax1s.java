package BinarySearch;

public class rowWithMax1s {
    public static void main(String[] args) {
        int[][] arr = {{0, 1, 1, 1},
           {0, 0, 1, 1},
           {1, 1, 1, 1},
           {0, 0, 0, 0}};
        int r = arr.length;
        int c = arr[0].length;
        int ans = 0;
        int i = 0, j = c-1;
        while (i<r && j>=0) {
            if (arr[i][j]==1) {
                j--;
            } else {
                i++;
            }
        }
        if (j<0) ans = i;
        if (i>=r) ans = r-j-1;
        System.out.println(ans);

    }
}
