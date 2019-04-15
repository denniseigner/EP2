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
    private MyList partList;

    // Creates an empty object of this class
    public Participations1(int n) {
        // TODO: implement this constructor
        partList = new MyList(n);
    }

    // Creates an empty object of this class
    public Participations1() {
        // TODO: implement this constructor
        partList = new MyList();
    }

    // Adds p to 'this'.
    public void add(Participation p) {
        // TODO: Implement this method
        partList.addParticipation(p);
    }

    // Print the entries in the order of insertion; each participation
    // is printed in the same format as produced by print() in
    // Participation, followed by a newline.
    public void print() {
        // TODO: Implement this method
        partList.print();
    }

    // Returns the first participation (the one that was inserted
    // earliest) in 'this' where the 'racer' equals 'r'.  If there is
    // no such participation, return null.
    public Participation lookupRacer(String r) {
        // TODO: Implement this method
        return partList.lookupRacer(r);
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
        return partList.first();
    }


    // Assignment 3.3 (continued in Participations2.java)

    // print the entries with bibnumber<=x in the order of insertion;
    // each participation is printed in the same format as produced by
    // print() in Participation, followed by a newline.

    // Anmerkung: Methodenheader auf public geändert
    // Siehe https://tuwel.tuwien.ac.at/mod/forum/discuss.php?d=136099
    public void print(int x) {
        // TODO: Implement this method
        partList.print(x);
    }

    // adhoc 3
    public void print(String x, int y) {
        // TODO: Implement this method

    }

    // Insert p immediately after the last entry in 'this' where race is equal to r.
    // If there is no such entry, insert p before the first entry.
    public void addAfter(String r, Participation p) {
        // TODO: implement this method
        partList.addAfter(r, p);
    }

    private class MyList {

        MyListNode head, last, first;
        int counter, maxCount;
        boolean limited;

        private MyList() {

        }

        private MyList(int maxCount) {
            counter = 0;
            this.maxCount = maxCount;
            limited = true;
        }

        private void addParticipation(Participation p) {
            if (++counter > maxCount && limited) {
                System.err.println("Cannot add any more Participations");
            }

            if (head == null) {
                head = last = first =  new MyListNode(p, null);
                return;
            }
            last.setNext(last = new MyListNode(p, null));
        }

        private MyListNode poll() {
            if (head == null) return null;
            MyListNode mln = head;
            head = head.getNext();
            if (head == null) {
                last = null;
            }
            return mln;
        }

        private void print() {
            MyListNode mln = poll();
            while (mln != null) {
                mln.getP().print();
                mln = poll();
            }
        }

        private void print(int x) {
            MyListNode mln = poll();
            while (mln != null) {
                if (mln.getP().getBibnumber() <= x) {
                    mln.getP().print();
                }
                mln = poll();
            }
        }

        private Participation lookupRacer(String r) {
            MyListNode mln = poll();
            while (mln != null) {
                if (mln.getP().getRacer().equals(r)) return mln.getP();
                mln = poll();
            }
            head = first;
            return null;
        }

        private Participation first() {
            if (head == null) return null;
            return head.getP();
        }

        private void addAfter(String r, Participation p) {
            MyListNode mln = poll();
            MyListNode tmpListNode = first;

            while (mln != null) {
                if (mln.getP().getRacer().equals(r)) tmpListNode = mln;
                mln = poll();
            }
            head = first;

            if (tmpListNode == first) {
                MyListNode newFirst = new MyListNode(p, first);
                first = newFirst;
                return;
            }

            tmpListNode.setNext(new MyListNode(p, tmpListNode.getNext()));
        }

        private class MyListNode {

            private MyListNode next;
            private Participation p;

            private MyListNode(Participation p, MyListNode next) {
                this.next = next;
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
        }
    }

    // This method is only for testing.
    // Alternatively, you can put the tests in additional classes.
    public static void main(String[] args) {
        // TODO: write your own test cases here if necessary.
    }
}
