package hongke.interview.leetcode.questions;

import java.util.Stack;

/**
 * Created by hongke on 4/20/14.
 */
public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            return 0;
        }
        Stack<Integer> oprands = new Stack<Integer>();
        Stack<String> input = new Stack<String>();

        for (int i = tokens.length; i > 0; i --) {
            input.push(tokens[i - 1]);
        }

        while (!input.isEmpty()) {
            String element = input.pop();
            try {
                int num = Integer.parseInt(element);
                oprands.push(num);
            } catch (NumberFormatException e) {
                int n2 = oprands.pop();
                int n1 = oprands.pop();
                if (element.equals("+")) {
                    oprands.push(n1 + n2);
                } else if (element.equals("-")) {
                    oprands.push(n1 - n2);
                } else if (element.equals("*")) {
                    oprands.push(n1 * n2);
                } else if (element.equals("/")) {
                    oprands.push(n1 / n2);
                } else {
                    throw new IllegalArgumentException("Unknown Operation" + element);
                }
            }
        }

        return oprands.peek();

    }

    public static void main(String[] args) {
        EvaluateReversePolishNotation test = new EvaluateReversePolishNotation();
        System.out.println(test.evalRPN(new String[] {"4", "13", "5", "/", "+"}));
        System.out.println(test.evalRPN(new String[] {"2", "1", "+", "3", "*"}));
    }
}
