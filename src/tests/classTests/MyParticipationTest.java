package tests.classTests;

import main.Participation;
import tests.miniTestSuite.MyMiniTestSuite;
import tests.miniTestSuite.MyTestInterface;

import java.util.Scanner;

public class MyParticipationTest implements MyTestInterface {

    private static String classTested = "Participation";
    private Participation testParticipation;

    @Override
    public boolean run() {
        return testGetters()
            && testPrint();
    }

    @Override
    public void print(String testName) {
        System.out.println("Testing " + classTested + " " + testName);
    }

    private boolean testGetters() {
        print("testGetters()");
        String racer = "Mikaela Shiffrin";
        String race = "Lienz 2011 Ladies' Slalom";
        int bibnumber = 40;
        testParticipation = new Participation(race, racer, bibnumber);

        return MyMiniTestSuite.assertEquals(racer, testParticipation.getRacer())
            && MyMiniTestSuite.assertEquals(race, testParticipation.getRace())
            && MyMiniTestSuite.assertEquals(bibnumber, testParticipation.getBibnumber());
    }

    private boolean testPrint() {
        print("testPrint()");
        String racer = "Mikaela Shiffrin";
        String race = "Lienz 2011 Ladies' Slalom";
        int bibnumber = 40;
        testParticipation = new Participation(race, racer, bibnumber);

        MyMiniTestSuite.changeOutToFile();
        testParticipation.print();
        return MyMiniTestSuite.assertOutContent("40 Mikaela Shiffrin (Lienz 2011 Ladies\' Slalom)");
    }
}
