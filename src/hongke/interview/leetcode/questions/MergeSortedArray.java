package hongke.interview.leetcode.questions;

import java.util.Arrays;

/**
 * Created by hongke on 9/5/14.
 */
public class MergeSortedArray {
    public void merge(int A[], int m, int B[], int n) {
        if (A == null || B == null || n == 0) {
            return;
        }

        int mi = m - 1, ni = n - 1;
        for (int i = m + n - 1; i >= 0; i --) {
            if (mi < 0 && ni >= 0 || ni >= 0 && mi >= 0 && A[mi] < B[ni]) {
                A[i] = B[ni];
                ni --;
            } else {
                A[i] = A[mi];
                mi --;
            }
        }
    }

    public static void main (String[] args) {
        int[] a1, a2;
        MergeSortedArray test = new MergeSortedArray();

        a1 = new int[]{1,2,3, 0};
        a2 = new int[]{-4};
        test.merge(a1, 3, a2, 1);
        System.out.println(Arrays.toString(a1));
    }

}
