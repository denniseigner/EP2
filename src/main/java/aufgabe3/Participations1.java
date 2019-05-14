package main.java.aufgabe3;/*
This class will be used in future assignments and in the ad-hoc
assignment.  It is recommended to solve Assignment 3.1, 3.2 and 3.3
*/
// Objects of class 'Participations1' contain participations from
// several races.  The implementation uses a linked list.  It does not
// use classes from the Collections Framework (e.g. LinkedList)
// <https://docs.oracle.com/javase/8/docs/technotes/guides/collections/overview.html>.

import main.java.aufgabe1.Participation;

public class Participations1 {

    // Assignment 3.1

    // Introduce (private) object variables and classes as needed.
    private MyListNode head, last, first;
    private int counter, maxCount;
    private boolean limited;

    private MyListNode poll() {
        if (head == null) return null;
        MyListNode mln = head;
        head = head.getNext();
        if (head == null) {
            last = null;
        }
        return mln;
    }

    // Creates an empty object of this class
    public Participations1(int n) {
        // TODO: implement this constructor
        counter = 0;
        this.maxCount = n;
        limited = true;
    }

    // Creates an empty object of this class
    public Participations1() {
        // TODO: implement this constructor

    }

    // Adds p to 'this'.
    public void add(Participation p) {
        // TODO: Implement this method
        if (++counter > maxCount && limited) {
            System.err.println("Cannot add any more Participations");
            return;
        }

        if (head == null) {
            head = last = first = new MyListNode(p, null, null);
            return;
        }
        last.setNext(last = new MyListNode(p, null, last));
    }

    // Print the entries in the order of insertion; each participation
    // is printed in the same format as produced by print() in
    // Participation, followed by a newline.
    public void print() {
        // TODO: Implement this method
        MyListNode mln = poll();
        while (mln != null) {
            mln.getP().print();
            mln = poll();
        }
        head = first;
    }

    // Returns the first participation (the one that was inserted
    // earliest) in 'this' where the 'racer' equals 'r'.  If there is
    // no such participation, return null.
    public Participation lookupRacer(String r) {
        // TODO: Implement this method
        MyListNode mln = poll();
        while (mln != null) {
            if (mln.getP().getRacer().equals(r)) return mln.getP();
            mln = poll();
        }
        head = first;
        return null;
    }

    // Fragen:

    // 1) Wie unterscheidet sich Ihre Implementierung von
    // Participations1 bis hierher von Ihrer Implementierung von
    // Participations?  Welche Vor- und Nachteile haben die beiden
    // Implementierungen im Vergleich?  Wäre eine
    // Array-Implementierung, die das Array gegen ein doppelt so
    // großes tauscht, wenn der Platz nicht mehr reicht, für diese
    // Aufgabe weniger aufwändig?

    // 2) Hat der Parameter des Konstruktors eine Funktion? Wenn doch,
    // welche? Wenn nicht, ist es sinnvoll, den Parameter zu behalten?
    // Warum, bzw. warum nicht?

    // 3) Muss Ihre Implementierung bei jedem add-Aufruf die ganze
    // Liste durchgehen? Wenn ja, wie könnte man das vermeiden und
    // wieviel Programmieraufwand wäre nötig? Wenn nein, wieviel
    // Programmieraufwand hat das gekostet?

    
    // Assignment 3.2 (continued in Participations2.java)
    
    // Returns the first participation (the one that was inserted
    // earliest) in 'this'.  If there is no such participation, return
    // null.
    public Participation first() {
        // TODO: Implement this method
        if (head == null) return null;
        return head.getP();
    }


    // Assignment 3.3 (continued in Participations2.java)

    // print the entries with bibnumber<=x in the order of insertion;
    // each participation is printed in the same format as produced by
    // print() in Participation, followed by a newline.

    // Anmerkung: Methodenheader auf public geändert
    // Siehe https://tuwel.tuwien.ac.at/mod/forum/discuss.php?d=136099
    public void print(int x) {
        // TODO: Implement this method
        MyListNode mln = poll();
        while (mln != null) {
            if (mln.getP().getBibnumber() <= x) {
                mln.getP().print();
            }
            mln = poll();
        }
        head = first;
    }

    // adhoc 3
    public void print(String x, int y) {
        // TODO: Implement this method

    }



    // Insert p immediately after the last entry in 'this' where race is equal to r.
    // If there is no such entry, insert p before the first entry.
    public void addAfter(String r, Participation p) {
        // TODO: implement this method
        MyListNode mln = poll();
        MyListNode tmpListNode = first;

        while (mln != null) {
            if (mln.getP().getRacer().equals(r)) tmpListNode = mln;
            mln = poll();
        }
        head = first;

        if (tmpListNode == first) {
            first = new MyListNode(p, first, null);
            return;
        }

        tmpListNode.setNext(new MyListNode(p, tmpListNode.getNext(), tmpListNode));
    }

    // Insert p immediately before the first entry in 'this' where race is equal to r.
    // If there is no such entry, insert p after the last entry.
    public void addBefore(String r, Participation p) {
        // TODO: implement this method
        MyListNode mln = poll();
        MyListNode tmpListNode = null;

        while (mln != null) {
            if (mln.getP().getRacer().equals(r)) {
                break;
            }
            tmpListNode = mln;
            mln = poll();
        }
        head = first;

        if (tmpListNode == null) {
            head = first = new MyListNode(p, first, null);
            return;
        }

        tmpListNode.setNext(new MyListNode(p, tmpListNode.getNext(), tmpListNode));
    }

    // Delete every entry in 'this' where race is equal to r.
    public void remove(String r) {
        // TODO: implement this method
        MyListNode mln = poll();

        while (mln != null) {
            if (mln.getP().getRacer().equals(r)) {
                if (mln == first) {
                    first = mln.next;
                }
                if (mln == last) {
                    last = mln.previous;
                }
                mln.remove();
            }
            mln = poll();
        }
        head = first;
    }

    @Override
    public String toString() {
        StringBuilder retString = new StringBuilder();
        MyListNode mln = poll();
        while (mln != null) {
            retString.append(mln.getP().toString());
            retString.append('\n');
            mln = poll();
        }
        head = first;
        return retString.toString();
    }

    // adhoc4
    public String toString(String x, int y) {
        StringBuilder retString = new StringBuilder();
        MyListNode mln = poll();
        while (mln != null) {
            retString.append(mln.getP().toString(x, y));
            retString.append('\n');
            mln = poll();
        }
        head = first;
        return retString.toString();
    }

    private class MyListNode {

        private MyListNode next, previous;
        private Participation p;

        private MyListNode(Participation p, MyListNode next, MyListNode previous) {
            this.next = next;
            this.previous = previous;
            this.p = p;
        }

        private void setNext(MyListNode next) {
            this.next = next;
        }


        private MyListNode getNext() {
            return next;
        }

        private Participation getP() {
            return p;
        }

        private void remove() {
            if (previous != null) {
                previous.next = next;
            }
            if (next != null) {
                next.previous = previous;
            }
        }
    }

    // This method is only for testing.
    // Alternatively, you can put the tests in additional classes.
    public static void main(String[] args) {
        // TODO: write your own test cases here if necessary.
    }
}
