package Hashing;

import java.util.Arrays;
import java.util.HashMap;

public class CountingFreqOfElementsOfArr {
    public static void main(String[] args) {
        int[] arr = {2,3,2,3,5};
        int n = arr.length;
        int p = 5;
        HashMap<Integer,Integer> hmap = new HashMap<>();
        for (int el : arr) {
            if (el<=n) {
                if (!hmap.containsKey(el)) {
                    hmap.put(el,1);
                } else {
                    hmap.put(el, hmap.get(el)+1);
                }
            }
        }
        System.out.println(hmap);
        for (int i = 0; i < n; i++) {
            arr[i] = hmap.getOrDefault(i + 1, 0);
        }
        System.out.println(Arrays.toString(arr));
    }
}
