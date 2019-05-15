public interface StringIteratorIterator extends java.util.Iterator<StringIterator> {
    // returns the next 'StringIterator' object in the container that
    // 'this' iterates over.
    StringIterator next();

    // returns true if there is another 'StringIterator' object that
    // this.next() can return.
    boolean hasNext();
}
