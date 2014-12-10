package hongke.interview.algorithms.substring;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hongke on 12/5/14.
 */
public class BoyerMoore {

    private final Map<Character, Integer> right;

    private final char[] p;

    private final int patternLength;

    BoyerMoore(String pattern) {
        assert pattern != null;
        right = buildRight(pattern);
        patternLength = pattern.length();
        p = pattern.toCharArray();
    }

    private Map<Character, Integer> buildRight(String pattern) {
        char[] p = pattern.toCharArray();
        Map<Character, Integer> right = new HashMap<Character, Integer>();
        for (int i = 0; i < p.length; i++) {
            right.put(p[i], i);
        }
        return right;
    }

    private int search(String text) {
        char[] t = text.toCharArray();
        int skip;
        for (int i = 0; i + patternLength <= text.length(); i += skip) {
            skip = 0;
            for (int j = patternLength - 1; j >= 0; j--) {
                if (t[i + j] != p[j]) {
                    skip = right.containsKey(t[i + j]) ? Math.max(j - right.get(t[i + j]), 1) : j + 1;
                    break;
                }
            }
            if (skip == 0) return i;
        }
        return -1;
    }

    public static int search(String text, String pattern) {
        if (text == pattern || text != null && pattern != null && text.startsWith(pattern)) {
            return 0;
        } else if (pattern == null || text == null || pattern.length() > text.length()) {
            return -1;
        }
        BoyerMoore bm = new BoyerMoore(pattern);
        return bm.search(text);
    }

    public static void main(String[] args) {
        System.out.println(BoyerMoore.search("mississippi", "issi"));
        System.out.println(BoyerMoore.search("HAYSTACKCONTAINSNEEDLES", "NEEDLE"));
    }
}
