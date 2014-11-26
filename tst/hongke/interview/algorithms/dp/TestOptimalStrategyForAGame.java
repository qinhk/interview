package hongke.interview.algorithms.dp;

import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.assertEquals;

/**
 * Created by hongke on 11/9/14.
 */
public class TestOptimalStrategyForAGame {

    OptimalStrategyForAGame test;

    @Before
    public void setup() {
        test = new OptimalStrategyForAGame();
    }

    @Test
    public void testNull() {
        assertEquals(0, test.optimalStrategy(null));
        assertEquals(0, test.optimalStrategy(new int[0]));
    }

    @Test
    public void testSimple() {
        assertEquals(1, test.optimalStrategy(new int[]{1}));
        assertEquals(2, test.optimalStrategy(new int[]{1, 2}));
        assertEquals(2, test.optimalStrategy(new int[]{1, 1, 1}));
    }

    @Test
    public void testNormal() {
        assertEquals(30, test.optimalStrategy(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));
    }

}
