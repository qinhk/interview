package hongke.interview.leetcode.questions;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * Created by hongke on 4/6/14.
 */
public class AddBinary {
    public String addBinary1(String a, String b) {
        if (a == null || b == null || !a.contains("1") || !b.contains("1")) {
            return "0";
        }

        BigInteger n1 = new BigInteger(a, 2);
        BigInteger n2 = new BigInteger(b, 2);
        return n1.add(n2).toString(2);
    }

    public static void main(String[] args) {
        AddBinary test = new AddBinary();
        System.out.println(test.addBinary1
                ("10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101", "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011"));
    }

    public String addBinary(String a, String b) {
        if (a == null || a.length() == 0)
            return b;
        else if (b == null || b.length() == 0)
            return a;

        int[] result = new int [Math.max(a.length(), b.length()) + 1];
        char[] n1 = a.toCharArray(), n2 = b.toCharArray();
        reverse(n1);
        reverse(n2);
        int carry = 0;
        for (int i = 0; i < result.length; i ++) {
            int d1 = i < n1.length ? n1[i] - '0' : 0;
            int d2 = i < n2.length ? n2[i] - '0' : 0;
            int sum = d1 + d2 + carry;
            result[i] = sum % 2;
            carry = sum / 2;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = result.length - 1; i >= 0; i --) {
            if (result[i] == 0 && sb.length() == 0)
                continue; // Skip leading zeros
            sb.append(result[i]);
        }
        return sb.toString();
    }

    private void reverse(char[] A) {
        for (int i = 0, j = A.length - 1; i < j; i ++, j --) {
            char t = A[i]; A[i] = A[j]; A[j] = t;
        }
    }
    //110111101100010011000101110110100000011101000101011001000011011000001100011110011010010011000000000
    //110111101100010011000101110110100000011101000101011001000011011000001100011110011010010011000000000

}
