package hongke.interview.leetcode.questions;

/**
 * Created by hongke on 8/8/14.
 */
public class RotateImage {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length <= 1) {
            return;
        }

        int tmp, n = matrix.length - 1;
        for (int layer = 0; layer < (n + 1) / 2; layer ++) {
            for (int i = layer; i < n - layer; i ++) {
                tmp = matrix[n - i][layer];
                matrix[n - i][layer] = matrix[n - layer][n - i]; // bottom -> left
                matrix[n - layer][n - i] = matrix[i][n - layer]; // right -> bottom
                matrix[i][n - layer] = matrix[layer][i]; // top -> right
                matrix[layer][i] = tmp; // left -> top
            }
        }
    }

    public static void main (String[] args) {
        RotateImage test = new RotateImage();
        int[][] input;

        input = new int[][] {{1}};
        test.rotate(input);
        Matrix.prettyPrint(input);

        input = new int[][] {{1, 2}, {3, 4}};
        test.rotate(input);
        Matrix.prettyPrint(input);

        input = new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        test.rotate(input);
        Matrix.prettyPrint(input);

        input = new int[][] {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 0, 1, 2}, {3, 4, 5, 6}};
        test.rotate(input);
        Matrix.prettyPrint(input);

        input = new int[][] {
            {1, 2, 3, 4, 5},
            {6, 7, 8, 9, 0},
            {11, 12, 13, 14, 15},
            {16, 17, 18, 19, 20},
            {21, 22, 23, 24, 25}};
        test.rotate(input);
        Matrix.prettyPrint(input);

        input = new int[][] {
            {1, 2, 3, 4, 5, 6},
            {1, 2, 3, 4, 5, 6},
            {1, 2, 3, 4, 5, 6},
            {1, 2, 3, 4, 5, 6},
            {1, 2, 3, 4, 5, 6},
            {1, 2, 3, 4, 5, 6},
        };
        test.rotate(input);
        Matrix.prettyPrint(input);

        input = new int[][] {
             {1,2,3,4,5,6,7,8,9,0}
            ,{1,2,3,4,5,6,7,8,9,0}
            ,{1,2,3,4,5,6,7,8,9,0}
            ,{1,2,3,4,5,6,7,8,9,0}
            ,{1,2,3,4,5,6,7,8,9,0}
            ,{1,2,3,4,5,6,7,8,9,0}
            ,{1,2,3,4,5,6,7,8,9,0}
            ,{1,2,3,4,5,6,7,8,9,0}
            ,{1,2,3,4,5,6,7,8,9,0}
            ,{1,2,3,4,5,6,7,8,9,0}
        };
        test.rotate(input);
        Matrix.prettyPrint(input);
    }
}
