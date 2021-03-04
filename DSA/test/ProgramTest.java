import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        int actualResult = Main.longestPrefix(x, y, input);
        assertTrue(prefixLengthExpected == actualResult);
    }

    @Test
    public void TestCaseLongestPrefix2() {
        int x = 6, y = 13;
        int[] input = new int[]{13, 13, 1, 6};
        int prefixLengthExpected = -1;
        int actualResult = Main.longestPrefix(x, y, input);
        assertTrue(prefixLengthExpected == actualResult);
    }

    @Test
    public void TestCaseLongestPrefix3() {
        int x = 100, y = 63;
        int[] input = new int[]{100, 63, 1, 6, 2, 13};
        int prefixLengthExpected = 5;
        int actualResult = Main.longestPrefix(x, y, input);
        assertTrue(prefixLengthExpected == actualResult);
    }

    @Test
    public void TestCaseLongestPrefixXYequals() {
        int[] input = new int[]{6, 42, 11, 7, 1, 42};
        int x = 42, y = 42;
        int prefixLengthExpected = 5;
        int actualResult = Main.longestPrefix(x, y, input);
        assertTrue(prefixLengthExpected == actualResult);
    }

    @Test
    public void TestCaseBinaryToDecimal() {
        final String binary = "011100";
        final int decimal = 28;
        final int resultDecimal = Main.getDecimal(binary);

        assertTrue(decimal == resultDecimal);
    }

    @Test
    public void TestCaseBinaryToDecimal2() {
        final String binary = "111";
        final int decimal = 7;
        final int resultDecimal = Main.getDecimal(binary);

        assertTrue(decimal == resultDecimal);
    }


    @Test
    public void TestCaseMovesOfBinaryToDecimalZero() {
        final String binary = "011100";
        final int movesToZero = 7;
        final int getMoves = Main.binaryToZero(binary);

        assertTrue(movesToZero == getMoves);
    }

    @Test
    public void TestCaseMovesOfBinaryToDecimalZero2() {
        final String binary = "111";
        final int movesToZero = 5;
        final int getMoves = Main.binaryToZero(binary);

        assertTrue(movesToZero == getMoves);
    }

    @Test
    public void TestCaseMovesOfBinaryToDecimalZero3() {
        final String binary = "111";
        final int movesToZero = 5;
        final int getMoves = Main.binaryToZero(binary);

        assertTrue(movesToZero == getMoves);
    }

    @Test
    public void TestCaseMovesOfBinaryToDecimalZero4() {
        final String binary = "1111010101111";
        final int movesToZero = 22;
        final int getMoves = Main.binaryToZero(binary);

        assertTrue(movesToZero == getMoves);
    }

    @Test
    public void TestCaseMovesOfBinaryToDecimalZeroBS() {
        final String binary = "111";
        final int movesToZero = 5;
        final int getMoves = Main.binaryToZeroBestSolution(binary);

        assertTrue(movesToZero == getMoves);
    }

    @Test
    public void TestCaseMovesOfBinaryToDecimalZeroBS2() {
        final String binary = "111";
        final int movesToZero = 5;
        final int getMoves = Main.binaryToZeroBestSolution(binary);

        assertTrue(movesToZero == getMoves);
    }

    @Test
    public void TestCaseMovesOfBinaryToDecimalZeroBS3() {
        final String binary = "1111010101111";
        final int movesToZero = 22;
        final int getMoves = Main.binaryToZeroBestSolution(binary);

        assertTrue(movesToZero == getMoves);
    }


    @Test
    public void TestCaseNumberOfLettersToMakeItEqualAnagrams() {
        final String A = "apple";
        final String B = "pear";
        final int minimumLetters = 3;
        final int resultMinimumLetters = Main.solution(A, B);
        assertTrue(minimumLetters == resultMinimumLetters);
    }

    @Test
    public void TestCaseProductSum() {
        List<Object> test =
                new ArrayList<Object>(
                        Arrays.asList(
                                5,
                                2,
                                new ArrayList<Object>(Arrays.asList(7, -1)),
                                3,
                                new ArrayList<Object>(
                                        Arrays.asList(6, new ArrayList<Object>(Arrays.asList(-13, 8)), 4))));
        assertTrue(Main.productSum(test) == 12);
    }

    @Test
    public void TestCaseBubbles() {
        int[] expected = {2, 3, 5, 5, 6, 8, 9};
        int[] input = {8, 5, 2, 9, 5, 6, 3};
        assertTrue(compare(Main.bubbleSort(input), expected));
    }

    public boolean compare(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void TestCaseBST() {
        var root = new Main.BST(10);
        root.left = new Main.BST(5);
        root.left.left = new Main.BST(2);
        root.left.left.left = new Main.BST(1);
        root.left.right = new Main.BST(5);
        root.right = new Main.BST(15);
        root.right.left = new Main.BST(13);
        root.right.left.right = new Main.BST(14);
        root.right.right = new Main.BST(22);

        var expected = 13;
        var actual = Main.findClosestValueInBst(root, 12);
        assertEquals(expected, actual);
    }

    @Test
    public void TestCaseTournamentWinner() {
        ArrayList<ArrayList<String>> competitions = new ArrayList<>();
        ArrayList<String> competition1 = new ArrayList<>(Arrays.asList("HTML", "C#"));
        ArrayList<String> competition2 = new ArrayList<>(Arrays.asList("C#", "Python"));
        ArrayList<String> competition3 = new ArrayList<>(Arrays.asList("Python", "HTML"));
        competitions.add(competition1);
        competitions.add(competition2);
        competitions.add(competition3);
        ArrayList<Integer> results = new ArrayList<>(Arrays.asList(0, 0, 1));
        String expected = "Python";
        var actual = Main.tournamentWinner(competitions, results);
        assertEquals(expected, actual);
    }

    @Test
    public void TestFirstDuplicate() {
        int[] array = new int[]{8, 4, 6, 2, 6, 4, 7, 9, 5, 8};
        int result = Main.firstDuplicate(array);
        int expected = 6;
        assertEquals(result, expected);
    }

}