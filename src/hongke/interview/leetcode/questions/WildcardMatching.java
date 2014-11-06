package hongke.interview.leetcode.questions;

/**
 * Created by hongke on 6/29/14.
 */
public class WildcardMatching {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }

        int si = 0, pi = 0, lastStar = -1, match = 0;
        while (si < s.length()) {
            if (pi < p.length() && (p.charAt(pi) == s.charAt(si) || p.charAt(pi) == '?')) {
                si ++;
                pi ++;
            } else if (pi < p.length() && p.charAt(pi) == '*') {
                lastStar = pi;
                match = si;
                pi ++;
            } else if (lastStar != -1) {
                pi = lastStar + 1;
                match ++;
                si = match;
            } else {
                return false;
            }
        }

        while (pi < p.length() && p.charAt(pi) == '*') {
            pi ++;
        }

        if (pi == p.length()) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        WildcardMatching match = new WildcardMatching();
        long start = 0, end = 0;

        System.out.println(match.isMatch("aab", "?*??"));//T
        System.out.println(match.isMatch("aabaaab", "a*?b"));//T
        System.out.println(match.isMatch("", "")); //T
        System.out.println(match.isMatch("", "*")); //T
        System.out.println(! match.isMatch("", "?")); //F
        System.out.println();

        System.out.println(match.isMatch("s", "*"));//T
        System.out.println(match.isMatch("a", "?"));//T
        System.out.println(! match.isMatch("ab", "aa"));//F
        System.out.println(match.isMatch("aab", "a*"));//T
        System.out.println(match.isMatch("a", "a*"));//T
        System.out.println();

        System.out.println(match.isMatch("aabaaab", "a*b"));//T
        System.out.println(! match.isMatch("aabaaab", "a*a"));//F
        System.out.println(match.isMatch("aabaaab", "a**"));//T
        System.out.println(match.isMatch("aabaaab", "a*a*********b"));//T
        System.out.println(match.isMatch("aab", "a?b"));//T
        System.out.println();

        System.out.println(match.isMatch("aab", "aab*"));//T
        System.out.println(! match.isMatch("a", "aa*"));//T
        start = System.nanoTime();
        System.out.println(match.isMatch("aabbccddeeeeeghf", "aa*bb*cc*dd*ghf"));//T
        end = System.nanoTime();
        System.out.println((end - start)/1000.0);

        start = System.currentTimeMillis();
        System.out.println(match.isMatch("abbbaaaaaaaabbbabaaabbabbbaabaabbbbaabaabbabaabbabbaabbbaabaabbabaabaabbbbaabbbaabaaababbbbabaaababbaaa", "ab**b*bb*ab**ab***b*abaa**b*a*aaa**bba*aa*a*abb*a*a"));//T
        end = System.currentTimeMillis();
        System.out.println((end - start)/1000.0);

        start = System.nanoTime();
        System.out.println(match.isMatch("abbaabbbbababaababababbabbbaaaabbbbaaabbbabaabbbbbabbbbabbabbaaabaaaabbbbbbaaabbabbbbababbbaaabbabbabb", "***b**a*a*b***b*a*b*bbb**baa*bba**b**bb***b*a*aab*a**"));//T
        end = System.currentTimeMillis();
        System.out.println((end - start)/1000.0);

        start = System.nanoTime();
        System.out.println(match.isMatch("abbabaaabbabbaababbabbbbbabbbabbbabaaaaababababbbabababaabbababaabbbbbbaaaabababbbaabbbbaabbbbababababbaabbaababaabbbababababbbbaaabbbbbabaaaabbababbbbaababaabbababbbbbababbbabaaaaaaaabbbbbaabaaababaaaabb", "**aa*****ba*a*bb**aa*ab****a*aaaaaa***a*aaaa**bbabb*b*b**aaaaaaaaa*a********ba*bbb***a*ba*bb*bb**a*b*bb"));//T
        end = System.nanoTime();
        System.out.println((end - start)/1000.0);

    }
}
