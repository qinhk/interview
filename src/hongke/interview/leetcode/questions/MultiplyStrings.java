package hongke.interview.leetcode.questions;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hongke on 8/26/14.
 */
public class MultiplyStrings {
    public String multiply1(String num1, String num2) {
        if (num1 == null || num1.length() == 0 || num2 == null || num2.length() == 0) {
            return "0";
        }

        BigInteger number1 = new BigInteger(num1);
        BigInteger number2 = new BigInteger(num2);
        return number1.multiply(number2).toString();
    }

    public String multiply(String num1, String num2) {
        if (num1 == null || num1.length() == 0 || num2 == null || num2.length() == 0) {
            return "0";
        }

        int sign = 1;
        char[] n1, n2;
        if (num1.startsWith("-") || num1.startsWith("+")) {
            n1 = num1.substring(1).toCharArray();
            sign = num1.charAt(0) == '-' ? -1 * sign : sign;
        } else {
            n1 = num1.toCharArray();
        }

        if (num2.startsWith("-") || num2.startsWith("+")) {
            n2 = num2.substring(1).toCharArray();
            sign = num2.charAt(0) == '-' ? -1 * sign : sign;
        } else {
            n2 = num2.toCharArray();
        }

        if (n1.length > n2.length) {
            char[] tmp = n1;
            n1 = n2;
            n2 = tmp;
        }

        int carry = 0;
        List<Integer> result = new ArrayList<Integer>();
        for (int i = n1.length - 1; i >= 0; i--) {
            for (int j = n2.length - 1; j >= 0; j--) {
                if (n1[i] >= '0' && n1[i] <= '9' && n2[j] >= '0' && n2[j] <= '9') {
                    int index = n1.length - 1 - i + n2.length - 1 - j;
                    if (result.size() <= index)
                        result.add(0);
                    int prev = result.get(index);
                    int product = (n1[i] - '0') * (n2[j] - '0') + carry + prev;
                    result.set(index, product % 10);
                    carry = product / 10;
                } else {
                    throw new RuntimeException();
                }
            }
            if (carry != 0) {
                result.add(carry);
                carry = 0;
            }
        }
        if (carry != 0) {
            result.add(carry);
        }

        StringBuilder sb = new StringBuilder();
        if (sign == -1) {
            sb.append('-');
        }
        boolean numberStarted = false;
        for (int i = result.size() - 1; i >= 0; i--) {
            if (!numberStarted && result.get(i) == 0) {
                continue;
            } else if (!numberStarted) {
                numberStarted = true;
            }
            sb.append(result.get(i));
        }

        if (!numberStarted) {
            return "0";
        } else {
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        MultiplyStrings test = new MultiplyStrings();
        System.out.println(test.multiply("123", "456"));
        System.out.println(test.multiply("31", "5"));
        System.out.println(test.multiply("-3", "-0015"));
        System.out.println(test.multiply("-31", "+5"));
        System.out.println(test.multiply("273739294947457738292736459606947376262523643748583625155236325678928765432438947832726", "2737392949474577382927364596069473762625236437485836251552363256789287654324"));
    }
}
