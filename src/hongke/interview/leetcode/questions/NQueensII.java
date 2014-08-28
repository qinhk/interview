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

    public static void main (String[] args) {
        NQueensII test = new NQueensII();
        //        prettyPrint(test.solveNQueens(0));
        //        prettyPrint(test.solveNQueens(1));
        //        prettyPrint(test.solveNQueens(2));
        //        prettyPrint(test.solveNQueens(3));
        System.out.println(test.totalNQueens(4));
        System.out.println(test.totalNQueens(9));
        System.out.println(test.totalNQueens(40));

    }
}
