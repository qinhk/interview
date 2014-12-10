package hongke.interview.leetcode.questions;

import java.util.Stack;

/**
 * Created by hongke on 8/27/14.
 */
public class NQueensII {
    public int totalNQueens(int n) {
        if (n <= 0) {
            return 0;
        }

        int length = n * n;
        int current = 0;
        int result = 0;

        Stack<Integer> stack = new Stack<Integer>();

        while (true) {
            if (stack.size() == n) {
                result ++;
                current = stack.pop() + 1;
            } else {
                if (stack.isEmpty() && current >= n) {
                    break;
                } else {
                    if (current < length) {
                        if (isValid(stack, current, n)) {
                            stack.push(current);
                            int step = n - current % n;
                            current = Math.max(1, step) + current;
                        } else if (current % n < n - 1) {
                            current ++;
                        } else {
                            current = length;
                        }
                    } else {
                        current = stack.pop() + 1;
                    }
                }
            }
        }
        return result;
    }

    private boolean isValid(Stack<Integer> stack, Integer index, Integer n) {

        int row = index / n;
        int col = index % n;

        for (int i : stack) {

            int row2 = i / n;
            int col2 = i % n;
            if (row2 == row
                || col2 == col
                || Math.abs(row2  - row) == Math.abs(col2 - col)) {
                return false;
            }
        }
        return true;
    }

    public int totalNQueens1(int n) {
        if (n <= 0) {
            return 0;
        }

        int [][] board = new int[n][n];
        int [] result = new int[]{0};
        findAllConfiguration(board, 0, result);
        return result[0];

    }

    private void findAllConfiguration(int[][] board, int row, int[] count) {
        if (row >= board.length) {
            count[0] ++;
        } else {
            for (int i = 0; i < board.length; i++) {
                board[row][i] = 1;
                if (isValidate(board, row, i)) {
                    findAllConfiguration(board, row + 1, count);
                }
                board[row][i] = 0;
            }
        }
    }

    private boolean isValidate(int[][] board, int y, int x) {
        for (int i = 0; i < board.length; i ++) {
            if (i == y) continue;
            if (board[i][x] == 1) return false;
        }
        for (int i = 0; i < board.length; i ++) {
            if (i == x) continue;
            if (board[y][i] == 1) return false;
        }
        for (int i = 0, j = x - y; i < board.length && j < board.length; i ++, j ++) {
            if (i == y || j < 0) continue;
            if (board[i][j] == 1) return false;
        }
        for (int i = 0, j = x + y; i < board.length && j >= 0; i ++, j --) {
            if (i == y || j >= board.length) continue;
            if (board[i][j] == 1) return false;
        }
        return true;
    }


    public static void main (String[] args) {
        NQueensII test = new NQueensII();
        System.out.println(test.totalNQueens(0));
        System.out.println(test.totalNQueens(1));
        System.out.println(test.totalNQueens(2));
        System.out.println(test.totalNQueens(3));
        System.out.println(test.totalNQueens(4));
        System.out.println(test.totalNQueens(9));
        System.out.println(test.totalNQueens(40));

    }
}
