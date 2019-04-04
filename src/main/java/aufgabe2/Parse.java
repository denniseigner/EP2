package main.java.aufgabe2;

import main.java.aufgabe3.CharStack1;

import java.util.Arrays;

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

        if (s.length() == 0) return true;

        String[] pairs = {
            "()",
            "[]",
            "{}",
            "<>"
        };

        String old = s;
        for (String pair : pairs) {
            s = s.replace(pair, "");
        }

        return !s.equals(old) && parseRec(s);
    }

    // Assignment 2.2 (partly also in CharStack.java)

    // returns true, if s is a properly parenthesized string,
    // otherwise false.  See parseRec for details.
    public static boolean parseStack(String s)
    {
        // TODO: implement this method using class 'CharStack', and no recursion

        if (s.length() == 0) return true;

        CharStack cs = new CharStack();
        char[][] pairs = {
            { '(', ')' },
            { '[', ']' },
            { '{', '}' },
            { '<', '>' }
        };

        for (char c : s.toCharArray()) {
            if (isOpening(pairs, c))
                cs.push(c);
            if (isClosing(pairs, c) && cs.pop() != getPair(pairs, c) || !contains(pairs, c))
                return false;
        }

        return cs.isEmpty();
    }

    private static char getPair(char[][] pairs, char c) {
        for (char[] pair : pairs) {
            if (c == pair[1]) return pair[0];
        }
        return 0;
    }

    private static boolean isOpening(char[][] pairs, char c) {
        for (char[] pair : pairs) {
            if (c == pair[0]) return true;
        }
        return false;
    }

    private static boolean isClosing(char[][] pairs, char c) {
        for (char[] pair : pairs) {
            if (c == pair[1]) return true;
        }
        return false;
    }

    private static boolean contains(char[][] pairs, char c) {
        return isClosing(pairs, c) || isOpening(pairs, c);
    }

    public static boolean parseStack1(String s)
    {

        if (s.length() == 0) return true;

        CharStack1 cs = new CharStack1();
        char[][] pairs = {
            { '(', ')' },
            { '[', ']' },
            { '{', '}' },
            { '<', '>' }
        };

        for (char c : s.toCharArray()) {
            if (isOpening(pairs, c))
                cs.push(c);
            if (isClosing(pairs, c) && cs.pop() != getPair(pairs, c) || !contains(pairs, c))
                return false;
        }

        return cs.isEmpty();
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
