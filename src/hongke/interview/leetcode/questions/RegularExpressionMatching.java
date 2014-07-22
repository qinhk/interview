package hongke.interview.leetcode.questions;

/**
 * Created by hongke on 6/11/14.
 */
public class RegularExpressionMatching {

    private String s;
    private String p;
    private int minimumRemainingLength;

    public boolean isMatch(String s, String p) {
        if (s == null && p == null) {
            return true;
        } else if (s == null || p == null) {
            return false;
        }

        minimumRemainingLength = calculateMinimumLength(p);
        if (minimumRemainingLength < 0 || s.length() < minimumRemainingLength) {
            return false;
        }
        this.s = s;
        this.p = p;
        return parse();
    }

    private int calculateMinimumLength(String p) {
        int i = 0;
        int length = 0;
        while (i < p.length()) {
            if (p.charAt(i) != '*') {
                length ++;
            } else {
                length --;
            }
            i++;
        }

        return length;
    }

    private boolean parse() {
        try {
            while (s.length() != 0 || p.length() != 0) {
                if (p.startsWith(".")) {
                    dot();
                } else if (!p.startsWith("*")) {
                    letter();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    private void dot() throws Exception {
        p = eat(p);
        if (p.startsWith("*")) {
            s = eat(s);
            star('.');
        } else {
            if (s.length() <= 0) {
                throw new Exception();
            }
            s = eat(s);
            minimumRemainingLength --;
            return;
            // do nothing, continue parsing
        }
    }

    private void letter() throws Exception {
        if (s.length() != 0 && s.charAt(0) == p.charAt(0)) {
            p = eat(p);
            if (p.startsWith("*")) {
                char c = s.charAt(0);
                star(c);
            } else {
                s = eat(s);
                minimumRemainingLength --;
                return;
                // do nothing, continue parsing
            }
        } else {
            p = eat(p);
            if (p.startsWith("*")) {
                p = eat(p);
                // continue parsing
            } else {
                throw new Exception();
            }
        }
    }

    private void star(char prev) throws Exception {
        if (prev != '.' && s.charAt(0) != prev) {
            throw new Exception();
        }

        int i = 0;
        while (i < s.length() - minimumRemainingLength && (prev == '.' || s.charAt(i) == prev)) {
            i++;
        }
        s = eat(s, i);
        p = eat(p);
    }

    private String eat(String s) {
        return eat(s, 1);
    }

    private String eat(String s, int length) {
        if (s.length() == 0) {
            return "";
        }
        return s.substring(length);
    }

    public static void main(String[] args) {
        RegularExpressionMatching matcher = new RegularExpressionMatching();
        System.out.println(matcher.isMatch("aasdfasdfasdfasdfas", "aasdf.*asdf.*asdf.*asdf.*s")); // true
        System.out.println(matcher.isMatch("", ".")); // true
        System.out.println(matcher.isMatch("a", "ab*")); // true
        System.out.println(matcher.isMatch("aaca", "ab*a*c*a")); // true
        System.out.println(matcher.isMatch("aa", "a")); // false
        System.out.println(matcher.isMatch("aa", "aa")); // true
        System.out.println(matcher.isMatch("aaa", "aa")); // false
        System.out.println(matcher.isMatch("aa", "a*")); // true
        System.out.println(matcher.isMatch("aa", ".*")); // true
        System.out.println(matcher.isMatch("ab", ".*")); // true
        System.out.println(matcher.isMatch("aab", "c*a*b")); // true
        System.out.println(matcher.isMatch("aab", ".*b")); // true
        System.out.println(matcher.isMatch("aaa", "a*a")); // true
        System.out.println(matcher.isMatch("ava", ".*.")); // true


        System.out.println(matcher.isMatch("ava", ".**")); // true
        System.out.println(matcher.isMatch("ava", "**.")); // true
        System.out.println(matcher.isMatch("ava", "..*")); // true
    }
}
