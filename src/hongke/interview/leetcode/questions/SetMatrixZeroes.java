package hongke.interview.leetcode.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by hongke on 8/3/14.
 */
public class SetMatrixZeroes {
    public void setZeroes1(int[][] matrix) {
        List<Integer> rows = new ArrayList<Integer>();
        List<Integer> columns = new ArrayList<Integer>();

        for (int i = 0; i < matrix[0].length; i ++) {
            boolean isZero = false;
            for (int j = 0; j < matrix.length; j ++) {
                isZero = isZero || matrix[j][i] == 0;
                if (isZero) {
                    break;
                }
            }

            if (isZero) {
                columns.add(i);
            }
        }

        for (int i = 0; i < matrix.length; i ++) {
            boolean isZero = false;
            for (int j = 0; j < matrix[0].length; j ++) {
                isZero = isZero || matrix[i][j] == 0;
                if (isZero) {
                    break;
                }
            }

            if (isZero) {
                rows.add(i);
            }
        }

        for (int i = 0; i < matrix.length; i ++) {
            for (int j = 0; j < matrix[0].length; j ++) {
                if (rows.contains(i) || columns.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        SetMatrixZeroes test = new SetMatrixZeroes();
        int [][] input;
        input = new int[][]{{0,0,0,5},{4,3,1,4},{0,1,1,4},{1,2,1,3},{0,0,1,1}};
        test.setZeroes(input);
        Matrix.prettyPrint(input);
        input = new int[][]{{0,1}};
        test.setZeroes(input);
        Matrix.prettyPrint(input);

    }

    public void setZeroes(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return;

        boolean rowZero = false, colZero = false;
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; !colZero && i < m; colZero = matrix[i][0] == 0, i ++);
        for (int i = 0; !rowZero && i < n; rowZero = matrix[0][i] == 0, i ++);
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (colZero)
            for (int i = 0; i < m; matrix[i][0] = 0, i ++);
        if (rowZero)
            for (int i = 0; i < n; matrix[0][i] = 0, i ++);
    }
}
