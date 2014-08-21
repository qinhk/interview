package hongke.interview.leetcode.questions;

import java.util.Arrays;

/**
 * Created by hongke on 8/19/14.
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        if(digits == null || digits.length == 0) {
            return digits;
        }

        int carry = 0, index = digits.length - 1;
        digits[index] += 1;
        do {
            int digit = digits[index] + carry;
            digits[index] = digit % 10;
            carry = digit / 10;
            index --;
        } while (index >= 0 && carry != 0);

        int[] result;
        if (carry != 0) {
            result = new int[digits.length + 1];
            result[0] = carry;
            for(int i = 0; i < digits.length; i++) {
                result[i + 1] = digits[i];
            }
        } else {
            result = digits;
        }
        return result;
    }

    public static void main(String[] args) {
        PlusOne test = new PlusOne();
        System.out.println(Arrays.toString(test.plusOne(new int[] {9, 9, 9})));
    }
}
