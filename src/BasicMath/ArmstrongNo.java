package BasicMath;

public class ArmstrongNo {
    public static void main(String[] args) {
        int n = 153;
        String s = Integer.toString(n);
        int n1 = s.charAt(0)-48;
        n1 = (int) Math.pow(n1,3);
        int n2 = s.charAt(1)-48;
        n2 = (int) Math.pow(n2,3);
        int n3 = s.charAt(2)-48;
        n3 = (int) Math.pow(n3,3);
        int ans= n1+n2+n3;
        if (ans == n) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
