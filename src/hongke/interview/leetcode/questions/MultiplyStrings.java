package hongke.interview.leetcode.questions;

import java.math.BigInteger;

/**
 * Created by hongke on 8/26/14.
 */
public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        if (num1 == null || num1.length() == 0 || num2 == null || num2.length() == 0) {
            return "0";
        }

        BigInteger number1 = new BigInteger(num1);
        BigInteger number2 = new BigInteger(num2);
        return number1.multiply(number2).toString();
    }

    public static void main (String[] args) {
        MultiplyStrings test = new MultiplyStrings();
        System.out.println(test.multiply("273739294947457738292736459606947376262523643748583625155236325678928765432438947832726", "2737392949474577382927364596069473762625236437485836251552363256789287654324"));
    }
}
