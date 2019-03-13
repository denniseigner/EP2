package main;

import java.util.Arrays;

/*
This class will be used in future assignments.  It is highly
recommended to solve Assignment 1.2.
*/
public class Startlist {

    // Assignment 1.2:

    private Participation[] participations;

    // keeps track on how many participations there are
    private int countParticipations = 0;

    // A new object constructed by
    //  
    //   new Startlist(100)
    //  
    // has room for 100 participations (all 'null' at first)
    public Startlist(int amountOfParticipations) {
        participations = new Participation[amountOfParticipations];
    }
    
    // adds p to 'this'
    public void add(Participation p) {
        participations[countParticipations] = p;
        countParticipations++;
    }

    // Print the filled entries in an arbitrary order; each
    // participation is printed in the same format as produced by
    // print() in Participation, followed by a newline.
    public void print() {
        for (int i = 0; i < countParticipations; i++) {
            participations[i].print();
            System.out.println();
        }
    }
    
    // Print the filled entries in the order of increasing bib
    // numbers; each participation is printed in the same format as
    // produced by print() in Participation, followed by a newline.
    public void printOrdered() {
        Participation[] orderedParticipations = orderParticipations();
        for (int i = 0; i < countParticipations; i++) {
            orderedParticipations[i].print();
            System.out.println();
        }
    }

    // simple selection sort for ordering the participations
    private Participation[] orderParticipations() {
        Participation[] retParticipations = filledParticipations();

        for (int i = 0; i < countParticipations - 1; i++) {
            int smallest = i;
            for (int j = i; j < countParticipations; j++) {
                if (retParticipations[j].getBibnumber() < retParticipations[smallest].getBibnumber())
                    smallest = j;
            }

            Participation tmp = retParticipations[i];
            retParticipations[i] = retParticipations[smallest];
            retParticipations[smallest] = tmp;
        }

        return retParticipations;
    }

    // Questions:

    // 1) In which sensible ways can the program react if more entries
    // are added to 'this' than the array has entries?  What does your
    // program do?
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
    // participations are for the same race.  Do you check this?
    // What is a sensible way to react if this is violated?

    // 1) make the return value of add to Boolean and return true or false, depending on if someone can be added or not
    // In my current implementation the program will just crash with an ArrayIndexOutOfBoundsException

    // 2) I did not require it. It definitely would make it easier, since the ordering for printOrdered() is needed
    // Currently nothing happens if it is inserted twice, but we could add a check in add()

    // 3) I did not check for this, but again, this could easily be done in add()


    // Assignment 1.3:

    // Print all the permutations of the start list, with each
    // permutation followed by an empty line.
    public void printPermutations() {
        permutateParticipations(filledParticipations(), new Participation[0]);

//        printParticipationList(filledParticipations());
//        heapParticipation(filledParticipations(), filledParticipations().length);
    }

    // permutates all S using the heap alogirithm
    private void heapParticipation(Participation[] S, int n) {
        int i;
        for (i = 0; ; i++) {
            if (n > 2)
                heapParticipation(S, n - 1);
            if (i == n - 1)
                break;
            if (n % 2 == 0) {
                Participation tmp = S[i];
                S[i] = S[n - 1];
                S[n - 1] = tmp;
            } else {
                Participation tmp = S[0];
                S[0] = S[n - 1];
                S[n - 1] = tmp;
            }
            printParticipationList(S);
        }
    }

    // returns a list of participations which are added
    private Participation[] filledParticipations() {
        return Arrays.copyOfRange(participations, 0, countParticipations);
    }

    // prints all given participations
    private void printParticipationList(Participation[] participations) {
        for (int i = 0; i < participations.length; i++) {
            participations[i].print();
        }
        System.out.println();
    }

    // permutates all given participations
    private void permutateParticipations(Participation[] left, Participation[] soFar) {
        if (soFar.length == countParticipations) {
            printParticipationList(soFar);
        }

        for (int i = 0; i < left.length; i++) {
            Participation[] newLeft = new Participation[left.length - 1];

            Participation removedValue = null;
            int index = 0;
            for (int j = 0; j < left.length; j++) {
                if (j != i) {
                    newLeft[index++] = left[j];
                } else {
                    removedValue = left[j];
                }
            }

            Participation[] newSoFar = new Participation[soFar.length + 1];

            for (int j = 0; j < soFar.length; j++) {
                newSoFar[j] = soFar[j];
            }
            newSoFar[newSoFar.length - 1] = removedValue;

            permutateParticipations(newLeft, newSoFar);
        }
    }

    // Question:

    // How many calls to your recursive method do you get when you
    // call printPermutations() on a start list with n filled entries?

    // n*n!

    // This method is only for testing.
    // Alternatively, you can put the tests in additional classes.
    public static void main(String[] args) {
        // TODO: write your own test cases here if necessary.
    }
}
