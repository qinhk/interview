package hongke.interview.algorithms.dp;

/**
 * Counting longest valid parenthesis. You are given a boolean expression consisting of a string of the symbols 'true',
 * 'false', 'and', 'or', and 'xor'. Count the number of ways to parenthesize the expression such that it will evaluate
 * to true. For example, there are 2 ways to parenthesize 'true and false xor true' such that it evaluates to true.
 * Created by hongke on 11/7/14.
 */
public class ValidParenthesis {

    public int countValidParenthesis(String input) {
        if (input == null || input.length() <= 1) {
            return 0;
        }

        int[] validLength = new int[input.length()];
        char[] content = input.toCharArray();

        int max = 0;
        for (int i = 1; i < input.length(); i++) {
            int openPos = i - validLength[i - 1] - 1;
            if (openPos >= 0 && pair(content[i]) == content[openPos]) {
                validLength[i] = validLength[i - 1] + 2;
                while (i - validLength[i] > 0 && validLength[i - validLength[i]] != 0) {
                    validLength[i] += validLength[i - validLength[i]];
                }
                max = Math.max(max, validLength[i]);
            }
        }

        return max;
    }

    private char pair(char c) {
        switch (c) {
            case '}':
                return '{';
            case ']':
                return '[';
            case ')':
                return '(';
            case '{':
            case '[':
            case '(':
                return '\0';
            default:
                throw new IllegalStateException("Invalid character");
        }
    }
}
