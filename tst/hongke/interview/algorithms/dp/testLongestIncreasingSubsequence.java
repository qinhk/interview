package hongke.interview.algorithms.dp;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by hongke on 11/2/14.
 */
public class testLongestIncreasingSubsequence {

    private LongestIncreasingSubsequence test;

    @Before
    public void setup() {
        test = new LongestIncreasingSubsequence();
    }

    @Test
    public void testNull() {
        assertEquals(0, test.longestIncreaseingSubsequence(null));
        assertEquals(0, test.longestIncreaseingSubsequence(new int[0]));
    }

    @Test
    public void testNormal() {
        assertEquals(1, test.longestIncreaseingSubsequence(new int[]{10}));
        assertEquals(1, test.longestIncreaseingSubsequence(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1}));
        assertEquals(10, test.longestIncreaseingSubsequence(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));
        assertEquals(5, test.longestIncreaseingSubsequence(new int[]{5, 19, 5, 81, 50, 28, 29, 1, 83, 23}));
        assertEquals(6, test.longestIncreaseingSubsequence(new int[]{10, 22, 9, 33, 21, 50, 41, 60, 80}));
    }
}
