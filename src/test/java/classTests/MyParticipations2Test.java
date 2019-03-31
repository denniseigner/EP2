package test.java.classTests;

import main.java.aufgabe1.Participation;
import main.java.aufgabe3.Participations2;
import test.java.miniTestSuite.MyClassTest;
import test.java.miniTestSuite.MyMiniTestSuite;
import test.java.miniTestSuite.MyTestInterface;

public class MyParticipations2Test extends MyClassTest implements MyTestInterface {

    @Override
    public boolean run() {
        return testPrint()
            && testLookupRacer();
    }

    private boolean testPrint() {
        print("testPrint()");

        Participations2 participations = new Participations2();
        Participations2 participationsOverload = new Participations2(2);
        boolean threwException = false;

        participations.add(new Participation("Kitzbühel", "Marcel Hirscher", 1));
        participations.add(new Participation("Kitzbühel", "Hermann Maier", 2));
        participations.add(new Participation("Kitzbühel", "Benni Raich", 3));
        participations.add(new Participation("Schladming", "Benni Raich", 4));
        participations.add(new Participation("Schladming", "Marcel Hirscher", 5));

        try {
            participationsOverload.add(new Participation("Kitzbühel", "Marcel Hirscher", 1));
            participationsOverload.add(new Participation("Kitzbühel", "Hermann Maier", 2));
            participationsOverload.add(new Participation("Kitzbühel", "Benni Raich", 3));
        } catch (Exception ex) {
            threwException = true;
        }

        MyMiniTestSuite.changeOutToFile();
        participations.print();

        return testPassed(MyMiniTestSuite.assertOutContent("3 Benni Raich (Kitzbühel)\n" +
            "4 Benni Raich (Schladming)\n" +
            "2 Hermann Maier (Kitzbühel)\n" +
            "1 Marcel Hirscher (Kitzbühel)\n" +
            "5 Marcel Hirscher (Schladming)")
            && threwException);
    }

    private boolean testLookupRacer() {
        print("testLookupRacer()");

        Participations2 participations = new Participations2();
        String lookupName = "Marcel Hirscher";
        Participation lookupParticipation = new Participation("Kitzbühel", lookupName, 1);
        String lookupWrongName = "aldskjfhalsdhflajhsdf";

        participations.add(lookupParticipation);
        participations.add(new Participation("Kitzbühel", "Hermann Maier", 2));
        participations.add(new Participation("Kitzbühel", "Benni Raich", 3));
        participations.add(new Participation("Schladming", "Benni Raich", 4));
        participations.add(new Participation("Schladming", lookupName, 5));

        return testPassed(MyMiniTestSuite.assertEquals(participations.lookupRacer(lookupName), lookupParticipation)
            && MyMiniTestSuite.assertEquals(participations.lookupRacer(lookupWrongName), null));
    }
}
