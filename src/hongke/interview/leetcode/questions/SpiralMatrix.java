package hongke.interview.leetcode.questions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hongke on 7/30/14.
 * <p/>
 * - - |
 * | - |
 * | - -
 */
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new ArrayList<Integer>();
        }

        List<Integer> result = new ArrayList<Integer>();
        int width = matrix[0].length, height = matrix.length, count = width * height;
        int layer = 0;
        while (count > 0) {
            // top
            for (int i = layer; count > 0 && i < width - layer; i++) {
                result.add(matrix[layer][i]);
                count --;
            }

            // right
            for (int i = layer; count > 0 && i < height - layer; i++) {
                result.add(matrix[i][width - layer - 1]);
                count --;
            }

            // bottom
            for (int i = width - layer - 1; count > 0 && i >= layer; i--) {
                result.add(matrix[width - layer - 1][i]);
                count --;
            }

            // left
            for (int i = height - layer - 1; count > 0 && i >= layer; i--) {
                result.add(matrix[i][layer]);
                count --;
            }
        }

//        // middle
//        if (scale % 2 != 0) {
//            int middle = matrix.length / 2;
//            result.add(matrix[middle][middle]);
//        }
        return result;
    }

    public static void main(String[] args) {
        SpiralMatrix test = new SpiralMatrix();
        int[][] input;


        input = new int[][] {
            {1}
        };
        System.out.println(test.spiralOrder(input));


        input = new int[][] {
            {1, 2},
            {3, 4},
        };
        System.out.println(test.spiralOrder(input));

        input = new int[][] {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        System.out.println(test.spiralOrder(input));

        input = new int[][] {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };
        System.out.println(test.spiralOrder(input));

        input = new int[][] {
            {1, 2, 3, 4, 5},
            {6, 7, 8, 9, 10},
            {11, 12, 13, 14, 15},
            {16, 17, 18, 19, 20},
            {21, 22, 23, 24, 25}
        };
        System.out.println(test.spiralOrder(input));

        input = new int[][] {
            {2,3}
        };
        System.out.println(test.spiralOrder(input));

        input = new int[][] {
            {3},
            {2}
        };
        System.out.println(test.spiralOrder(input));
    }

}
