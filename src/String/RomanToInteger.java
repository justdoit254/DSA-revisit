package String;

import java.util.HashMap;

public class RomanToInteger {
    public static void main(String[] args) {
        String str = "XXVII";
        int n = str.length();
        int num = 0;
        HashMap<Character, Integer> hm = new HashMap<>();
        hm.put('I', 1);
        hm.put('V', 5);
        hm.put('X', 10);
        hm.put('L', 50);
        hm.put('C', 100);
        hm.put('D', 500);
        hm.put('M', 1000);

        num += hm.get(str.charAt(n-1));
        for (int i = n-2; i >=0 ; i--) {
            if (hm.get(str.charAt(i)) >= hm.get(str.charAt(i+1))) {
                num += hm.get(str.charAt(i));
            } else {
                num -= hm.get(str.charAt(i));
            }
        }
        System.out.println(num);
    }
}
