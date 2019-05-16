package main.java.aufgabe5;

import main.java.aufgabe1.Participation;
import main.java.aufgabe3.Participations1;

import java.util.Iterator;

public class Participations4Iter implements PartIterator {
    // This class implements an iterator for the class Participations4
    
    // TODO: Introduce (private) object variables as needed.
    private Participations1[] participations;
    private int index;
    private Iterator partIter;

    public Participations4Iter(Participations1[] participations) {
        this.participations = participations;
        index = 0;
    }

    // returns the next 'Participation' object in the container that
    // 'this' iterates over.
    @Override
    public Participation next() {
        // TODO: Implement this method
        if (!hasNext()) {
            return null;
        }
        return (Participation) partIter.next();
    }

    // returns true if there is another 'Participation' object that
    // this.next() can return.
    @Override
    public boolean hasNext() {
        // TODO: Implement this method
        if (partIter != null && partIter.hasNext()) {
            return true;
        }

        for (; index < participations.length; index++) {
            if (participations[index] == null) continue;
            partIter = participations[index++].iterator();
            return hasNext();
        }

        return false;
    }
}
