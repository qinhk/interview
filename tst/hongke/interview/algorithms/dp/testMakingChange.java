package hongke.interview.algorithms.dp;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by hongke on 11/2/14.
 */
public class testMakingChange {

    private MakingChange test = new MakingChange();

    private static int[] COINS = new int[]{1, 5, 10, 25};

    @Before
    public void setup() {
        test = new MakingChange();
    }

    @Test
    public void testNull() {
        assertEquals(test.makingChange(null, 1), 0);
        assertEquals(test.makingChange(new int[0], 1), 0);
        assertEquals(test.makingChange(new int[]{1}, 0), 0);
        assertEquals(test.makingChange(new int[]{1}, -1), 0);
        assertEquals(test.makingChange(new int[]{-1}, 1), 0);
    }


    @Test
    public void testMakingChangeMinCount() {
        assertEquals(1, test.makingChange(COINS, 1));
        assertEquals(1, test.makingChange(COINS, 5));
        assertEquals(1, test.makingChange(COINS, 10));
        assertEquals(1, test.makingChange(COINS, 25));
        assertEquals(2,test.makingChange(COINS, 2));
        assertEquals(2,test.makingChange(COINS, 6));
        assertEquals(2,test.makingChange(COINS, 15));
        assertEquals(2,test.makingChange(COINS, 26));
        assertEquals(4, test.makingChange(COINS, 17));
        assertEquals(6,test.makingChange(COINS, 24));
        assertEquals(8,test.makingChange(COINS, 176));
        assertEquals(4005, test.makingChange(COINS, 99999));
    }

    @Test
    public void testMakingChangeCombination() {

        assertEquals(4, test.makingChangeCombination(COINS, 10));
        assertEquals(1, test.makingChangeCombination(COINS, 4));
        assertEquals(2, test.makingChangeCombination(COINS, 5));
        assertEquals(13, test.makingChangeCombination(COINS, 25));
        assertEquals(242, test.makingChangeCombination(COINS, 100));
    }
}
