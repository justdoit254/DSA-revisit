package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class FibonacciOfAllNoLessThanN {

    public static void main(String[] args) {
        int n = 5;

        long ans = fibb(n);
        System.out.println(ans);
    }

    private static long fibb(int n) {
      if (n==0) return 0;
      if (n==1) return 1;

      return fibb(n-1) + fibb(n-2);
    }

//
}
