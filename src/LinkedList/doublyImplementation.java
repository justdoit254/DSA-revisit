package LinkedList;

public class doublyImplementation {

    public static class Node{
        int data;               //This will store the data
        Node next;
        Node prev;//This will store the address of next node
    }

    public static class LinkedList {
        Node head;
        Node tail;
        int size;


        void display(){
            Node temp=head;
            while(temp!=null){
                System.out.print(temp.data + " ");
                temp=temp.next;
            }
            System.out.println();
        }
        // Method 1 (add element at first position)
        void addFirst(int val){
            Node temp=new Node();
            temp.data=val;
            temp.prev=null;
            temp.next=null;
            if(size==0){
                head=tail=temp;
            }
            else {
                temp.next=head;
                head.prev=temp;
                head=temp;

            }
            size++;
        }

        // Method 2 ( add element at last)
        void addLast(int val){
            Node temp=new Node();
            temp.data=val;
            temp.next=null;
            temp.prev=null;
            Node end=head;
            if(size==0){
                head=tail=temp;
            }
            else{
                while(end.next!=null){
                    end=end.next;
                }
                end.next=temp;
                temp.prev=end;
                end=temp;
            }
            size++;
        }

        //Method 3 (adding element at nth position)
        void addAtNthIndex(int val, int position){
            Node temp=new Node();
            temp.data=val;
            temp.next=null;
            temp.prev=null;
            Node insert=head;
            if(position == 1){
                addFirst(val);
            }
            else if(position ==size+1){
                addLast(val);
            }
            else{
                for(int i=0; i<position-2; i++){
                    insert=insert.next;
                }
                temp.next=insert.next;
                temp.prev=insert;
                insert.next=temp;
                insert.next.next.prev=temp;
            }
            size++;
        }

        // Method 4 (remove first element)
        int removeFirst(){
            int data=-1;
            if(size==0){
                System.out.println("List is already empty");
            }
            else if(size==1){
                data = head.data;
                head=tail=null;
            }
            else{
                data=head.data;
                head=head.next;
                head.prev=null;
            }
            size--;
            return data;
        }

        // Method 5 (remove last element)
        int removeLast(){
            int data=-1;
            Node end=head;
            if(size==0){
                System.out.println("List is already empty");
            }
            else if(size==1){
                data=tail.data;
                head=tail=null;
            }
            else{
                while(end.next!=null){
                    end=end.next;
                }
                end=end.prev;
                end.next=null;
            }
            size--;
            return data;
        }

        // Method 6 (remove nth element)
        int removeAtNthIndex(int position){
            if (position==1) {
                removeFirst();
            } else if(position == size) {
                removeLast();
            } else {
                Node remove=head;
                int data=-1;
                for(int i=0; i<position-2; i++){
                    remove=remove.next;
                }
                data=remove.next.data;
                remove.next=remove.next.next;
                remove.next.prev=remove;

                size--;
                return data;
            }
            return -1;
        }

        //Method 7 (reverse the linked list)
        void reverse() {
            Node temp = head;
//            while (temp.next!=null) {
//                temp = temp.next;
//            }
//            head = temp;
            while(temp != null) {
                temp = temp.next;
                head.next = head.prev;
                head.prev = temp;
               if (temp != null)head = temp;
            }
            System.out.println(head.data);
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
            list.addFirst(2);
            list.addLast(4);
            list.addLast(5);
//            list.addAtNthIndex(3, 2);
//            list.removeFirst();
//            list.removeLast();
//            list.removeAtNthIndex(3);
            list.display();
            list.reverse();
            list.display();
    }
}
