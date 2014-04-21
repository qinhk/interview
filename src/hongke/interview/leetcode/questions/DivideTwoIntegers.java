package hongke.interview.leetcode.questions;

import java.math.BigInteger;

/**
 * Created by hongke on 4/19/14.
 */

/*
Set quotient to 0
Align leftmost digits in dividend and divisor
Repeat
    If that portion of the dividend above the divisor is greater than or equal to the divisor
    Then subtract divisor from that portion of the dividend and
    Concatentate 1 to the right hand end of the quotient
    Else concatentate 0 to the right hand end of the quotient
    Shift the divisor one place right
Until dividend is less than the divisor
quotient is correct, dividend is remainder
STOP
 */
public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        BigInteger a = new BigInteger(String.valueOf(dividend));
        BigInteger b = new BigInteger(String.valueOf(divisor));
        return a.divide(b).intValue();
    }
    public static void main(String[] args) {
        DivideTwoIntegers test = new DivideTwoIntegers();

        System.out.println(test.divide(6, 3));
        System.out.println(test.divide(5, 3));
        System.out.println(test.divide(0, 3));
        System.out.println(test.divide(333, 3));
        System.out.println(test.divide(2, 3));
        System.out.println(test.divide(2147483647, 1));
        System.out.println(test.divide(2147483647, 1000000000));
        System.out.println(test.divide(-6, 3));
        System.out.println(test.divide(5, 0));
    }
}
