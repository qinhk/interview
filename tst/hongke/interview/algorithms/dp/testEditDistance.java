package hongke.interview.algorithms.dp;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by hongke on 11/6/14.
 */
public class testEditDistance {

    EditDistance test;

    @Before
    public void setup() {
        this.test = new EditDistance();
    }

    @Test
    public void testNull() {
        assertEquals(0, test.calculateEditDistance(null, null));
        assertEquals(0, test.calculateEditDistance("", null));
        assertEquals(0, test.calculateEditDistance(null, ""));
        assertEquals(2, test.calculateEditDistance("ab", null));
        assertEquals(2, test.calculateEditDistance(null, "ab"));
        assertEquals(0, test.calculateEditDistance(new String("ab"), new String("ab")));
        assertEquals(0, test.calculateEditDistance("", ""));
    }

    @Test
    public void testSimple() {
        assertEquals(1, test.calculateEditDistance("a", "b"));
        assertEquals(1, test.calculateEditDistance("a", ""));
        assertEquals(1, test.calculateEditDistance("", "b"));
        assertEquals(1, test.calculateEditDistance("a", "ab"));
        assertEquals(1, test.calculateEditDistance("ab", "a"));
        assertEquals(1, test.calculateEditDistance("ab", "b"));
        assertEquals(1, test.calculateEditDistance("b", "ab"));
    }

    @Test
    public void testNormal() {
        assertEquals(13, test.calculateEditDistance("JavaLaunchHelper", "JavaVirtualMachines"));
    }
}
