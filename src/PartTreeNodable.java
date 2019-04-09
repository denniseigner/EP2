// An objects of a class implementing 'PartTreeNodable' represent a
// node in a binary search tree, using 'racer' as key.  The value
// associated with the key is a 'Participations1' object containing
// all participations of this racer.

// Variables and expressions of type 'PartTreeNodable' and its subtypes
// are never null.  Instead, an empty subtree is represented by a
// 'PartTreeNull' object.

// Classes that implement 'PartTreeNodable' do not use 'if', 'while',
// or '? :' to check whether a node is empty or not; instead, they
// call the appropriate method implementation with dynamic binding.

public interface PartTreeNodable {
    // ToDo: introduce (public) methods if needed

    // Returns a binary search tree that contains 'p' in addition
    // to the participations of 'this'. Participations of the same
    // racer are stored in a 'Participations1' object.
    public PartTreeNodable add(Participation p);

    // print the participations in 'this', in the same order as
    // Participations2 and Participations3.
    public void print();

    // Returns the first participation (the one that was inserted
    // earliest) in 'this' where the 'racer' equals 'r'.  If there is
    // no such participation, return null.
    public Participation lookupRacer(String r);
}
                                
