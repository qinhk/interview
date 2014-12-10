package hongke.interview.algorithms.substring;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by hongke on 12/4/14.
 */
public class KMP {

    final private Map<Character, int[]> dfa;

    private final int matchLength;

    public KMP(String pattern) {
        // Pre-condition
        assert pattern != null;
        dfa = new TreeMap<Character, int[]>();
        matchLength = pattern.length();
        buildDFA(pattern);
    }

    private void buildDFA(String pattern) {

        char[] p = pattern.toCharArray();
        // DFA state initialization
        dfa.put(p[0], new int[p.length]);
        dfa.get(p[0])[0] = 1;

        for (int X = 0, i = 1; i < p.length; i++) {
            // Update character set
            if (!dfa.containsKey(p[i])) {
                dfa.put(p[i], new int[p.length]);
            }
            //Copy mismatch states
            for (Character c : dfa.keySet()) {
                dfa.get(c)[i] = dfa.get(c)[X];
            }
            // Update match states
            dfa.get(p[i])[i] = i + 1;
            // Update next X
            X = dfa.get(p[i])[X];
        }
    }

    private int search(String text) {
        int p = 0, i = 1;
        for (Character c : text.toCharArray()) {
            if (dfa.containsKey(c)) {
                p = dfa.get(c)[p];
                if (p == matchLength) {
                    return i - matchLength;
                }
            } else {
                p = 0;
            }
            i ++;
        }
        return -1;
    }

    public static int search(String text, String pattern) {
        if (text == pattern || text != null && pattern != null && text.equals(pattern)) {
            return 0;
        } else if (text == null || pattern == null) {
            return -1;
        }
        KMP kmp = new KMP(pattern);
        return kmp.search(text);
    }

    public static void main(String[] args) {
        System.out.println(KMP.search("", ""));
        System.out.println(KMP.search("BCBAABACAABABACAA", "ABABAC"));
        System.out.println(KMP.search("mississippi", "issi"));
        System.out.println(KMP.search("babba", "bbb"));
    }
}
