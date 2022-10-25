/*  Java program to implement Stack using linked list so that reverse */
class StackNode {
    int data;
    StackNode next;

    // node in the Linked list is a class
    public StackNode(int data) {
        /*
         * constructor is used to create a new Node and Next is by default is
         * initialized as null
         */

        this.data = data;
        this.next = null;
    }
}

class Stack {
    // Initializing the 'top' pointer
    StackNode top;

    // Push operation
    public void push(int data) {
        if (this.top == null) { /* if the node in the LL is empty, then store(push) the value inside it */
            top = new StackNode(data);
            return;
        }
        /*
         * if the current node in the LL is not empty, then store (push) the value
         * inside the next node
         */
        StackNode s = new StackNode(data);
        s.next = this.top;
        this.top = s;
    }

    // Pop operation
    public StackNode pop() {
        StackNode s = this.top;
        this.top = this.top.next;
        return s;
    }

    // prints contents of stack
    public void display() {
        StackNode s = this.top;
        while (s != null) { /* prints till the last node points 'null' */
            System.out.print(s.data + " ");
            s = s.next; // updating the values of the stack to print
        }
        System.out.println();
    }

    // Reverses the stack using simple linked list reversal logic.
    public void reverse() {
        StackNode prev, cur, succ;
        cur = prev = this.top;
        cur = cur.next;
        prev.next = null;
        while (cur != null) {

            succ = cur.next;
            cur.next = prev;
            prev = cur;
            cur = succ;
        }
        this.top = prev; /* The top has to point to prev as we reversed the data. */
    }
}

public class reverseStack { // Creating a class
    public static void main(String[] args) { // main method
        Stack obj = new Stack(); // Object initialization
        obj.push(86);
        obj.push(88);
        obj.push(66);
        obj.push(82);
        obj.push(18);
        System.out.println("Original Stack");
        obj.display();

        // reverse
        obj.reverse();

        System.out.println("Reversed Stack");
        obj.display();
    }
}
