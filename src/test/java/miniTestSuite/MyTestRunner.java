package test.java.miniTestSuite;

import test.java.classTests.*;

public class MyTestRunner {
    public static void main(String[] args) {
        boolean run = new MyParticipationTest().run()
            && new MyStartlistTest().run()
            && new MyParseTest().run()
            && new MyCharStackTest().run()
            && new MyParticipationsTest().run()
            && new MyParticipations1Test().run()
            && new MyParticipations2Test().run()
            && new MyCharStack1Test().run();

        System.out.println("All Tests succesfully run");
    }
}
