package main.java.aufgabe5;

import main.java.aufgabe1.Participation;
import main.java.aufgabe3.Participations1;
import main.java.aufgabe6.StringIterable;
import main.java.aufgabe6.StringIterator;

import java.util.ArrayList;

public class Participations4 implements PartIterable {
    // Objects of class 'Participations3' contain participations from
    // several races.  The implementation uses a hash table as follows:
    //   - the tuple ('racer','race') is the key (i.e., what the 'equals'
    //     method of 'Participation' implements);
    //   - the values of the hash table are 'Participations' objects.
    // However, the array of the hash table contains 'Participations1'
    // objects.  'Participation' objects with the same index in the
    // array are inserted in the same 'Participations1' object.
    // This variant of hash table implementation is known as separate chaining.

    // This implementation does not use classes from the Collections
    // Framework (e.g., HashMap)
    // <https://docs.oracle.com/javase/8/docs/technotes/guides/collections/overview.html>.

    // Assignment 5.2

    // TODO: Introduce (private) object variables, methods and classes as needed.
    private Participations1[] participations;

    // Creates an empty hash table with room for n 'Participation1' objects
    public Participations4(int n) {
        // TODO: implement this constructor
        participations = new Participations1[n];
    }

    // Adds p to 'this'.
    public void add(Participation p) {
        // TODO: Implement this method
        if (participations[hash(p)] == null) participations[hash(p)] = new Participations1();
        participations[hash(p)].add(p);
    }
    
    // returns a string that contains the participations in arbitrary
    // order, each participation in the format produced by print() in
    // Participation, followed by a newline.
    @Override
    public String toString() {
        // TODO: Implement this method.
        StringBuilder retString = new StringBuilder();

        for (Participations1 participation : participations) {
            if (participation != null) retString.append(participation);
        }

        return retString.toString();
    }

    // Print the participations in the format produced by 'toString()'.
    public void print() {
        // TODO: Implement this method
        System.out.println(this);
    }

    // Returns the first participation (the one that was inserted
    // earliest) in 'this' that equals() 'p'.  If there is no such
    // participation, return null.
    public Participation lookupRacer(Participation p) {
        // TODO: Implement this method
        if (participations[hash(p)] == null) return null;
        return participations[hash(p)].lookupRacer(p);
    }

    private int hash(Participation p) {
        return p.hashCode() % participations.length;
    }

    @Override
    public PartIterator iterator() {
        return new Participations4Iter(participations);
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
    // 'Participations' bis 'Participations4'.  Was sind die
    // Gemeinsamkeiten und Unterschiede im Verhalten (nicht in der
    // Implementierung). Überlegen Sie sich, wie Sie diese drei
    // Klassen in einer Typhierarchie organisieren würden; welche
    // Typen übernehmen welche Eigenschaften von den übergeordneten
    // Typen, und welche fügen sie hinzu?

    // Returns a StringIterable (see StringIterable.java) that contains
    // the set of 'race's (i.e., each race occurs only once) of all
    // Participation entries in 'this' (at the time when copyRaces() is
    // called).
    public StringIterable copyRaces() {
        // TODO: implement this method; you are allowed to use a data
        //  structure from the Collections Framework for this task.
        //  Implement  helper classes as needed.
        return copyRaces(null);
    }

    // As in copyRaces(), but selects only those races where the racer equals 'r'.
    public StringIterable copyRaces(String r) {
        // TODO: implement this method; you are allowed to use a data
        //  structure from the Collections Framework for this task.
        //  Implement helper classes as needed.
        ArrayList<String> races = new ArrayList<>();
        for (Participation p : this) {
            if (races.contains(p.getRace()) || (r != null &&  !p.getRacer().equals(r))) {
                continue;
            }
            races.add(p.getRace());
        }

        return new MyStringIterable(races);
    }

    public StringIterable viewRaces() {
        // TODO: implement this method; you are allowed to use a data
        //  structure from the Collections Framework for this task.
        //  Implement helper classes as needed.
        return viewRaces(null);
    }

    // As in viewRaces(), but selects only those races where the racer equals 'r'.
    public StringIterable viewRaces(String r) {
        // TODO: implement this method; you are allowed to use a data
        //  structure from the Collections Framework for this task.
        //  Implement helper classes as needed.
        return new MyStringIterableView(r);
    }

    private class MyStringIterable implements StringIterable {

        ArrayList<String> races;
        private MyStringIterable(ArrayList<String> races) {
            this.races = races;
        }

        @Override
        public StringIterator iterator() {
            return new MyStringIterator(races);
        }
    }

    private class MyStringIterator implements StringIterator {

        ArrayList<String> races;
        int index;
        private MyStringIterator(ArrayList<String> races) {
            this.races = races;
            index = 0;
        }

        @Override
        public String next() {
            if (!hasNext()) return null;
            return races.get(index++);
        }

        @Override
        public boolean hasNext() {
            return index < races.size();
        }
    }

    private class MyStringIterableView implements StringIterable {

        String r;
        private MyStringIterableView(String r) {
            this.r = r;
        }

        @Override
        public StringIterator iterator() {
            return new MyStringIteratorView(r);
        }
    }

    public class MyStringIteratorView implements StringIterator {

        ArrayList<String> races;
        String r;
        int index;
        private MyStringIteratorView(String r) {
            this.r = r;
            index = 0;
            races = new ArrayList<>();
            for (String s : copyRaces(r)) {
                races.add(s);
            }
        }

        // Returns a StringIterable vv.  The object vv contains the set of
        // 'racer's of all Participation entries in p where the race equals s.
        // Iterating through the resulting StringIterable enumerates all the
        // 'racer's in 'this' at the time when the iterator is created.  It is
        // allowed to enumerate none, some, or all of the new racers that are
        // added between the creation of the iterator and its exhaustion
        // (hasNext() returns false).
        public StringIterable viewRacers() {
            // TODO: implement this method; you are allowed to use a data
            //  structure from the Collections Framework for this task.
            //  Implement helper classes as needed.
            return null;
        }

        @Override
        public String next() {
            if (!hasNext()) {
                if (grow()) return next();
                return null;
            }
            return races.get(index++);
        }

        @Override
        public boolean hasNext() {
            return index < races.size();
        }

        private boolean grow() {
            boolean grew = false;
            for (String s : copyRaces(r)) {
                if (races.contains(s)) continue;
                races.add(s);
                grew = true;
            }
            return grew;
        }
    }

    // This method is only for testing.
    // Alternatively, you can put the tests in additional classes.
    public static void main(String[] args) {
        // TODO: write your own test cases here if necessary.
    }
}
