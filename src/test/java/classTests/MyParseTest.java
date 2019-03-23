package test.java.classTests;

import main.java.aufgabe2.Parse;
import test.java.miniTestSuite.MyClassTest;
import test.java.miniTestSuite.MyMiniTestSuite;
import test.java.miniTestSuite.MyTestInterface;

public class MyParseTest extends MyClassTest implements MyTestInterface {

    @Override
    public boolean run() {
        return testParseRec()
            && testParseStack();
    }

    private boolean testParseRec() {
        print("testParseRec()");

        return MyMiniTestSuite.assertTrue(Parse.parseRec(""))
            && MyMiniTestSuite.assertTrue(Parse.parseRec("()<>"))
            && MyMiniTestSuite.assertTrue(Parse.parseRec("(([(<>)])){()}<{}>"))
            && MyMiniTestSuite.assertFalse(Parse.parseRec("("))
            && MyMiniTestSuite.assertFalse(Parse.parseRec(")"))
            && MyMiniTestSuite.assertFalse(Parse.parseRec("(a)"))
            && MyMiniTestSuite.assertFalse(Parse.parseRec("(]"));
    }

    private boolean testParseStack() {
        print("testParseStack()");

        return MyMiniTestSuite.assertTrue(Parse.parseStack(""))
            && MyMiniTestSuite.assertTrue(Parse.parseStack("()<>"))
            && MyMiniTestSuite.assertTrue(Parse.parseStack("(([(<>)])){()}<{}>"))
            && MyMiniTestSuite.assertFalse(Parse.parseStack("("))
            && MyMiniTestSuite.assertFalse(Parse.parseStack(")"))
            && MyMiniTestSuite.assertFalse(Parse.parseStack("(a)"))
            && MyMiniTestSuite.assertFalse(Parse.parseStack("(]"));
    }
}
