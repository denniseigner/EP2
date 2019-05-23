package main.java.aufgabe6;

public interface StringIterator extends java.util.Iterator<String> {
    // returns the next 'String' object in the container that
    // 'this' iterates over.
    String next();

    // returns true if there is another 'String' object that
    // this.next() can return.
    boolean hasNext();
}
