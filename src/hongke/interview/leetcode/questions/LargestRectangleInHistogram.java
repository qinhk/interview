package hongke.interview.leetcode.questions;

import java.util.Stack;

/**
 * Created by hongke on 5/7/14.
 */
public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int max = 0;
        Stack<Integer> prev = new Stack<Integer>();
        int i = 0, n = height.length;
        while (i < n) {
            if (prev.isEmpty() || height[prev.peek()] <= height[i]) {
                prev.push(i ++);
            } else {
                int h = prev.pop();
                int w = prev.isEmpty() ? i : i - prev.peek() - 1;
                max = Math.max(height[h] * w, max);
            }
        }

        while (!prev.isEmpty()) {
            int h = prev.pop();
            int w = prev.isEmpty() ? i : i - prev.peek() - 1;
            max = Math.max(height[h] * w, max);
        }
        return max;
    }

    public static void main(String[] args) {
        LargestRectangleInHistogram test = new LargestRectangleInHistogram();
        System.out.println(test.largestRectangleArea(new int[] {2, 2, 5, 6, 2, 3}));
        System.out.println(test.largestRectangleArea(new int[] {3, 3}));
        System.out.println(test.largestRectangleArea(new int[] {4, 3, 4, 3}));
        System.out.println(test.largestRectangleArea(new int[] {4, 2, 0, 3, 2, 5}));


    }
}
