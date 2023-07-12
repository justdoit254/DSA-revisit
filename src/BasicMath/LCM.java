package BasicMath;

public class LCM {
    public static void main(String[] args) {
        int a = 4;
        int b = 8;
        int gcd = gcd(a,b);
        int lcm = (a*b) / gcd;
        System.out.println(lcm);

    }

    private static int gcd(int a, int b) {
        if (b==0) {
            return a;
        }
        return gcd(b, a%b);
    }
}
