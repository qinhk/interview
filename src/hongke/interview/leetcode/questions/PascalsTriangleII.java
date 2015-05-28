package hongke.interview.leetcode.questions;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hongke on 8/24/14.
 */
public class PascalsTriangleII {
    public List<Integer> getRow1(int rowIndex) {
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

    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<Integer>();
        result.add(1);
        for (int i = 1; i <= rowIndex; i ++) {
            result.add(0);
            for (int j = i; j >= 0; j --) {
                int left = j - 1 >= 0 ? result.get(j - 1) : 0;
                int right = j < i ? result.get(j) : 0;
                result.set(j, left + right);
            }
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
