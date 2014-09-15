package hongke.interview.leetcode.questions;

/**
 * Created by hongke on 9/11/14.
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }

        int n = s.length(), longest = 1, position = 0;
        int[][] cache = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j + i < n; j++) {
                int prevIsPalindrome = i > 1 ? cache[i - 2][j + 1] : 1;
                cache[i][j] = s.charAt(j) == s.charAt(j + i) ? prevIsPalindrome : 0;
                if (cache[i][j] != 0) {
                    longest = i;
                    position = j;
                }
            }
        }

        return s.substring(position, position + longest + 1);
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring test = new LongestPalindromicSubstring();
        System.out.println(test.longestPalindrome("abcdcbasssss"));
    }
}
