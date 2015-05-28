package hongke.interview.leetcode.questions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hongke on 8/23/14.
 */
public class PermutationSequence {
    public String getPermutation1(int n, int k) {
        if (n <= 1 || k <= 0) {
            return String.valueOf(n);
        }

        int factorial = 1;
        for (int i = n - 1; i >= 1; i --) {
            factorial *= i;
        }

        List<String> digits = new ArrayList<String>();
        for (int i = 1; i <= n; i ++) {
            digits.add("" + i);
        }

        StringBuilder sb = new StringBuilder();
        k = k - 1;
        while (digits.size() > 1) {
            int branch = factorial == 0 ? 0 : k / factorial;
            k = factorial == 0 ? 0 : k % factorial;
            factorial /= (digits.size() - 1);
            String digit = digits.remove(branch);
            sb.append(digit);
        }

        sb.append(digits.remove(0));
        return sb.toString();
    }

    public String getPermutation(int n, int k) {
        if (n <= 0 || k <= 0) return "";
        List<Integer> digits = new ArrayList();
        int total = 1;
        for (int i = 1; digits.size() < n; total *= i, digits.add(i), i ++);
        k = k - 1; // zero based.
        StringBuilder seq = new StringBuilder();
        while (!digits.isEmpty()) {
            total = total / digits.size();
            int d = digits.remove(k / total);//!! total cauld be zero at this time
            seq.append(d);
            k = k % total;
        }
        return seq.toString();
    }

    public static void main (String[] args) {
        PermutationSequence test = new PermutationSequence();
        System.out.println(test.getPermutation(1, 1));
        System.out.println(test.getPermutation(3, 0));
        System.out.println(test.getPermutation(3, 1));
        System.out.println(test.getPermutation(3, 2));
        System.out.println(test.getPermutation(3, 3));
        System.out.println(test.getPermutation(3, 4));
        System.out.println(test.getPermutation(3, 5));
        System.out.println(test.getPermutation(3, 6));
        System.out.println(test.getPermutation(4, 2));

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 24; i ++) {
            sb.append("[" + test.getPermutation(4, i) + "] ");
        }
        System.out.println(sb);
    }
}
