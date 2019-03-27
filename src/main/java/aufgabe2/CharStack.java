package main.java.aufgabe2;

import java.util.Arrays;

// Objects of CharStack are stacks holding chars.  The stack is
// implemented using an array, without using other classes.
// The array grows whenever the number of entries is insufficient.
public class CharStack {

    // Assignment 2.2 (partly also in Parse.java)

    // introduce (private) object variables as needed
    private char[] thisCharStack;
    private int countFilledChars;

    // Create an empty stack
    public CharStack() {
        // TODO: implement this constructor
        thisCharStack = new char[0];
        countFilledChars = 0;
    }

    // Push c on 'this'.  
    public void push(char c) {
        // TODO: Implement this method
        if (thisCharStack.length < countFilledChars + 1) {
            thisCharStack = Arrays.copyOf(thisCharStack, thisCharStack.length + 1);
        }

        thisCharStack[countFilledChars++] = c;
    }

    // Pop the most recent character that was pushed, but has not been
    // popped yet
    public char pop() {
        // TODO: Implement this method
        // return --countFilledChars < 0 ? (char) ++countFilledChars : thisCharStack[countFilledChars];

        if (--countFilledChars < 0) {
            countFilledChars = 0;
            return 0;
        }

        char retChar = thisCharStack[countFilledChars];
        thisCharStack[countFilledChars] = 0;

        return retChar;
    }

    // returns true if all characters pushed on 'this' have been popped.
    public boolean isEmpty() {
        // TODO: Implement this method
        return countFilledChars == 0;
    }

    // This method is only for testing.
    // Alternatively, you can put the tests in additional classes.
    public static void main(String[] args) {
        // TODO: write your own test cases here if necessary.
    }
}
