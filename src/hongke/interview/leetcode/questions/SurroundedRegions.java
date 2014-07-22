package hongke.interview.leetcode.questions;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Queue;

/**
 * Created by hongke on 7/19/14.
 */
public class SurroundedRegions {
    public void solve(char[][] board) {

        if (board == null || board.length < 1 || board[0].length < 1) {
            return;
        }

        int width = board[0].length;
        int height = board.length;
        char[][] results = new char[height][width];

        for (char[] row : results) {
            Arrays.fill(row, 'X');
        }

        // Mark white spaces on edges with '1'
        // top and bottom
        for (int i = 0; i < width; i++) {
            if (board[0][i] == 'O') {
                fillBoard(board, 0, i, '1');
            }
            if (board[height - 1][i] == 'O') {
                fillBoard(board, height - 1, i, '1');;
            }
        }

        // left and right
        for (int i = 0; i < height; i++) {
            if (board[i][0] == 'O') {
                fillBoard(board, i, 0, '1');
            }
            if (board[i][width - 1] == 'O') {
                fillBoard(board, i, width - 1, '1');
            }
        }

        for (int i =0; i < height; i ++) {
            for (int j = 0; j < width; j ++) {
                if (board[i][j] == '1') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void fillBoard(char[][] board, int i, int j, char c) {
        int width = board[0].length;
        int height = board.length;
        Queue<Integer[]> queue = new ArrayDeque<Integer[]>();
        queue.add(new Integer[]{i, j});
        while (!queue.isEmpty()) {
            Integer[] pos = queue.poll();
            int x = pos[1], y = pos[0];
            board[y][x] = c;
            if (y - 1 >= 0 && board[y - 1][x] == 'O') {
                queue.add(new Integer[]{y - 1, x});
            }
            if (y + 1 < height && board[y + 1][x] == 'O') {
                queue.add(new Integer[]{y + 1, x});
            }
            if (x - 1 >= 0 && board[y][x - 1] == 'O') {
                queue.add(new Integer[]{y, x - 1});
            }
            if (x + 1 < width && board[y][x + 1] == 'O') {
                queue.add(new Integer[]{y, x + 1});
            }
        }
    }

    public static void main(String[] args) {
        SurroundedRegions test = new SurroundedRegions();
        char[][] board = null;
        board = new char[][] {
            {'X', 'X', 'O', 'X'},
            {'X', 'X', 'X', 'X'},
            {'X', 'X', 'O', 'X'},
            {'X', 'X', 'X', 'X'}
        };
        test.solve(board);
        prettyPrint(board);

        System.out.println(System.currentTimeMillis());
        board = new char[][] {
            {'X','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O'},
            {'O','X','O','O','O','O','X','O','O','O','O','O','O','O','O','O','O','O','X','X'},
            {'O','O','O','O','O','O','O','O','X','O','O','O','O','O','O','O','O','O','O','X'},
            {'O','O','X','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','X','O'},
            {'O','O','O','O','O','X','O','O','O','O','X','O','O','O','O','O','X','O','O','X'},
            {'X','O','O','O','X','O','O','O','O','O','X','O','X','O','X','O','X','O','X','O'},
            {'O','O','O','O','X','O','O','X','O','O','O','O','O','X','O','O','X','O','O','O'},
            {'X','O','O','O','X','X','X','O','X','O','O','O','O','X','X','O','X','O','O','O'},
            {'O','O','O','O','O','X','X','X','X','O','O','O','O','X','O','O','X','O','O','O'},
            {'X','O','O','O','O','X','O','O','O','O','O','O','X','X','O','O','X','O','O','X'},
            {'O','O','O','O','O','O','O','O','O','O','X','O','O','X','O','O','O','X','O','X'},
            {'O','O','O','O','X','O','X','O','O','X','X','O','O','O','O','O','X','O','O','O'},
            {'X','X','O','O','O','O','O','X','O','O','O','O','O','O','O','O','O','O','O','O'},
            {'O','X','O','X','O','O','O','X','O','X','O','O','O','X','O','X','O','X','O','O'},
            {'O','O','X','O','O','O','O','O','O','O','X','O','O','O','O','O','X','O','X','O'},
            {'X','X','O','O','O','O','O','O','O','O','X','O','X','X','O','O','O','X','O','O'},
            {'O','O','X','O','O','O','O','O','O','O','X','O','O','X','O','X','O','X','O','O'},
            {'O','O','O','X','O','O','O','O','O','X','X','X','O','O','X','O','O','O','X','O'},
            {'O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O'},
            {'X','O','O','O','O','X','O','O','O','X','X','O','O','X','O','X','O','X','O','O'}
        };
        test.solve(board);
        prettyPrint(board);
        System.out.println(System.currentTimeMillis());
    }

    public static void prettyPrint(char[][] board) {
        for (char[] c : board) {
            System.out.println(Arrays.toString(c));
        }
    }

}
