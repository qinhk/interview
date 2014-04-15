package hongke.interview.leetcode.questions;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by hongke on 4/14/14.
 */
public class GrayCode {
    public ArrayList<Integer> grayCode(int n) {
        if (n == 0) {
            return new ArrayList();
        }

        ArrayList<Integer> results = new ArrayList<Integer>();
        int [] bits = new int[2 * n];
        Arrays.fill(bits, 0, n - 1, 0);
        Arrays.fill(bits, n, 2 * n , 1);
        for (int offset = 0; offset < 2 * n; offset ++) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i ++) {
                sb.append(bits[(offset + i) % (2 * n)]);
            }
            results.add(Integer.parseInt(sb.toString(),2));

        }
        return results;
    }

    public static void main(String[] args) {
        GrayCode test = new GrayCode();
        test.grayCode(0);
        int[] test1 = new int[]{0,1,3,2,6,7,5,4};
        for (int i : test1) {
            System.out.println(Integer.toBinaryString(i));
        }
    }
}
