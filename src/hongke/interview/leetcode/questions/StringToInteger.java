package hongke.interview.leetcode.questions;

import java.math.BigDecimal;

/**
 * Created by hongke on 7/28/14.
 */
public class StringToInteger {
    public int atoi(String str) {
        try {
            String numString = str.trim().split("[^0-9+-]")[0];
            BigDecimal integer = new BigDecimal(numString);
            if (integer.compareTo(new BigDecimal(Integer.MAX_VALUE)) > 0) {
                return Integer.MAX_VALUE;
            } else if (integer.compareTo(new BigDecimal(Integer.MIN_VALUE)) < 0) {
                return Integer.MIN_VALUE;
            } else {
                return integer.intValue();
            }

        } catch (Throwable t) {
            return 0;
        }
    }

    public static void main(String[] args) {
        StringToInteger test = new StringToInteger();
        System.out.println(test.atoi("-12312  3asjjjds1213123"));
        System.out.println(test.atoi(""));
        System.out.println(test.atoi(null));
    }
}
