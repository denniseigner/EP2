// Objects of class 'PartTreeNull' represent an nonempty node in a binary
// search tree, using 'racer' as key.

// Variables of type 'PartTreeNodable' and its subtypes are never
// null.  Instead, an empty subtree is represented by a 'PartTreeNull'
// object.

// Do not use 'if', while, or '? :' to check whether a node is empty
// or not; instead, call the appropriate method implementation with
// dynamic binding.

public class PartTreeNull implements PartTreeNodable {
    // ToDo: define object variables, constructors and methods as needed

    public PartTreeNodable add(Participation p) {
        // TODO: Implement this method
        return new PartTreeNull();
    }

    public void print() {
        // TODO: Implement this method
    }

    public Participation lookupRacer(String r) {
        // TODO: Implement this method
        return null;
    }
}
