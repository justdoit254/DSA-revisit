package Array.Medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeadersInArray {
    public static void main(String[] args) {
        int[] arr = {16,17,4,3,5,2};
        int n = arr.length;
        int max = arr[n-1];
        List<Integer> ls = new ArrayList<>();
        ls.add(max);
        int i = n-1;

        while (i>0) {
            if (arr[i-1] >= arr[i] && arr[i-1] >= max) {
                max = arr[i-1];
                ls.add(max);
            }
            i--;
        }
        if (arr[0] > max) ls.add(arr[0]);
        Collections.reverse(ls);
        System.out.println(ls);
    }
}
