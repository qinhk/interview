package hongke.interview.leetcode.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by hongke on 7/7/14.
 */
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }

        List<List<Integer>> cache = new ArrayList<List<Integer>>();
        cache.add(new ArrayList(triangle.get(0)));
        for (int i = 1; i < triangle.size(); i ++) {
            List<Integer> list = triangle.get(i);
            List<Integer> prev = cache.get(i - 1);
            List<Integer> mins = new ArrayList<Integer>();
            for (int j = 0; j < list.size(); j ++) {
                Integer minLeft = Integer.MAX_VALUE, minRight = Integer.MAX_VALUE;
                if ( j >= 0 &&  j < prev.size()) {
                    minLeft = prev.get(j);
                }
                if ( j > 0 && j - 1 < prev.size()) {
                    minRight = prev.get(j - 1);
                }
                mins.add(Math.min(minLeft, minRight) + list.get(j));
            }
            cache.add(mins);
        }
        int result = Integer.MAX_VALUE;
        for (Integer i : cache.get(cache.size() - 1)) {
            result = Math.min(i, result);
        }

        return result;
    }

    public static void main (String[] args) {
        Triangle test = new Triangle();

        List<List<Integer>> input = new ArrayList<List<Integer>>();
        input.add(Arrays.asList(new Integer[]{1}));
        input.add(Arrays.asList(new Integer[]{2, 3}));
        System.out.println(test.minimumTotal(input));
        input.clear();
    }
}
