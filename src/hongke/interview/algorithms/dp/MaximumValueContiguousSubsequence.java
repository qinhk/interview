package hongke.interview.algorithms.dp;

/**
 * Maximum Value Contiguous Subsequence. Given a sequence of n real numbers A(1) ... A(n), determine a contiguous
 * subsequence A(i) ... A(j) for which the sum of elements in the subsequence is maximized. Created by hongke on
 * 11/2/14.
 */
public class MaximumValueContiguousSubsequence {

    public int maximumValueContiguousSubsequence(int[] input) {

        int result = 0;
        if (input == null || input.length == 0) {
            return result;
        }
        int sum = input[0];
        result = sum;
        for (int i = 1; i < input.length; i++) {
            sum = sum + input[i] < 0 ? 0 : sum + input[i];
            result = Math.max(result, sum);
        }

        return result;
    }

}
