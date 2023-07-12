package BasicMath;

public class PalindromeInt {
    public static void main(String[] args) {
        int n = 55555;
        String s = Integer.toString(n);
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        if (s.equals(sb.toString())) System.out.println(true);
        else System.out.println(false);
    }
}
