package hongke.interview.leetcode.questions;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by hongke on 12/12/14.
 */
public class LongestSubstringWithAtMostTwoDistinctCharacters {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        Set<Character> letters = new HashSet<Character>();
        int start = 0, end = 0, max = 0;
        while (end < s.length()) {
            if (!letters.contains(s.charAt(end))) {
                if (letters.size() == 2) {
                    char c = s.charAt(end - 1);
                    int t = end - 1;
                    while (s.charAt(t) == c) {
                        t --;
                    }
                    start = t + 1;
                    letters.remove(s.charAt(t));
                }
                letters.add(s.charAt(end));
            }
            max = Math.max(max, end - start + 1);
            end++;
        }
        return max;
    }


    public static void main(String[] args) {
        LongestSubstringWithAtMostTwoDistinctCharacters test = new LongestSubstringWithAtMostTwoDistinctCharacters();

        System.out.println(test.lengthOfLongestSubstringTwoDistinct("cdaba"));
        System.out.println(test.lengthOfLongestSubstringTwoDistinct("abaccc"));
        System.out.println(test.lengthOfLongestSubstringTwoDistinct("asasasbb"));
        System.out.println(test.lengthOfLongestSubstringTwoDistinct("eceba"));
        System.out.println(test.lengthOfLongestSubstringTwoDistinct("aaaabbb"));
        System.out.println(test.lengthOfLongestSubstringTwoDistinct("aaaa"));
        System.out.println(test.lengthOfLongestSubstringTwoDistinct("a"));
        System.out.println(test.lengthOfLongestSubstringTwoDistinct(""));
    }
}
