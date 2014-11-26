package hongke.interview.leetcode.questions;

/**
 * Created by hongke on 6/23/14.
 */
public class WordSearch {
    boolean[][] used;
    char[][] board;
    boolean found;
    int width = 0, height = 0;

    public boolean exist1(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0 || word == null) {
            return false;
        } else if (word.length() == 0){
            return true;
        }

        width = board[0].length;
        height = board.length;
        used = new boolean[height][width];
        this.board = board;
        int count = 0;
        found = false;
        while (!found && count < width * height) {
            int i = count / width;
            int j = count % width;
            recursiveSearch(word, 0, j, i);
            count ++;
        }

        return found;
    }

    private void recursiveSearch(String s, int i, int x, int y) {
        if (found || i >= s.length() || board[y][x] != s.charAt(i)) {
            return;
        } else if (i + 1 == s.length()) {
            found = true;
        }

        used[y][x] = true;
        if (y - 1 >= 0 && !used[y - 1][x]){
            recursiveSearch(s, i + 1, x, y - 1);
        }
        if (x + 1 < width && !used[y][x + 1]){
            recursiveSearch(s, i + 1, x + 1, y);
        }
        if (y + 1 < height && !used[y + 1][x]){
            recursiveSearch(s, i + 1, x, y + 1);
        }
        if (x - 1 >= 0 && !used[y][x - 1]){
            recursiveSearch(s, i + 1, x - 1, y);
        }
        used[y][x] = false;
    }

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) {
            return false;
        } else if (word == null || word.length() == 0) {
            return true;
        }

        int h = board.length, w = board[0].length;
        boolean[][] visited = new boolean[h][w];
        boolean found = false;
        for (int x = 0; x < w; x ++) {
            for (int y = 0; y < h; y ++) {
                if(findPath(word.toCharArray(), 0, x, y, visited, board)) {
                    return found;
                }
            }
        }
        return false;
    }

    private boolean findPath(char[] w, int i, int x, int y, boolean[][] visited, char[][] board) {
        if (i == w.length) {
            return true;
        } else if (isMatch(w, i, x, y, visited, board)) {
            visited[y][x] = true;
            boolean found = false;
            if (!found) {
                found = findPath(w, i + 1, x + 1, y, visited, board);
            }
            if (!found) {
                found = findPath(w, i + 1, x, y + 1, visited, board);
            }
            if (!found) {
                found = findPath(w, i + 1, x - 1, y, visited, board);
            }
            if (!found) {
                found = findPath(w, i + 1, x, y - 1, visited, board);
            }
            visited[y][x] = false;
            return found;
        } else {
            return false;
        }
    }

    private boolean isMatch(char[] w, int i, int x, int y, boolean[][] visited, char[][] board) {
        return x >= 0 && x < visited[0].length
                && y >=0 && y < visited.length
                && !visited[y][x] && w[i] == board[y][x];
    }

    public static void main(String[] args) {
        WordSearch test = new WordSearch();
        System.out.println(test.exist(new char[][]{{'a'}}, "a"));
    }
}
