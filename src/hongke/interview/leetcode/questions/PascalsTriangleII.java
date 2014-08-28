package hongke.interview.leetcode.questions;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hongke on 8/24/14.
 */
public class PascalsTriangleII {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<Integer>();
        if (rowIndex < 0) {
            return result;
        }
        int n = rowIndex;
        for (int r = 0; r <= n; r++) {
            BigInteger element = factorial(n).divide(factorial(r).multiply(factorial(n - r)));
            result.add(element.intValue());
        }

        return result;
    }

    private BigInteger factorial(long i) {
        if (i == 0 || i == 1) {
            return BigInteger.ONE;
        }
        BigInteger result = BigInteger.valueOf(i);
        while (i != 1) {
            result = result.multiply(BigInteger.valueOf(--i));
        }

        return result;
    }

    public static void main(String[] args) {
        PascalsTriangleII test = new PascalsTriangleII();

        System.out.println(test.getRow(0));
        System.out.println(test.getRow(1));
        System.out.println(test.getRow(2));
        System.out.println(test.getRow(3));
        System.out.println(test.getRow(4));
        System.out.println(test.getRow(5));
        System.out.println(test.getRow(21));
    }
}
