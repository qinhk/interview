package hongke.interview.leetcode.questions;

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

    public static void main(String[] args) {
        PalindromeNumber test = new PalindromeNumber();


        System.out.println(test.isPalindrome(131));
        System.out.println(test.isPalindrome(10000021));
        System.out.println(test.isPalindrome(1));
        System.out.println(test.isPalindrome(11));
        System.out.println(test.isPalindrome(12121));
        System.out.println(test.isPalindrome(10));
    }
}
