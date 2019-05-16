package test.java.miniTestSuite;

import test.java.classTests.aufgabe1.MyParticipationTest;
import test.java.classTests.aufgabe1.MyStartlistTest;
import test.java.classTests.aufgabe2.MyCharStackTest;
import test.java.classTests.aufgabe2.MyParseTest;
import test.java.classTests.aufgabe2.MyParticipationsTest;
import test.java.classTests.aufgabe3.MyCharStack1Test;
import test.java.classTests.aufgabe3.MyParticipations1Test;
import test.java.classTests.aufgabe3.MyParticipations2Test;
import test.java.classTests.aufgabe4.MyParticipations3Test;
import test.java.classTests.aufgabe5.MyParticipations4Test;

public class MyTestRunner {
    public static void main(String[] args) {
        boolean run = new MyParticipationTest().run()
            && new MyStartlistTest().run()
            && new MyParseTest().run()
            && new MyCharStackTest().run()
            && new MyParticipationsTest().run()
            && new MyParticipations1Test().run()
            && new MyParticipations2Test().run()
            && new MyCharStack1Test().run()
            && new MyParticipations3Test().run()
            && new MyParticipations4Test().run();

        System.out.println("All Tests succesfully run");
    }
}
