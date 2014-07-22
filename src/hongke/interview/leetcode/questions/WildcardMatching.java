package hongke.interview.leetcode.questions;

/**
 * Created by hongke on 6/29/14.
 */
public class WildcardMatching {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }

        int si = 0, pi = 0;
        boolean result = dfs(s, si, p, pi);
//        System.out.println(count);
        return result;
    }

    private boolean dfs(String s, int si, String p, int pi) {
        while (pi < p.length() && si <= s.length()) {
            if (p.charAt(pi) == '*') {
                while (pi < p.length() && p.charAt(pi) == '*') {
                    pi ++;
                }
                if (pi == p.length()) {
                    return true;
                } else {
                    boolean found = false;
                    while (si < s.length() && !found){
                        found = dfs(s, si, p, pi);

                        if (p.charAt(pi) != '?' ) {
                            si = s.indexOf(p.charAt(pi), si + 1);
                        } else {
                            si ++;
                        }
                        if (si < 0) {
                            break;
                        }
                    }

                    return found;
                }
            } else if  (si < s.length() && (p.charAt(pi) == '?' || p.charAt(pi) == s.charAt(si))) {
                pi ++;
                si ++;
            } else {
                return false;
            }
        }
        return si == s.length() && pi == p.length();
    }

    public static void main(String[] args) {
        WildcardMatching match = new WildcardMatching();
        long start = 0, end = 0;

        System.out.println(match.isMatch("aab", "?*??"));//T
        System.out.println(match.isMatch("aabaaab", "a*?b"));//T
        System.out.println(match.isMatch("", "")); //T
        System.out.println(match.isMatch("", "*")); //T
        System.out.println(! match.isMatch("", "?")); //F
        System.out.println(match.isMatch("s", "*"));//T
        System.out.println(match.isMatch("a", "?"));//T
        System.out.println(! match.isMatch("ab", "aa"));//F
        System.out.println(match.isMatch("aab", "a*"));//T
        System.out.println(match.isMatch("a", "a*"));//T
        System.out.println(match.isMatch("aabaaab", "a*b"));//T
        System.out.println(! match.isMatch("aabaaab", "a*a"));//F
        System.out.println(match.isMatch("aabaaab", "a**"));//T
        System.out.println(match.isMatch("aabaaab", "a*a*********b"));//T
        System.out.println(match.isMatch("aab", "a?b"));//T
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
        System.out.println(match.isMatch("abbabaaabbabbaababbabbbbbabbbabbbabaaaaababababbbabababaabbababaabbbbbbaaaabababbbaabbbbaabbbbababababbaabbaababaabbbababababbbbaaabbbbbabaaaabbababbbbaababaabbababbbbbababbbabaaaaaaaabbbbbaabaaababaaaabb", "**aa*****ba*a*bb**aa*ab****a*aaaaaa***a*aaaa**bbabb*b*b**aaaaaaaaa*a********ba*bbb***a*ba*bb*bb**a*b*bb"));//T
        end = System.nanoTime();
        System.out.println((end - start)/1000.0);

    }
}
