package hongke.interview.leetcode.questions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by hongke on 8/8/14.
 */

public class ScrambleString {

    private Map<String, Boolean> cache;

    public boolean isScramble(String s1, String s2) {

        cache = new HashMap<String, Boolean>();

        if (s1 == null && s2 == null || s1 == s2 || s1.equals(s2)) {
            return true;
        } else if (s1 == null || s2 == null || s1.length() != s2.length()) {
            return false;
        }

        boolean result = recurse(s1, s2);
        return result;

    }

    private boolean recurse(String s1, String s2) {

        if (s1.equals(s2)) {
            return true;
        } else if (s1.length() != s2.length()) {
            return false;
        } else if (s1.length() == 1 && !s1.equals(s2)) {
            return false;
        } else if (cache.containsKey(s1 + "|" + s2)) {
            return cache.get(s1 + "|" + s2);
        }

        Set<Character> c1 = new HashSet<Character>();
        for (char c : s1.toCharArray()) {
            c1.add(c);
        }

        Set<Character> c2 = new HashSet<Character>();
        for (char c : s2.toCharArray()) {
            c2.add(c);
        }

        if (!c1.containsAll(c2)) {
            return false;
        }

        boolean isScramble = false;
        for (int l = 1; !isScramble && l < s1.length(); l ++) {
            String s1l = s1.substring(0, l);
            String s1r = s1.substring(l);
            String s2l = s2.substring(0, l);
            String s2r = s2.substring(l);
            isScramble = recurse(s1l, s2l) && recurse(s1r, s2r);

            if (!isScramble) {
                s1l = s1.substring(0, l);
                s1r = s1.substring(l);
                s2l = s2.substring(0, s1.length() - l);
                s2r = s2.substring(s1.length() - l);
                isScramble = recurse(s1l, s2r) && recurse(s1r, s2l);
            }
        }
        cache.put(s1 + "|" + s2, isScramble);
        cache.put(s2 + "|" + s1, isScramble);
        return isScramble;
    }

    public static void main(String[] args) {
        ScrambleString test = new ScrambleString();

        System.out.println(System.currentTimeMillis());
        System.out.println(test.isScramble("ccabcbabcbabbbbcbb", "bbbbabccccbbbabcba"));
        System.out.println(System.currentTimeMillis());
        System.out.println(test.isScramble("abcdefghijklmnopq", "efghijklmnopqcadb"));
        System.out.println(System.currentTimeMillis());
        System.out.println(test.isScramble("abcde", "eacdb"));
        System.out.println(test.isScramble("abc", "cab"));
        System.out.println(test.isScramble("aa", "ab"));
        System.out.println(test.isScramble("abb", "bab"));
        System.out.println(test.isScramble("great", "rgate"));
        System.out.println(test.isScramble("great", "rgeat"));
    }
}
