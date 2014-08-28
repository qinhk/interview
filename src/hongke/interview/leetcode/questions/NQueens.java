package hongke.interview.leetcode.questions;

import java.util.*;

/**
 * Created by hongke on 8/26/14.
 */
public class NQueens {
    public List<String[]> solveNQueens(int n) {
        List<String[]> results = new ArrayList<String[]>();
        if (n <= 0) {
            String[] result = new String[0];
            results.add(result);
            return results;
        }

        int length = n * n;
        int current = 0;

        Stack<Integer> stack = new Stack<Integer>();

        while (true) {
            if (stack.size() == n) {
                String[] result = toStringArray(stack, n);
                results.add(result);
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
        return results;
    }

    private String[] toStringArray(Stack<Integer> stack, Integer n) {
        String[] result = new String[n];

        for (Integer i : stack) {
            int row = i / n;
            int col = i % n;
            StringBuilder content = new StringBuilder();
            for (int j = 0; j < n; j ++) {
                if (j == col) {
                    content.append("Q");
                } else {
                    content.append(".");
                }
            }
            result[row] = content.toString();
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

    public static void main (String[] args) {
        NQueens test = new NQueens();
//        prettyPrint(test.solveNQueens(0));
//        prettyPrint(test.solveNQueens(1));
//        prettyPrint(test.solveNQueens(2));
//        prettyPrint(test.solveNQueens(3));
        prettyPrint(test.solveNQueens(4));
        prettyPrint(test.solveNQueens(9));


    }

    public static void prettyPrint(List<String[]> boards) {
        for (String[] board : boards) {
            for (String row : board) {
                System.out.println(row);
            }

            System.out.println("");
        }
    }

}
