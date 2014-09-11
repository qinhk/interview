package hongke.interview.leetcode.questions;

/**
 * Created by hongke on 9/6/14.
 */
public class MaximumSubarray {
    public int maxSubArray(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }

        int maxEndingHere = 0, maxSoFar = A[0];
        for (int i = 0; i < A.length; i++) {
            maxEndingHere = Math.max(A[i], maxEndingHere + A[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        return maxSoFar;
    }

    public static void main(String[] args) {
        MaximumSubarray test = new MaximumSubarray();
        System.out.println(test.maxSubArray(new int[] {-1, 2, 3, -1, 4, -10}));
    }
}
