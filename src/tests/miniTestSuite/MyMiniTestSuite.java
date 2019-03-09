package tests.miniTestSuite;

public class MyMiniTestSuite {
    public static boolean assertEquals(String is, String should) {
        return is.contentEquals(should);
    }

    public static boolean assertEquals(int is, int should) {
        return is == should;
    }
}
