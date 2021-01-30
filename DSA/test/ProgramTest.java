import org.junit.Test;

import static org.junit.Assert.*;

public class ProgramTest {
    @Test
    public void TestCase1() {
        // Smallest Difference AlgoExpert
        int[] expected = {28, 26};
        assertArrayEquals(Main.smallestDifference(
                new int[]{-1, 5, 10, 20, 28, 3}, new int[]{26, 134, 135, 15, 17}), expected);

        expected = new int[]{-123, -124};
        assertArrayEquals(Main.smallestDifference(
                new int[]{10, 1000, 9124, 2142, 59, 24, 596, 591, 124, -123}, new int[]{-1441, -124, -25, 1014, 1500, 660, 410, 245, 530}), expected);
    }

    @Test
    public void TestCaseIsMonotonic() {
        var array = new int[]{-1, -5, -10, -1100, -1100, -1101, -1102, -9001};
        var actual = Main.isMonotonic(array);
        assertTrue(actual);
    }

    @Test
    public void TestCaseIsNotMonotonic() {
        var array = new int[]{1, 2, 2, 3, 90, 92, 34, 95};
        var actual = Main.isMonotonic(array);
        assertFalse(actual);
    }

    @Test
    public void TestCaseLongestPeak() {
        var input = new int[]{1, 2, 3, 3, 4, 0, 10, 6, 5, -1, -3, 2, 3};
        var expected = 6;
        var actual = Main.longestPeak(input);
        assertTrue(expected == actual);
    }


    @Test
    public void TestCaseLongestPrefix() {
        int[] input = new int[]{6, 42, 11, 7, 1, 42};
        int x = 7, y = 42;
        int prefixLengthExpected = 4;
        int actualResult = Main.longestPrefix(x,y,input);
        assertTrue(prefixLengthExpected == actualResult);
    }

    @Test
    public void TestCaseLongestPrefix2() {
        int x = 6, y = 13;
        int[] input = new int[]{13, 13, 1, 6};
        int prefixLengthExpected = -1;
        int actualResult = Main.longestPrefix(x,y,input);
        assertTrue(prefixLengthExpected == actualResult);
    }

    @Test
    public void TestCaseLongestPrefix3() {
        int x = 100, y = 63;
        int[] input = new int[]{100, 63, 1, 6, 2, 13};
        int prefixLengthExpected = 5;
        int actualResult = Main.longestPrefix(x,y,input);
        assertTrue(prefixLengthExpected == actualResult);
    }
    @Test
    public void TestCaseLongestPrefixXYequals() {
        int[] input = new int[]{6, 42, 11, 7, 1, 42};
        int x = 42, y = 42;
        int prefixLengthExpected = 5;
        int actualResult = Main.longestPrefix(x,y,input);
        assertTrue(prefixLengthExpected == actualResult);
    }

}