package hongke.interview.leetcode.questions;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by hongke on 9/11/14.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int start = 0, end = 0, longest = 0;
        Set<Character> letters = new HashSet<Character>();
        while (end < s.length()) {
            while (end < s.length() && !letters.contains(s.charAt(end))) {
                letters.add(s.charAt(end));
                longest = Math.max(letters.size(), longest);
                end ++;
            }
            while (end < s.length() && letters.contains(s.charAt(end))) {
                letters.remove(s.charAt(start));
                start ++;
            }
        }

        return longest;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters test = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(test.lengthOfLongestSubstring("wlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmco"));
    }
}
