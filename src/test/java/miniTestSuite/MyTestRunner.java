package test.java.miniTestSuite;

import test.java.classTests.MyCharStackTest;
import test.java.classTests.MyParseTest;
import test.java.classTests.MyParticipationTest;
import test.java.classTests.MyStartlistTest;

public class MyTestRunner {
    public static void main(String[] args) {
        boolean run = new MyParticipationTest().run()
            && new MyStartlistTest().run()
            && new MyParseTest().run()
            && new MyCharStackTest().run();

        System.out.println(run ? "All Tests passed" : "Test failed");
    }
}
