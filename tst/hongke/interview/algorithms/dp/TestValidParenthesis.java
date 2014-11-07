package hongke.interview.algorithms.dp;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by hongke on 11/7/14.
 */
public class TestValidParenthesis {
    ValidParenthesis test;

    @Before
    public void setup() {
        test = new ValidParenthesis();
    }

    @Test(expected = IllegalStateException.class)
    public void testNull() {
        assertEquals(0, test.countValidParenthesis(null));
        assertEquals(0, test.countValidParenthesis(""));
        assertEquals(0, test.countValidParenthesis("["));
        assertEquals(0, test.countValidParenthesis("aaaa"));
    }

    @Test
    public void testEasy() {
        assertEquals(2, test.countValidParenthesis("{}"));
        assertEquals(2, test.countValidParenthesis("[[]"));
        assertEquals(2, test.countValidParenthesis("())"));
        assertEquals(2, test.countValidParenthesis("}{}{"));
        assertEquals(4, test.countValidParenthesis("[[]]"));
        assertEquals(4, test.countValidParenthesis("()())"));
        assertEquals(6, test.countValidParenthesis("{}{}{}"));
        assertEquals(6, test.countValidParenthesis("[[]][]"));
        assertEquals(6, test.countValidParenthesis("({}())"));
    }

    @Test
    public void testNormal() {
        assertEquals(8, test.countValidParenthesis("((()))())"));
        assertEquals(4, test.countValidParenthesis(")()())()()("));
        assertEquals(2, test.countValidParenthesis("()(()"));
    }
}
