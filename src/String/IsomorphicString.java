package String;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicString {
    public static void main(String[] args) {
        String str1 = "aab";
        String str2 = "sty";
        int n1 = str1.length();
        int n2 = str2.length();
        if (n1 != n2) System.out.println(false);

        HashMap<Character, Character> hm = new HashMap<>();
        HashMap<Character, Integer> hm2 = new HashMap<>();

        for (int i = 0; i < n1; i++) {
            char c1 = str1.charAt(i);
            char c2 = str2.charAt(i);
            if (hm.containsKey(c1)) {
                if (hm.get(c1)!=c2) {
                    System.out.println(false);
                    break;
                }
            } else {
                if (hm.containsValue(c2)) {
                    System.out.println(false);
                     break;
                }
                hm.put(c1, c2);
            }
        }
        System.out.println(true);

//        for (int i = 0; i < n1; i++) {
//            char c = str1.charAt(i);
//            if (hm1.containsKey(c)) {
//                hm1.put(c, hm1.get(c)+1);
//            } else {
//                hm1.put(c, 1);
//            }
//        }
//        for (int i = 0; i < n2; i++) {
//            char c = str2.charAt(i);
//            if (hm2.containsKey(c)) {
//                hm2.put(c, hm2.get(c)+1);
//            } else {
//                hm2.put(c, 1);
//            }
//        }
//        if (hm1.size() != hm2.size()) System.out.println(false);
//        int count = 0;
//        for (Map.Entry<Character, Integer> mapElment : hm1.entrySet()) {
//            Integer value = mapElment.getValue();
//            if (hm2.containsValue(value)) {
//                count++;
//            }
//        }
//        if (count==hm1.size()) System.out.println(true);
//        else System.out.println(false);
    }
}
