package Array.Medium;

import java.util.Arrays;

public class MakeZeros {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4},
                 {5, 6, 0, 7},
                 {8, 9, 4, 6},
                 {8, 4, 5, 2}};

        int row = matrix.length;
        int col = matrix[0].length;
        int[][] newMatrix = new int[row][col];

        for (int i = 0; i < row; i++) {
            newMatrix[i] = matrix[i].clone();
        }
//        for (int i = 0; i < row; i++) {
//            System.out.println(Arrays.toString(newMatrix[i]));
//        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (newMatrix[i][j] == 0) {
                    int newNum = 0;
                    if (i-1 >= 0) {
                        newNum += newMatrix[i-1][j];
                        matrix[i-1][j] = 0;
                    }
                    if (i+1 < row) {
                        newNum += newMatrix[i+1][j];
                        matrix[i+1][j] = 0;
                    }
                    if (j-1 >= 0) {
                        newNum += newMatrix[i][j-1];
                        matrix[i][j-1] = 0;
                    }
                    if (j+1 < col) {
                        newNum += newMatrix[i][j+1];
                        matrix[i][j+1] = 0;
                    }
                    matrix[i][j] = newNum;
                }
            }
        }
    }
}
