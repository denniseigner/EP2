public class Parse {

    // Assignment 2.1

    // returns true, if s is a properly parenthesized string,
    // otherwise false.  The opening parenthesis '(' is closed with
    // ')', '[' with ']', '{' with '}', and '<' with '>'.  A properly
    // parenthesized string contains either nothing, or an opening
    // parenthesis followed by a properly parenthesized string, then
    // a closing parenthesis matching the opening parenthesis, then a
    // properly parenthesized string.  Examples for properly
    // parenthesized strings are "", "()<>", "(([(<>)])){()}<{}>".
    // By contrast, "(", ")", "(a)", "(]" are not properly
    // parenthesized.
    public static boolean parseRec(String s)
    {
        // TODO: implement this method using recursion
        return false;
    }

    // Assignment 2.2 (partly also in CharStack.java)

    // returns true, if s is a properly parenthesized string,
    // otherwise false.  See parseRec for details.
    public static boolean parseStack(String s)
    {
        // TODO: implement this method using class 'CharStack', and no recursion
        return false;
    }

    // Fragen:

    // 1) Vergleichen Sie ParseRec mit ParseStack (+CharStack).  Was
    // war einfacher zu programmieren?  Was war einfacher zu
    // verstehen?  Waren bestimmte Aspekte in einer Variante einfacher
    // und andere in der anderen?

    // 2) Braucht ParseStack für sehr tief verschachtelte Strings mehr
    // oder weniger Speicher als ParseRec?  Begründen Sie Ihre
    // Antwort.  Eine faktisch falsche Antwort auf diese Frage ist
    // nicht so tragisch, solange die Begründung erkennen läßt, dass
    // sie sich ernsthaft damit auseinendergesetzt haben.


    // This method is only for testing.
    // Alternatively, you can put the tests in additional classes.
    public static void main(String[] args) {
        // TODO: write your own test cases here if necessary.
    }
}
