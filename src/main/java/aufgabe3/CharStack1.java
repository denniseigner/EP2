package main.java.aufgabe3;

import main.java.aufgabe2.CharStack;

// Objects of CharStack1 are stacks holding chars.  The stack is
// implemented using a linked list.  It does not
// use classes from the Collections Framework (e.g. LinkedList)
// <https://docs.oracle.com/javase/8/docs/technotes/guides/collections/overview.html>.
public class CharStack1 {

    // Assignment 3.4 (partly also in Aufgabenblatt3.txt)

    // introduce (private) object variables as needed
    private MyCharList head;

    // Create an empty stack
    public CharStack1() {
        // TODO: implement this constructor
        // nothing to do
    }

    // Push c on 'this'.  
    public void push(char c) {
        // TODO: Implement this method
        head = new MyCharList(c, head);

    }

    // Pop the most recent character that was pushed, but has not been
    // popped yet
    public char pop() {
        // TODO: Implement this method
        if (head != null) {
            char rest = head.getC();
            head = head.getNext();
            return rest;
        }
        return 0;
    }

    // returns true if all characters pushed on 'this' have been popped.
    public boolean isEmpty() {
        // TODO: Implement this method
        return head == null;
    }

    private class MyCharList {
        private char c;
        private MyCharList next;

        private MyCharList(char c, MyCharList next) {
            this.c = c;
            this.next = next;
        }

        private char getC() {
            return c;
        }

        private MyCharList getNext() {
            return next;
        }
    }

    // Frage:

    // Vergleichen Sie diese Implementierung mit CharStack.  Was sind
    // die Vor- und Nachteile der beiden Implementierungen?

    
    // This method is only for testing.
    // Alternatively, you can put the tests in additional classes.
    public static void main(String[] args) {
        // TODO: write your own test cases here if necessary.
    }
}
