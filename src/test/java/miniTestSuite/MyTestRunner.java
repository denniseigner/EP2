package test.java.miniTestSuite;

import test.java.classTests.*;

public class MyTestRunner {
    public static void main(String[] args) {
        boolean run = new MyParticipationTest().run()
            && new MyStartlistTest().run()
            && new MyParseTest().run()
            && new MyCharStackTest().run()
            && new MyParticipationsTest().run();

        System.out.println(run ? "All Tests passed" : "Test failed");
    }
}
