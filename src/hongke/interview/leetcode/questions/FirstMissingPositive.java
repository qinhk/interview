package hongke.interview.leetcode.questions;


import com.sun.tools.classfile.StackMapTable_attribute;

/**
 * Created by hongke on 4/23/14.
 */
public class FirstMissingPositive {
    public int firstMissingPositive(int[] A) {
        if (A == null) {
            return 1;
        }

        for (int i = 0; i < A.length; i++) {
            if (A[i] < i + 1 && A[i] - 1 < A.length && A[i] - 1 >= 0 && A[i] != A[A[i] - 1]) {
                int t = A[i];
                A[i] = A[t - 1];
                A[t - 1] = t;
            }
        }

        for (int i = 0; i < A.length; i++) {
            if (i + 1 != A[i]) {
                return i + 1;
            }
        }

        return A.length + 1;
    }

    public static void main (String[] args) {
        FirstMissingPositive test = new FirstMissingPositive();
        System.out.println(test.firstMissingPositive(new int[]{11,1,6,11,5,5,-6,9,-3,9,5,4,2,-8,16,-6,-4,2,3}));
        System.out.println(test.firstMissingPositive(new int[]{4,3,2,-1}));
        System.out.println(test.firstMissingPositive(new int[]{3,4,-1,1}));
        System.out.println(test.firstMissingPositive(new int[]{}));
        System.out.println(test.firstMissingPositive(new int[]{0}));
        System.out.println(test.firstMissingPositive(new int[]{1,2,5}));
        System.out.println(test.firstMissingPositive(new int[]{1,1}));
        System.out.println(test.firstMissingPositive(new int[]{5,1}));
        System.out.println(test.firstMissingPositive(new int[]{3}));
        System.out.println(test.firstMissingPositive(new int[]{1,2,3,4}));
    }

}
