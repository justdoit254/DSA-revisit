package String;

import java.util.HashSet;
import java.util.LinkedList;

public class noOfSubstrings {
    public static void main(String[] args) {
        String s = "aba";
        int n = s.length();
        int count = 0;
        int k = 2;

//        for(int i = 0; i < n; i++){
//            HashSet<Character> hs = new HashSet<>();
//
//            for(int j = i; j < n; j++){
//                char ch = s.charAt(j);
//                hs.add(ch);
//                if (hs.size() == k) count++;
//            }
//            hs.clear();
//        }

//        for(int i = 0; i < n; i++){
//            int[] arr = new int[26];
//            int distinct = k;
//
//            for(int j = i; j < n; j++){
//                char ch = s.charAt(j);
//                if (arr[ch-'a'] == 0) {
//                    arr[ch-'a']++;
//                    distinct--;
//                    if (distinct==0) {
//                        count++;
//                    }
//                } else {
//                    if (distinct==0) {
//                        count++;
//                    }
//                }
//            }
//        }


        System.out.println(count);
    }
}
