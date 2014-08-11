package hongke.interview.leetcode.questions;

import java.util.Stack;

/**
 * Created by hongke on 8/9/14.
 */
public class ReverseWordsInAString {
    public String reverseWords(String s) {
        if (s == null ) {
            return s;
        } else if (s.trim().length() == 0) {
            return s.trim();
        }

        Stack<String> stack = new Stack<String>();
        for (String w : s.trim().split(" ")) {
            if (w.trim().length() != 0) {
                stack.push(w);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(" " + stack.pop());
        }

        return sb.substring(1);
    }

    public static void main(String[] args) {
        ReverseWordsInAString test = new ReverseWordsInAString();
        System.out.println(test.reverseWords("The sky is    blue  "));

    }
}
