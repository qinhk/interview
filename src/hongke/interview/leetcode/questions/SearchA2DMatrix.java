package hongke.interview.leetcode.questions;

/**
 * Created by hongke on 8/6/14.
 */
public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int width = matrix[0].length, height = matrix.length;
        int start = 0, end = height - 1;
        int row = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (target >= matrix[mid][0] && target <= matrix[mid][width - 1]) {
                row = mid;
                break;
            } else if (target >= matrix[start][0] && target < matrix[mid][0]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        if (row == -1) {
            return false;
        }

        start = 0; end = width - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (target == matrix[row][mid]) {
                return true;
            } else if (target >= matrix[row][start] && target < matrix[row][mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        SearchA2DMatrix test = new SearchA2DMatrix();
        int [][] input;
        input = new int[][]{{1,3,5}};
        System.out.println(test.searchMatrix(input, 1));
    }
}
