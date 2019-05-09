public class Participations4 {
    // Objects of class 'Participations3' contain participations from
    // several races.  The implementation uses a hash table with
    // external chaining as associative data structure; the keys of
    // the hash table is the tuple ('racer','race') as key (i.e., what
    // is implemented by the 'equals' method of 'Participation'); the
    // values of the hash table are 'Participations' objects.
    // However, the array of the hash table contains 'Participations1'
    // objects.  'Participation' objects with the same index in the
    // array are inserted in the same 'Participations1' object.
    
    // This implementation does not use classes from the Collections
    // Framework (e.g., HashMap)
    // <https://docs.oracle.com/javase/8/docs/technotes/guides/collections/overview.html>.

    // Assignment 5.2

    // TODO: Introduce (private) object variables, methods and classes as needed.
    // Creates an empty hash table with room for n 'Participation1' objects
    public Participations4(int n) {
        // TODO: implement this constructor
    }

    // Adds p to 'this'.
    public void add(Participation p) {
        // TODO: Implement this method
    }
    
    // returns a string that contains the participations in arbitrary
    // order, each participation in the format produced by print() in
    // Participation, followed by a newline.
    @Override
    public String toString() {
        // TODO: Implement this method.
        return "";
    }

    // Print the participations in the format produced by 'toString()'.
    public void print() {
        // TODO: Implement this method
    }

    // Returns the first participation (the one that was inserted
    // earliest) in 'this' that equals() 'p'.  If there is no such
    // participation, return null.
    public Participation lookupRacer(Participation p) {
        // TODO: Implement this method
        return null;
    }

    // Fragen:

    // 1) Wenn in so eine Hash-Tabelle mit n 'Participations1'-Listen
    // m unterschiedliche Participation-Einträge eingefügt werden, wie
    // gross ist die durchschnittliche Länge l der Listen?  Warum kann
    // der durchschnittliche Zugriff deutlich länger dauern als ein
    // durchschnittlicher Zugriff auf eine Liste der Länge l plus der
    // Aufwand, bis die Liste erreicht ist?  Überlegen Sie sich einen
    // besonders langsamen Fall, und wann der garantiert auftritt.
    // Worauf sollte man daher bei der Verwendung von Hash-Tabellen
    // achten?
    
    // 2) Vergleichen Sie diese Art der Kollisionsbehandlung mit der im
    // Skriptum gezeigten. Was sind die Vor- und Nachteile der Methoden?

    // 3) Vergleichen Sie die Klassen
    // 'Participations'-'Participations4'.  Was sind die
    // Gemeinsamkeiten und Unterschiede im Verhalten (nicht in der
    // Implementierung). Überlegen Sie sich, wie Sie diese drei
    // Klassen in einer Typhierarchie organisieren würden; welche
    // Typen übernehmen welche Eigenschaften von den übergeordneten
    // Typen, und welche fügen sie hinzu?


    // This method is only for testing.
    // Alternatively, you can put the tests in additional classes.
    public static void main(String[] args) {
        // TODO: write your own test cases here if necessary.
    }
}
