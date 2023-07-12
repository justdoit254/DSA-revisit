package StackQueue;

import java.util.Arrays;
import java.util.Stack;

public class nextGreaterElement {
    public static void main(String[] args) {
        long[] arr = {1,2,3,4};
        int n = arr.length;
        long[] ans = new long[n];
        ans[n-1] = -1;
        Stack<Long> stk = new Stack<>();
        stk.push(arr[n-1]);
        for (int i = n-2; i >=0 ; i--) {
            while (!stk.empty() && stk.peek() <= arr[i]) {
                stk.pop();
            }
            if (stk.empty()) {
                ans[i] = -1;
                stk.push(arr[i]);
            } else {
                ans[i] = stk.peek();
                if (arr[i] < stk.peek()) stk.push(arr[i]);
            }
        }
            while (!stk.empty() && stk.peek() <= arr[n-1]) {
                stk.pop();
            }
            if (stk.empty()) {
                ans[n-1] = -1;
            } else {
                ans[n-1] = stk.peek();
            }
        System.out.println(Arrays.toString(ans));
    }
}
