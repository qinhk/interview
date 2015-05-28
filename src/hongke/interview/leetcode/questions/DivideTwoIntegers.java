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
    public int divide1(int dividend, int divisor) {
        BigInteger a = new BigInteger(String.valueOf(dividend));
        BigInteger b = new BigInteger(String.valueOf(divisor));
        return a.divide(b).intValue();
    }


    public int divide1(long dividend, long divisor) {
        if (dividend == 0) {
            return 0;
        } else if (divisor == 0) {
            return Integer.MAX_VALUE;
        }

        int sign = (dividend | divisor) < 0 ? -1 : 1;
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        long result = 0;
        while (dividend >= divisor) {
            long partialResult = 1, minus = divisor;
            while ((long)dividend >= 2 * minus) {
                partialResult = partialResult << 1;
                minus = minus << 1;
            }
            dividend -= minus;
            result += partialResult;
        }
        return (int)result * sign;
    }

    public int divide2(long dividend, long divisor) {
        if (divisor == 0) return Integer.MAX_VALUE;
        if (dividend == 0) return 0;
        long sign = (dividend ^ divisor) < 0 ? -1 : 1;
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        long result = 0;
        while (dividend >= divisor) {
            long d = dividend, r = 1;
            while (d >= divisor) {
                d = d >> 1;
                r = r << 1;
            }
            r = r >> 1;
            dividend -= divisor * r;
            result += r;
        }
        if (result >= Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        else
            return (int)(result * sign);
    }

    public int divide2(int dividend, int divisor) {
        if (dividend == 0) return 0;
        if (divisor == 0) return Integer.MAX_VALUE;
        long p = Math.abs((long)dividend);
        long q = Math.abs((long)divisor);

        long ret = 0;
        while (p >= q) {
            int counter = 0;
            while (p >= (q << counter)) {
                counter++;
            }
            ret += 1l << (counter - 1);
            p -= q << (counter - 1);
        }

        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0))
            return (int)-ret;

        if (ret > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        else
            return (int)ret;
    }

    public int divide(int dividend, int divisor) {
        int sign = 1;
        if (dividend > 0 && divisor < 0 || dividend < 0 && divisor > 0) {
            sign = -1;
        }
        long p = Math.abs(Long.valueOf(dividend));
        long q = Math.abs(Long.valueOf(divisor));
        long result = 0;
        while (p >= q) {
            long m = q, count = 1;
            while (p >= m) {
                m = m << 1;
                count = count << 1;
            }
            result += count >> 1;
            p -= m >> 1;
        }
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE)
            return Integer.MAX_VALUE;
        else
            return sign > 0 ? (int)result : 0 - (int)result;
    }

    public static void main(String[] args) {
        DivideTwoIntegers test = new DivideTwoIntegers();

        /*
        -2147483648
        1
        2147483647
        0
        2
        1
        0
        111
        0
        2
        -2
        2147483647
         */

        System.out.println(test.divide(Integer.MIN_VALUE, 1));
        System.out.println(Integer.MIN_VALUE / -1);
        System.out.println(test.divide(1, 1));
        System.out.println(test.divide(2147483647, 1));
        System.out.println(test.divide(-1010369383, -2147483648));
        System.out.println(test.divide(6, 3));
        System.out.println(test.divide(5, 3));
        System.out.println(test.divide(0, 3));
        System.out.println(test.divide(333, 3));
        System.out.println(test.divide(2, 3));
        System.out.println(test.divide(2147483647, 1000000000));
        System.out.println(test.divide(-6, 3));
        System.out.println(test.divide(5, 0));
        String t = "00";
        System.out.println(t.replace("", "1"));
    }
}
