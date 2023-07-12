package Array.Medium;

import java.util.Arrays;

public class RotateBy90 {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3},
              {4, 5, 6},
              {7, 8, 9}};
        int row = matrix.length;
        int col = matrix[0].length;

//        Reverse Row
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col/2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][col-j-1];
                matrix[i][col-j-1] = temp;
            }
        }
        for (int i = 0; i < row; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }

//        Transpose
        for (int i = 0; i < row; i++) {
            for (int j = i; j < col; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int i = 0; i < row; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }

    }
}
