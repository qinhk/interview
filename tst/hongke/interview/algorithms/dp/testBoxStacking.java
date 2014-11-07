package hongke.interview.algorithms.dp;

import hongke.interview.algorithms.dp.model.Box;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
        assertEquals(0, test.boxStacking(new ArrayList<Box>()));
    }

    @Test
    public void testSimple() {
        assertEquals(1, test.boxStacking(Collections.singletonList(new Box(1,1,1))));
        assertEquals(2, test.boxStacking(Collections.singletonList(new Box(2,2,1))));
        assertEquals(4, test.boxStacking(Collections.singletonList(new Box(3,2,1))));
    }

    @Test
    public void testNormal1() {
        List<Box> input;
        input = new ArrayList<Box>();
        input.add(new Box(3,2,1));
        input.add(new Box(3,2,3));
        assertEquals(6, test.boxStacking(input));
    }

    @Test
    public void testNormal2() {
        List<Box> input;
        input = new ArrayList<Box>();
        input.add(new Box(2,2,2));
        input.add(new Box(3,3,3));
        assertEquals(5, test.boxStacking(input));
    }

    @Test
    public void testNormal3() {
        List<Box> input;
        input = new ArrayList<Box>();
        input.add(new Box(3,2,1));
        input.add(new Box(3,3,3));
        assertEquals(6, test.boxStacking(input));
    }

    @Test
    public void testNormal4() {
        List<Box> input;
        input = new ArrayList<Box>();
        input.add(new Box(3,2,1));
        input.add(new Box(4,4,3));
        assertEquals(7, test.boxStacking(input));
    }
}
