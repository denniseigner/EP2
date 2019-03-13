package tests.classTests;

import main.Participation;
import main.Startlist;
import tests.miniTestSuite.MyClassTest;
import tests.miniTestSuite.MyMiniTestSuite;
import tests.miniTestSuite.MyTestInterface;

import java.io.File;
import java.io.PrintStream;

public class MyStartlistTest extends MyClassTest implements MyTestInterface {

    @Override
    public boolean run() {
        return testPrint()
            && testPrintOrdered()
            && testPrintPermutations();
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

    private boolean testPrintPermutations() {
        print("testPrintPermutations()");
        Startlist startlist = new Startlist(100);

        startlist.add(new Participation("Kitzbühel", "Marcel Hirscher", 1));
        startlist.add(new Participation("Kitzbühel", "Hermann Maier", 2));
        startlist.add(new Participation("Kitzbühel", "Benni Raich", 3));

        MyMiniTestSuite.changeOutToFile();
        startlist.printPermutations();
        return MyMiniTestSuite.assertOutContent("1 Marcel Hirscher (Kitzbühel)\n" +
            "2 Hermann Maier (Kitzbühel)\n" +
            "3 Benni Raich (Kitzbühel)\n" +
            "\n" +
            "1 Marcel Hirscher (Kitzbühel)\n" +
            "3 Benni Raich (Kitzbühel)\n" +
            "2 Hermann Maier (Kitzbühel)\n" +
            "\n" +
            "2 Hermann Maier (Kitzbühel)\n" +
            "1 Marcel Hirscher (Kitzbühel)\n" +
            "3 Benni Raich (Kitzbühel)\n" +
            "\n" +
            "2 Hermann Maier (Kitzbühel)\n" +
            "3 Benni Raich (Kitzbühel)\n" +
            "1 Marcel Hirscher (Kitzbühel)\n" +
            "\n" +
            "3 Benni Raich (Kitzbühel)\n" +
            "1 Marcel Hirscher (Kitzbühel)\n" +
            "2 Hermann Maier (Kitzbühel)\n" +
            "\n" +
            "3 Benni Raich (Kitzbühel)\n" +
            "2 Hermann Maier (Kitzbühel)\n" +
            "1 Marcel Hirscher (Kitzbühel)\n");
    }
}
