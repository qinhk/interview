package hongke.interview.leetcode.questions;

/**
 * Created by hongke on 8/17/14.
 */
public class Pow {
    public double power(double x, int n) {
        if (n == 0)
            return 1;

        double v = power(x, n / 2);

        if (n % 2 == 0) {
            return v * v;
        } else {
            return v * v * x;
        }
    }

    public double pow(double x, int n) {
        if (n < 0) {
            return 1 / power(x, -n);
        } else {
            return power(x, n);
        }
    }

    public static void main(String[] args) {
        Pow test = new Pow();
        System.out.println(System.currentTimeMillis());
        System.out.println(test.pow(1.01, 365));
        System.out.println(System.currentTimeMillis());
    }
}
