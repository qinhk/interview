package hongke.interview.algorithms.dp;

import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

/**
 * Created by hongke on 2/1/15.
 */
public class ExcelSheetColumnTitle {

    public String convertToTitle(int n) {
        if (n < 1) return "";
        Stack<Character> stack = new Stack<Character>();
        while (n --> 0) {
            int d = n % 26;
            stack.push((char)('A' + d));
            n = n / 26;
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ExcelSheetColumnTitle test = new ExcelSheetColumnTitle();
        System.out.println(test.convertToTitle(0));
        System.out.println(test.convertToTitle(1));
        System.out.println(test.convertToTitle(25));
        System.out.println(test.convertToTitle(26));
        System.out.println(test.convertToTitle(27));
    }
}
