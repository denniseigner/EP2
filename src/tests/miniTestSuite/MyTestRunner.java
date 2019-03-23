package tests.miniTestSuite;

import tests.classTests.MyParticipationTest;
import tests.classTests.MyStartlistTest;

public class MyTestRunner {
    public static void main(String[] args) {
        boolean run = new MyParticipationTest().run()
            && new MyStartlistTest().run();

        System.out.println(run ? "All Tests passed" : "Test failed");
    }
}
