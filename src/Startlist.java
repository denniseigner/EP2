/*
This class has an object variable "participations", which is an array
of Participation objects.

Write a constructor that creates a Startlist with room for 100 entries
(but none filled at first), with

new Startlist(100)

Write non-static methods

void add(Participation p)
void print()
void printOrdered()

where print() prints the filled entries in an arbitrary order, while
printOrdered() prints them in the order of increasing bib numbers.
Both print each participant in the same format as produced by
Participant.print(), followed by a newline.

Questions:

In which sensible ways can the program react if more entries are added
to the start list than the array has entries?  What does your program
do?

Frequent requirements for start lists are that all the bib numbers in
a race are different, contiguous, and start at 1.  We did not require
these in this assignment.  Did you?  If so, did this simplify the
implementation?  How much more complex would your program become if
you lifted one or several of these requirements?  With such
requirements, what are sensible ways to react to violations of these
requirements?  In particular, what happens if the same bib number is
inserted twice?

Another requirement for a start list is that all participations are
for the same race.  Do you check this?  What is a sensible way to
react if this is violated?

Assignment 3:

Add the following method to Startlist:

void printpermutations()

prints all the permutations of the startlist, with each permutation
followed by an empty line.  Use a recursive algorithm.

Questions: How many calls to your recursive method do you get when you
call printpermutations() on a Startlist with n filled entries?
 */
public class Startlist {
}
