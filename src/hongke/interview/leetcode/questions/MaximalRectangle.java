package hongke.interview.leetcode.questions;

import java.util.Stack;

/**
 * Created by hongke on 9/14/14.
 */
public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int m = matrix.length, n = matrix[0].length;
        int[][] histoGram = new int [m][n];
        for (int i = 0; i < n; i ++) {
            histoGram[0][i] = matrix[0][i] == '0' ? 0 : 1;
            for (int j = 1; j < m; j ++) {
                histoGram[j][i] = (matrix[j][i] == '0' ? 0 : histoGram[j - 1][i] + 1);
            }
        }

        int[] areas = new int[m];
        for (int i = 0; i < m; i ++) {
            areas[i] = largestRectangleArea(histoGram[i]);
        }

        int max = 0;
        for (int i : areas) {
            max = Math.max(i, max);
        }

        return max;
    }

    public int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int max = 0;
        Stack<Integer> prev = new Stack<Integer>();
        int i = 0, n = height.length;
        while (i < n) {
            if (prev.isEmpty() || height[prev.peek()] <= height[i]) {
                prev.push(i ++);
            } else {
                int h = prev.pop();
                int w = prev.isEmpty() ? i : i - prev.peek() - 1;
                max = Math.max(height[h] * w, max);
            }
        }

        while (!prev.isEmpty()) {
            int h = prev.pop();
            int w = prev.isEmpty() ? i : i - prev.peek() - 1;
            max = Math.max(height[h] * w, max);
        }
        return max;
    }

    public static void main(String[] args) {
        MaximalRectangle test = new MaximalRectangle();
        System.out.println(test.maximalRectangle(new char[][] {
            {'0', '1', '0', '0', '0', '0',},
            {'0', '0', '1', '1', '1', '1',},
            {'0', '0', '0', '1', '1', '1',},
            {'0', '0', '0', '1', '1', '1',},
            {'1', '1', '0', '0', '1', '1',},
            {'1', '1', '0', '0', '0', '1',},
        }));
    }
}
