package main.java.aufgabe5;

import main.java.aufgabe1.Participation;

public class ParticipationsIter implements PartIterator {
    // This class implements an iterator for the class Participations
    
    // TODO: Introduce (private) object variables as needed.
    private Participation[] participations;
    private int countParticipations, index;

    public ParticipationsIter(Participation[] participations, int countParticipations) {
        this.participations = participations;
        this.countParticipations = countParticipations;
        index = 0;
    }

    // returns the next 'Participation' object in the container that
    // 'this' iterates over.
    @Override
    public Participation next() {
        // TODO: Implement this method
        if (hasNext()) {
            return participations[index++];
        }
        return null;
    }

    // returns true if there is another 'Participation' object that
    // this.next() can return.
    @Override
    public boolean hasNext() {
        // TODO: Implement this method
        return (index < countParticipations);
    }
}
