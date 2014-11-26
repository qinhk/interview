package hongke.interview.leetcode.questions;

import java.util.Arrays;

/**
 * Created by hongke on 8/28/14.
 */
public class PalindromePartitioning2 {
    public int minCut1(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int n = s.length();

        int[] cache = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            cache[i] = i - 1;
        }

        for (int i = 0; i < n; i++) {
            // odd length palindrome
            for (int r = 0; i - r >= 0 && i + r < n && s.charAt(i - r) == s.charAt(i + r); r++) {
                cache[i + r + 1] = Math.min(cache[i + r + 1], cache[i - r] + 1);
            }

            // even length palindrome
            for (int r = 1; i - r + 1 >= 0 && i + r < n && s.charAt(i - r + 1) == s.charAt(i + r); r++) {
                cache[i + r + 1] = Math.min(cache[i + r + 1], cache[i - r + 1] + 1);
            }
        }

        return cache[n];
    }

    public int minCut2(String s) {
        if (s == null || s.length() <= 1) {
            return 0;
        }
        int[][] palindrome_map = new int[s.length()][s.length()];
        int[] cut_num_array = new int[s.length() + 1];

        for (int i = s.length() - 1; i >= 0; i--) {
            cut_num_array[i] = s.length() - i;
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i < 2 || palindrome_map[i + 1][j - 1] == 1) {
                        palindrome_map[i][j] = 1;
                        cut_num_array[i] = Math.min(cut_num_array[i], cut_num_array[j + 1] + 1);
                    }
                }
            }
        }
        return cut_num_array[0] - 1;
    }

    public int minCut(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }

        char[] chars = s.toCharArray();
        int [] cut = new int[s.length() + 1];
        boolean [][] isPalindrome = new boolean [s.length() + 1][s.length() + 1];
        for (int i = 0; i <= s.length(); i ++) {
            cut[i] = i;
        }

        Arrays.fill(isPalindrome[0], true);
        Arrays.fill(isPalindrome[1], true);

        for (int i = 2; i <= s.length(); i ++) {
            System.out.println(i);
            for (int j = i; j <= s.length();  j ++) {
                if (chars[j - 1] == chars[j - i]) {
                    isPalindrome[i][j] = isPalindrome[i - 2][j - 1];
                }
                if (isPalindrome[i][j]) {
                    cut[j] = Math.min(cut[j - i] + 1, cut[j]);
                } else {
                    cut[j] = Math.min(cut[j - 1] + 1, cut[j]);
                }
            }
        }
        return cut[s.length()] - 1;
    }

    public static void main(String[] args) {
        PalindromePartitioning2 test = new PalindromePartitioning2();

        System.out.println(test.minCut("ababbbabbaba"));
        System.out.println(test.minCut("aba"));
        System.out.println(test.minCut("abba"));
        System.out.println(test.minCut("aaabbaa"));
        System.out.println(test.minCut("ab"));
        System.out.println(test.minCut("aabb"));
        System.out.println(test.minCut("aaaaaaaaaa"));
        System.out.println(test.minCut("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab"));
        System.out.println(test.minCut("a"));
    }
}
