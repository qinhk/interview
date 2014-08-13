package hongke.interview.leetcode.questions;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by hongke on 8/12/14.
 */
public class RestoreIPAddress {
    public List<String> restoreIpAddresses(String s) {

        if(s == null || s.length() < 4 || s.length() > 16) {
            return new ArrayList<String>();
        }

        Stack<Integer> stack = new Stack<Integer>();
        List<String> results = new ArrayList<String>();
        boolean isFinished = false;
        stack.push(0);
        while (!isFinished) {
            if (stack.size() == 4 && stack.peek() == s.length() - 1) {
                StringBuilder sb = new StringBuilder(s);
                for (int i : stack) {
                    if (i != 0) {
                        sb.insert(i, '.');
                    }
                }
                results.add(sb.toString());
                
            } else if (stack.size() < 4) {
                stack.push(stack.peek() + 1);
            } else {
                int end = stack.pop();
                while (!stack.isEmpty()) {
                    int number = Integer.parseInt(s.substring(stack.peek(), end));
                    if (end >= s.length() || number > 255) {
                        ;
                    } else {
                        stack.push(end + 1);
                        break;
                    }
                    end = stack.pop();
                }

                if (stack.isEmpty()) {
                    isFinished = true;
                }
            }
        }

        return results;
    }

    public static void main(String[] args) {
        RestoreIPAddress test = new RestoreIPAddress();
        System.out.println(test.restoreIpAddresses("01101"));
    }

}
