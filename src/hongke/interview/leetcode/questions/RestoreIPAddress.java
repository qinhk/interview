package hongke.interview.leetcode.questions;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by hongke on 8/12/14.
 */
public class RestoreIPAddress {
    public List<String> restoreIpAddresses(String s) {

        if (s == null || s.length() < 4 || s.length() > 16) {
            return new ArrayList<String>();
        }

        Stack<int[]> stack = new Stack<int[]>();
        List<String> results = new ArrayList<String>();
        stack.push(new int[] {0, 1});
        int[] last = null;
        boolean finished = false;
        while (!finished) {
            if (stack.size() == 4) {
                if (stack.peek()[1] == s.length() && isValidSubRange(s, stack.peek()[0], stack.peek()[1])) {
                    StringBuilder sb = new StringBuilder();
                    for (int[] i : stack) {
                        sb.append('.').append(s.substring(i[0], i[1]));
                    }
                    results.add(sb.substring(1));
                }

                last = stack.pop();
            } else {
                if (last == null && stack.peek()[1] < s.length() && isValidSubRange(s, stack.peek()[1], stack.peek()[1] + 1)) {
                    stack.push(new int[] {stack.peek()[1], stack.peek()[1] + 1});
                    last = null;
                } else if (last != null && last[1] < s.length() && isValidSubRange(s, last[0], last[1] + 1)) {
                    stack.push(new int[] {last[0], last[1] + 1});
                    last = null;
                } else {
                    last = stack.pop();
                    if (last[0] == 0 && !isValidSubRange(s, last[0], last[1] + 1)) {
                        finished = true;
                    }
                }
            }
        }

        return results;
    }

    private boolean isValidSubRange(String s, int i, int j) {
        if (j <= s.length()) {
            String sub = s.substring(i, j);
            int num = Integer.parseInt(sub);
            if (num < 256 && sub.length() == Integer.toString(num).length()) {
                return true;
            }
        }
        return false ;
    }

    public static void main(String[] args) {
        RestoreIPAddress test = new RestoreIPAddress();
        System.out.println(test.restoreIpAddresses("010010"));
        System.out.println(test.restoreIpAddresses("0000"));
    }

}
