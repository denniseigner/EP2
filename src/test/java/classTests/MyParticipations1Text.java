package test.java.classTests;

import main.java.aufgabe1.Participation;
import main.java.aufgabe3.Participations1;
import test.java.miniTestSuite.MyClassTest;
import test.java.miniTestSuite.MyMiniTestSuite;
import test.java.miniTestSuite.MyTestInterface;

public class MyParticipations1Text extends MyClassTest implements MyTestInterface {

    @Override
    public boolean run() {
        return testPrint();
    }

    private boolean testPrint() {
        print("testPrint()");

        Participations1 participations = new Participations1();

        participations.add(new Participation("Kitzbühel", "Marcel Hirscher", 1));
        participations.add(new Participation("Kitzbühel", "Hermann Maier", 2));
        participations.add(new Participation("Kitzbühel", "Benni Raich", 3));

        MyMiniTestSuite.changeOutToFile();
        participations.print();
        return testPassed(MyMiniTestSuite.assertOutContent("1 Marcel Hirscher (Kitzbühel)\n" +
            "2 Hermann Maier (Kitzbühel)\n" +
            "3 Benni Raich (Kitzbühel)"));
    }
}
