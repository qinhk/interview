package hongke.interview.leetcode.questions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by hongke on 7/22/14.
 */
public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9) {
            return;
        }

        recursiveSolve(board);
    }

    private boolean recursiveSolve(char[][] board) {
        int x = 0, y = 0;
        for (int i = 0; i < 81; i++) {
            x = i % 9;
            y = i / 9;
            if (board[y][x] == '.') {
                break;
            }
        }

        for (int i = 1; i <= 9; i++) {
            board[y][x] = Integer.toString(i).charAt(0);
            if (isRowValid(board, y) && isColumnValid(board, x) && isGridValid(board, x, y)) {
                if (x == 8 && y == 8) {
                    return true;
                }
                boolean found = recursiveSolve(board);
                if (found) {
                    return found;
                }
            }
        }

        // recover the status
        board[y][x] = '.';
        return false;
    }

    private boolean isRowValid(char[][] board, int row) {
        Set<Character> numbers = new HashSet<Character>();
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == '.') {
                continue;
            } else if (!numbers.contains(board[row][i])) {
                numbers.add(board[row][i]);
            } else {
                return false;
            }
        }

        return true;
    }

    private boolean isColumnValid(char[][] board, int column) {
        Set<Character> numbers = new HashSet<Character>();
        for (int i = 0; i < 9; i++) {
            if (board[i][column] == '.') {
                continue;
            } else if (!numbers.contains(board[i][column])) {
                numbers.add(board[i][column]);
            } else {
                return false;
            }
        }

        return true;
    }

    private boolean isGridValid(char[][] board, int x, int y) {
        Set<Character> numbers = new HashSet<Character>();
        int x0 = x - x % 3, y0 = y - y % 3;
        for (int i = 0; i < 9; i++) {
            int dx = i % 3, dy = i / 3;
            if (board[y0 + dy][x0 + dx] == '.') {
                continue;
            } else if (!numbers.contains(board[y0 + dy][x0 + dx])) {
                numbers.add(board[y0 + dy][x0 + dx]);
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        SudokuSolver test = new SudokuSolver();
        char[][] board = null;

        board = new char[][] {
            {'.', '.', '9', '7', '4', '8', '.', '.', '.'},
            {'7', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '2', '.', '1', '.', '9', '.', '.', '.'},
            {'.', '.', '7', '.', '.', '.', '2', '4', '.'},
            {'.', '6', '4', '.', '1', '.', '5', '9', '.'},
            {'.', '9', '8', '.', '.', '.', '3', '.', '.'},
            {'.', '.', '.', '8', '.', '3', '.', '2', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '6'},
            {'.', '.', '.', '2', '7', '5', '9', '.', '.'}
        };
        test.solveSudoku(board);
        prettyPrint(board);
    }

    public static void prettyPrint(char[][] board) {
        System.out.println();
        for (char[] c : board) {
            System.out.println(Arrays.toString(c));
        }
        System.out.println();
    }
}
