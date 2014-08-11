package hongke.interview.leetcode.questions;

import java.util.Arrays;

/**
 * Created by hongke on 8/3/14.
 */
public class Matrix {

    public static void prettyPrint(int[][] matrix) {
        for (int i = 0; i < matrix.length; i ++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
        System.out.println();
    }

    public static String toString(int[][] matrix) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < matrix.length; i ++) {
            sb.append(Arrays.toString(matrix[i]) + '\n');
        }
        return sb.toString();
    }
}
