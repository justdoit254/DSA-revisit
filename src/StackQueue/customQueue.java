package StackQueue;

public class customQueue {

    int[] data;
    int size;
    int idx;
    int front;

    customQueue(int size) {
        data = new int[size];
        idx = 0;
        front = 0;
    }

    // Method 1 (displaying queue)
    void display() {
        if (size == 0) {
            System.out.println("Queue is empty");
        } else {
            int count = 0;
            while (count < size) {
                System.out.print(data[(front + count) % data.length] + " ");
                count++;
            }
            System.out.println();
        }
    }


    // Method 2 (adding element in queue)
    void add(int val) {
        if (size == data.length) {
            System.out.println("Queue is full");
        } else {
            idx = (front + size) % data.length;
            data[idx] = val;
            size++;
        }
    }


    // Method 3 (removing element from queue)
    int remove() {
        int num = -1;
        if (size == 0) {
            System.out.println("Queue is empty");
        } else {
            num = data[front];
            front = (front + 1) % data.length;
            size--;
        }
        return num;
    }


    // Method 4 (peeking element in queue)
    int peek() {
        int num = -1;
        if (size == 0) {
            System.out.println("Queue is empty");
        } else {
            num = data[front];
        }
        return num;
    }
    public static void main(String[] args) {

    }
}
