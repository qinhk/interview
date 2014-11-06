package hongke.interview.algorithms.dp;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

/**
 * Created by hongke on 11/3/14.
 */
public class testBoxStacking {

    BoxStacking test;

    @Before
    public void setup() {
        test = new BoxStacking();
    }

    @Test
    public void testNull() {
        assertEquals(-1, test.boxStacking(null));
        assertEquals(0, test.boxStacking(new ArrayList<BoxStacking.Box>()));
    }

    @Test
    public void testSimple() {
        assertEquals(1, test.boxStacking(Collections.singletonList(new BoxStacking.Box(1,1,1))));
        assertEquals(2, test.boxStacking(Collections.singletonList(new BoxStacking.Box(2,2,1))));
        assertEquals(4, test.boxStacking(Collections.singletonList(new BoxStacking.Box(3,2,1))));
    }
}
