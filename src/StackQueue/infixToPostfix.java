package StackQueue;

import java.util.Stack;

public class infixToPostfix {
    public static void main(String[] args) {
//        String exp = "a+b*(c^d-e)^(f+g*h)-i";
        String exp = "h^m^q^(7-4)";
        int n = exp.length();
        Stack<Character> stk = new Stack<>();
        String ans = "";
        for (int i = 0; i < n; i++) {
            char ch = exp.charAt(i);
            int num = findPrecedence(ch);

            if (num == 0) {
                stk.push(ch);
            } else if (num == 2 || num == 1 || num == 3) {
                if (stk.empty()) stk.push(ch);
                else {
                    while(!stk.empty() && findPrecedence(stk.peek()) >= num) {
                        ans += stk.pop();
                    }
                    stk.push(ch);
                }
            } else if (num == 4) {
                while (findPrecedence(stk.peek()) != 0) {
                    ans += stk.pop();
                }
                stk.pop();
            } else {
                ans += ch;
            }
        }
        while (!stk.empty()) {
            ans += stk.pop();
        }
        System.out.println(ans);
    }

    //        ( --> 0, +- --> 1, */ --> 2, ^ --> 3, ) --> 4
    private static int findPrecedence(char ch) {
        if (ch == ')') return 4;
        if (ch == '+' || ch == '-') return 1;
        if (ch == '*' || ch == '/') return 2;
        if (ch == '^') return 3;
        if (ch == '(') return 0;
        return -1;
    }
}
