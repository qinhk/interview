package hongke.interview.leetcode.questions;

/**
 * Created by hongke on 7/28/14.
 */
public class SquareRoot {

    public int sqrt(int x) {
        if (x == 0) return 0;
        if (x == 1) return 1;
        double result = x / 2.0, prev = 0.0;
        while ((int)result != (int)prev)
        {
            prev = result;
            // x|k+1 = x|k - f(x|k)/f'(x|k), f(x) = x^2 - X, =>
            result = result - (result * result - x)/(2 * result);
        }
        return (int)result;
    }

    public double sqrt(double x) {
        if (x < 0) throw new IllegalArgumentException("NotANumber");
        if (x == 0) return 0;
        if (x == 1) return 1;
        double lo = 0, hi = x;
        double margin = 0.000001;
        while (true) {
            double m = lo + (hi - lo) / 2;
            if (m * m <= x && (m + margin) * (m + margin) > x) {
                return m;
            } else if ( m * m > x) {
                hi = m - 1;
            } else {
                lo = m + 1;
            }
        }
    }

    public static void main(String[] args) {
        SquareRoot test = new SquareRoot();

        System.out.println(test.sqrt(2));
        System.out.println(test.sqrt(1579205274));
        System.out.println(test.sqrt(2147483647));
        System.out.println(test.sqrt(Integer.MAX_VALUE));
        System.out.println(test.sqrt(4));
        System.out.println(test.sqrt(144));
        System.out.println(test.sqrt(0));
        System.out.println(test.sqrt(5));
        System.out.println(test.sqrt(4.56));
        System.out.println(test.sqrt(-4.56));

    }

}
