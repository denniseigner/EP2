/*
This class will be used in future assignments.  It is highly
recommended to solve Assignment 1.2.
*/
public class Startlist {

    // Assignment 1.2:
    
    // TODO: The object variable "participations", which is an array
    //  of Participation objects, shall be declared here.

    // TODO: A constructor for this class shall be defined here.
    // A new object constructed by
    //  
    //   new Startlist(100)
    //  
    // has room for 100 Participations (but all NULL at first)
    
    // adds Participation p to the Startlist
    public void add(Participation p) {
        // TODO: Implement this method
    }

    // Print the filled entries in an arbitrary order; each
    // participant is printed in the same format as produced by
    // Participant.print(), followed by a newline.
    public void print() {
        // TODO: Implement this method
    }
    
    // Print the filled entries in the order of increasing bib
    // numbers; each participant is printed in the same format as
    // produced by Participant.print(), followed by a newline.
    public void printOrdered() {
        // TODO: Implement this method
    }

    // Questions:

    // 1) In which sensible ways can the program react if more entries
    // are added to the start list than the array has entries?  What
    // does your program do?
    // 
    // 2) Frequent requirements for start lists are that all the bib
    // numbers in a race are different, contiguous, and start at 1.
    // We did not require these in this assignment.  Did you?  If so,
    // did this simplify the implementation?  How much more complex
    // would your program become if you lifted one or several of these
    // requirements?  With such requirements, what are sensible ways
    // to react to violations of these requirements?  In particular,
    // what happens if the same bib number is inserted twice?
    // 
    // 3) Another requirement for a start list is that all
    // participations are for the same race.  Do you check this?  What
    // is a sensible way to react if this is violated?


    // Assignment 1.3:

    // Print all the permutations of the startlist, with each
    // permutation followed by an empty line.
    public void printpermutations() {
        // TODO: Implement this method using a recursive algorithm.
    }

    // Question:

    // How many calls to your recursive method do you get when you
    // call printpermutations() on a Startlist with n filled entries?


    // This method is only for testing.
    // Alternatively, you can put the tests in additional classes.
    public static void main(String[] args) {
        // TODO: write your own test cases here if necessary.
    }
}
