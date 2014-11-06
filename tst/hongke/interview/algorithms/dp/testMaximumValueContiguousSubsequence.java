package hongke.interview.algorithms.dp;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by hongke on 11/2/14.
 */
public class testMaximumValueContiguousSubsequence {

    private MaximumValueContiguousSubsequence test;

    @Before
    public void setup() {
        test = new MaximumValueContiguousSubsequence();
    }

    @Test
    public void testNull() {
        int result = test.maximumValueContiguousSubsequence(null);
        assertTrue(result == 0);

        result = test.maximumValueContiguousSubsequence(new int[0]);
        assertTrue(result == 0);
    }

    @Test
    public void testNormal0() {
        int result = test.maximumValueContiguousSubsequence(new int[]{0, 1, 2, 3, 4, 5});
        assertEquals(15, result);
    }

    @Test
    public void testNormal1() {
        int result = test.maximumValueContiguousSubsequence(new int[]{0, 11, -3, 3, 4, 5});
        assertEquals(20, result);
    }

    @Test
    public void testNormal2() {
        int result = test.maximumValueContiguousSubsequence(new int[]{0, -1, 2, -3, 4, 5, -1});
        assertEquals(9, result);
    }

    @Test
    public void testNormal3() {
        int result = test.maximumValueContiguousSubsequence(new int[]{3, -1, -2, -3, 4, -5});
        assertEquals(4, result);
    }


    @Test
    public void testNormal4() {
        int result = test.maximumValueContiguousSubsequence(new int[]{-1, 1, -1, 1, -1, 1});
        assertEquals(1, result);
    }


    @Test
    public void testNormal5() {
        int result = test.maximumValueContiguousSubsequence(new int[]{0, -1, -2, -3, 4, 5, -100, 100});
        assertEquals(100, result);
    }

    @Test
    public void testEdge1() {
        int result = test.maximumValueContiguousSubsequence(new int[]{-5});
        assertEquals(-5, result);
    }

    @Test
    public void testEdge2() {
        int result = test.maximumValueContiguousSubsequence(new int[]{5});
        assertEquals(5, result);
    }


}
