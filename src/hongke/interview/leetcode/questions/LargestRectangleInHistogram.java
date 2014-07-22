//package hongke.interview.leetcode.questions;
//
//import java.util.Stack;
//
///**
// * Created by hongke on 5/7/14.
// */
//public class LargestRectangleInHistogram {
//    public int largestRectangleArea(int[] height) {
//        if (height == null || height.length == 0) {
//            return 0;
//        }
//
//        Stack<Integer> s = new Stack<Integer>();
//        Integer maxArea = 0;
//        for (int i = 0; i < height.length; i ++) {
//            if (s.isEmpty() || height[i] > height[s.peek()]) {
//                s.push(i);
//            } else {
//                Integer high = s.peek(), low = high;
//                while (!s.isEmpty() && height[low] >= height[i]) {
//                    maxArea = Math.max(maxArea, calculateArea(low, high));
//                    s.pop();
//                    low = s.peek();
//                }
//            }
//        }
//
//        while (!s.isEmpty()) {
//            maxArea = Math.max(maxArea, calculateArea(low, i));
//            s.pop();
//            low = s.peek();
//        }
//
//        return maxArea;
//    }
//
////    private Integer calculateArea(int start, int end);
//}
