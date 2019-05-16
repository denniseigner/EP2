package main.java.aufgabe5;

import main.java.aufgabe1.Participation;

public interface PartIterator extends java.util.Iterator<Participation> {
    // returns the next 'Participation' object in the container that
    // 'this' iterates over.
    Participation next();

    // returns true if there is another 'Participation' object that
    // this.next() can return.
    boolean hasNext();
}
