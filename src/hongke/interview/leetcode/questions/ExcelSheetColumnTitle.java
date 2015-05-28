package hongke.interview.leetcode.questions;

import java.util.Stack;

/**
 * Created by hongke on 12/21/14.
 */
public class ExcelSheetColumnTitle {
    public String convertToTitle(int n) {
        if (n < 1) {
            return "";
        }

        Stack<Character> stack = new Stack<Character>();
        while  (n != 0) {
            int d = (n - 1) % 26;
            stack.push((char)('A' + d));
            n = (n - 1) / 26;
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ExcelSheetColumnTitle test = new ExcelSheetColumnTitle();
        System.out.println(test.convertToTitle(26));
        System.out.println(test.convertToTitle(1));
        System.out.println(test.convertToTitle(27));
        System.out.println(test.convertToTitle(0));
    }
}
