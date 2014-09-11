package hongke.interview.leetcode.questions;

/**
 * Created by hongke on 9/2/14.
 */
public class minPathSum {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int m = grid[0].length;
        int n = grid.length;
        int[][] minPathSum = new int[m][n];
        minPathSum[0][0] = grid[0][0];
        for (int i = 1; i < m; i ++) {
            minPathSum[0][i] = minPathSum[0][i - 1] + grid[0][i];
        }

        for (int i = 1; i < n; i ++) {
            minPathSum[n][0] = minPathSum[i - 1][0] + grid[i][0];
        }

        for (int i = 1; i < n; i ++) {
            for (int j = 1; j < m; j++) {
                minPathSum[i][j] = Math.min(minPathSum[i - 1][j], minPathSum[i][j - 1]) + grid[i][j];
            }
        }

        return minPathSum[n - 1][m - 1];
    }
}
