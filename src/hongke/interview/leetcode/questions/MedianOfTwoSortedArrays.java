package hongke.interview.leetcode.questions;

/**
 * Created by hongke on 9/6/14.
 */
public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] A, int[] B) {
        if (A == null || B == null) {
            return 0;
        }
        int l = (A.length + B.length + 1) / 2;
        int r = (A.length + B.length + 2) / 2;
        if (A.length > B.length) {
            int[] tmp = A; A = B; B = tmp;
        }
        return ((double) recursivelyGetKth(A, 0, B, 0, l)
            + (double) recursivelyGetKth(A, 0, B, 0, r)) / 2.0;
    }

    private int recursivelyGetKth(int[] A, int startA, int[] B, int startB, int k) {
        if (startA == A.length) {
            return B[startB + k - 1];
        } else if (k == 1) {
            return Math.min(A[startA], B[startB]);
        } else {
            int i = Math.min(A.length - startA, k / 2), j = Math.min(B.length - startB, k / 2);
            if (A[i - 1 + startA] > B[j - 1 + startB]) {
                return recursivelyGetKth(A, startA, B, startB + j, k - j);
            } else {
                return recursivelyGetKth(A, startA + i, B, startB, k - i);
            }
        }
    }

    public static void main (String[] args) {
        MedianOfTwoSortedArrays test = new MedianOfTwoSortedArrays();

        System.out.println(test.findMedianSortedArrays(new int[]{},  new int[]{0, 1}));
        System.out.println(test.findMedianSortedArrays(new int[]{1},  new int[]{0}));
        System.out.println(test.findMedianSortedArrays(new int[]{1,3,5},  new int[]{1,2,4,7,10}));
        System.out.println(test.findMedianSortedArrays(new int[]{1,2,3},  new int[]{4,5,6,7,8}));
    }

}
