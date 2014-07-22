package hongke.interview.leetcode.questions;

/**
 * Created by hongke on 6/23/14.
 */
public class WordSearch {
    boolean[][] used;
    char[][] board;
    boolean found;
    int width = 0, height = 0;

    public boolean exist(char[][] board, String word) {
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

    public static void main(String[] args) {
        WordSearch test = new WordSearch();
        System.out.println(test.exist(new char[][]{{'a','a'}}, "aaa"));
    }
}
