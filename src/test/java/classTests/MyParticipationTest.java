package test.java.classTests;

import main.java.aufgabe1.Participation;
import test.java.miniTestSuite.MyClassTest;
import test.java.miniTestSuite.MyMiniTestSuite;
import test.java.miniTestSuite.MyTestInterface;

public class MyParticipationTest extends MyClassTest implements MyTestInterface {

    @Override
    public boolean run() {
        return testGetters()
            && testExtendedGetters()
            && testPrint()
            && testPrint1();
    }

    private boolean testGetters() {
        print("testGetters()");
        String racer = "Mikaela Shiffrin";
        String race = "Lienz 2011 Ladies' Slalom";
        int bibnumber = 40;
        Participation testParticipation = new Participation(race, racer, bibnumber);

        return MyMiniTestSuite.assertEquals(racer, testParticipation.getRacer())
            && MyMiniTestSuite.assertEquals(race, testParticipation.getRace())
            && MyMiniTestSuite.assertEquals(bibnumber, testParticipation.getBibnumber());
    }

    private boolean testExtendedGetters() {
        print("testExtendedGetters()");
        String racer = "Mikaela Shiffrin";
        String race = "Lienz 2011 Ladies' Slalom";
        int bibnumber = 40;
        int place = 3;
        String runtime = "IncredibleTime";
        Participation testParticipation = new Participation(race, racer, bibnumber, place, runtime);

        return MyMiniTestSuite.assertEquals(racer, testParticipation.getRacer())
            && MyMiniTestSuite.assertEquals(race, testParticipation.getRace())
            && MyMiniTestSuite.assertEquals(bibnumber, testParticipation.getBibnumber())
            && MyMiniTestSuite.assertEquals(place, testParticipation.getPlace())
            && MyMiniTestSuite.assertEquals(runtime, testParticipation.getRuntime());
    }

    private boolean testPrint() {
        print("testPrint()");
        String racer = "Mikaela Shiffrin";
        String race = "Lienz 2011 Ladies' Slalom";
        int bibnumber = 40;
        Participation testParticipation = new Participation(race, racer, bibnumber);

        MyMiniTestSuite.changeOutToFile();
        testParticipation.print();
        return MyMiniTestSuite.assertOutContent("40 Mikaela Shiffrin (Lienz 2011 Ladies\' Slalom)");
    }

    private boolean testPrint1() {
        print("testPrint1()");

        String racer = "Mikaela Shiffrin";
        String race = "Lienz 2011 Ladies' Slalom";
        int bibnumber = 40;
        int place = 3;
        String runtime = "IncredibleTime";
        Participation testParticipation = new Participation(race, racer, bibnumber);
        Participation testParticipation2 = new Participation(race, racer, bibnumber, place, runtime);

        MyMiniTestSuite.changeOutToFile();
        testParticipation.print();
        boolean emptyElement = MyMiniTestSuite.assertOutContent("40 Mikaela Shiffrin (Lienz 2011 Ladies\' Slalom)");

        MyMiniTestSuite.changeOutToFile();
        testParticipation2.print1();
        boolean filledElement = MyMiniTestSuite.assertOutContent("40 Mikaela Shiffrin (Lienz 2011 Ladies' Slalom); " +
            "3; IncredibleTime");

        return emptyElement
            && filledElement;
    }
}
