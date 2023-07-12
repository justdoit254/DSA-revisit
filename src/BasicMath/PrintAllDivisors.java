package BasicMath;

public class PrintAllDivisors {
    public static void main(String[] args) {
        int n = 4;
        int ans = 0;

//        Time complexity O(n^2)
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= (i); j++) {
                if (i%j == 0) {
                    ans += j;
                }
            }
        }
        System.out.println(ans);

//        Time complexity O(n)
        int ans1 = 0;
        for (int i = 1; i <= n; i++) {
            ans1 += (n/i)*i;
        }
        System.out.println(ans1);
    }
}
