package main.java.aufgabe4;

import main.java.aufgabe1.Participation;
import main.java.aufgabe3.Participations1;

public class PartTreeBinary implements PartTreeNodable {
    // An object of class 'PartTreeBinary' represents a nonempty node
    // in a binary search tree, using 'racer' as key.
    
    // Variables and expressions of type 'PartTreeNodable' and its
    // subtypes are never null.  Instead, an empty subtree is
    // represented by a 'PartTreeNull' object.
    
    // Do not use 'if', 'while', or '? :' to check whether a node is
    // empty or not; instead, call the appropriate method
    // implementation with dynamic binding.

    // TODO: define object variables, constructors and methods as needed
    private PartTreeNodable left, right;
    private Participations1 partList;

    public PartTreeBinary() {
        left = right = PartTreeNull.NIL;
    }

    @Override
    public PartTreeNodable add(Participation p) {
        // TODO: Implement this method
        if (partList == null) {
            partList = new Participations1();
            partList.add(p);
            return this;
        }

        if (p.getRacer().compareTo(partList.first().getRacer()) < 0) {
            left = left.add(p);
        }

        if (p.getRacer().compareTo(partList.first().getRacer()) == 0) {
            partList.add(p);
        }

        if (p.getRacer().compareTo(partList.first().getRacer()) > 0) {
            right = right.add(p);
        }

        return this;
    }

    @Override
    public void print() {
        // TODO: Implement this method
        left.print();
        partList.print();
        right.print();
    }

    @Override public String toString() {
        return left.toString() + partList.toString() + right.toString();
    }

    @Override
    public String toString(String x, int y) {
        return left.toString(x, y) + partList.toString(x, y) + right.toString(x, y);
    }

    @Override
    public Participation lookupRacer(String r) {
        // TODO: Implement this method
        if (partList.first().getRacer().equals(r)) {
            return partList.lookupRacer(r);
        }

        return partList.first().getRacer().compareTo(r) < 0
            ? left.lookupRacer(r)
            : right.lookupRacer(r);
    }


    // This method is only for testing.
    // Alternatively, you can put the tests in additional classes.
    public static void main(String[] args) {
        // TODO: write your own test cases here if necessary.
    }
}
