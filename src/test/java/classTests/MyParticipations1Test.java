package test.java.classTests;

import main.java.aufgabe1.Participation;
import main.java.aufgabe3.Participations1;
import test.java.miniTestSuite.MyClassTest;
import test.java.miniTestSuite.MyMiniTestSuite;
import test.java.miniTestSuite.MyTestInterface;

public class MyParticipations1Test extends MyClassTest implements MyTestInterface {

    @Override
    public boolean run() {
        return testParticipations1Overload()
            && testPrint()
            && testLookupRacer()
            && testFirst()
            && testPrintWithConstraints();
    }

    private boolean testParticipations1Overload() {
        print("testParticipations1Overload()");
        Participations1 participationsOverload = new Participations1(2);

        participationsOverload.add(new Participation("Kitzbühel", "Marcel Hirscher", 1));
        participationsOverload.add(new Participation("Kitzbühel", "Hermann Maier", 2));
        participationsOverload.add(new Participation("Kitzbühel", "Benni Raich", 3));

        return testPassed(true);
    }

    private boolean testPrint() {
        print("testPrint()");

        Participations1 participations = new Participations1();

        participations.add(new Participation("Kitzbühel", "Marcel Hirscher", 1));
        participations.add(new Participation("Kitzbühel", "Hermann Maier", 2));
        participations.add(new Participation("Kitzbühel", "Benni Raich", 3));

        MyMiniTestSuite.changeOutToFile();
        participations.print();
        return testPassed(
            MyMiniTestSuite.assertOutContent("1 Marcel Hirscher (Kitzbühel)\n" +
            "2 Hermann Maier (Kitzbühel)\n" +
            "3 Benni Raich (Kitzbühel)")
        );
    }

    private boolean testLookupRacer() {
        print("testLookupRacer()");

        Participations1 participations = new Participations1();
        String lookupName = "Marcel Hirscher";
        Participation lookupParticipation = new Participation("Kitzbühel", lookupName, 1);
        String lookupWrongName = "aldskjfhalsdhflajhsdf";

        participations.add(lookupParticipation);
        participations.add(new Participation("Kitzbühel", "Hermann Maier", 2));
        participations.add(new Participation("Kitzbühel", "Benni Raich", 3));

        return testPassed(
            MyMiniTestSuite.assertEquals(participations.lookupRacer(lookupName), lookupParticipation)
            && MyMiniTestSuite.assertEquals(participations.lookupRacer(lookupWrongName), null)
        );
    }

    private boolean testFirst() {
        print("testFirst()");

        Participations1 participations = new Participations1();
        Participations1 participationsEmpty = new Participations1();
        Participation first = new Participation("Kitzbühel", "Marcel Hirscher", 1);

        participations.add(first);
        participations.add(new Participation("Kitzbühel", "Hermann Maier", 2));
        participations.add(new Participation("Kitzbühel", "Benni Raich", 3));

        return testPassed(
            MyMiniTestSuite.assertEquals(participations.first(), first)
            && MyMiniTestSuite.assertEquals(participationsEmpty.first(), null)
        );
    }

    private boolean testPrintWithConstraints() {
        print("testPrintWithConstraints()");

        Participations1 participations = new Participations1();

        participations.add(new Participation("Kitzbühel", "Marcel Hirscher", 1));
        participations.add(new Participation("Kitzbühel", "Hermann Maier", 2));
        participations.add(new Participation("Kitzbühel", "Benni Raich", 3));
        participations.add(new Participation("Schladming", "Benni Raich", 4));
        participations.add(new Participation("Schladming", "Marcel Hirscher", 5));

        MyMiniTestSuite.changeOutToFile();
        participations.print(3);

        return testPassed(
            MyMiniTestSuite.assertOutContent("1 Marcel Hirscher (Kitzbühel)\n" +
                "2 Hermann Maier (Kitzbühel)\n" +
                "3 Benni Raich (Kitzbühel)")
        );
    }
}
