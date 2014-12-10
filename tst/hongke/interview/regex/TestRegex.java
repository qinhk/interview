package hongke.interview.regex;

import org.junit.Test;

/**
 * Created by hongke on 12/4/14.
 */
public class TestRegex {

    @Test
    public void test() {
        System.out.println(System.currentTimeMillis());
        System.out.println(Regex.isMatch("aasdfasdfasdfasdfas", "aasdf.*asdf.*asdf.*asdf.*s")); // true
        System.out.println(Regex.isMatch("", ".")); // false
        System.out.println(Regex.isMatch("a", "ab*")); // true
        System.out.println(Regex.isMatch("aaca", "ab*a*c*a")); // true
        System.out.println(Regex.isMatch("aa", "a")); // false
        System.out.println();

        System.out.println(Regex.isMatch("aa", "aa")); // true
        System.out.println(Regex.isMatch("aaa", "aa")); // false
        System.out.println(Regex.isMatch("aa", "a*")); // true
        System.out.println(Regex.isMatch("aa", ".*")); // true
        System.out.println(Regex.isMatch("ab", ".*")); // true
        System.out.println();

        System.out.println(Regex.isMatch("aab", "c*a*b")); // true
        System.out.println(Regex.isMatch("aab", ".*b")); // true
        System.out.println(Regex.isMatch("aaa", "a*a")); // true
        System.out.println(Regex.isMatch("ava", ".*.")); // true
        System.out.println(Regex.isMatch("ava", ".**")); // true
        System.out.println();

        System.out.println(Regex.isMatch("ava", "**.")); // false
        System.out.println(Regex.isMatch("ava", "..*")); // true
        System.out.println(Regex.isMatch("", "c*c*")); // true
        System.out.println(Regex.isMatch("abcaacaccccacaabcca", "a*a*a*aabab*c*.")); // false
        System.out.println(Regex.isMatch("bacabaababcbabbccb", ".*a*ac*.b*a*a*b*")); // false
        System.out.println();

        System.out.println(Regex.isMatch("aaaaaaaaaaaaab", "a*a*a*a*a*a*a*a*a*a*c"));
        System.out.println(Regex.isMatch("aaaaaaaaaaaaab", ".*.*.*.*.*.*.*.*.*.*c"));
        System.out.println(System.currentTimeMillis());
    }
}
