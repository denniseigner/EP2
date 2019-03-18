/*
This class will be used in future assignments and in the ad-hoc
assignment.  It is recommended to solve Assignment 2.3 and 2.4
*/
public class Participations {

    // introduce (private) object variables as needed

    // Assignment 2.3

    // In general, Objects of class 'Participations' contain
    // participations from many races.  Use an array to implement this
    // class.

    // creates an empty object of this class
    public Participations(int n) {
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

    // Frage:

    // Wie unterscheidet sich Ihre Implementierung von Participations
    // bis hierher von Ihrer Implementierung von StartList?  Wenn Sie
    // in StartList Vorbedingungen ausgenutzt haben, um die
    // Implementierung zu vereinfachen, hat sich das in der
    // Gesamtsicht ausgezahlt?  Begründen Sie Ihre Antwort.


    // returns the first participation (the one that was inserted
    // earliest) in 'this' where the 'racer' equals 'r'.  If there is
    // no such participation, return null.
    public Participation lookupRacer(String r) {
        // TODO: Implement this method
    }

    // Frage:

    // Wie können Sie die letzte participation mit diesem racer
    // zurückgeben?  Ist das aufwändiger zu Programmieren?  Ist es zur
    // Laufzeit aufwändiger?


    // Assignment 2.4
    
    // create a startlist that contains all participations where the
    // race >= r1 and where the race <= r2, in the same order.
    public Participations(Participations l, String r1, String r2) {
        // TODO: Implement this constructor
    }

    
    
    // This method is only for testing.
    // Alternatively, you can put the tests in additional classes.
    public static void main(String[] args) {
        // TODO: write your own test cases here if necessary.
    }
}
