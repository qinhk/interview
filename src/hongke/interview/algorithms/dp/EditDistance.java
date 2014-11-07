package hongke.interview.algorithms.dp;

import java.util.Arrays;

/**
 * Edit Distance. Given two text strings A of length n and B of length m, you want to transform A into B with a minimum
 * number of operations of the following types: delete a character from A, insert a character into A, or change some
 * character in A into a new character. The minimal number of such operations required to transform A into B is called
 * the edit distance between A and B. Created by hongke on 11/6/14.
 */
public class EditDistance {

    public int calculateEditDistance(String a, String b) {
        if (a == b) {
            return 0;
        } else if (a == null) {
            return b.length();
        } else if (b == null) {
            return a.length();
        } else if (a.equals(b)) {
            return 0;
        }

        int[][] cache = new int[a.length() + 1][b.length() + 1];
        for (int[] c : cache)
            Arrays.fill(c, -1);

        int editDist = findMinEditDist(a.toCharArray(), 0, b.toCharArray(), 0, cache);
        return editDist;
    }

    private int findMinEditDist(char[] a, int i, char[] b, int j, int[][] cache) {
        if (cache[i][j] != -1) {
            return cache[i][j];
        }
        int editDist = 0;
        if (i < a.length && j < b.length && a[i] == b[j]) {
            editDist = findMinEditDist(a, i + 1, b, j + 1, cache);
        } else if (i < a.length && j < b.length) {
            editDist = 1 + min(
                    findMinEditDist(a, i + 1, b, j, cache), // delete
                    findMinEditDist(a, i, b, j + 1, cache), // insert
                    findMinEditDist(a, i + 1, b, j + 1, cache) // modify
            );
        } else if (i == a.length) {
            editDist = b.length - j;
        } else if (j == b.length) {
            editDist = a.length - i;
        }
        cache[i][j] = editDist;
        return editDist;
    }

    private int min(int... numbers) {
        int min = Integer.MAX_VALUE;
        for (int i : numbers) {
            min = Math.min(i, min);
        }
        return min;
    }

}
