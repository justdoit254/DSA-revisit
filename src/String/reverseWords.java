package String;

public class reverseWords {
    public static void main(String[] args) {
        String S = "i.like.this.program.very.much";
        int n = S.length();
        String ans = "";
        int end = n, start = 0;
        for (int i = n-1; i >=0 ; i--) {
            if (S.charAt(i)=='.') {
               start = i+1;
               ans += S.substring(start,end);
               ans += ".";
               end = i;
            }
        }
        ans += S.substring(0,end);
        System.out.println(ans);
    }
}
