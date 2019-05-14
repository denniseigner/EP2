package main.java.aufgabe4;

import main.java.aufgabe1.Participation;

public class PartTreeNull implements PartTreeNodable {
    // Objects of class 'PartTreeNull' represent an empty node in a binary
    // search tree, using 'racer' as key.
    
    // Variables and expressions of type 'PartTreeNodable' and its subtypes
    // are never null.  Instead, an empty subtree is represented by a
    // 'PartTreeNull' object.
    
    // Do not use 'if', 'while', or '? :' to check whether a node is empty
    // or not; instead, call the appropriate method implementation with
    // dynamic binding.

    // TODO: define object variables, constructors and methods as needed

    // 'NIL' is the only object of type 'PartTreeNull'.
    // Appropriate visibility and use of the constructor of 'PartTreeNull'
    // ensure this property.
    public static final PartTreeNull NIL = new PartTreeNull();

    @Override
    public PartTreeNodable add(Participation p) {
        // TODO: Implement this method
        return new PartTreeBinary().add(p);
    }

    @Override
    public void print() {
        // TODO: Implement this method
        // nothing to do
    }

    @Override
    public Participation lookupRacer(String r) {
        // TODO: Implement this method
        return null;
    }

    @Override
    public String toString(String x, int y) {
        return null;
    }

    @Override
    public String toString() {
        return "";
    }


    // This method is only for testing.
    // Alternatively, you can put the tests in additional classes.
    public static void main(String[] args) {
        // TODO: write your own test cases here if necessary.
    }
}
