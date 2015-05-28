package hongke.interview.algorithms.substring;

import java.util.*;

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
//
//    public static int strStr(String text, String pattern) {
//        if (text == pattern || pattern != null && pattern.length() == 0) {
//            return 0;
//        } else if (text == null || pattern == null || pattern.length() > text.length()) {
//            return -1;
//        }
//
//        char[] p = pattern.toCharArray();
//        Map<Character, int[]> DFA = new HashMap<Character, int[]>();
//        DFA.put(p[0], new int[p.length]);
//        DFA.get(p[0])[0] = 1;
//        for (int x = 0, i = 1; i < p.length; i ++) {
//            if (!DFA.containsKey(p[i])) {
//                DFA.put(p[i], new int[p.length]);
//            }
//            for (int[] row : DFA.values()) {
//                row[i] = row[x];
//            }
//            DFA.get(p[i])[i] = i + 1;
//            x = DFA.get(p[i])[x];
//        }
//
//        int i = 0, j = 1;
//        for (char t : text.toCharArray()) {
//            if (DFA.containsKey(t)) {
//                i = DFA.get(t)[i];
//                if (i == p.length) {
//                    return j - p.length;
//                }
//            } else {
//                i = 0;
//            }
//            j ++;
//        }
//
//        return  -1;
//    }

    public  static String fractionToDecimal(long numerator, long denominator) {
        if (denominator == 0) {
            throw new ArithmeticException("Divide by zero");
        } else if (numerator == 0) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        if (numerator < 0 && denominator > 0 || numerator > 0 && denominator < 0) {
            sb.append('-');
        }
        numerator = numerator < 0 ? -1 * numerator : numerator;
        denominator = denominator < 0 ? -1 * denominator : denominator;
        sb.append(numerator / denominator);
        long r = numerator % denominator;
        if (r != 0) {
            sb.append('.');
            LinkedHashMap<Long, Integer> map = new LinkedHashMap<Long, Integer>();
            while (r != 0) {
                if (r < denominator) {
                    r *= 10;
                }
                if (map.containsKey(r)) {
                    for (Map.Entry<Long, Integer> e : map.entrySet()) {
                        if(e.getKey() == r)
                            sb.append('(');
                        sb.append(e.getValue());
                    }
                    sb.append(')');
                    return sb.toString();
                } else {
                    map.put(r, (int)(r / denominator));
                    r = r % denominator;
                }
            }
            for (Map.Entry<Long, Integer> e : map.entrySet()) {
                sb.append(e.getValue());
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(KMP.search("", ""));
        System.out.println(KMP.search("BCBAABACAABABACAA", "ABABAC"));
        System.out.println(KMP.search("mississippi", "issi"));
        System.out.println(KMP.search("aaa", "aa"));


        System.out.println(fractionToDecimal(Integer.MIN_VALUE, 1));
        System.out.println(fractionToDecimal(-1, Integer.MIN_VALUE));

        System.out.println(fractionToDecimal(1, 5));
        System.out.println(fractionToDecimal(1, 4));
        System.out.println(fractionToDecimal(1, 90));
        System.out.println(fractionToDecimal(2, 3));
        System.out.println(fractionToDecimal(53, 40));
    }
}
