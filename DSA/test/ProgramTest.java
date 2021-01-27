import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

class ProgramTest {
    @Test
    public void TestCase1() {
        // Smallest Difference AlgoExpert
        int[] expected = {28, 26};
        assertTrue(
                Arrays.equals(
                        Main.smallestDifference(
                                new int[]{-1, 5, 10, 20, 28, 3}, new int[]{26, 134, 135, 15, 17}),
                        expected));
    }
}