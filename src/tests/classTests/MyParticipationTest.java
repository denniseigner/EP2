package tests.classTests;

import main.Participation;
import tests.miniTestSuite.MyClassTest;
import tests.miniTestSuite.MyMiniTestSuite;
import tests.miniTestSuite.MyTestInterface;

import java.util.Scanner;

public class MyParticipationTest extends MyClassTest implements MyTestInterface {

    @Override
    public boolean run() {
        return testGetters()
            && testPrint();
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
}
