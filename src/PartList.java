/*
This class will be used in future assignments and in the ad-hoc
assignment.  It is highly recommended to solve Assignment 2.1 and 2.3
*/
public class PartList {

    // introduce (private) object variables as needed

    // Assignment 2.1

    // implement a class like 'Startlist', but use a linked list
    // instead of an array; note that 'print' has additional
    // requirements compared to 'print' of 'Startlist'

    // creates an empty object of this class
    public Startlist1(int n) {
        // TODO: implement this constructor
    }

    // adds p to 'this'
    public void add(Participation p) {
        // TODO: Implement this method
    }
    
    // Print the filled entries in the order of insertion; each
    // participation is printed in the same format as produced by
    // print() in Participation, followed by a newline.
    public void print() {
        // TODO: Implement this method
    }

    // Fragen:

    // 1) Hat der Parameter des Konstruktors eine Funktion? Wenn doch,
    // welche? Wenn nicht, ist es sinnvoll, den Parameter zu behalten?
    // Warum, bzw. warum nicht?

    // 2) Welche Vor- und Nachteile hat die Implementierung von
    // 'Startlist1' im Vergleich zu 'Startlist'? Wäre eine
    // Array-Implementierung, die das Array gegen ein doppelt so
    // großes tauscht, wenn der Platz nicht mehr reicht, für diese
    // Aufgabe weniger aufwändig? Ändert sich Ihre Einschätzung, wenn
    // Sie auch die weiteren von Ihnen gelösten Aufgaben
    // berücksichtigen?

    // 3) Muss Ihre Implementierung bei jedem add-Aufruf die ganze
    // Liste durchgehen? Wenn ja, wie könnte man das vermeiden und
    // wieviel Programmieraufwand wäre nötig? Wenn nein, wieviel
    // Programmieraufwand hat das gekostet?


    // Assignment 2.2

    // returns the first participation (the one that was inserted
    // earliest) in 'this' where the 'racer' equals 'r'.  If there is
    // no such participation, return null.
    public Participation lookupRacer(String r) {
        // TODO: Implement this method
    }

    // Frage:

    // Wie können Sie die letzte participation mit diesem racer
    // zurückgeben?  Ist das aufwändiger?


    // Assignment 2.3
    
    // create a startlist that contains all participations where the
    // race >= r1 and where the race <= r2, in the same order.
    public PartList(PartList l, String r1, String r2) {
        // TODO: Implement this constructor
    }

    // Frage:

    // Wäre die Aufgabe einfacher, wenn man die Reihenfolge der Songs
    // nicht erhalten müsste? Warum bzw. warum nicht?


    // Assignment 2.4

    // Inserts 'p' in 'this' after the last Participation with race
    // 'r', or at the end if there is no Participation with race 'r'.
    void addAfter(String r, Participation p) {
        // TODO: Implement this method
    }

    // Frage:

    // Wäre diese Aufgabe in einer Implementierung mit Arrays leichter
    // zu lösen? Was hätte so eine Variante sonst für Vor- und
    // Nachteile?


    // Assignment 2.5
    
    // Inserts 'p' in 'this' before the firs Participation with race
    // 'r', or at the end if there is no Participation with race 'r'.
    void addBefore(String r, Participation p) {
        // TODO: Implement this method
    }

    // Frage:

    // Wäre diese Aufgabe in einer Implementierung mit Arrays leichter
    // zu lösen? Was hätte so eine Variante sonst für Vor- und
    // Nachteile?

    // This method is only for testing.
    // Alternatively, you can put the tests in additional classes.
    public static void main(String[] args) {
        // TODO: write your own test cases here if necessary.
    }
}
