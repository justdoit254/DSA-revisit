package BinarySearch;

public class squareRoot {
    public static void main(String[] args) {
        int x = 6;
//        System.out.println(Math.floor(Math.sqrt(5)));

        int l = 0, h = x/2, m = 0, ans=0;
        while (l<=h) {
            m = (l+h)/2;
            if (m*m == x) {
                System.out.println(m);
                return;
            }
            else if (m*m > x) {
                h = m-1;
            } else {
                l = m+1;
                ans = m;
            }
        }
        System.out.println(-1);
        System.out.println(ans);
    }
}
