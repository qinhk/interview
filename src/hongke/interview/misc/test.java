package hongke.interview.misc;

/**
 * Created by hongke on 3/2/15.
 */
public class test {

    public static void main(String[] args) {
        System.out.println(reverse(-2147483648));
    }

    public static int reverse(int x) {
        long r = 0;
        while (x != 0) {
            int d = x % 10;
            r = r * 10 + d;
            x = x / 10;
        }
        if (r > Integer.MAX_VALUE || r < Integer.MIN_VALUE)
            return 0;
        else
            return (int)r;
    }
}
