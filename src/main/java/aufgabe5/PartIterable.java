package main.java.aufgabe5;

import main.java.aufgabe1.Participation;

public interface PartIterable extends java.lang.Iterable<Participation> {
    // creates an iterator for the container 'this'
    PartIterator iterator();
}
                                
