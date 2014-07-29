package hongke.interview.leetcode.questions;

/**
 * Created by hongke on 7/28/14.
 */
public class SquareRoot {
    public int sqrt(int x) {

        if (x < 0) {
            return -1;
        }
        int k = 0;
        for (int i = 0; i < Integer.MAX_VALUE; i += 1000) {
            long square = (long)i * (long)i;
            if ( square == x) {
                return i;
            } else if (square > x) {
                k = i - 1000;
                break;
            }
        }

        for (int i = k; i < k + 1000; i ++) {
            long square = (long)i * (long)i;
            if ( square == x) {
                return i;
            } else if (square > x) {
                return i - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SquareRoot test = new SquareRoot();

        System.out.println(System.currentTimeMillis());
        System.out.println(test.sqrt(1579205274));
        System.out.println(System.currentTimeMillis());
        System.out.println(test.sqrt(2147483647));
        System.out.println(System.currentTimeMillis());
        System.out.println(test.sqrt(Integer.MAX_VALUE));
        System.out.println(test.sqrt(4));
        System.out.println(test.sqrt(144));
        System.out.println(test.sqrt(0));
        System.out.println(test.sqrt(5));
        System.out.println(test.sqrt(-4));
    }
}
