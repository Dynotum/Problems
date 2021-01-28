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
        var array = new int[] {-1, -5, -10, -1100, -1100, -1101, -1102, -9001};
        var actual = Main.isMonotonic(array);
        assertTrue(actual);
    }

    @Test
    public void TestCaseIsNotMonotonic() {
        var array = new int[]{1, 2, 2, 3, 90, 92, 34, 95};
        var actual = Main.isMonotonic(array);
        assertFalse(actual);
    }
}