package hongke.interview.leetcode.questions;

/**
 * Created by hongke on 7/30/14.
 */
public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        if (n <= 0) {
            return new int[0][0];
        }

        int[][] matrix = new int[n][n];
        int count = 1;
        for (int length = matrix.length - 1; length > 0; length --) {
            // top
            for (int i = matrix.length - 1 - length; i < length; i ++) {
                matrix[matrix.length - 1 - length][i] = count;
                count ++;
            }

            // right
            for (int i = matrix.length - 1 - length; i < length; i ++) {
                matrix[i][length] = count;
                count ++;
            }

            // bottom
            for (int i = matrix.length - 1 - length; i < length; i ++) {
                matrix[length][matrix.length - 1 - i] = count;
                count ++;
            }

            // left
            for (int i = matrix.length - 1 - length; i < length; i ++) {
                matrix[matrix.length - i - 1][matrix.length - 1 - length] = count;
                count ++;
            }
        }

        // middle
        if (matrix.length % 2 != 0) {
            int middle = matrix.length / 2;
            matrix[middle][middle] = count;
        }
        return matrix;
    }
}
