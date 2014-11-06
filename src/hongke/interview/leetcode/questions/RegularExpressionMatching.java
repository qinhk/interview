package hongke.interview.leetcode.questions;

import java.util.IllegalFormatException;

/**
 * Created by hongke on 6/11/14.
 */
public class RegularExpressionMatching {

    public boolean isMatch(String s, String p) {
        if (s == null && p == null) {
            return true;
        } else if (s == null || p == null) {
            return false;
        }

        try {
            match(s, p, 0, 0);
        } catch (Throwable t) {
            return false;
        }
        return true;
    }

    public void match(String s, String p, int si, int pi) {
        if (si == s.length() && pi == p.length()) {
            return;
        } else if (pi < p.length() && p.charAt(pi) == '.') {
            dot(s, p, si, pi);
        } else if (pi < p.length() && p.charAt(pi) == '*') {
            throw new IllegalArgumentException("Invalid *, " +
                "[String index: " + si + ", Pattern Index: " + pi + "]");
        }
        else {
            letter(s, p, si, pi);
        }
    }

    private void dot(String s, String p, int si, int pi) {
        if (pi + 1 < p.length() && p.charAt(pi + 1) == '*') {
            star(s, p, si, pi);
        } else if (si >= 0 && pi >= 0 && si < s.length() && pi < p.length()) {
            match(s, p, si + 1, pi + 1);
        } else {
            throw new IllegalArgumentException("Unable to match dot, " +
                "[String index: " + si + ", Pattern Index: " + pi + "]");
        }
    }

    private void letter(String s, String p, int si, int pi) {
        if (pi + 1 < p.length() && p.charAt(pi + 1) == '*') {
            star(s, p, si, pi);
        } else if (si < s.length() && pi < p.length() && s.charAt(si) == p.charAt(pi)) {
            match(s, p, si + 1, pi + 1);
        } else {
            throw new IllegalArgumentException("Unable to match letter, " +
                "[String index: " + si + ", Pattern Index: " + pi + "]");
        }
    }

    private void star(String s, String p, int si, int pi) {
        char pre = p.charAt(pi);
        if (pre == '.') {
            int j = 1;
            while (pi + j < p.length() && p.charAt(pi + j) == '*') {
                j++;
            }

            // handle .*.*.*
            while (pi + j + 1 < p.length() && p.charAt(pi + j) == '.' && p.charAt(pi + j + 1) == '*') {
                j += 2;
            }

            int i = s.length();
            while (i >= si) {
                try {
                    match(s, p, i, pi + j);
                    break;
                } catch (IllegalArgumentException t) {
                    i--;
                    if (i < si) {
                        throw t;
                    }
                }
            }
        } else {
            int i = 0;
            while (si + i < s.length() && s.charAt(si + i) == pre) {
                i++;
            }
            // handle a**
            int j = 1;
            while (pi + j < p.length() && p.charAt(pi + j) == '*') {
                j++;
            }
            // handle a*a*a*
            while (pi + j + 1 < p.length() && p.charAt(pi + j) == pre && p.charAt(pi + j + 1) == '*') {
                j += 2;
            }

            while (i >= 0) {
                try {
                    match(s, p, i + si, pi + j);
                    break;
                } catch (IllegalArgumentException t) {
                    i--;
                    if (i < 0) {
                        throw t;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        RegularExpressionMatching matcher = new RegularExpressionMatching();

        System.out.println(matcher.isMatch("aasdfasdfasdfasdfas", "aasdf.*asdf.*asdf.*asdf.*s")); // true
        System.out.println(matcher.isMatch("", ".")); // false
        System.out.println(matcher.isMatch("a", "ab*")); // true
        System.out.println(matcher.isMatch("aaca", "ab*a*c*a")); // true
        System.out.println(matcher.isMatch("aa", "a")); // false
        System.out.println();

        System.out.println(matcher.isMatch("aa", "aa")); // true
        System.out.println(matcher.isMatch("aaa", "aa")); // false
        System.out.println(matcher.isMatch("aa", "a*")); // true
        System.out.println(matcher.isMatch("aa", ".*")); // true
        System.out.println(matcher.isMatch("ab", ".*")); // true
        System.out.println();

        System.out.println(matcher.isMatch("aab", "c*a*b")); // true
        System.out.println(matcher.isMatch("aab", ".*b")); // true
        System.out.println(matcher.isMatch("aaa", "a*a")); // true
        System.out.println(matcher.isMatch("ava", ".*.")); // true
        System.out.println(matcher.isMatch("ava", ".**")); // true
        System.out.println();

        System.out.println(matcher.isMatch("ava", "**.")); // false
        System.out.println(matcher.isMatch("ava", "..*")); // true
        System.out.println(matcher.isMatch("", "c*c*")); // true
        System.out.println(matcher.isMatch("abcaacaccccacaabcca", "a*a*a*aabab*c*.")); // false
        System.out.println(matcher.isMatch("bacabaababcbabbccb", ".*a*ac*.b*a*a*b*")); // false
        System.out.println();

        System.out.println(matcher.isMatch("aaaaaaaaaaaaab", "a*a*a*a*a*a*a*a*a*a*c"));
        System.out.println(matcher.isMatch("aaaaaaaaaaaaab", ".*.*.*.*.*.*.*.*.*.*c"));
    }
}
