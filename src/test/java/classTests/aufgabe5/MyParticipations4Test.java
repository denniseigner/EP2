package test.java.classTests.aufgabe5;

import main.java.aufgabe1.Participation;
import main.java.aufgabe5.Participations4;
import test.java.miniTestSuite.MyClassTest;
import test.java.miniTestSuite.MyMiniTestSuite;
import test.java.miniTestSuite.MyTestInterface;

public class MyParticipations4Test extends MyClassTest implements MyTestInterface {
    @Override
    public boolean run() {
        return testPrint()
            && testLookupRacer();
    }

    private boolean testPrint() {
        print("testPrint()");

        Participations4 participations = new Participations4(3);

        participations.add(new Participation("Kitzbühel", "Marcel Hirscher", 1));
        participations.add(new Participation("Kitzbühel", "Hermann Maier", 2));
        participations.add(new Participation("Kitzbühel", "Benni Raich", 3));

        MyMiniTestSuite.changeOutToFile();
        participations.print();
        return testPassed(
            MyMiniTestSuite.assertOutContent("2 Hermann Maier (Kitzbühel)\n" +
                "1 Marcel Hirscher (Kitzbühel)\n" +
                "3 Benni Raich (Kitzbühel)\n")
        );
    }

    private boolean testLookupRacer() {
        print("testLookupRacer()");

        Participations4 participations = new Participations4(3);
        Participation lookupParticipation = new Participation("Kitzbühel", "Marcel Hirscher", 1);
        Participation a = new Participation("Kitzbühel", "Hermann Maier", 2);

        participations.add(lookupParticipation);

        return testPassed(
            MyMiniTestSuite.assertEquals(participations.lookupRacer(lookupParticipation), lookupParticipation)
                && MyMiniTestSuite.assertEquals(participations.lookupRacer(a), null)
        );
    }
}
