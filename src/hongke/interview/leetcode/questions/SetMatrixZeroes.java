package hongke.interview.leetcode.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by hongke on 8/3/14.
 */
public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
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
        input = new int[][]{{0,1}};
        test.setZeroes(input);
        Matrix.prettyPrint(input);

    }
}
