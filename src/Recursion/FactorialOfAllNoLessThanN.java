package Recursion;

import java.util.ArrayList;
import java.util.Collections;

public class FactorialOfAllNoLessThanN {
    public static void main(String[] args) {
        int n = 3;

        ArrayList<Integer> list = factorialNumbers(n,1, 2);
        Collections.reverse(list);
        System.out.println(list);
    }

    private static ArrayList<Integer> factorialNumbers(int n, int fact, int currNum) {
        if (fact > n) {
            return new ArrayList<>();
        }
        ArrayList<Integer> list = factorialNumbers(n, fact * currNum, currNum + 1);
        list.add(fact);
        return list;
    }
}
