package hongke.interview.leetcode.questions;

import java.math.BigInteger;

/**
 * Created by hongke on 4/6/14.
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        if (a == null || b == null || !a.contains("1") || !b.contains("1")) {
            return "0";
        }

        BigInteger n1 = new BigInteger(a, 2);
        BigInteger n2 = new BigInteger(b, 2);
        return n1.add(n2).toString(2);
    }

    public static void main(String[] args) {
        AddBinary test = new AddBinary();
        System.out.println(test.addBinary
                ("10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101", "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011"));
    }
}
