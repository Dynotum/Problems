import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

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
}