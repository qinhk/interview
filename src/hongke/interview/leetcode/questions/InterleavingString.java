package hongke.interview.leetcode.questions;

/*
 Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

 For example,
 Given:
 s1 = "aabcc",
 s2 = "dbbca",

 When s3 = "aadbbcbcac", return true.
 When s3 = "aadbbbaccc", return false.  

 */

public class InterleavingString {

    public boolean isInterleave1(String s1, String s2, String s3) {
        if (s1 == null || s2 == null || s3 == null) {
            return false;
        }

        boolean[][] cache = new boolean[s1.length() + 1][s2.length() + 1];
        cache[0][0] = true;
        for (int i = 1; i <= s1.length(); i++) {
            cache[i][0] = s1.charAt(i - 1) == s3.charAt(i - 1) && cache[i - 1][0];
        }
        for (int i = 1; i <= s2.length(); i++) {
            cache[0][i] = s2.charAt(i - 1) == s3.charAt(i - 1) && cache[0][i - 1];
        }
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (cache[i - 1][j] && s3.charAt(i + j - 1) == s1.charAt(i - 1)) {
                    cache[i][j] = true;
                } else if (cache[i][j - 1] && s3.charAt(i + j - 1) == s2.charAt(j - 1)) {
                    cache[i][j] = true;
                }
            }
        }
        return cache[s1.length()][s2.length()];
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null || s2 == null || s3 == null
                || s3.length() != s1.length() + s2.length()) //!! S3 can have extra characters.
            return false;

        int m = s1.length(), n = s2.length();
        boolean[][] state = new boolean[m + 1][n + 1];
        state[0][0] = true;
        for (int i = 1; i <= m; i ++) {
            if (s3.charAt(i - 1) == s1.charAt(i - 1)) {
                state[i][0] = state[i - 1][0];
            }
        }
        for (int i = 1; i <= n; i ++) {
            if (s3.charAt(i - 1) == s2.charAt(i - 1)) {
                state[0][i] = state[0][i - 1];
            }
        }
        for (int i = 1; i <= m; i ++) {
            for (int j = 1; j <= n; j ++) {
                state[i][j] = (s3.charAt(i + j - 1) == s2.charAt(j - 1) && state[i][j - 1])
                        || (s3.charAt(i + j - 1) == s1.charAt(i - 1) && state[i - 1][j]);
            }
        }
        return state[m][n];
    }

    public static void main(String[] args) {
        InterleavingString test = new InterleavingString();

        System.out.println(test.isInterleave("a", "b", "ab")); //F
        System.out.println(!test.isInterleave("ab", "bc", "bbac")); //F
        System.out.println(!test.isInterleave("aa", "ab", "baaa")); //F
        System.out.println(test.isInterleave("ca", "ba", "caba")); //T
        System.out.println(test.isInterleave("ac", "ab", "acab")); //T
        System.out.println(test.isInterleave("ac", "ab", "abac")); //T
        System.out.println(test.isInterleave("aabd", "abdc", "aabdabcd")); //T
        System.out.println(!test.isInterleave("aabd", "abdc", "aabdbadc")); //F
        System.out.println(test.isInterleave("aa", "ab", "aaba")); //T
        System.out.println(test.isInterleave("aa", "ab", "abaa")); //T
        System.out.println(test.isInterleave("aabcc", "dbbca", "aadbbcbcac")); //T
        System.out.println(!test.isInterleave("aabcc", "dbbca", "aadbbbaccc")); //F
        System.out.println(test.isInterleave("aa", "ab", "aaab")); //T
        System.out.println(test.isInterleave("ac", "ab", "aabc")); //T
        System.out.println(test.isInterleave("ac", "ab", "aacb")); //T
        System.out.println(test.isInterleave("aa", "aa", "aaaa")); //T
        System.out.println(test.isInterleave("ca", "ba", "bcaa")); //T
        System.out.println(test.isInterleave("ca", "ba", "cbaa")); //T
        System.out.println(test.isInterleave("acca", "abba", "acabbaca")); //T

    }

}
