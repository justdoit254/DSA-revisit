package BinarySearch;

public class searchIn2dMatrix {
    public static void main(String[] args) {
        int[][] arr = {{3,30,38},{44,52,54},{57,60,69}};
        int r = arr.length;
        int k = 62;
        int isPresent = 0;
        for (int i = 0; i < r; i++) {
            int c = arr[0].length;
            if (arr[i][c-1]==k) {
                isPresent = 1;
                break;
            }
            if (arr[i][c-1]>k) {
                int l = 0, h = c-1, m = 0;
                while (l<=h) {
                    m = (l+h)/2;
                    if (arr[i][m]==k) {
                        isPresent = 1;
                        break;
                    }
                    else if (arr[i][m] > k) {
                        h = m-1;
                    } else {
                        l = m+1;
                    }
                }
            }
        }
        System.out.println(isPresent);
    }
}
