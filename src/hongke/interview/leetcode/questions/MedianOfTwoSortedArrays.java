package hongke.interview.leetcode.questions;

/**
 * Created by hongke on 9/6/14.
 */
public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] A, int[] B) {
        if (A == null && B == null) {
            return 0;
        }

        int l = (A.length + B.length + 1) / 2;
        int r = (A.length + B.length + 2) / 2;

        return ((double) recursivelyGetKth(A, 0, A.length, B, 0, B.length, l)
            + (double) recursivelyGetKth(A, 0, A.length, B, 0, B.length, r)) / 2.0;
    }

    private int recursivelyGetKth(int[] A, int startA, int lengthA, int[] B, int startB, int lengthB, int k) {

        if (lengthA > lengthB) {
            return recursivelyGetKth(B, startB, lengthB, A, startA, lengthA, k);
        }

        if (lengthA == 0) {
            return B[startB + k - 1];
        }

        if (k == 1) {
            return Math.min(A[startA], B[startB]);
        }

        int i = Math.min(lengthA, k / 2), j = Math.min(lengthB, k /2);
        if (A[i - 1 + startA] > B[j - 1 + startB]) {
            return recursivelyGetKth(A, startA, lengthA, B, startB + j, lengthB - j, k - j);
        } else {
            return recursivelyGetKth(A, startA + i, lengthA - i, B, startB, lengthB, k - i);
        }

    }

    public static void main (String[] args) {
        MedianOfTwoSortedArrays test = new MedianOfTwoSortedArrays();
        System.out.println(test.findMedianSortedArrays(new int[]{1,3,5},  new int[]{1,2,4,7,10}));
    }

}
