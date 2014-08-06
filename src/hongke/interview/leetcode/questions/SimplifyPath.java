package hongke.interview.leetcode.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Created by hongke on 8/1/14.
 */
public class SimplifyPath {
    public String simplifyPath(String path) {

        if (path == null || path.length() == 0) {
            return path;
        }

        String[] elements = path.trim().split("[/]+");
        Stack<String> stack = new Stack<String>();
        for (String s : elements) {
            if (s.equals(".") || s.equals("")) {
                continue;
            } else if (s.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(s);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String s : stack) {
            sb.append("/");
            sb.append(s);
        }

        String result = sb.toString();
        if (result.length() == 0) {
            result = "/";
        }
        return result;
    }

    public static void main (String[] args) {
        SimplifyPath test = new SimplifyPath();
        System.out.println(test.simplifyPath("///"));
        System.out.println(test.simplifyPath("/a/./b/../../c/"));
        System.out.println(test.simplifyPath("./home/"));
    }
}
