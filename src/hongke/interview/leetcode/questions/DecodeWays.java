package hongke.interview.leetcode.questions;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by hongke on 4/17/14.
 */
public class DecodeWays {
    Map<Integer, Integer> cache;

    public int numDecodings(String s) {
        long start = System.nanoTime();
        if (s == null) {
            return 0;
        }
        cache = new TreeMap<Integer, Integer>();
        int result = recurse(s) + 1;
        long end = System.nanoTime();
        System.out.println("Time:" + (end - start));
        return result;
    }

    private int recurse(String s) {
        if (s.length() <= 1) {
            return 0;
        } else if (cache.containsKey(s.length())){
            return cache.get(s.length());
        }

        int val = recurse(s.substring(1)) + recurse(s.substring(2));
        int extra = Integer.parseInt(s.substring(0,2)) < 27 ? 1 : 0;

        cache.put(s.length(), val + extra);
        return val + extra;
    }

    public static void main(String[] args) {
        DecodeWays test = new DecodeWays();
        System.out.println(test.numDecodings("2"));
        System.out.println(test.numDecodings("12"));
        System.out.println(test.numDecodings("111"));
        System.out.println(test.numDecodings("999"));
        System.out.println(test.numDecodings("12578"));
        System.out.println(test.numDecodings("1212"));
        System.out.println(test.numDecodings("12121"));
        System.out.println(test.numDecodings
                ("6065812287883668764831544958683283296479682877898293612168136334983851946827579555449329483852397155"));
    }
}
