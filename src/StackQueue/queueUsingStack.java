package StackQueue;

import java.util.Stack;

public class queueUsingStack {

    Stack<Integer> input = new Stack<>();
    Stack<Integer> output = new Stack<>();

    void enqueue(int x) {
        input.push(x);
    }

    int dequeue() {
        while (input.size() > 1) {
            output.push(input.pop());
        }
        int val = input.pop();
        while (output.size() > 0) {
            input.push(output.pop());
        }
        return val;
    }
    public static void main(String[] args) {
        queueUsingStack qu = new queueUsingStack();
        qu.enqueue(2);
        qu.enqueue(3);
        qu.enqueue(5);
        System.out.println(qu.dequeue());
    }
}
