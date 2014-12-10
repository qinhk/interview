package hongke.interview.common;

/**
 * Created by hongke on 12/4/14.
 */
public class Solution {
    class RabinKarp {

        private static final long Q = 99999999977L;

        private static final int R = 256;

        private final int M;

        private final long RM;

        private final long patternHash;

        RabinKarp(String pattern) {
            M = pattern.length();
            long rm = 1;
            for (int i = 1; i <= M - 1; i++) {
                rm = (R * rm) % Q;
            }
            RM = rm;
            patternHash = hash(pattern, M);
        }

        int search(String text) {
            long hash = hash(text, M);
            if (hash == patternHash) return 0;

            for (int i = M; i < text.length(); i++) {
                hash = (hash + Q - RM * text.charAt(i - M) % Q) % Q;
                hash = (hash * R + text.charAt(i)) % Q;
                if (hash == patternHash) return i - M + 1;
            }
            return -1;
        }

        private long hash(String key, int M) {
            long h = 0;
            for (int i = 0; i < M; i++) {
                h = (R * h + key.charAt(i)) % Q;
            }
            return h;
        }
    }

    public int strStr(String text, String pattern) {
        if (text == pattern || text != null && pattern != null && text.equals(pattern)) {
            return 0;
        } else if (text == null || pattern == null) {
            return -1;
        }
        RabinKarp rk = new RabinKarp(pattern);
        return rk.search(text);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.strStr("abbbaaaaaaabbababbbbabababbbbbbbaaaaaaabbaaabbaababbbbababababaabbbbbbaaaaababbbbaaabababbbaaaabbbaabbbbbbabababbabaaaaabaabaaababbbaaabaababbaaabaaababbabbbbababaaaaaaababaabaabbaabbbaaabaaaaaa", "aabaaaabababbbabababbbaabaabaaaaabaabbbaabbbbba"));
        System.out.println(s.strStr("mississippi", "issi"));
        System.out.println(s.strStr("HAYSTACKCONTAINSNEEDLES", "NEEDLE"));
    }
}
