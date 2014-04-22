package hongke.interview.leetcode.questions;

/*
 * Created by hongke on 3/9/14.
 *
 * Given a sorted array of integers, find the starting and ending position of a given target value.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * If the target is not found in the array, return [-1, -1].
 *
 * For example,
 * Given [5, 7, 7, 8, 8, 10] and target value 8,
 * return [3, 4].
 *
 * http://oj.leetcode.com/problems/search-for-a-range/
 */

public class SearchForARange {
    public int[] searchRange(int[] A, int target) {
        if (A == null || A.length == 0 ||
                target < A[0] || target > A[A.length - 1]) {
            return new int[]{-1, -1};
        }

        int start = 0;
        int end = A.length;
        while (true) {
            int pivot = (end + start) / 2;
            if (start != end && A[pivot] < target) {
                start = pivot;
            } else if (start != end && A[pivot] > target) {
                end = pivot;
            } else if (A[pivot] == target) {
                for (start = pivot; start > 0; start--) {
                    if (start == 0 || A[start - 1] < target) {
                        break;
                    }
                }
                for (end = pivot; end < A.length; end++) {
                    if (end == A.length - 1 || A[end + 1] > target) {
                        break;
                    }
                }
                return new int[]{start, end} ;
            } else {
                return new int[]{-1, -1};
            }
        }
    }

    public static void main(String[] args) {
        int[] result = new SearchForARange().searchRange(new int[]{1, 5}, 4);
        System.out.println("[" + result[0] + ", " + result[1] + "]");

        result = new SearchForARange().searchRange(new int[]{1, 2, 3,
                4, 4, 4, 5,
                6}, 6);
        System.out.println("[" + result[0] + ", " + result[1] + "]");

        result = new SearchForARange().searchRange(new int[]{1, 2, 3,
                4, 4, 4, 5,
                6}, 5);
        System.out.println("[" + result[0] + ", " + result[1] + "]");

        result = new SearchForARange().searchRange(new int[]{1, 2, 3,
                4, 4, 4, 5}, 1);
        System.out.println("[" + result[0] + ", " + result[1] + "]");

        result = new SearchForARange().searchRange(new int[]{1, 2, 3,
                4, 4, 4, 5}, 2);
        System.out.println("[" + result[0] + ", " + result[1] + "]");

        result = new SearchForARange().searchRange(new int[]{1, 2, 3,
                4, 4, 4, 5}, 4);
        System.out.println("[" + result[0] + ", " + result[1] + "]");
    }
}
