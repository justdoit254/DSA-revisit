package BasicMath;

public class ReverseBits {
    public static void main(String[] args) {
        long n = 5;
        String str = String.format("%32s",Long.toBinaryString(n)).replaceAll(" ", "0");
        System.out.println(str);
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        System.out.println(sb);
        long ans = Long.parseLong(sb.toString(),2);
        System.out.println(ans);

    }
}
