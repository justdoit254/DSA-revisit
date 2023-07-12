package StackQueue;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class stackUsingQueue {

    Queue<Integer> q1 = new ArrayDeque<>();
    Queue<Integer> q2 = new ArrayDeque<>();

    void push(int a) {
        q1.add(a);
    }

    int pop() {
        if (q1.size() == 0) {
            return -1;
        }
        while (q1.size() > 1) {
            q2.add(q1.remove());
        }
        int val = q1.remove();
        while (q2.size() > 0) {
            q1.add(q2.remove());
        }
        return val;
    }
    public static void main(String[] args) {
        stackUsingQueue stk = new stackUsingQueue();
        stk.push(2);
        stk.push(3);
        stk.push(5);
        System.out.println(stk.pop());
    }
}
