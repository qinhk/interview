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
        int result;
        try {
	        if (s == null || s.length() < 1){
	        	return 0;
	        }
	        cache = new TreeMap<Integer, Integer>();
        	result = recurse(s);
            return result;
        } catch (IllegalStateException e) {
        	return 0;
        } finally {
        	long end = System.nanoTime();
        	System.out.println("Input:" + s + " Time:" + (end - start));
        }
    }

    private int recurse(String s) {
    	if (s.startsWith("0")) {
    		return 0;
    	} else if (s.length() <= 1) {
			return 1;
    	} else if (cache.containsKey(s.length())) {
    		return cache.get(s.length());
    	}
    	
    	int code = Integer.parseInt(s.substring(0,Math.min(s.length(), 2)));
    	int val = 0;
    	if (code > 26) {
    		val = recurse(s.substring(1));
    	} else if (code == 10 || code == 20){
    		val = recurse(s.substring(2));
    	}else {
    		val = recurse(s.substring(1)) + recurse(s.substring(2));
        }
    	cache.put(s.length(), val);
    	return val;
    	
    }

    public static void main(String[] args) {
        DecodeWays test = new DecodeWays();
        System.out.println(test.numDecodings("27"));
        System.out.println(test.numDecodings("110"));
        System.out.println(test.numDecodings("12"));
        System.out.println(test.numDecodings("2"));
        System.out.println(test.numDecodings("0"));
        System.out.println(test.numDecodings("2001"));
        System.out.println(test.numDecodings("201"));
        System.out.println(test.numDecodings("111"));
        System.out.println(test.numDecodings("999"));
        System.out.println(test.numDecodings("12578"));
        System.out.println(test.numDecodings("1212"));
        System.out.println(test.numDecodings("12121"));
        System.out.println(test.numDecodings
                ("665812287883668764831544958683283296479682877898293612168136334983851946827579555449329483852397155"));
        System.out.println(test.numDecodings
                ("111111111111111111111111111122222222222222222222221111111111111111111122222222222222222221111111111"));
    }
}
