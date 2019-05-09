public interface PartIterator extends java.util.Iterator<Participation> {
    // returns the next 'Participation' object in the container that
    // the iterator 'this' iterates over.
    Participation next();

    // returns true if there is another 'Participation' object that
    // the this.next() can return.
    boolean hasNext();
}
