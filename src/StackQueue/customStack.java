package StackQueue;

public class customStack {

    int[] data;
    int idx;
    int len;               //length of array


    // customize stack
    customStack (int len){
        data=new int[len];
        idx=-1;
    }


    // Method 1 (Displaying stack)
    void display(){
        for(int i=0; i<=idx; i++){
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }


    // Method 2 (Pushing an element)
    void push(int val){
        if(idx==data.length-1){
            System.out.println("Stack is full");
        }
        else{
            idx++;
            data[idx]=val;
        }
    }

    // Method 3 (Popping an element)
    int pop(){
        int num = -1;
        if (idx == -1) {
            System.out.println("Stack is empty");
        }
        else {
            num = data[idx];
            idx--;
        }
        return num;
    }

    // Method 4 (Peeking an element)
    int peek(){
        int num = -1;
        if (idx == -1) {
            System.out.println("Stack if empty");
        }
        else {
            num = data[idx];
        }
        return num;
    }

    // Method 5 (Pushing an element even if stack if full)
    void push2(int val){
        if(idx==data.length-1){
            int[] temp_data = new int[2*data.length];
            System.arraycopy(data, 0, temp_data, 0, data.length);
            data = temp_data;

        }
            idx++;
            data[idx]=val;

    }
    public static void main(String[] args) {

    }
}
