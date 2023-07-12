package String;

public class checkStringRotation {
    public static void main(String[] args) {
        String s1 = "geeksforgeeks";
        String s2 = "forgeeksgeeks";
        int n1 = s1.length();
        int n2 = s2.length();
        if (n1!=n2) {
            System.out.println(false);
            return;
        }
        String temp = s1+s1;
        System.out.println(temp);

            if (temp.contains(s2)) {
                System.out.println(true);
            } else System.out.println(false);

    }
}
