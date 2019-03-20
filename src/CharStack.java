// Objects of CharStack are stacks holding chars.  The stack is
// implemented using an array, not using other classes.
// The array grows whenever the number of entries is insufficient.
public class CharStack {

    // Assignment 2.2 (partly also in Parse.java)

    // introduce (private) object variables as needed

    // Create an empty stack
    public CharStack() {
        // TODO: implement this constructor
    }

    // Push c on 'this'.  
    public void push(char c) {
        // TODO: Implement this method
    }

    // Pop the most recent character that was pushed, but has not been
    // popped yet
    public char pop() {
        // TODO: Implement this method
        return ' ';
    }

    // returns true if all characters pushed on 'this' have been popped.
    public boolean isEmpty() {
        // TODO: Implement this method
        return false;
    }

    // This method is only for testing.
    // Alternatively, you can put the tests in additional classes.
    public static void main(String[] args) {
        // TODO: write your own test cases here if necessary.
    }
}
