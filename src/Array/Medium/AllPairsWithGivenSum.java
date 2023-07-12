package Array.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class pair  {
    long first, second;
    public pair(long first, long second)
    {
        this.first = first;
        this.second = second;
    }
}

public class AllPairsWithGivenSum {
    public static void main(String[] args) {
        long[] A = {1, 2, 4, 5, 7};
        long[] B = {5, 6, 3, 4, 8};
        long N = A.length;
        long M = B.length;
        long X = 9;
        List<Long> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            long u = A[i];
            for (int j = 0; j < M; j++) {
                long v = B[j];
                if (u+v == X) {
                    list.add(u);
                }
            }
        }
        Collections.sort(list);
//        System.out.println(list);
        pair[] arr = new pair[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = new pair(list.get(i), X- list.get(i));
        }
         for (int i = 0; i < list.size(); i++) {
             System.out.println(arr[i].first + "," + arr[i].second);
        }

    }
}
