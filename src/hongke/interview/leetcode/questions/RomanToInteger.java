package hongke.interview.leetcode.questions;

/**
 * Created by hongke on 8/9/14.
 */
public class RomanToInteger {
    /*
    Symbol	Value
    I   	1
    V   	5
    X   	10
    L   	50
    C   	100
    D   	500
    M   	1000
    */
    public int romanToInt(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] num = s.toCharArray();
        int i = 0, result = 0;
        char prev = '\0';
        while (i < num.length) {
            if (num[i] == 'M') {
                result += 1000;
                if (prev == 'C') {
                    result -= 200;
                }
            } else if (num[i] == 'D') {
                result += 500;
                if (prev == 'C') {
                    result -= 200;
                }
            } else if (num[i] == 'C') {
                result += 100;
                if (prev == 'X') {
                    result -= 20;
                }
            } else if (num[i] == 'L') {
                result += 50;
                if (prev == 'X') {
                    result -= 20;
                }
            } else if (num[i] == 'X') {
                result += 10;
                if (prev == 'I') {
                    result -= 2;
                }
            } else if (num[i] == 'V') {
                result += 5;
                if (prev == 'I') {
                    result -= 2;
                }
            } else if (num[i] == 'I') {
                result += 1;
            } else {
                throw new RuntimeException("Invalid format");
            }
            prev = num[i];
            i++;
        }
        return result;
    }

    public static void main (String[] args) {
        RomanToInteger test = new RomanToInteger();
        System.out.println(test.romanToInt("MCMIV"));
    }
}
