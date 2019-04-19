package test.java.classTests;

import main.java.aufgabe1.Participation;
import main.java.aufgabe4.Participations3;
import test.java.miniTestSuite.MyClassTest;
import test.java.miniTestSuite.MyMiniTestSuite;
import test.java.miniTestSuite.MyTestInterface;

public class MyParticipations3Test extends MyClassTest implements MyTestInterface  {
    @Override
    public boolean run() {
        return testPrint()
            && testLookupRacer()
            && testToString();
    }

    private boolean testPrint() {
        print("testPrint()");

        Participations3 participations = new Participations3();

        participations.add(new Participation("Kitzbühel", "Marcel Hirscher", 1));
        participations.add(new Participation("Kitzbühel", "Hermann Maier", 2));
        participations.add(new Participation("Kitzbühel", "Benni Raich", 3));
        participations.add(new Participation("Schladming", "Benni Raich", 4));
        participations.add(new Participation("Schladming", "Marcel Hirscher", 5));

        MyMiniTestSuite.changeOutToFile();
        participations.print();

        return testPassed(MyMiniTestSuite.assertOutContent("3 Benni Raich (Kitzbühel)\n" +
            "4 Benni Raich (Schladming)\n" +
            "2 Hermann Maier (Kitzbühel)\n" +
            "1 Marcel Hirscher (Kitzbühel)\n" +
            "5 Marcel Hirscher (Schladming)")
        );
    }

    private boolean testLookupRacer() {
        print("testLookupRacer()");

        Participations3 participations = new Participations3();
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

    private boolean testToString() {
        print("testToString()");

        Participations3 participations = new Participations3();

        participations.add(new Participation("Kitzbühel", "Marcel Hirscher", 1));
        participations.add(new Participation("Kitzbühel", "Hermann Maier", 2));
        participations.add(new Participation("Kitzbühel", "Benni Raich", 3));
        participations.add(new Participation("Schladming", "Benni Raich", 4));
        participations.add(new Participation("Schladming", "Marcel Hirscher", 5));

        MyMiniTestSuite.changeOutToFile();
        System.out.println(participations);

        return testPassed(MyMiniTestSuite.assertOutContent("3 Benni Raich (Kitzbühel)\n" +
            "4 Benni Raich (Schladming)\n" +
            "2 Hermann Maier (Kitzbühel)\n" +
            "1 Marcel Hirscher (Kitzbühel)\n" +
            "5 Marcel Hirscher (Schladming)")
        );
    }
}
