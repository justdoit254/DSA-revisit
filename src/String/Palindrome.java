package String;

public class Palindrome {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        s = (s.toLowerCase().replaceAll("[^a-zA-Z0-9]", ""));

    }

    private static boolean isPalindrome(String s, int i) {
        if (i>s.length()/2) {
            return true;
        }
        if (s.charAt(i)!=s.charAt(s.length()-i-1)) return false;
        return isPalindrome(s,i+1);

    }
}
