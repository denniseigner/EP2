package test.java.classTests.aufgabe3;

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
            && testPrintWithConstraints()
            && testAddAfter()
            && testAddBefore()
            && testRemove();
    }

    private boolean testParticipations1Overload() {
        print("testParticipations1Overload()");
        Participations1 participationsOverload = new Participations1(2);

        MyMiniTestSuite.changeErrToFile();

        participationsOverload.add(new Participation("Kitzbühel", "Marcel Hirscher", 1));
        participationsOverload.add(new Participation("Kitzbühel", "Hermann Maier", 2));
        participationsOverload.add(new Participation("Kitzbühel", "Benni Raich", 3));

        return testPassed(MyMiniTestSuite.assertOutContent("Cannot add any more Participations"));
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
            && MyMiniTestSuite.assertEquals(participations.lookupRacer(lookupName), lookupParticipation)
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

    private boolean testAddAfter() {
        print("testAddAfter()");

        Participations1 participations = new Participations1();

        participations.add(new Participation("Kitzbühel", "Marcel Hirscher", 1));
        participations.add(new Participation("Kitzbühel", "Hermann Maier", 2));
        participations.add(new Participation("Kitzbühel", "Benni Raich", 3));
        participations.add(new Participation("Schladming", "Marcel Hirscher", 4));
        participations.add(new Participation("Schladming", "Benni Raich", 5));

        participations.addAfter("Lindsey Vonn", new Participation("Schladming", "Lindsey Vonn", 10));
        participations.addAfter("Marcel Hirscher", new Participation("Kitzbühel", "Lindsey Vonn", 15));
        participations.addAfter("Benni Raich", new Participation("Planai", "Lindsey Vonn", 20));

        MyMiniTestSuite.changeOutToFile();
        participations.print();

        return testPassed(
            MyMiniTestSuite.assertOutContent(
                "10 Lindsey Vonn (Schladming)\n" +
                    "1 Marcel Hirscher (Kitzbühel)\n" +
                    "2 Hermann Maier (Kitzbühel)\n" +
                    "3 Benni Raich (Kitzbühel)\n" +
                    "4 Marcel Hirscher (Schladming)\n" +
                    "15 Lindsey Vonn (Kitzbühel)\n" +
                    "5 Benni Raich (Schladming)\n" +
                    "20 Lindsey Vonn (Planai)"
            )
        );
    }

    private boolean testAddBefore() {
        print("testAddBefore()");

        Participations1 participations = new Participations1();

        participations.add(new Participation("Kitzbühel", "Marcel Hirscher", 1));
        participations.add(new Participation("Kitzbühel", "Hermann Maier", 2));
        participations.add(new Participation("Kitzbühel", "Benni Raich", 3));
        participations.add(new Participation("Schladming", "Marcel Hirscher", 4));
        participations.add(new Participation("Schladming", "Benni Raich", 5));

        participations.addBefore("Lindsey Vonn", new Participation("Schladming", "Lindsey Vonn", 20));
        participations.addBefore("Hermann Maier", new Participation("Kitzbühel", "Lindsey Vonn", 15));
        participations.addBefore("Marcel Hirscher", new Participation("Kitzbühel", "Lindsey Vonn", 10));

        MyMiniTestSuite.changeOutToFile();
        participations.print();

        return testPassed(
            MyMiniTestSuite.assertOutContent(
            "10 Lindsey Vonn (Kitzbühel)\n" +
                "1 Marcel Hirscher (Kitzbühel)\n" +
                "15 Lindsey Vonn (Kitzbühel)\n" +
                "2 Hermann Maier (Kitzbühel)\n" +
                "3 Benni Raich (Kitzbühel)\n" +
                "4 Marcel Hirscher (Schladming)\n" +
                "5 Benni Raich (Schladming)\n" +
                "20 Lindsey Vonn (Schladming)"
            )
        );
    }

    private boolean testRemove() {
        print("testAddBefore()");

        Participations1 participations = new Participations1();

        participations.add(new Participation("Kitzbühel", "Benni Raich", 10));
        participations.add(new Participation("Kitzbühel", "Marcel Hirscher", 1));
        participations.add(new Participation("Kitzbühel", "Hermann Maier", 2));
        participations.add(new Participation("Kitzbühel", "Benni Raich", 3));
        participations.add(new Participation("Schladming", "Marcel Hirscher", 4));
        participations.add(new Participation("Schladming", "Benni Raich", 5));

        participations.remove("Benni Raich");

        MyMiniTestSuite.changeOutToFile();
        participations.print();

        return testPassed(
            MyMiniTestSuite.assertOutContent(
                "1 Marcel Hirscher (Kitzbühel)\n" +
                    "2 Hermann Maier (Kitzbühel)\n" +
                    "4 Marcel Hirscher (Schladming)"
            )
        );
    }
}
