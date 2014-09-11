package hongke.interview.leetcode.questions;

/**
 * Created by hongke on 8/28/14.
 */
public class PalindromePartitioningII {
    public int minCut(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int n = s.length();

        // build table, n^2
        int[][] cache = new int[n][n];
        for (int i = 0;i < n; i ++) {
            cache[0][i] = 1;
        }
        for (int i = 0;i < n - 1; i ++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                cache[1][i] = 1;
            } else {
                cache[1][i] = 0;
            }
        }

        for (int i = 2; i < n; i ++) {
            for (int j = 0; j < n - i; j ++) {
                if (s.charAt(j) == s.charAt(j + i)) {
                    cache[i][j] = cache[i - 2][j + 1];
                } else {
                    cache[i][j] = 0;
                }
            }
        }

        int[] cuts = new int[n];
        for (int i = 0; i < n; i++) {
            int cut = i > 0 ? cuts[i - 1] : 0;
            for (int l = 0; l + i < n; l++) {
                if (cache[l][i] == 1) {
                    if (cuts[i + l] == 0) {
                        cuts[i + l] = cut + 1;
                    } else {
                        cuts[i + l] = Math.min(cuts[i + l], cut + 1);
                    }
                }
            }
        }
        return cuts[n - 1] - 1;
    }

    public static void main(String[] args) {
        PalindromePartitioningII test = new PalindromePartitioningII();

        System.out.println(test.minCut("aba"));
        System.out.println(test.minCut("aaabbaa"));
        System.out.println(test.minCut("ab"));
        System.out.println(test.minCut("aabb"));
        System.out.println(test.minCut("aaaaaaaaaa"));
        System.out.println(test.minCut("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
        System.out.println(test.minCut("a"));
    }
}
