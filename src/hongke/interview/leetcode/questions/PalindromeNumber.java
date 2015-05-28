package hongke.interview.leetcode.questions;

import java.math.BigInteger;

/**
 * Created by hongke on 8/28/14.
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        } else if (x < 10) {
            return true;
        }

        int start = 0;
        int tmp = x;
        int end = 0;
        while (tmp >= 10) {
            tmp = tmp / 10;
            end ++;
        }

        int i = 0;
        while (start + i < end - i) {
            tmp = x;
            int j = start + i;
            int k = end - i;
            while (j > 0) {
                tmp = tmp / 10;
                j --;
                k --;
            }
            int digit1 = tmp % 10;
            while (k > 0) {
                tmp = tmp / 10;
                k --;
            }
            int digit2 = tmp % 10;

            if (digit1 != digit2) {
                return false;
            }
            i ++;
        }
        return true;
    }

    public boolean isPalindrome1(int x) {
        if (x < 0) return false;

        int l = 1, t = x;
        while (t > 9) {
            l *= 10;
            t /= 10;
        }
        boolean valid = true;
        while (l > 1 && x > 0 && valid) {
            valid = x % 10 == x / l;
            x = (x - l * (x / l)) / 10;
            l /= 100;
        }
        return valid;
    }

    public static void main(String[] args) {
        PalindromeNumber test = new PalindromeNumber();


        System.out.println(test.isPalindrome1(1000000001));
        System.out.println(test.isPalindrome(131));
        System.out.println(test.isPalindrome(10000021));
        System.out.println(test.isPalindrome(1));
        System.out.println(test.isPalindrome(11));
        System.out.println(test.isPalindrome(12121));
        System.out.println(test.isPalindrome(10));

        System.out.println(1 | 1);
    }
}
