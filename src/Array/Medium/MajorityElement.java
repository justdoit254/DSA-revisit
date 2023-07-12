package Array.Medium;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class MajorityElement {
    public static void main(String[] args) {
        int[] arr = {3,1,3,3,2};
        int n = arr.length;
        Arrays.sort(arr);
        int ans = arr[n/2];
        int count = 0;
//        System.out.println(Arrays.toString(arr));
        for (int el : arr) {
            if (el==ans) {
                count++;
            }
        }
        if (count >= (n/2)+1) System.out.println(ans);
        else System.out.println(-1);

//        Hashmap can also be used

//        Moore's Voting Algorithm
        int cnt = 0;
        int el = 0;
        for (int e: arr) {
            if (cnt == 0) {
                el = e;
                cnt++;
            } else if (el == e) cnt++;
            else cnt--;
        }

        int cnt2 = 0;
        for (int e : arr) {
            if (e == el) cnt2++;
        }

        if (cnt2 >= (n/2)+1) System.out.println(el);
        else System.out.println(-1);


    }
}
