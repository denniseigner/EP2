package test.java.classTests.aufgabe5;

import main.java.aufgabe1.Participation;
import main.java.aufgabe5.Participations4;
import main.java.aufgabe6.StringIterable;
import main.java.aufgabe6.StringIterator;
import test.java.miniTestSuite.MyClassTest;
import test.java.miniTestSuite.MyMiniTestSuite;
import test.java.miniTestSuite.MyTestInterface;

import java.util.Iterator;

public class MyParticipations4Test extends MyClassTest implements MyTestInterface {
    @Override
    public boolean run() {
        return testPrint()
            && testLookupRacer()
            && testIterator()
            && testCopyRaces()
            && testViewRaces()
            && testViewRacesNew();
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

    private boolean testIterator() {
        print("testIterator()");

        Participations4 participations = new Participations4(100);

        Participation a = new Participation("Kitzbühel1", "Marcel Hirscher", 1);
        Participation b = new Participation("Kitzbühel2", "Hermann Maier", 2);
        Participation c = new Participation("Kitzbühel3", "Benni Raich", 3);

        participations.add(a);
        participations.add(b);
        participations.add(c);

        Iterator partIterator = participations.iterator();

        return testPassed(
            MyMiniTestSuite.assertTrue(partIterator.next().equals(a))
                && MyMiniTestSuite.assertTrue(partIterator.next().equals(c))
                && MyMiniTestSuite.assertTrue(partIterator.next().equals(b))
                && MyMiniTestSuite.assertFalse(partIterator.hasNext())
        );
    }

    private boolean testCopyRaces() {
        print("testCopyRaces()");

        Participations4 participations = new Participations4(100);

        String race1 = "Kitzbühel";
        String race2 = "Schladming";

        participations.add(new Participation(race1, "Marcel Hirscher", 1));
        participations.add(new Participation(race1, "Hermann Maier", 2));
        participations.add(new Participation(race1, "Benni Raich", 3));
        participations.add(new Participation(race2, "Benni Raich", 4));
        participations.add(new Participation(race2, "Marcel Hirscher", 5));

        MyMiniTestSuite.changeOutToFile();
        for (String s : participations.copyRaces()) {
            System.out.println(s);
        }

        for (String s : participations.copyRaces("Hermann Maier")) {
            System.out.println(s);
        }

        return testPassed(
            MyMiniTestSuite.assertOutContent(
                "Schladming\n" +
                    "Kitzbühel\n" +
                    "Kitzbühel"
            )
        );
    }

    private boolean testViewRaces() {
        print("testViewRaces()");

        Participations4 participations = new Participations4(100);

        String race1 = "Kitzbühel";
        String race2 = "Schladming";
        String race3 = "Matterhorn";

        participations.add(new Participation(race1, "Marcel Hirscher", 1));
        participations.add(new Participation(race1, "Hermann Maier", 2));
        participations.add(new Participation(race1, "Benni Raich", 3));
        participations.add(new Participation(race2, "Benni Raich", 4));
        participations.add(new Participation(race2, "Marcel Hirscher", 5));

        MyMiniTestSuite.changeOutToFile();

        StringIterator raceView = participations.viewRaces().iterator();
        System.out.println(raceView.next());
        participations.add(new Participation(race3, "Marcel Hirscher", 6));
        System.out.println(raceView.next());
        System.out.println(raceView.next());

        StringIterator raceViewConstrained = participations.viewRaces("Hermann Maier").iterator();
        System.out.println(raceViewConstrained.next());
        participations.add(new Participation(race3, "Hermann Maier", 7));
        System.out.println(raceViewConstrained.next());

        return testPassed(
            MyMiniTestSuite.assertOutContent(
                "Schladming\n" +
                    "Kitzbühel\n" +
                    "Matterhorn\n" +
                    "Kitzbühel\n" +
                    "Matterhorn"
            )
        );
    }

    private boolean testViewRacesNew() {
        print("testViewRacesNew()");

        Participations4 participations = new Participations4(100);

        String race1 = "Kitzbühel";
        String race2 = "Schladming";
        String race3 = "Matterhorn";

        participations.add(new Participation(race1, "Marcel Hirscher", 1));
        participations.add(new Participation(race1, "Hermann Maier", 2));
        participations.add(new Participation(race1, "Benni Raich", 3));
        participations.add(new Participation(race2, "Benni Raich", 4));
        participations.add(new Participation(race2, "Marcel Hirscher", 5));

        StringIterable v = participations.viewRaces();
        Participations4.MyStringIteratorView t = (Participations4.MyStringIteratorView) v.iterator();
        while (t.hasNext()) {
            StringIterable vv = t.viewRacers();
            String s = t.next();
            System.out.print("Teilnehmer an " + s + ":");
            StringIterator tt = vv.iterator();
            while(tt.hasNext()) {
                System.out.print(" "+tt.next());
            }
            System.out.println("");
        }

        return testPassed(
           false
        );
    }
}
