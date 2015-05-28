package hongke.interview.leetcode.questions;

import java.util.Stack;

/**
 * Created by hongke on 5/7/14.
 */
public class LargestRectangleInHistogram {
    public int largestRectangleArea2(int[] height) {
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

    public int largestRectangleArea1(int[] heights) {
        if (heights == null || heights.length == 0)  {
            return 0;
        }

        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        for (int i = 0; i < heights.length; i ++) {
            if (stack.isEmpty() || heights[i] >= heights[stack.peek()]) {
                stack.push(i);
            } else {
                max = Math.max(max, calculateArea(stack, heights, i));
                stack.push(i);
            }
        }
        max = Math.max(max, calculateArea(stack, heights, heights.length));
        return max;
    }

    private int calculateArea(Stack<Integer> stack, int[] heights, int next) {
        if (stack.isEmpty())
            return 0;
        int right = stack.peek() + 1, max = 0;
        while (!stack.isEmpty() && (next >= heights.length || heights[stack.peek()] >= heights[next])) {
            int height = heights[stack.pop()];
            int left = stack.isEmpty() ? 0 : stack.peek() + 1;
            max = Math.max(max, height * (right - left));
        }
        return max;
    }

    public int largestRectangleArea(int[] bars) {
        if (bars == null || bars.length == 0)
            return 0;

        Stack<Integer> height = new Stack<Integer>();
        int max = 0, len = bars.length, i = 0;
        while (i <= len) {
            if (i < len && (height.size() == 0 || bars[height.peek()] <= bars[i])) {
                height.push(i ++);
            } else if (height.size() > 0 && (i == len || bars[height.peek()] > bars[i])) {
                int h = bars[height.pop()], r = i;
                int l = height.size() == 0 ? 0 : height.peek() + 1;
                max = Math.max(max, (r - l) * h);
            } else {
                i ++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LargestRectangleInHistogram test = new LargestRectangleInHistogram();
        System.out.println(test.largestRectangleArea(new int[] {2, 0, 2}));
        System.out.println(test.largestRectangleArea(new int[] {2, 2, 5, 6, 2, 3}));
        System.out.println(test.largestRectangleArea(new int[] {3, 3}));
        System.out.println(test.largestRectangleArea(new int[] {4, 3, 4, 3}));
        System.out.println(test.largestRectangleArea(new int[] {4, 2, 0, 3, 2, 5}));


    }
}
