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

    @Override
    public PartTreeNodable add(Participation p) {
        // TODO: Implement this method
        return PartTreeNull.NIL;
    }

    @Override
    public void print() {
        // TODO: Implement this method
    }

    @Override
    public Participation lookupRacer(String r) {
        // TODO: Implement this method
        return null;
    }


    // This method is only for testing.
    // Alternatively, you can put the tests in additional classes.
    public static void main(String[] args) {
        // TODO: write your own test cases here if necessary.
    }
}
