
/*  Java program for delimiter checking using stack */
import java.util.Scanner;

class StackImpl {

    public int length;
    public char[] array;
    public int top;

    /*** constructor to create stack with size */
    public StackImpl(int dim) {
        this.length = dim;
        this.array = new char[length];
        this.top = -1;
    }

    /*** This method adds new entry to the top of the stack */
    public void push(char entry) {
        this.array[++top] = entry;
    }

    /*** This method removes an entry from the top of the stack. */
    public char pop() {
        char entry = this.array[top--];
        return entry;
    }

    /*** This method returns top of the stack without removing it. */
    public char peek() {
        return array[top];
    }

    /*** This method returns true if the stack is empty */
    public boolean isStackEmpty() {
        return (top == -1);
    }

    /*** This method returns true if the stack is full */
    public boolean isStackFull() {
        return (top == length - 1);
    }
}

public class Delimiter_Matching { // Creating a class

    public boolean isDelimiterMatching(String inputExpr) { // Method defined to check the paranthesis
        /*
         * The argument inside it is basically the expression we've to parse through to
         * check the brackets
         */
        int length = inputExpr.length(); /* We're declaring the size of the stack as the length of input expression */
        StackImpl theStack = new StackImpl(length); /* Initializing a stack of size 'length' */
        for (int j = 0; j < inputExpr.length(); j++) { // Traversing through the stack
            char ch = inputExpr.charAt(j); /* This method returns the character at the specified index(j) in a string */
            switch (ch) {
                // pushing the left opening delimiters into the stack
                case '{':
                case '[':
                case '(':
                    theStack.push(ch);
                    break;
                case '}':
                case ']':
                case ')':
                    if (!theStack.isStackEmpty()) { /*
                                                     * Checking if stack is not empty (it has a few paranthesis to deal
                                                     * with)
                                                     */
                        char stackContent = theStack.pop(); /*
                                                             * * The left opening delimiters popped out are stored
                                                             * inside
                                                             * the'stackContent'
                                                             */
                        if ((ch == '}' && stackContent != '{')
                                || (ch == ']' && stackContent != '[') /* Checking for the mismatch condition */
                                || (ch == ')' && stackContent != '(')) {
                            System.out.println("Mismatch found: " + ch + " at " + j);
                            return false;
                        }
                    } else {
                        System.out.println("Mismatch found: " + ch + " at " + j);
                        return false;
                    }
                    break;
                default: // If there is no case match in the switch:
                    break;
            }
        }
        if (!theStack.isStackEmpty()) { /*
                                         * If you can't pop the stack because it is empty, report a missing right
                                         * delimiter error
                                         */
            System.out.println("Error: missing right delimiter");
            return false;
        }
        return true;
    }

    public static void main(String args[]) { // main method
        Delimiter_Matching obj = new Delimiter_Matching();// Object initialization
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the expression: ");
        String expression = sc.nextLine();
        // String expression = "{(a+b)*c-{d]}"; // Input_expression
        // String expression = "{(2+3)*(5+6)}"; // Input_expression
        boolean result = obj.isDelimiterMatching(expression);// Calling the method
        // returns true or false based on matching the brackets.
        System.out.println(expression + " == " + result); // String concatenation
    }
}
