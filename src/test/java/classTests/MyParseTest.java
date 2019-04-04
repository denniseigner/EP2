package test.java.classTests;

import main.java.aufgabe2.Parse;
import test.java.miniTestSuite.MyClassTest;
import test.java.miniTestSuite.MyMiniTestSuite;
import test.java.miniTestSuite.MyTestInterface;

public class MyParseTest extends MyClassTest implements MyTestInterface {

    @Override
    public boolean run() {
        return testParseRec()
            && testParseStack()
            && testParseStack1();
    }

    private boolean testParseRec() {
        print("testParseRec()");

        return testPassed(MyMiniTestSuite.assertTrue(Parse.parseRec(""))
            && MyMiniTestSuite.assertTrue(Parse.parseRec("()<>"))
            && MyMiniTestSuite.assertTrue(Parse.parseRec("(([(<>)])){()}<{}>"))
            && MyMiniTestSuite.assertFalse(Parse.parseRec("("))
            && MyMiniTestSuite.assertFalse(Parse.parseRec(")"))
            && MyMiniTestSuite.assertFalse(Parse.parseRec("(a)"))
            && MyMiniTestSuite.assertFalse(Parse.parseRec("(]")));
    }

    private boolean testParseStack() {
        print("testParseStack()");

        return testPassed(MyMiniTestSuite.assertTrue(Parse.parseStack(""))
            && MyMiniTestSuite.assertTrue(Parse.parseStack("()<>"))
            && MyMiniTestSuite.assertTrue(Parse.parseStack("(([(<>)])){()}<{}>"))
            && MyMiniTestSuite.assertFalse(Parse.parseStack("("))
            && MyMiniTestSuite.assertFalse(Parse.parseStack(")"))
            && MyMiniTestSuite.assertFalse(Parse.parseStack("(a)"))
            && MyMiniTestSuite.assertFalse(Parse.parseStack("(]")));
    }

    private boolean testParseStack1() {
        print("testParseStack()");

        return testPassed(MyMiniTestSuite.assertTrue(Parse.parseStack1(""))
            && MyMiniTestSuite.assertTrue(Parse.parseStack1("()<>"))
            && MyMiniTestSuite.assertTrue(Parse.parseStack1("(([(<>)])){()}<{}>"))
            && MyMiniTestSuite.assertFalse(Parse.parseStack1("("))
            && MyMiniTestSuite.assertFalse(Parse.parseStack1(")"))
            && MyMiniTestSuite.assertFalse(Parse.parseStack1("(a)"))
            && MyMiniTestSuite.assertFalse(Parse.parseStack1("(]")));
    }
}
