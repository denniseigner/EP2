package test.java.miniTestSuite;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class MyMiniTestSuite {
    private static PrintStream console = System.out;

    public static boolean assertEquals(String is, String should) {
        return is.contentEquals(should);
    }

    public static boolean assertEquals(int is, int should) {
        return is == should;
    }

    public static boolean assertEquals(char is, char should) {
        return is == should;
    }

    public static boolean assertEquals(Object is, Object should) {
        return is == should;
    }

    public static boolean assertTrue(boolean is) {
        return is;
    }

    public static boolean assertFalse(boolean is) {
        return !is;
    }

    public static void changeOutToFile() {
        PrintStream o = null;
        try {
            o = new PrintStream(new File("A.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.setOut(o);
    }

    public static void changeOutToConsole() {
        System.setOut(console);
    }

    public static boolean assertOutContent(String is) {
        String content;
        changeOutToConsole();
        try {
            content = new Scanner(new File("A.txt")).useDelimiter("\\Z").next();
        } catch (FileNotFoundException e) {
            return false;
        }

        new File("A.txt").delete();

        return assertEquals(is, content);
    }
}
