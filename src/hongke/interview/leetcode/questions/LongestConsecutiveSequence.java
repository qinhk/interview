package hongke.interview.leetcode.questions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hongke on 9/11/14.
 */
public class LongestConsecutiveSequence {
    public int longestConsecutiveSlow(int[] num) {
        if (num == null || num.length == 0) {
            return 0;
        }

        Map<Integer, Integer> valueAndLength = new HashMap<Integer, Integer>();
        int longest = 0;
        for (int i : num) {
            if (valueAndLength.containsKey(i)) {
                continue;
            }
            int cur = i;
            int left = valueAndLength.containsKey(cur - 1) ? valueAndLength.get(cur - 1) : 0;
            int right = valueAndLength.containsKey(cur + 1) ? valueAndLength.get(cur + 1) : 0;
            int length = left + right + 1;
            longest = Math.max(longest, length);
            valueAndLength.put(cur, length);
            while (valueAndLength.containsKey(cur + 1)) {
                valueAndLength.put(cur + 1, length);
                cur = cur + 1;
            }
            cur = i;
            while (valueAndLength.containsKey(cur - 1)) {
                valueAndLength.put(cur - 1, length);
                cur = cur - 1;
            }
        }

        return longest;
    }

    public int longestConsecutive(int[] num) {
        if (num == null || num.length == 0) {
            return 0;
        }

        Map<Integer, Integer> valueAndLength = new HashMap<Integer, Integer>();
        for (int i : num) {
            valueAndLength.put(i, 1);
        }

        int longest = 0;
        for (Map.Entry<Integer, Integer> e : valueAndLength.entrySet()) {
            if (e.getValue() != 1) {
                continue;
            }
            int cur = e.getKey(), length = 1;
            while (valueAndLength.containsKey(cur + 1)) {
                valueAndLength.put(cur + 1, length);
                cur = cur + 1;
                length ++;
            }
            cur = e.getKey();
            while (valueAndLength.containsKey(cur - 1)) {
                valueAndLength.put(cur - 1, length);
                cur = cur - 1;
                length ++;
            }
            longest = Math.max(longest, length);
        }

        return longest;
    }

    public static void main(String[] args) {
        LongestConsecutiveSequence test = new LongestConsecutiveSequence();
        System.out.println(test.longestConsecutive(new int[] {0, -1}));
        System.out.println(test.longestConsecutive(new int[] {100, 4, 200, 1, 3, 2}));
        System.out.println(test.longestConsecutive(new int[] {1, 2, 0, 1}));

        int[] input = new int[10000];
        for (int i = 0; i < 10000; i ++) {
            input[i] = i;
        }
        System.out.println(System.currentTimeMillis());
        System.out.println(test.longestConsecutiveSlow(input));
        System.out.println(System.currentTimeMillis());
    }
}
