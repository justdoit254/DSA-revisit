package Array.Easy;

public class MaximizeNumberOfOnes {
    public static void main(String[] args) {
        int[] arr = {1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1};
//        int[] arr = {1,0,1,1,1,1,1,0,0,1,1,0,1,1,0};
        int p = 1;
        System.out.println(arr[p++]);
        System.out.println(arr[p++]);
        System.out.println(arr[p++]);
        int n = arr.length;
        int m = 1;
        int x = 0, y = 0;
        int sum = 0, max = 0;
        for (int idx = 0; idx < n; idx++) {     //idx is denoting the first 0
            if (arr[idx]==0) {
                y = idx;
                break;
            }
        }
        for (int ptr = 0; ptr < n; ptr++) {
            if (arr[ptr]==1) {
                sum++;
            } else {
                if (m>0) {
                    sum++;
                    m--;
                } else {
                    if (y<n-1) {
                        y++;
                        while (y<n-1 && arr[y]!=0) {
                            y++;
                        }
                    }
                    x++;
                    while (x<=y && arr[x]!=0) {
                        x++;
                        sum--;
                    }
                }
            }
            max = Math.max(max,sum);
        }
        System.out.println(max);
    }
}
