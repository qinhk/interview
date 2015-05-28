package hongke.interview.algorithms.dp;

import java.util.*;

/**
 * Longest Increasing Subsequence. Given a sequence of n real numbers A(1) ... A(n), determine a subsequence (not
 * necessarily contiguous) of maximum length in which the values in the subsequence form a strictly increasing sequence.
 * [on problem set 4] Created by hongke on 11/2/14.
 */
public class LongestIncreasingSubsequence {
    // Dynamic programming, O(n^2)
    public int longestIncreaseingSubsequence(int[] input) {
        if (input == null || input.length == 0) {
            return 0;
        }

        int[] lengths = new int[input.length];
        Arrays.fill(lengths, 1);
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

    // Advanced DP solution, O(nlogn)
    public List<Integer> findLIS(int[] input) {
        if (input == null || input.length == 0) {
            return new ArrayList<Integer>();
        }

        int n = input.length, l = 1;
        int[] tail = new int[n];
        int[] prev = new int[n];
        prev[0] = -1;
        Deque<Integer> result = new ArrayDeque<Integer>();
        for (int i = 1; i < n; i ++) {
            if (input[i] < input[tail[0]]) {// left edge case, smaller than all
                tail[0] = i;
            } else if ( input[tail[l - 1]] < input[i]) {// right edge case, larger than all
                prev[i] = tail[l - 1];// update prev
                tail[l ++] = i;
            } else {// replace case,
                int pos = ceilIndex(input, tail, 0, l - 1, input[i]); // find ceil position,
                prev[i] = tail[pos - 1];// update parent pointer,
                tail[pos] = i;// update ending element for ceil index,
            }
        }

        for(int i = tail[l-1]; i >= 0; i = prev[i]) // scan from end of the LIS tree;
            result.addFirst(input[i]);

        return new ArrayList<Integer>(result);
    }

    private int ceilIndex(int[] input, int[] tail, int l, int r, int num) {
        while( r - l > 1 ) {
            int m = l + (r - l)/2;
            if(input[tail[m]] >= num)
                r = m;
            else
                l = m;
        }

        return r;
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence LIS = new LongestIncreasingSubsequence();
        int length = LIS.longestIncreaseingSubsequence(new int[]{ 10, 22, 9, 33, 21, 50, 41, 60, 80 });
        System.out.println(length);
        List<Integer> lis = LIS.findLIS(new int[]{ 10, 22, 9, 33, 21, 50, 41, 60, 80 });
        System.out.println(lis);


        length = LIS.longestIncreaseingSubsequence(new int[]{0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15});
        System.out.println(length);
        lis = LIS.findLIS(new int[]{0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15});
        System.out.println(lis);
    }
}
