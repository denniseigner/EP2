package tests.classTests;

import main.Participation;
import main.Startlist;
import tests.miniTestSuite.MyTestInterface;

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
        
        startlist.print();

        return true;
    }

    // TODO: find an automated way of thesting this
    private boolean testPrintOrdered() {
        print("testPrintOrdered()");

        Startlist startlist = new Startlist(100);

        startlist.add(new Participation("Kitzbühel", "Benni Raich", 3));
        startlist.add(new Participation("Kitzbühel", "Marcel Hirscher", 1));
        startlist.add(new Participation("Kitzbühel", "Hermann Maier", 2));

        startlist.printOrdered();

        return true;
    }
}
