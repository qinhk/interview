package hongke.interview.leetcode.questions;

import java.util.ArrayDeque;
import java.util.Arrays;
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

        // Mark white spaces on edges with '1'
        // top and bottom
        for (int i = 0; i < width; i++) {
            if (board[0][i] == 'O') {
                fillBoard(board, 0, i, '1');
            }
            if (board[height - 1][i] == 'O') {
                fillBoard(board, height - 1, i, '1');
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
        Queue<Integer> X = new ArrayDeque<Integer>();
        Queue<Integer> Y = new ArrayDeque<Integer>();
        X.add(j);
        Y.add(i);
        board[i][j] = c;
        while (!X.isEmpty()) {
            int x = X.poll(), y = Y.poll();
            if (y - 1 >= 0 && board[y - 1][x] == 'O') {
                Y.add(y - 1);
                X.add(x);
                board[y - 1][x] = c;
            }
            if (y + 1 < height && board[y + 1][x] == 'O') {
                Y.add(y + 1);
                X.add(x);
                board[y + 1][x] = c;
            }
            if (x - 1 >= 0 && board[y][x - 1] == 'O') {
                Y.add(y);
                X.add(x - 1);
                board[y][x - 1] = c;
            }
            if (x + 1 < width && board[y][x + 1] == 'O') {
                Y.add(y);
                X.add(x + 1);
                board[y][x + 1] = c;
            }
        }
    }

    public static void main(String[] args) {
        SurroundedRegions test = new SurroundedRegions();
        char[][] board;
        board = new char[][] {
            {'X', 'X', 'O', 'X'},
            {'X', 'X', 'X', 'X'},
            {'X', 'X', 'O', 'X'},
            {'X', 'X', 'X', 'X'}
        };
        test.solve(board);
        prettyPrint(board);

        board = new char[][] {
            {'O', 'O', 'O', 'O'},
            {'O', 'O', 'O', 'O'},
            {'O', 'O', 'O', 'O'},
            {'O', 'O', 'O', 'O'}
        };
        test.solve(board);
        prettyPrint(board);



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
        System.out.println(System.currentTimeMillis());
        test.solve(board);
        System.out.println(System.currentTimeMillis());
        prettyPrint(board);


        board = new char[][] {
            {'O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O'},
            {'O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O'},
            {'O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O'},
            {'O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O'},
            {'O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O'},
            {'O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O'},
            {'O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O'},
            {'O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O'},
            {'O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O'},
            {'O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O'},
            {'O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O'},
            {'O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O'},
            {'O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O'},
            {'O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O'},
            {'O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O'},
            {'O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O'},
            {'O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O'},
            {'O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O'},
            {'O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O'},
            {'O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O'}
        };
        System.out.println(System.currentTimeMillis());
        test.solve(board);
        System.out.println(System.currentTimeMillis());
        prettyPrint(board);
    }

    public static void prettyPrint(char[][] board) {
        for (char[] c : board) {
            System.out.println(Arrays.toString(c));
        }
    }

}
