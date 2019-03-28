package test.java.miniTestSuite;

public class MyClassTest {

    private final String ANSI_RESET = "\u001B[0m";
    private final String ANSI_RED = "\u001B[31m";

    protected void print(String testName) {
        System.out.println("Testing " + getClass().getSimpleName() + " " + testName);
    }

    protected boolean testPassed(boolean passed) {
        System.out.print(!passed ? ANSI_RED + "Test failed!\n" + ANSI_RESET : "");

        return true;
    }
}
