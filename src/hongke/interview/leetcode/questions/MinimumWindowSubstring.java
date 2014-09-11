package hongke.interview.leetcode.questions;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hongke on 9/1/14.
 */
public class MinimumWindowSubstring {
    public String minWindow(String S, String T) {
        if (S == null || T == null || S.isEmpty() || T.isEmpty()) {
            return "";
        }

        int start = 0, end = 0, minStart = 0, minEnd = S.length() + 1;
        Map<Character, Integer> chars = new HashMap<Character, Integer>();
        Map<Character, Integer> contains = new HashMap<Character, Integer>();

        for (Character c : T.toCharArray()) {
            if (!chars.containsKey(c)) {
                chars.put(c, 1);
            } else {
                chars.put(c, chars.get(c) + 1);
            }
        }

        for (Character c : chars.keySet()) {
            contains.put(c, 0);
        }

        while (end < S.length() && minEnd - minStart >= T.length()) {
            if (chars.containsKey(S.charAt(end))) {
                contains.put(S.charAt(end), contains.get(S.charAt(end)) + 1);
            }
            while (containsAllCharacters(contains, chars)) {
                if (end - start < minEnd - minStart) {
                    minEnd = end;
                    minStart = start;
                }
                if (chars.containsKey(S.charAt(start))) {
                    contains.put(S.charAt(start), contains.get(S.charAt(start)) - 1);
                }
                start ++;
            }
            end ++;
        }

        if (minEnd > S.length()) {
            return "";
        } else {
            return S.substring(minStart, minEnd + 1);
        }

    }

    private boolean containsAllCharacters(Map<Character, Integer>contains, Map<Character, Integer> chars) {
        for (Map.Entry<Character, Integer> entry : chars.entrySet()) {
            if (!contains.containsKey(entry.getKey()) || contains.get(entry.getKey()) < chars.get(entry.getKey())) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        MinimumWindowSubstring test = new MinimumWindowSubstring();
        System.out.println(test.minWindow("bdab", "ab"));
    }
}
