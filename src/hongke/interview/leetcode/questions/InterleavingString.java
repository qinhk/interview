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

import java.util.ArrayList;
import java.util.List;

public class InterleavingString {

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null || s1.length() == 0) {
            return s2.equals(s3);
        } else if (s2 == null || s2.length() == 0) {
            return s1.equals(s3);
        } else if (s3.length() != s1.length() + s2.length()) {
            return false;
        }

        List<Character> a3 = new ArrayList<Character>();
        for (Character c : s3.toCharArray()) {
            a3.add(c);
        }

        for (int i = a3.size() - 1, j = s2.length() - 1; j >= 0 && i >= 0; i --) {
            if (a3.get(i) == s2.charAt(j)) {
                a3.remove(i);
                j --;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Character c : a3) {
            sb.append(c);
        }

        return s1.equals(sb.toString());
    }

    public static void main(String[] args) {
        InterleavingString test = new InterleavingString();
        System.out.println(test.isInterleave("acca", "abba", "acabbaca")); //T
        System.out.println(test.isInterleave("ac", "ab", "acab")); //T
        System.out.println(test.isInterleave("ac", "ab", "abac")); //T
        System.out.println(test.isInterleave("aabd", "abdc", "aabdabcd")); //T
        System.out.println(test.isInterleave("aabd", "abdc", "aabdbadc")); //F
        System.out.println(test.isInterleave("aa", "ab", "aaba")); //T
        System.out.println(test.isInterleave("aa", "ab", "abaa")); //T
        System.out.println(test.isInterleave("aabcc", "dbbca", "aadbbcbcac")); //T
        System.out.println(test.isInterleave("aabcc", "dbbca", "aadbbbaccc")); //F
        System.out.println(test.isInterleave("aa", "ab", "baaa")); //F
        System.out.println(test.isInterleave("aa", "ab", "aaab")); //T
        System.out.println(test.isInterleave("ac", "ab", "aabc")); //T
        System.out.println(test.isInterleave("ac", "ab", "aacb")); //T
        System.out.println(test.isInterleave("aa", "aa", "aaaa")); //T
        System.out.println(test.isInterleave("ca", "ba", "bcaa")); //T
        System.out.println(test.isInterleave("ca", "ba", "cbaa")); //T
        System.out.println(test.isInterleave("ca", "ba", "caba")); //T

    }

}
