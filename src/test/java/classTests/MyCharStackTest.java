package test.java.classTests;

import main.java.aufgabe2.CharStack;
import test.java.miniTestSuite.MyClassTest;
import test.java.miniTestSuite.MyMiniTestSuite;
import test.java.miniTestSuite.MyTestInterface;

public class MyCharStackTest extends MyClassTest implements MyTestInterface {

    @Override
    public boolean run() {
        return testPop()
            && testIsEmpty();
    }

    private boolean testPop() {
        print("testPop()");

        CharStack cs = new CharStack();

        cs.push('y');
        cs.push('e');
        cs.push('h');


        return MyMiniTestSuite.assertEquals(cs.pop(), 'h')
            && MyMiniTestSuite.assertEquals(cs.pop(), 'e')
            && MyMiniTestSuite.assertEquals(cs.pop(), 'y')
            && MyMiniTestSuite.assertEquals(cs.pop(), 0);
    }

    private boolean testIsEmpty() {
        print("testIsEmpty()");

        CharStack cs1 = new CharStack();
        CharStack cs2 = new CharStack();
        CharStack cs3 = new CharStack();

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

        return MyMiniTestSuite.assertTrue(cs1.isEmpty())
            && MyMiniTestSuite.assertFalse(cs2.isEmpty())
            && MyMiniTestSuite.assertTrue(cs3.isEmpty());
    }

}
