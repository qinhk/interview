package hongke.interview.leetcode.questions;

import java.util.*;

/**
 * Created by hongke on 4/27/14.
 */
public class LetterCombinationsOfPhoneNumbers {
    private static final Map<Character, List<Character>> cache;
    static {
        Map<Character, List<Character>> map = new HashMap<Character, List<Character>>();
        map.put('1', Arrays.asList(new Character[]{}));
        map.put('2', Arrays.asList(new Character[]{'a', 'b', 'c'}));
        map.put('3', Arrays.asList(new Character[]{'d', 'e', 'f'}));
        map.put('4', Arrays.asList(new Character[]{'g', 'h', 'i'}));
        map.put('5', Arrays.asList(new Character[]{'j', 'k', 'l'}));
        map.put('6', Arrays.asList(new Character[]{'m', 'n', 'o'}));
        map.put('7', Arrays.asList(new Character[]{'p', 'q', 'r', 's'}));
        map.put('8', Arrays.asList(new Character[]{'u', 'v', 'w'}));
        map.put('9', Arrays.asList(new Character[]{'w', 'x', 'y', 'z'}));
        map.put('0', Arrays.asList(new Character[]{' '}));
        cache = Collections.unmodifiableMap(map);
    }

    public ArrayList<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<String>();
        }

        ArrayList<String> results = new ArrayList<String>();
        results.add("");
        for (int i = 0; i < digits.length(); i ++) {
            if (digits.charAt(i) == '1') {
                continue;
            }
            ArrayList<String> combinations = new ArrayList<String>();
            for (String s : results) {
                for (Character c : cache.get(digits.charAt(i))) {
                    StringBuilder sb = new StringBuilder(s);
                    sb.append(c);
                    combinations.add(sb.toString());
                }
            }
            results = combinations;
        }
        return results;
    }

    public static void main(String[] args) {
        LetterCombinationsOfPhoneNumbers test = new LetterCombinationsOfPhoneNumbers();
        List<String> result = test.letterCombinations("3522159962");
        System.out.println(String.valueOf(result));
    }
}
