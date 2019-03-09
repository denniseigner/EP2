package tests.classTests;

import main.Participation;
import main.Startlist;
import tests.miniTestSuite.MyMiniTestSuite;
import tests.miniTestSuite.MyTestInterface;

import java.io.File;
import java.io.PrintStream;

public class MyStartlistTest implements MyTestInterface {
    private static String classTested = "Startlist";

    @Override
    public boolean run() {
        return testPrint()
            && testPrintOrdered();
    }

    @Override
    public void print(String testName) {
        System.out.println("Testing " + classTested + " " + testName);
    }

    // TODO: find an automated way of thesting this
    private boolean testPrint() {
        print("testPrint()");

        Startlist startlist = new Startlist(100);

        startlist.add(new Participation("Kitzbühel", "Marcel Hirscher", 1));
        startlist.add(new Participation("Kitzbühel", "Hermann Maier", 2));
        startlist.add(new Participation("Kitzbühel", "Benni Raich", 3));

        MyMiniTestSuite.changeOutToFile();
        startlist.print();
        return MyMiniTestSuite.assertOutContent("1 Marcel Hirscher (Kitzbühel)\n" +
            "\n" +
            "2 Hermann Maier (Kitzbühel)\n" +
            "\n" +
            "3 Benni Raich (Kitzbühel)" +
            "\n");
    }

    // TODO: find an automated way of thesting this
    private boolean testPrintOrdered() {
        print("testPrintOrdered()");

        Startlist startlist = new Startlist(100);

        startlist.add(new Participation("Kitzbühel", "Benni Raich", 3));
        startlist.add(new Participation("Kitzbühel", "Marcel Hirscher", 1));
        startlist.add(new Participation("Kitzbühel", "Hermann Maier", 2));

        MyMiniTestSuite.changeOutToFile();
        startlist.printOrdered();
        return MyMiniTestSuite.assertOutContent("1 Marcel Hirscher (Kitzbühel)\n" +
            "\n" +
            "2 Hermann Maier (Kitzbühel)\n" +
            "\n" +
            "3 Benni Raich (Kitzbühel)" +
            "\n");
    }
}
