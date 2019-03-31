package test.java.classTests;

import main.java.aufgabe3.CharStack1;
import test.java.miniTestSuite.MyClassTest;
import test.java.miniTestSuite.MyMiniTestSuite;
import test.java.miniTestSuite.MyTestInterface;

public class MyCharStack1Test extends MyClassTest implements MyTestInterface {

    @Override
    public boolean run() {
        return testPop()
            && testIsEmpty();
    }

    private boolean testPop() {
        print("testPop()");

        CharStack1 cs = new CharStack1();

        cs.push('y');
        cs.push('e');
        cs.push('h');

        return testPassed(MyMiniTestSuite.assertEquals(cs.pop(), 'h')
            && MyMiniTestSuite.assertEquals(cs.pop(), 'e')
            && MyMiniTestSuite.assertEquals(cs.pop(), 'y')
            && MyMiniTestSuite.assertEquals(cs.pop(), 0));
    }

    private boolean testIsEmpty() {
        print("testIsEmpty()");

        CharStack1 cs1 = new CharStack1();
        CharStack1 cs2 = new CharStack1();
        CharStack1 cs3 = new CharStack1();

        cs2.push('y');
        cs2.push('e');
        cs2.push('h');
        cs2.pop();

        cs3.push('y');
        cs3.push('e');
        cs3.push('h');
        cs3.pop();
        cs3.pop();
        cs3.pop();
        cs3.pop();
        cs3.pop();
        cs3.pop();

        return testPassed(MyMiniTestSuite.assertTrue(cs1.isEmpty())
            && MyMiniTestSuite.assertFalse(cs2.isEmpty())
            && MyMiniTestSuite.assertTrue(cs3.isEmpty()));
    }

}
