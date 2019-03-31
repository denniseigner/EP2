package main.java.aufgabe3;/*
This class will be used in future assignments and in the ad-hoc
assignment.  It is recommended to solve Assignment 3.2 and 3.3 (and
this also requires 3.1)
*/
// Objects of class 'Participations2' contain participations from
// several races.  The implementation uses a binary search tree as
// associative data structure, using 'racer' as key; the value
// associated with the key is a 'Participations1' object containing
// all participations of this racer.  This implementation does not use
// classes from the Collections Framework (e.g., TreeMap)
// <https://docs.oracle.com/javase/8/docs/technotes/guides/collections/overview.html>.

import main.java.aufgabe1.Participation;

public class Participations2 {

    // Assignment 3.2 (continued from Participations1.java)

    // Introduce (private) object variables and classes as needed.
    private Participations2 left, right;
    private Participation participation;
    private int iteration;

    // Creates an empty object of this class
    public Participations2(int n) {
        // TODO: implement this constructor
        if (--n < 0) throw new IllegalArgumentException("Cannot add any more Participations");
        iteration = n;
    }

    // Creates an empty object of this class
    public Participations2() {
        // TODO: implement this constructor
        iteration = -1;
    }

    // Adds p to 'this'.
    public void add(Participation p) {
        // TODO: Implement this method
        if (participation == null) {
            participation = p;
            return;
        }

        if (p.getRacer().compareTo(participation.getRacer()) < 0) {
            if (left == null) left = iteration >= 0 ? new Participations2(iteration) : new Participations2();
            left.add(p);
        } else {
            if (right == null) right = iteration >= 0 ? new Participations2(iteration) : new Participations2();
            right.add(p);
        }
    }
    
    // Print the entries in the following order: The participations of
    // different racers are printed in the order given by compareTo,
    // with x being printed before y if x.compareTo(y)<0.  The
    // participations of the same racer are printed in the order of
    // insertion.  Each participation is printed in the same format as
    // produced by print() in Participation, followed by a newline.
    public void print() {
        // TODO: Implement this method
        if (participation == null) return;

        if (left != null) left.print();
        participation.print();
        if (right != null) right.print();
    }

    // Returns the first participation (the one that was inserted
    // earliest) in 'this' where the 'racer' equals 'r'.  If there is
    // no such participation, return null.
    public Participation lookupRacer(String r) {
        // TODO: Implement this method
        if (participation == null) return null;

        return participation.getRacer().equals(r)
            ? participation
            : participation.getRacer().compareTo(r) < 0
                ? left != null
                    ? left.lookupRacer(r)
                    : null
                : right != null
                    ? right.lookupRacer(r)
                    : null;
    }

    // Fragen:

    // 1) Wie unterscheidet sich Ihre Implementierung von
    // Participations2 bis hierher von Ihrer Implementierung von
    // Participations1 und Participations?  Welche Vor- und Nachteile
    // haben die Implementierungen im Vergleich?

    // 2) Was sind die Vorteile der Verwendung von 'racer' als
    // Schlüssel?  Könnte man stattdessen auch 'race' oder 'bibnumber'
    // verwenden?  In welchen Fällen wäre das hilfreich?  Wie kann
    // man die Daten organisieren, wenn man die Vorteile von
    // verschiedenen Schlüsseln kombinieren will?  Und was wären die
    // Nachteile?

    
    // Assignment 3.3 (continued from Participations1.java)

    // print the entries with bibnumber<=x in the same order as used
    // by print() in Participations2; each participation is printed in
    // the same format as produced by print() in Participation,
    // followed by a newline.
    public void print(int x) {
        // TODO: Implement this method

        if (participation == null) return;

        if (left != null) left.print(x);
        if (participation.getBibnumber() <= x) participation.print();
        if (right != null) right.print(x);
    }

    // This method is only for testing.
    // Alternatively, you can put the tests in additional classes.
    public static void main(String[] args) {
        // TODO: write your own test cases here if necessary.
    }
}
