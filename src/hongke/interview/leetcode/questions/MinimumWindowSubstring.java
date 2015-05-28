package hongke.interview.leetcode.questions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by hongke on 9/1/14.
 */
public class MinimumWindowSubstring {
    public String minWindow1(String S, String T) {
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

    public String minWindow(String S, String T) {
        if (S == null || T == null || S.length() == 0 || T.length() == 0) {
            return "";
        }

        int i = 0, j = 0;
        String result = null;
        Map<Character, Integer> ref = new HashMap<Character, Integer>();
        for (Character c : T.toCharArray()) {
            add(ref, c);
        }
        Map<Character, Integer> content = new HashMap<Character, Integer>();
        while (true) {
            if (j < S.length() && !contains(content, ref)) {
                if (ref.containsKey(S.charAt(j))) {
                    add(content, S.charAt(j));
                }
                j ++;
            } else if (contains(content, ref)){
                while (i < j && contains(content, ref)) {
                    if (ref.containsKey(S.charAt(i))) {
                        deduct(content, S.charAt(i));
                    }
                    i ++;
                }
                if (result == null || j - i + 1 < result.length()) {
                    result = S.substring(i - 1, j);
                }
            } else {
                break;
            }
        }
        return result == null ? "" : result;
    }

    private void add(Map<Character, Integer> map, Character c) {
        if (!map.containsKey(c)) {
            map.put(c, 0);
        }
        map.put(c, map.get(c) + 1);
    }

    private void deduct(Map<Character, Integer> map, Character c) {
        if (map.containsKey(c)) {
            map.put(c, map.get(c) - 1);
            if (map.get(c) <= 0) {
                map.remove(c);
            }
        }
    }

    private boolean contains(Map<Character, Integer> map1, Map<Character, Integer> map2) {
        for (Map.Entry<Character, Integer> entry : map2.entrySet()) {
            if (!map1.containsKey(entry.getKey()) || map1.get(entry.getKey()) < map2.get(entry.getKey())) {
                return false;
            }
        }
        return true;
    }

    // This method return minimum substring which contains all characters found in string T;
    public String minWindow2(String S, String T) {
        if (S == null || T == null || S.length() == 0 || T.length() == 0) {
            return "";
        }

        Set<Character> set = new HashSet<Character>();
        for (char c : T.toCharArray())
            set.add(c);
        Map<Character, Integer> counts = new HashMap<Character, Integer>();
        String result = null;
        Integer start = 0, end = 0;
        while (end < S.length()) {
            char c = S.charAt(end);
            if (set.contains(c)) {
                int count1 = counts.containsKey(c) ? counts.get(c) : 0;
                counts.put(c, count1 + 1);
                while (counts.size() == set.size()) {
                    char d = S.charAt(start);
                    if (set.contains(d)) {
                        int count2 = counts.get(d);
                        if (count2 == 1) {
                            counts.remove(d);
                            if (result == null || end + 1 - start < result.length()) {
                                result = S.substring(start, end + 1);
                            }
                        } else {
                            counts.put(d, count2 - 1);
                        }
                    }
                    start ++;
                }

            }
            end ++;
        }
        return result == null ? "" : result;
    }



    public static void main(String[] args) {
        MinimumWindowSubstring test = new MinimumWindowSubstring();
        System.out.println(test.minWindow("bba", "ab"));
        System.out.println(test.minWindow("bdab", "ab"));
        System.out.println(test.minWindow2("a", "a"));
    }
}
