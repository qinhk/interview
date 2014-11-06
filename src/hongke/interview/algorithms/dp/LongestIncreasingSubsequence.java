package hongke.interview.algorithms.dp;

/**
 * Longest Increasing Subsequence. Given a sequence of n real numbers A(1) ... A(n), determine a subsequence (not
 * necessarily contiguous) of maximum length in which the values in the subsequence form a strictly increasing sequence.
 * [on problem set 4] Created by hongke on 11/2/14.
 */
public class LongestIncreasingSubsequence {
    public int longestIncreaseingSubsequence(int[] input) {
        if (!precondition(input)) return 0;
        int[] lengths = new int[input.length];
        lengths[0] = 1;
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < i; j++) {
                if (input[j] < input[i]) {
                    lengths[i] = Math.max(lengths[i], lengths[j] + 1);
                }
            }
        }

        int maxLength = 0;
        for (int length : lengths) {
            maxLength = Math.max(maxLength, length);
        }
        return maxLength;
    }

    private boolean precondition(int[] input) {
        if (input == null || input.length == 0) {
            return false;
        } else {
            return true;
        }
    }
}
