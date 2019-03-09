package tests.miniTestSuite;

import tests.classTests.MyParticipationTest;

public class MyTestRunner {
    public static void main(String[] args) {
        boolean run = new MyParticipationTest().run();

        System.out.println(run ? "All Tests passed" : "Test failed");
    }
}
