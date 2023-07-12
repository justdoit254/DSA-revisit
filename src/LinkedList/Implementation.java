package LinkedList;

import java.util.HashSet;

public class Implementation {

    public static class Node {
        int data;
        Node next;
    }

    public static class LinkedList {
        Node head;
        Node tail;
        int size;

        //Method 1
        void addLast(int val) {
            Node temp = new Node();     //Node create
            temp.data = val;              //Enter the data
            temp.next = null;           //Address

            if (size == 0) {
                head = tail = temp;         //assignment chaining
            } else {
                tail.next = temp;
                tail = temp;
            }
            size++;
        }

        //Method 2
        void addFirst(int val) {
            Node temp = new Node();
            temp.data = val;
            temp.next = head;
            head = temp;

            if (size == 0) {
                tail = temp;
            }
            size++;
        }

//        Method 3
        int size() {
//            return size;
            int len = 1;
            Node temp = head;
            while (temp.next != null) {
                len ++;
                temp = temp.next;
            }
            return len;
        }

//        Method 4
        void display() {
            Node temp = head;
            while (temp.next != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.print(temp.data);
            System.out.println();
        }

        //Method 5
        int removeFirst() {
            int data = -1;
            if (size == 0) System.out.println("List is already empty");
            else if (size == 1) {
                data = head.data;
                head = tail = null;
                size --;
            } else {
                data = head.data;
                head = head.next;
                size --;
            }
            return data;
        }

        //Method 6
        int removeLast() {
            int data = -1;
            if (size == 0) System.out.println("List is already empty");
            else if (size == 1) {
                data = head.data;
                head = tail = null;
                size --;
            } else {
                Node temp = head;
                while (temp.next.next != null) {
                    temp = temp.next;
                }
                data = temp.next.data;
                temp.next = null;
                tail = temp;
                size --;
            }
            return data;
        }

//        Method 7
        int search(int val) {
            int position = 1;
            Node temp = head;
            while (temp != null) {
                if (temp.data != val) {
                    position++;
                    temp = temp.next;
                } else {
                    return position;
                }
            }
            return  -1;
        }

//        Method 8
        void addAtNthPosition(int position, int val) {
            if (position == 1) {
                addFirst(val);
            } else if (position == size()+1) {
                addLast(val);
            } else {
                Node temp = new Node();
                temp.data = val;
                temp.next = null;
                Node insert = head;
                for (int i = 0; i < position-2; i++) {
                    insert = insert.next;
                }
                temp.next = insert.next;
                insert.next = temp;
            }
        }

//        Method 9
        int removeNthElement(int position) {
            if (position == 1) {
                removeFirst();
            } else if (position == size()) {
                removeLast();
            } else {
                int data = -1;
                Node remove = head;
                for (int i = 0; i < position-2; i++) {
                    remove = remove.next;
                }
                data = remove.next.data;
                remove.next = remove.next.next;
                return data;
            }
            return -1;
        }

//        Method 10
        void reverse() {
          Node temp = head;
          Node prev = null;
            while(temp != null) {
                temp = temp.next;
                head.next = prev;
                prev = head;
               if (temp != null)head = temp;
            }
            System.out.println(head.data);
        }

//        Method 11
        int getMiddle() {
            Node fast = head;
            Node slow = head;
            while (fast.next != null && fast != null) {
               if(fast.next.next != null) fast = fast.next.next;
               else fast = fast.next;
                slow = slow.next;
            }
            return slow.data;
        }

    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addLast(2);
        list.addLast(4);
        list.addLast(5);
//        System.out.println(list);
//        System.out.println(list.size());
//        list.display();
//        System.out.println(list.removeFirst());
//        list.display();
//        System.out.println(list.head.data);
//        System.out.println(list.removeLast());
//        list.display();
//        System.out.println(list.head.data);
//        System.out.println(list.tail.data);
//        System.out.println(list.search(4));
//        System.out.println(list.search(6));
//        list.addAtNthPosition(2,3);
//        list.addAtNthPosition(1,1);
//        list.addAtNthPosition(6,6);
//        list.display();
//        list.removeNthElement(3);
//        list.display();
//        list.reverse();
//        list.display();
        int middle = list.getMiddle();
        System.out.println(middle);

        HashSet<Integer> hs = new HashSet<>();
    }
}
