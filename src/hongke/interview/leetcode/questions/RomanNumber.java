package hongke.interview.leetcode.questions;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by hongke on 4/22/14.
 */
public class RomanNumber {
    private static final int M = 1000;
    private static final int CM = 900;
    private static final int D = 500;
    private static final int CD = 400;
    private static final int C = 100;
    private static final int XC = 90;
    private static final int L = 50;
    private static final int XL = 40;
    private static final int X = 10;
    private static final int IX = 9;
    private static final int V = 5;
    private static final int IV = 4;
    private static final int I = 1;

    public String intToRoman(int num) {
        Map<Integer, String> rNum = new TreeMap<Integer, String>(Collections.reverseOrder());
        rNum.put(M, "M");
        rNum.put(CM, "CM");
        rNum.put(D, "D");
        rNum.put(CD, "CD");
        rNum.put(C, "C");
        rNum.put(XC, "XC");
        rNum.put(L, "L");
        rNum.put(XL, "XL");
        rNum.put(X, "X");
        rNum.put(IX, "IX");
        rNum.put(V, "V");
        rNum.put(IV, "IV");
        rNum.put(I, "I");
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Integer, String> e : rNum.entrySet()) {
            while (num != 0) {
                if (num >= e.getKey()) {
                    num -= e.getKey();
                    sb.append(e.getValue());
                } else {
                    break;
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        RomanNumber roman = new RomanNumber();
        System.out.println(roman.intToRoman(90));
        System.out.println(roman.intToRoman(990));
        System.out.println(roman.intToRoman(41));
        System.out.println(roman.intToRoman(400));
        System.out.println(roman.intToRoman(1954));
        System.out.println(roman.intToRoman(1990));
        System.out.println(roman.intToRoman(2014));
    }
}
