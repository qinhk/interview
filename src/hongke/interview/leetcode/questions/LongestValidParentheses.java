package hongke.interview.leetcode.questions;

import java.util.Stack;

/**
 * Created by hongke on 9/7/14.
 */
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }

        Stack<Character> right = new Stack<Character>();
        Stack<Integer> length = new Stack<Integer>();

        for (int i = s.length() - 1; i >= 0; i--) {
            if (!right.isEmpty() && s.charAt(i) == '(' && right.peek() == ')') {
                int l = 2 + length.pop();
                if (!length.isEmpty()) {
                    l += length.pop();
                }
                length.push(l);
                right.pop();
            } else {
                length.push(0);
                if (s.charAt(i) != '(') {
                    right.push(s.charAt(i));
                }
            }
        }

        int longest = 0;
        while (!length.isEmpty()) {
            int len = length.pop();
            longest = Math.max(longest, len);
        }
        return longest;
    }

    public static void main(String[] args) {
        LongestValidParentheses test = new LongestValidParentheses();
        System.out.println(test.longestValidParentheses("((()))())"));
        System.out.println(test.longestValidParentheses("())()"));
        System.out.println(test.longestValidParentheses("()(()"));
        System.out.println(test.longestValidParentheses("((()()()()))"));
        System.out.println(test.longestValidParentheses("()()()())"));
        System.out.println(test.longestValidParentheses(")()())()()("));
    }
}
